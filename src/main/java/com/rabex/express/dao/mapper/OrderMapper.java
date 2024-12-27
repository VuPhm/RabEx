package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    private String prefix;
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();

    public OrderMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Order mapRow(ResultSet resultSet, int row) throws SQLException {
        return Order.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .receiverId(idConvertor.convert(resultSet.getString(prefix+"receiver_id")))
                .senderId(idConvertor.convert(resultSet.getString(prefix+ "sender_id")))
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
