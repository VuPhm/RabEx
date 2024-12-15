package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    private String prefix;



    @Override
    public Address mapRow(ResultSet resultSet, int row) throws SQLException {
        return null;
    }
}
