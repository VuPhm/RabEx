package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.*;
import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PricingTierMapper;
import com.rabex.express.dao.mapper.CostEstimateExtractor;
import com.rabex.express.dao.mapper.ShippingServMapper;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.enumm.ShippingRange;
import com.rabex.express.model.ShippingServ;

import java.util.List;
import java.util.Optional;

public class DefaultShippingServDao extends TemplateDao<ShippingServ> implements ShippingServDao {
    private static final String QUERY_SQL = """
SELECT ss.id                AS ss_id,
       ss.name              AS ss_name,
       ss.slug              AS ss_slug,
       ss.short_description AS ss_short_description,
       ss.details           AS ss_details,
       ss.image             AS ss_image,
       ss.expected_time     AS ss_expected_time,
       ss.service_type      AS ss_type,
       ss.created_at        AS ss_created_at,
       ss.modified_at       AS ss_modified_at
FROM shipping_services ss
""";
    private static final String PRICING_SQL = """
            SELECT
                ss.id                AS ss_id,
                ss.name              AS ss_name,
                ss.slug              AS ss_slug,
                ss.expected_time     AS ss_expected_time,
                pt.id                AS pt_id,
                pt.description       AS pt_description,
                pt.service_id        AS pt_service_id,
                pt.weight_start      AS pt_weight_start,
                pt.weight_end        AS pt_weight_end,
                pt.step_increment    AS pt_step_increment,
                pt.price_per_step    AS pt_price_per_step,
                pt.base_price        AS pt_base_price,
                pt.shipping_range    AS pt_shipping_range,
                pt.created_at        AS pt_created_at,
                pt.updated_at        AS pt_updated_at
            FROM shipping_services ss
                     LEFT JOIN pricing_tiers pt
                               ON ss.id = pt.service_id
                                   AND ? BETWEEN pt.weight_start AND pt.weight_end
                                   AND pt.shipping_range = ?

            WHERE ss.service_type = 'delivery'
            ORDER BY pt.weight_start
            """;
    private static final String NON_WEIGHT_PRICING_SQL = """
            SELECT
                ss.id                AS ss_id,
                ss.name              AS ss_name,
                ss.slug              AS ss_slug,
                ss.expected_time     AS ss_expected_time,
                pt.id                AS pt_id,
                pt.description       AS pt_description,
                pt.service_id        AS pt_service_id,
                pt.weight_start      AS pt_weight_start,
                pt.weight_end        AS pt_weight_end,
                pt.step_increment    AS pt_step_increment,
                pt.price_per_step    AS pt_price_per_step,
                pt.base_price        AS pt_base_price,
                pt.shipping_range    AS pt_shipping_range,
                pt.created_at        AS pt_created_at,
                pt.updated_at        AS pt_updated_at
            FROM shipping_services ss
                     LEFT JOIN pricing_tiers pt
                               ON ss.id = pt.service_id
                                   AND pt.shipping_range = ?
            WHERE ss.service_type = 'delivery'
                        ORDER BY pt.weight_start
            """;
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
                shippingServMapper = new ShippingServMapper("ss_") : shippingServMapper;
    }

    public RowMapper<PricingTier> pricingTierMapper() {
        return pricingTierMapper == null ?
                pricingTierMapper = new PricingTierMapper("pt_") : pricingTierMapper;
    }

    protected ResultSetExtractor<List<ShippingServ>> costEstimateExtractor() {
        return new CostEstimateExtractor(rowMapper(), pricingTierMapper());
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
    public List<ShippingServ> findAll() {
        return query(querySql(), rowMapper());
    }

    @Override
    public Optional<ShippingServ> findBySlug(String slug) {
        String sql = querySql() + " WHERE " + tableLabel() + ".slug = ?";
        return Optional.ofNullable(singleQuery(sql, rowMapper(), slug));
    }

    @Override
    public List<ShippingServ> findByRequest(double weight, boolean isInProvince) {
        ShippingRange range = isInProvince ? ShippingRange.IN_PROVINCE : ShippingRange.OUT_PROVINCE;
        return query(PRICING_SQL, costEstimateExtractor(), weight, range);
    }

    @Override
    public List<ShippingServ> findByRequest(boolean inProvince) {
        ShippingRange range = inProvince ? ShippingRange.IN_PROVINCE : ShippingRange.OUT_PROVINCE;
        return query(NON_WEIGHT_PRICING_SQL, costEstimateExtractor(), range);
    }
}
