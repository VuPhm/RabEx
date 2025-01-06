package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.DeliveryFailedAction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryFailedActionMapper implements RowMapper<DeliveryFailedAction> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();


    public DeliveryFailedActionMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public DeliveryFailedAction mapRow(ResultSet resultSet, int row) throws SQLException {
        return DeliveryFailedAction.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .name(resultSet.getString(prefix + "name"))
                .description(resultSet.getString(prefix + "description"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
