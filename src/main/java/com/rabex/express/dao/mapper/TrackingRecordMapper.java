package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Order;
import com.rabex.express.model.Post;
import com.rabex.express.model.Staff;
import com.rabex.express.model.TrackingRecord;
import com.rabex.express.model.enumm.RecordAction;
import lombok.Builder;

import java.sql.ResultSet;
import java.sql.SQLException;

@Builder
public class TrackingRecordMapper implements RowMapper<TrackingRecord> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private final Convertor<String, RecordAction> enumConvertor = new StringToEnumConvertor<>(RecordAction.class);

    private final RowMapper<Order> orderMapper;
    private final RowMapper<Post> postMapper;
    private final RowMapper<Staff> executorMapper;
    private final RowMapper<Staff> staffMapper;

    @Override
    public TrackingRecord mapRow(ResultSet resultSet, int row) throws SQLException {
        return TrackingRecord.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .orderCode(resultSet.getString(orderMapper.getPrefix() + "code"))
                .post(resultSet.getString(postMapper.getPrefix() + "title"))
                .action(enumConvertor.convert(resultSet.getString(prefix + "action")))
                .executor(executorMapper.mapRow(resultSet, row))
                .staff(staffMapper.mapRow(resultSet, row))
                .createdAt(resultSet.getTimestamp(prefix + "created_at"))
                .modifiedAt(resultSet.getTimestamp(prefix + "updated_at"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
