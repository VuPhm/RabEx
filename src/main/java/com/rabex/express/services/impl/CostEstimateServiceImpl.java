package com.rabex.express.services.impl;

import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.impl.DefaultPricingTierDao;
import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.CostEstimateService;
import jakarta.inject.Inject;

import java.util.List;

public class CostEstimateServiceImpl implements CostEstimateService {
    @Inject
    private ShippingServDao shippingServDao;
    @Inject
    private DefaultPricingTierDao pricingTierDao;

    @Override
    public List<ShippingServ> getEstimating(CostEstimateRequest request) {
        double weight = 0;
        weight = (request.getUnknownWeight() && !request.unknownVolume())
                ? request.getOrTransformedWeight()
                : request.getWeight();

        return shippingServDao.findByRequest(weight, request.isInProvince());
    }
}
