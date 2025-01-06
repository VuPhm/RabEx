package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PricingTierMapper;
import com.rabex.express.model.PricingTier;

public class PricingTierDaoImpl extends TemplateDao<PricingTier> implements Dao<PricingTier> {
    private static final String SQL_QUERY = "SELECT pt.service_id AS pt_service_id, ss.name AS service_name, pt.weight_start, pt.weight_end, pt.step_increment, pt.price_per_step, pt.base_price, pt.shipping_range FROM pricing_tiers pt JOIN shipping_services ss ON pt.service_id = ss.id WHERE pt.shipping_range = ? AND ? BETWEEN pt.weight_start AND pt.weight_end ORDER BY pt.base_price LIMIT 1;";
    private PricingTierMapper pricingTierMapper;

    @Override
    protected String tableLabel() {
        return "pt";
    }

    @Override
    protected RowMapper<PricingTier> rowMapper() {
        return pricingTierMapper == null ? new PricingTierMapper("pt_") : pricingTierMapper;
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

}
