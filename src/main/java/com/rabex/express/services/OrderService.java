package com.rabex.express.services;

import com.rabex.express.model.Order;

public interface OrderService {
    Order findByCode(String code);
}
