package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PricingTierMapper;
import com.rabex.express.dao.mapper.ShippingServMapper;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.ShippingRange;
import com.rabex.express.model.ShippingServ;

import java.util.List;
import java.util.Optional;

public class ShippingServDaoImpl extends TemplateDao<ShippingServ> implements ShippingServDao {
    private static final String QUERY_SQL = "SELECT ss.id AS ss_id, ss.name AS ss_name, ss.slug AS ss_slug, ss.short_description AS ss_short_description, ss.details AS ss_details, ss.image AS ss_image, ss.expected_time AS ss_expected_time, ss.created_at AS ss_created_at, ss.modified_at AS ss_modified_at FROM shipping_services AS ss";
    private static final String PRICING_SQL = "SELECT pt.id AS pt_id, pt.description AS pt_description, pt.service_id AS pt_service_id, pt.weight_start AS pt_weight_start, pt.weight_end AS pt_weight_end, pt.step_increment AS pt_step_increment, pt.price_per_step AS pt_price_per_step, pt.base_price AS pt_base_price, pt.shipping_range AS pt_shipping_range FROM pricing_tiers pt WHERE pt.shipping_range = ? AND ? BETWEEN pt.weight_start AND pt.weight_end;";
    private static final String SHIPPING_SERV_PREFIX = "ss_";
    private static final String PRICING_TIER_PREFIX = "pt_";
    private ShippingServMapper shippingServMapper;
    private PricingTierMapper pricingTierMapper;

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

    public RowMapper<PricingTier> pricingTierMapper() {
        return pricingTierMapper == null ?
                pricingTierMapper = new PricingTierMapper(PRICING_TIER_PREFIX) : pricingTierMapper;
    }
    @Override
    public Optional<PricingTier> findPricingTiers(double weight, ShippingRange range) {
        List<PricingTier> tiers = query(PRICING_SQL, pricingTierMapper(), range, weight);
        System.out.println(tiers.toString());
        return Optional.ofNullable(tiers.isEmpty() ? null : tiers.get(0));
    }
}
