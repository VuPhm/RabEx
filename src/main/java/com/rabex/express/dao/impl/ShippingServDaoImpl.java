package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.ShippingServMapper;
import com.rabex.express.model.ShippingServ;

public class ShippingServDaoImpl extends TemplateDao<ShippingServ> implements ShippingServDao {
    private static final String QUERY_SQL = "SELECT ss.id AS shipping_service_id, ss.name AS shipping_service_short_description, ss.short_description AS shipping_service_name, ss.details AS shipping_service_short_short_description, ss.shipping_method_coefficient AS shipping_shipping_method_coefficient, ss.unit_cost AS shipping_service_unit_cost, ss.created_at AS shipping_service_create_at, ss.modified_at AS shipping_service_modify_at FROM shipping_services AS ss";
    private ShippingServMapper shippingServMapper;

    @Override
    protected String table() {
        return "shipping_services";
    }

    @Override
    protected RowMapper<ShippingServ> rowMapper() {
        return shippingServMapper == null ?
                shippingServMapper = new ShippingServMapper("shipping_service") : shippingServMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    public boolean insert(ShippingServ request) {
        return insert(QUERY_SQL, request);
    }

    @Override
    public boolean update(RID id, ShippingServ request) {
        return update(QUERY_SQL, id, request);
    }
}
