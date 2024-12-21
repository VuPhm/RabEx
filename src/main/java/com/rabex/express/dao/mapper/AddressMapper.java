package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Address;
import com.rabex.express.model.AddressType;
import com.rabex.express.model.RoleName;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    private String prefix;
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, AddressType> enumConvertor = new StringToEnumConvertor<>(AddressType.class);


    public AddressMapper(String address) {
        this.prefix = address;
    }


    @Override
    public Address mapRow(ResultSet resultSet, int row) throws SQLException {
        return new Address(idConvertor.convert(resultSet.getString(prefix + "id")),
                resultSet.getString(prefix + "des"),
                resultSet.getString(prefix + "ward"),
                resultSet.getString(prefix + "dis"),
                resultSet.getString(prefix + "pro"),
                enumConvertor.convert(resultSet.getString(prefix + "type")),
                resultSet.getTimestamp(prefix + "created_at"),
                resultSet.getTimestamp(prefix + "modified_at")
        );
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
