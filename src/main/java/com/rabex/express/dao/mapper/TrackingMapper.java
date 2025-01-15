package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.TrackingRecord;
import com.rabex.express.model.enumm.TrackingStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackingMapper implements RowMapper<TrackingRecord> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, TrackingStatus> enumConvertor = new StringToEnumConvertor<>(TrackingStatus.class);

    public TrackingMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public TrackingRecord mapRow(ResultSet resultSet, int row) throws SQLException {
        return TrackingRecord.builder()
                .id(idConvertor.convert(resultSet.getString(getPrefix() + "id")))
                .status(enumConvertor.convert(resultSet.getString(getPrefix() + "status")))
                .createdAt(resultSet.getTimestamp(getPrefix() + "created_at"))
                .modifiedAt(resultSet.getTimestamp(getPrefix() + "modified_at"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
