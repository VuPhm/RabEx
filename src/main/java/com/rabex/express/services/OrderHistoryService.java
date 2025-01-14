package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Order;

import java.util.List;

public interface OrderHistoryService {
    public List<Order> getOrderHistory();
    public Order getOrderDetails(RID oid);
}
