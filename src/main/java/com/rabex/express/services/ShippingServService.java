package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.dto.PricingTiersTable;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.model.SurchargeTier;

import java.util.List;

public interface ShippingServService {
    ShippingServ findById(RID id);

    int countAll();

    List<ShippingServ> findAll();

    ShippingServ findBySlug(String slug);

    List<ShippingServ> findByEstimateRequest(CostEstimateRequest costEstimateRequest);

    List<PricingTiersTable> findPricingTiers(RID sid);

    List<SurchargeTier> findSurchargeTiers(RID sid);
}
