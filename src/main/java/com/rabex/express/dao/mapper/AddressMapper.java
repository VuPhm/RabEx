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
                resultSet.getTimestamp(prefix + "created_at"),
                resultSet.getTimestamp(prefix + "updated_at")
        );
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
