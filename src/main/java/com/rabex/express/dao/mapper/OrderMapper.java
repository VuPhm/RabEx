package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Order;
import com.rabex.express.model.enumm.OrderStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, OrderStatus> enumConvertor = new StringToEnumConvertor<>(OrderStatus.class);

    public OrderMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Order mapRow(ResultSet resultSet, int row) throws SQLException {
        return Order.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                // receiver_id sender_id receiver_address_id sender_address_id parcel_id delivery_failed_action_id shipping_service_id
                .status(enumConvertor.convert(resultSet.getString(prefix + "status")))
                .code(resultSet.getString(prefix + "code"))
                .note(resultSet.getString(prefix + "note"))
                .receiveAtHome(resultSet.getBoolean(prefix + "receive_at_home"))
                .failedCount(resultSet.getInt(prefix + "failed_count"))
                .createdAt(resultSet.getTimestamp(prefix + "created_at"))
                .updatedAt(resultSet.getTimestamp(prefix + "modified_at"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

}
