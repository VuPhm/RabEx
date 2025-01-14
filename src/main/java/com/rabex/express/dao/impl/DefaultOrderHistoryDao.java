package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.OrderHistoryDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.*;
import com.rabex.express.model.*;

import java.util.List;

public class DefaultOrderHistoryDao extends TemplateDao<Order> implements OrderHistoryDao {
    private static final String QUERY_SQL = "SELECT this.id AS order_id, r.id AS receiver_id, r.phone_number AS receiver_phone_number, r.full_name AS receiver_full_name, r.email AS receiver_email, s.id AS sender_id, s.phone_number AS sender_phone_number, s.full_name AS sender_full_name, s.email AS sender_email, ra.id AS receiver_address_id, ra.description AS receiver_address_description, ra.ward AS receiver_address_ward, ra.district AS receiver_address_district, ra.province AS receiver_address_province, ra.address_type AS receiver_address_type, ra.created_at AS receiver_address_created_at, ra.modified_at AS receiver_address_modified_at, sa.id AS sender_address_id, sa.description AS sender_address_description, sa.ward AS sender_address_ward, sa.district AS sender_address_district, sa.province AS sender_address_province, ra.address_type AS sender_address_type, ra.created_at AS sender_address_created_at, ra.modified_at AS sender_address_modified_at, p.id AS parcel_id, p.name AS parcel_name, p.created_by AS parcel_created_by, p.created_at AS parcel_created_at, p.modified_at AS parcel_modified_at, p.weight AS parcel_weight, p.longg AS parcel_longg, p.high AS parcel_high, p.wide AS parcel_wide, ss.id AS shipping_service_id, ss.name AS shipping_service_name, ss.slug AS shipping_service_slug, ss.short_description AS shipping_service_short_description, ss.details AS shipping_service_details, dfa.id AS delivery_failed_action_id, dfa.name AS delivery_failed_action_name, dfa.description AS delivery_failed_action_description, this.status AS order_status, this.code AS order_code, this.note AS order_note, this.receive_at_home AS order_receive_at_home, this.failed_count AS order_failed_count, this.created_at AS order_created_at, this.modified_at AS order_modified_at FROM orders this LEFT JOIN person_info r ON this.receiver_id = r.id LEFT JOIN person_info s ON this.sender_id = s.id LEFT JOIN address ra ON this.receiver_address_id = ra.id LEFT JOIN address sa ON this.sender_address_id = sa.id LEFT JOIN parcels p ON this.parcel_id = p.id LEFT JOIN shipping_services ss ON this.shipping_service_id = ss.id LEFT JOIN delivery_failed_action dfa ON this.delivery_failed_action_id = dfa.id;";
    private OrderMapper orderMapper;

    @Override
    protected String table() {
        return "orders";
    }

    @Override
    protected ResultSetExtractor<List<Order>> extractor() {
        return new OrderExtractor(
                rowMapper(),
                new PersonInfoMapper("receiver_"),
                new PersonInfoMapper("sender_"),
                new AddressMapper("receiver_address_"),
                new AddressMapper("sender_address_"),
                new ParcelMapper("parcel_"),
                new DeliveryFailedActionMapper("delivery_failed_action_"),
                new ShippingServMapper("shipping_service_")
        );
    }

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
