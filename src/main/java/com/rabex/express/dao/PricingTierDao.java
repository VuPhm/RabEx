package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.PricingTier;

import java.util.List;

public interface PricingTierDao extends Dao<PricingTier> {

    List<PricingTier> findByEstimateParam(double weight, boolean inProvince);
}
