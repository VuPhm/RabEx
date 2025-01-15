package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.ShippingServ;

import java.util.List;

public interface ShippingServService {
    ShippingServ findById(RID id);
    int countAll();
    List<ShippingServ> findAll();
    ShippingServ findBySlug(String slug);
    List<ShippingServ> findByEstimateRequest(CostEstimateRequest costEstimateRequest);
}
