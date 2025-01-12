package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.*;
import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PricingTierMapper;
import com.rabex.express.dao.mapper.ShippingServExtractor;
import com.rabex.express.dao.mapper.ShippingServMapper;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.ShippingRange;
import com.rabex.express.model.ShippingServ;

import java.util.List;
import java.util.Optional;

public class ShippingServDaoImpl extends TemplateDao<ShippingServ> implements ShippingServDao {
    private static final String QUERY_SQL = "SELECT ss.id AS ss_id, ss.name AS ss_name, ss.slug AS ss_slug, ss.short_description AS ss_short_description, ss.details AS ss_details, ss.image AS ss_image, ss.expected_time AS ss_expected_time, ss.created_at AS ss_created_at, ss.modified_at AS ss_modified_at FROM shipping_services AS ss";
    private static final String PRICING_SQL = "SELECT ss.id AS ss_id, ss.name AS ss_name, ss.slug AS ss_slug, ss.short_description AS ss_short_description, ss.details AS ss_details, ss.image AS ss_image, ss.expected_time AS ss_expected_time, ss.service_type AS ss_service_type, ss.created_at AS ss_created_at, ss.modified_at AS ss_modified_at, pt.id AS pt_id, pt.description AS pt_description, pt.service_id AS pt_service_id, pt.weight_start AS pt_weight_start, pt.weight_end AS pt_weight_end, pt.step_increment AS pt_step_increment, pt.price_per_step AS pt_price_per_step, pt.base_price AS pt_base_price, pt.shipping_range AS pt_shipping_range, pt.created_at AS pt_created_at, pt.updated_at AS pt_updated_at FROM shipping_services ss LEFT JOIN pricing_tiers pt ON ss.id = pt.service_id AND ? BETWEEN pt.weight_start AND pt.weight_end WHERE pt.shipping_range = ? ORDER BY ss.name;";
    private static final String SHIPPING_SERV_PREFIX = "ss_";
    private static final String PRICING_TIER_PREFIX = "pt_";
    private ShippingServMapper shippingServMapper;
    private PricingTierMapper pricingTierMapper;

    private static final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    @Override
    protected String table() {
        return "shipping_services";
    }

    @Override
    protected String tableLabel() {
        return "ss";
    }

    @Override
    protected RowMapper<ShippingServ> rowMapper() {
        return shippingServMapper == null ?
                shippingServMapper = new ShippingServMapper(SHIPPING_SERV_PREFIX) : shippingServMapper;
    }

    public RowMapper<PricingTier> pricingTierMapper() {
        return pricingTierMapper == null ?
                pricingTierMapper = new PricingTierMapper(PRICING_TIER_PREFIX) : pricingTierMapper;
    }

    @Override
    protected ResultSetExtractor<List<ShippingServ>> extractor() {
        return new ShippingServExtractor(rowMapper(), pricingTierMapper());
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    public boolean insert(ShippingServ request) {
        return insert(QUERY_SQL, request);
    }

    @Override
    public boolean update(RID id, ShippingServ request) {
        return update(QUERY_SQL, id, request);
    }

    @Override
    public Optional<ShippingServ> findBySlug(String slug) {
        String sql = querySql() + " WHERE " + tableLabel() + ".slug = ?";
        return Optional.ofNullable(singleQuery(sql, rowMapper(), slug));
    }

    @Override
    public List<ShippingServ> findByRequest(double weight, boolean isInProvince) {
        ShippingRange range = isInProvince ? ShippingRange.IN_PROVINCE : ShippingRange.OUT_PROVINCE;
        return query(PRICING_SQL, extractor(), weight, range);
    }
}
