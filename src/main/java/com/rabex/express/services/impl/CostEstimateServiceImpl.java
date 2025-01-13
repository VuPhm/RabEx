package com.rabex.express.services.impl;

import com.rabex.express.dao.PricingTierDao;
import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.PricingTier;
import com.rabex.express.services.CostEstimateService;
import jakarta.inject.Inject;

import java.util.List;

public class CostEstimateServiceImpl implements CostEstimateService {
    @Inject
    private PricingTierDao pricingTierDao;

    @Override
    public List<PricingTier> getEstimating(CostEstimateRequest request) {
        double weight = (request.getUnknownWeight() && request.unknownVolume())
                ? request.getOrTransformedWeight()
                : request.getWeight();
        return pricingTierDao.findByEstimateParam(weight, request.isInProvince());
    }

    @Override
    public List<PricingTier> getEstimating(String senderProvince, String receiverProvince, double weight) {
        return pricingTierDao.findByEstimateParam(weight, senderProvince.equals(receiverProvince));
    }
}
