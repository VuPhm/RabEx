package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.model.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
public class StaffMapper implements RowMapper<Staff> {
    private final String prefix;

    @Override
    public Staff mapRow(ResultSet resultSet, int row) throws SQLException {
        return null;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
