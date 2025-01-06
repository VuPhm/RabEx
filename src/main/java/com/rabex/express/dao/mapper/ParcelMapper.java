package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.AddressType;
import com.rabex.express.model.Parcel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParcelMapper implements RowMapper<Parcel> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, AddressType> enumConvertor = new StringToEnumConvertor<AddressType>(AddressType.class);

    public ParcelMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Parcel mapRow(ResultSet resultSet, int row) throws SQLException {
        return Parcel.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .name(resultSet.getString(prefix + "name"))
                .creatorId(idConvertor.convert(resultSet.getString(prefix + "created_by")))
                .createdAt(resultSet.getTimestamp(prefix + "created_at"))
                .modifiedAt(resultSet.getTimestamp(prefix + "modified_at"))
                .weight(resultSet.getInt(prefix + "weight"))
                .longg(resultSet.getLong(prefix + "longg"))
                .high(resultSet.getInt(prefix + "high"))
                .wide(resultSet.getInt(prefix + "wide"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
