package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.OrderHistoryDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.CustomerMapper;
import com.rabex.express.dao.mapper.OrderMapper;
import com.rabex.express.model.Order;


public class DefaultOrderHistoryDao extends TemplateDao<Order> implements OrderHistoryDao {
    private static final String QUERY_SQL= "SELECT this.id as order_id, this.receiver_id as order_receiver_id, this.sender_id as order_sender_id FROM orders as this";
    private OrderMapper orderMapper;
    @Override
    public boolean insert(Order request) {
        return false;
    }

    @Override
    public boolean update(RID id, Order request) {
        return false;
    }

    @Override
    protected RowMapper<Order> rowMapper() {
        if (orderMapper == null) orderMapper = new OrderMapper("order_");
        return orderMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }
}
