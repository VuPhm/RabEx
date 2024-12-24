package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.ShippingServDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.ShippingServMapper;
import com.rabex.express.model.ShippingServ;

import java.util.List;
import java.util.Optional;

public class ShippingServDaoImpl extends TemplateDao<ShippingServ> implements ShippingServDao {
    private static final String QUERY_SQL = "SELECT ss.id AS ss_id, ss.name AS ss_name, ss.slug AS ss_slug, ss.short_description AS ss_short_description, ss.details AS ss_details, ss.shipping_method_coefficient AS ss_shipping_method_coefficient, ss.unit_cost AS ss_unit_cost, ss.created_at AS ss_created_at, ss.modified_at AS ss_modified_at FROM shipping_services AS ss";
    private ShippingServMapper shippingServMapper;

    @Override
    protected String table() {
        return "shipping_services";
    }

    @Override
    protected String tableLabel() {
        return "ss";
    }

    @Override
    protected RowMapper<ShippingServ> rowMapper() {
        return shippingServMapper == null ?
                shippingServMapper = new ShippingServMapper("ss_") : shippingServMapper;
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

    @Override
    public Optional<ShippingServ> findBySlug(String slug) {
        String sql = querySql() + " WHERE " + tableLabel() + ".slug = ?";
        return Optional.ofNullable(singleQuery(sql, rowMapper(), slug));
    }
}
