package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.model.Address;
import com.rabex.express.model.PersonInfo;
import com.rabex.express.model.ShippingAddress;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingAddressMapper implements RowMapper<ShippingAddress> {
    RowMapper<PersonInfo> personInfoRowMapper;
    RowMapper<Address> addressRowMapper;

    @Override
    public ShippingAddress mapRow(ResultSet resultSet, int row) throws SQLException {
        PersonInfo personInfo = personInfoRowMapper.mapRow(resultSet, row);
        Address address = addressRowMapper.mapRow(resultSet, row);
        return ShippingAddress.builder().address(address).personInfo(personInfo).build();
    }
}
