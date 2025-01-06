package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Address;
import com.rabex.express.model.AddressType;
import com.rabex.express.model.User;
import com.rabex.express.model.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    private String prefix;
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private Convertor<String, AddressType> enumConvertor = new StringToEnumConvertor<AddressType>(AddressType.class);


    public AddressMapper(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public Address mapRow(ResultSet resultSet, int row) throws SQLException {
        return Address.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .description(resultSet.getString(prefix + "des"))
                .ward(resultSet.getString(prefix + "ward"))
                .district(resultSet.getString(prefix + "dis"))
                .province(resultSet.getString(prefix + "pro"))
                .addressType(enumConvertor.convert(resultSet.getString(prefix + "type")))
                .createdAt(resultSet.getTimestamp(prefix + "created_at"))
                .modifiedAt(resultSet.getTimestamp(prefix + "modified_at"))
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
