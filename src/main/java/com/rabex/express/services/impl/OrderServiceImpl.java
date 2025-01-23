package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.OrderDao;
import com.rabex.express.dto.OrderCreateForm;
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

    @Override
    public boolean addOrder(RID cId, OrderCreateForm orderCreateForm) {
        return false;
    }
}
