package com.rabex.express.dao.impl;

import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.model.ShippingRange;
import org.junit.jupiter.api.Test;

public class ShippingServDaoTest {
    @Test
    public void test() {
        ShippingServDao shippingServDao = new ShippingServDaoImpl();
        System.out.println(shippingServDao.findPricingTiers(10, ShippingRange.OUT_PROVINCE));
    }
}
