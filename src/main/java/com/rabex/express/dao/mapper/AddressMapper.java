package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    private String prefix;
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();

    public AddressMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Address mapRow(ResultSet resultSet, int row) throws SQLException {
        return new Address(idConvertor.convert(resultSet.getString("id")),
                resultSet.getString("description"),
                resultSet.getString("ward"),
                resultSet.getString("district"),
                resultSet.getString("province"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("modified_at"));
    }
}
