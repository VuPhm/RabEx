package com.rabex.express.services.impl;

import com.rabex.express.dao.OrderHistoryDao;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderHistoryService;
import jakarta.inject.Inject;

import java.util.List;

public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Inject
    OrderHistoryDao orderHistoryDao;


    @Override
    public List<Order> getOrderHistory() {
        return orderHistoryDao.findAll();
    }
}
