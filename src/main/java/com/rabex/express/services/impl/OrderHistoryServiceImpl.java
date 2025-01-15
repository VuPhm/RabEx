package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.OrderDao;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderHistoryService;
import jakarta.inject.Inject;

import java.util.List;

public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Inject
    OrderDao orderHistoryDao;


    @Override
    public List<Order> getOrderHistory() {
        return orderHistoryDao.findAll();
    }

    @Override
    public Order getOrderDetails(RID oid) {
        return orderHistoryDao.findById(oid).orElse(null);
    }
}
