package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.ShippingServ;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingServMapper implements RowMapper<ShippingServ> {
    private String prefix;
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();

    public ShippingServMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public ShippingServ mapRow(ResultSet resultSet, int row) throws SQLException {

        return ShippingServ.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .name(resultSet.getString(prefix + "name"))
                .shortDescription(resultSet.getString(prefix + "short_description"))
                .details(resultSet.getString(prefix + "details"))
                .methodCoefficient(resultSet.getDouble(prefix + "shipping_method_coefficient"))
                .unitCost(resultSet.getDouble(prefix + "unit_cost"))
                .createdAt(resultSet.getTimestamp(prefix + "create_at"))
                .modifiedAt(resultSet.getTimestamp(prefix + "modified_at"))
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
