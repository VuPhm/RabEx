package com.rabex.express.services.impl;

import com.rabex.express.dao.OrderDao;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderService;
import jakarta.inject.Inject;

public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;

    @Override
    public Order findByCode(String code) {
        return orderDao.findByCode(code);
    }
}
