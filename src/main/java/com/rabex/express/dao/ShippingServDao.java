package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.PricingTier;
import com.rabex.express.model.ShippingRange;
import com.rabex.express.model.ShippingServ;

import java.util.Map;
import java.util.Optional;

public interface ShippingServDao extends Dao<ShippingServ> {
    Optional<ShippingServ> findBySlug(String slug);
    Optional<PricingTier> findPricingTiers(double weight, ShippingRange range);
}