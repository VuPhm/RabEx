package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.SurchargeTier;
import com.rabex.express.model.enumm.UnitType;

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
//                .serviceId(idConvertor.convert(resultSet.getString(prefix + "service_id")))
                .weightStart(resultSet.getDouble(prefix + "weight_start"))
                .weightEnd(resultSet.getDouble(prefix + "weight_end"))
                .stepIncrement(resultSet.getDouble(prefix + "step_increment"))
                .pricePerStep(resultSet.getDouble(prefix + "price_per_step"))
                .basePrice(resultSet.getDouble(prefix + "base_price"))
                .unitType(enumConvertor.convert(resultSet.getString(prefix + "unit_type")))
//                .createdAt(resultSet.getTimestamp(prefix + "createdAt"))
//                .updatedAt(resultSet.getTimestamp(prefix + "updatedAt"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
