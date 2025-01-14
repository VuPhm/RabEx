package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.PricingTierDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PricingTierMapper;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.enumm.ShippingRange;

import java.util.List;

public class DefaultPricingTierDao extends TemplateDao<PricingTier> implements PricingTierDao {
    private static final String SQL_QUERY = """
            SELECT pt.service_id AS pt_service_id,
                   pt.description AS pt_description,
                   ss.name       AS ss_name,
                   pt.weight_start AS pt_weight_start,
                   pt.weight_end AS pt_weight_end,
                   pt.step_increment AS pt_step_increment,
                   pt.price_per_step AS pt_price_per_step,
                   pt.base_price AS pt_base_price,
                   pt.shipping_range AS pt_shipping_range,
                   pt.created_at AS pt_created_at,
                   pt.updated_at AS pt_updated_at
            FROM pricing_tiers pt
                     JOIN shipping_services ss ON pt.service_id = ss.id
            WHERE pt.shipping_range = ?
              AND ? BETWEEN pt.weight_start AND pt.weight_end
            ORDER BY pt.base_price;""";
    private PricingTierMapper pricingTierMapper;

    @Override
    protected String tableLabel() {
        return "pt";
    }

    @Override
    protected RowMapper<PricingTier> rowMapper() {
        return pricingTierMapper == null ? pricingTierMapper = new PricingTierMapper("pt_") : pricingTierMapper;
    }

    @Override
    protected String querySql() {
        return SQL_QUERY;
    }

    @Override
    public boolean insert(PricingTier request) {
        return insert(SQL_QUERY, request);
    }

    @Override
    public boolean update(RID id, PricingTier request) {
        return update(SQL_QUERY, id, request);
    }

    @Override
    public List<PricingTier> findByEstimateParam(double weight, boolean inProvince) {
        ShippingRange range = inProvince ? ShippingRange.IN_PROVINCE : ShippingRange.OUT_PROVINCE;
        return query(querySql(), rowMapper(), range, weight);
    }
}
