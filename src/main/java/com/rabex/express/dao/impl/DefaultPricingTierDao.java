package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.AbstractDao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;
import com.rabex.express.dao.PricingTierDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PricingTierMapper;
import com.rabex.express.model.PricingTier;

import java.util.List;
import java.util.Optional;

public class DefaultPricingTierDao extends TemplateDao<PricingTier> implements PricingTierDao {
    private static final String QUERY_SQL = "";

    private PricingTierMapper pricingTierMapper;

    @Override
    protected RowMapper<PricingTier> rowMapper() {
        return pricingTierMapper == null ? pricingTierMapper = new PricingTierMapper("pt") : pricingTierMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    public boolean insert(PricingTier request) {
        return false;
    }

    @Override
    public boolean update(RID id, PricingTier request) {
        return false;
    }
}
