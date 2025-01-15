package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.*;
import com.rabex.express.dao.OrderDao;
import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.*;
import com.rabex.express.model.Order;
import com.rabex.express.model.enumm.OrderStatus;
import jakarta.inject.Inject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends TemplateDao<Order> implements OrderDao {
    @Inject
    private ShippingServDao shippingServDao;

    private final String QUERY = "select * from orders";

    private final Convertor<String, RID> ridConvertor = new StringToRidConvertor()  ;
    private final Convertor<String, OrderStatus> enumConvertor = new StringToEnumConvertor<>(OrderStatus.class);

    @Override
    protected ResultSetExtractor<List<Order>> extractor() {
        return OrderExtractor.builder()
                .senderMapper(new PersonInfoMapper("se_"))
                .receiverMapper(new PersonInfoMapper("re_"))
                .senderAddressMapper(new AddressMapper("sa_"))
                .receiverAddressMapper(new AddressMapper("ra_"))
                .parcelRowMapper(new ParcelMapper("par_"))
                .deliveryFailedActionRowMapper(new DeliveryFailedActionMapper("df_"))
                .shippingServRowMapper(new ShippingServMapper("ss_"))

                .build();
    }

    @Override
    protected RowMapper<Order> rowMapper() {
        return null;
    }

    @Override
    protected String querySql() {
        return "";
    }

    @Override
    public boolean insert(Order request) {
        return false;
    }

    @Override
    public boolean update(RID id, Order request) {
        return false;
    }

    public Order findByCode(String code) {
        String sql = "select * from orders where code = ?";
        RowMapper<Order> mapper = new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int row) throws SQLException {
                return Order.builder()
                        .id(ridConvertor.convert(resultSet.getString("id")))
                        .shippingService_id(ridConvertor.convert(resultSet.getString("shipping_service_id")))
                        .createdAt(resultSet.getTimestamp("created_at"))
                        .status(enumConvertor.convert(resultSet.getString("status")))
                        .build();
            }
        };
        return singleQuery(sql, mapper, code);
    }
}
