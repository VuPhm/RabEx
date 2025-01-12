package com.rabex.express.services;

import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.ShippingServ;

import java.util.List;

public interface CostEstimateService {
    List<ShippingServ> getEstimating(CostEstimateRequest request);
}
