package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Order;

import java.util.List;

public interface OrderManagerService {
    public List<Order> getOrderManager();
    public Order getOrderDetails(RID oid);
}
