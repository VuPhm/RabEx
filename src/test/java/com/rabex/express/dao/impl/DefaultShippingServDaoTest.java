package com.rabex.express.dao.impl;

import com.rabex.express.model.PricingTier;
import com.rabex.express.model.ShippingServ;
import org.junit.jupiter.api.Test;

import java.util.List;

class DefaultShippingServDaoTest {

    @Test
    void findByRequest() {
        List<ShippingServ> res =  new DefaultShippingServDao().findByRequest(92000, false);
        PricingTier tier = res.get(0).getPricingTiers().get(0);
        System.out.println();
    }
}