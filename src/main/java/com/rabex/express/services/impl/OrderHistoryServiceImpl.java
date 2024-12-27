package com.rabex.express.services.impl;

import com.rabex.express.dao.OrderHistoryDao;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderHistoryService;

import java.util.List;

public class OrderHistoryServiceImpl implements OrderHistoryService {
    OrderHistoryDao orderHistory;
    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }
}
