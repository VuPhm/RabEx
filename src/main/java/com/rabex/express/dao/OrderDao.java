package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends Dao<Order> {
    Order findByCode(String code);

    List<Order> findAll();

}
