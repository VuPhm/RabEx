package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.OrderCreateForm;
import com.rabex.express.dto.ShippingAddressForm;
import com.rabex.express.model.Order;

public interface OrderService {
    Order findByCode(String code);
    boolean addOrder(RID cId, OrderCreateForm orderCreate);
}
