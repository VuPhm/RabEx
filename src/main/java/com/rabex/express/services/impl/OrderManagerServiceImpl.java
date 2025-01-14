package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.OrderDao;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderManagerService;
import jakarta.inject.Inject;

import java.util.List;

public class OrderManagerServiceImpl implements OrderManagerService {

    @Inject
    OrderDao orderManagerDao;

    @Override
    public List<Order> getOrderManager() {
        return orderManagerDao.findAll();
    }

    @Override
    public Order getOrderDetails(RID oid) {
        return orderManagerDao.findById(oid).orElse(null);
    }
}
