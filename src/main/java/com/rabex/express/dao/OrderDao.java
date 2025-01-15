package com.rabex.express.dao;

import com.rabex.express.model.Order;

public interface OrderDao {
    Order findByCode(String code);
}
