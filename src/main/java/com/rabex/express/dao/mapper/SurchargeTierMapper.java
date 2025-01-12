package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.model.ShippingServiceType;
import com.rabex.express.model.SurchargeTier;
import com.rabex.express.model.UnitType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurchargeTierMapper implements RowMapper<SurchargeTier> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, UnitType> enumConvertor = new StringToEnumConvertor<>(UnitType.class);

    public SurchargeTierMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public SurchargeTier mapRow(ResultSet resultSet, int row) throws SQLException {

        return SurchargeTier.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .description(resultSet.getString(prefix + "description"))
                .serviceId(idConvertor.convert(resultSet.getString(prefix + "serviceId")))
                .weightStart(resultSet.getDouble(prefix + "weightStart"))
                .weightEnd(resultSet.getDouble(prefix + "weightEnd"))
                .stepIncrement(resultSet.getDouble(prefix + "stepIncrement"))
                .pricePerStep(resultSet.getDouble(prefix + "pricePerStep"))
                .basePrice(resultSet.getDouble(prefix + "basePrice"))
                .unitType(enumConvertor.convert(resultSet.getString(prefix + "unitType")))
//                .createdAt(resultSet.getTimestamp(prefix + "createdAt"))
//                .updatedAt(resultSet.getTimestamp(prefix + "updatedAt"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
