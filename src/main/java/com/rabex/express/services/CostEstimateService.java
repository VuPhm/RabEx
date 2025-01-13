package com.rabex.express.services;

import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.PricingTier;

import java.util.List;

public interface CostEstimateService {
    List<PricingTier> getEstimating(CostEstimateRequest request);
    List<PricingTier> getEstimating(String senderProvince, String receiverProvince, double weight);
}
