package com.rabex.express.services.impl;

import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;

import java.util.List;

public class ShippingServServiceImpl implements ShippingServService {
    @Inject
    ShippingServDao shippingServDao;

    @Override
    public int countAll() {
        return shippingServDao.countAll();
    }

    @Override
    public List<ShippingServ> findAll() {
        return shippingServDao.findAll();
    }

    @Override
    public ShippingServ findBySlug(String slug) {
        return shippingServDao.findBySlug(slug).orElse(null);
    }
}
