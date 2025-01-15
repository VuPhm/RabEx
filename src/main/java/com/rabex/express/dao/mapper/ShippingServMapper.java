package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.model.enumm.ShippingServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingServMapper implements RowMapper<ShippingServ> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, ShippingServiceType> enumConvertor = new StringToEnumConvertor<>(ShippingServiceType.class);

    public ShippingServMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public ShippingServ mapRow(ResultSet resultSet, int row) throws SQLException {

        return ShippingServ.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .name(resultSet.getString(prefix + "name"))
                .slug(resultSet.getString(prefix + "slug"))
                .shortDescription(resultSet.getString(prefix + "short_description"))
                .details(resultSet.getString(prefix + "details"))
                .image(resultSet.getString(prefix + "image"))
                .expectedTime(resultSet.getString(prefix + "expected_time"))
                .type(enumConvertor.convert(resultSet.getString(prefix + "service_type")))
                .expectedDay(resultSet.getInt(prefix + "expected_day"))
                .createdAt(resultSet.getTimestamp(prefix + "created_at"))
                .modifiedAt(resultSet.getTimestamp(prefix + "modified_at"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
