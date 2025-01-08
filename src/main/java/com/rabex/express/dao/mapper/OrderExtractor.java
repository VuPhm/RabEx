package com.rabex.express.dao.mapper;


import com.rabex.express.core.dao.*;
import com.rabex.express.model.*;
import lombok.Builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class OrderExtractor implements ResultSetExtractor<List<Order>> {
    private final RowMapper<Order> orderRowMapper;
    private final RowMapper<PersonInfo> receiverMapper;
    private final RowMapper<PersonInfo> senderMapper;
    private final RowMapper<Address> receiverAddressMapper;
    private final RowMapper<Address> senderAddressMapper;
    private final RowMapper<Parcel> parcelRowMapper;
    private final RowMapper<DeliveryFailedAction> deliveryFailedActionRowMapper;
    private final RowMapper<ShippingServ> shippingServRowMapper;


    private final Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    @Override
    public List<Order> extractData(ResultSet resultSet) throws SQLException {
        Map<RID, Order> orders = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            RID orderId = ridConvertor.convert(resultSet.getString(orderRowMapper.getPrefix() + "id"));

            Order order = orderRowMapper.mapRow(resultSet, i);

            order.setReceiver(receiverMapper.mapRow(resultSet, i));
            order.setSender(senderMapper.mapRow(resultSet, i));
            order.setReceiverAddress(receiverAddressMapper.mapRow(resultSet, i));
            order.setSenderAddress(senderAddressMapper.mapRow(resultSet, i));
            order.setParcel(parcelRowMapper.mapRow(resultSet, i));
            order.setDeliveryFailedAction(deliveryFailedActionRowMapper.mapRow(resultSet, i));
            order.setShippingService(shippingServRowMapper.mapRow(resultSet, i));

            orders.put(orderId, order);

            i++;
        }

        return orders.values().stream().toList();
    }
}
