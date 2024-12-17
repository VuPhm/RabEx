package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.AddressMapper;
import com.rabex.express.dao.mapper.UserMapper;
import com.rabex.express.model.Address;

public class DefaultAddressDao extends TemplateDao<Address> {
    private static final String QUERY_SQL = "SELECT this.id as address_id, this.description as address_des, this.ward as address_ward, this.district as address_dis, this.province as address_pro, this.created_at as address_created_at, this.updated_at as address_updated_at from address this";
    private AddressMapper addressMapper;
    @Override
    public boolean insert(Address request) {
        String insertAddress = "INSERT INTO address()";
        return false;
    }

    @Override
    public boolean update(RID id, Address request) {
        return false;
    }

    @Override
    protected RowMapper<Address> rowMapper() {
        if (addressMapper == null)
            addressMapper = new AddressMapper("address_");
        return addressMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM address";
    }
}
