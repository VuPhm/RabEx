package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShortStaffMapper implements RowMapper<Staff> {

    private final String prefix;
    private final Convertor<String, RID> ridConvertor;

    public ShortStaffMapper(String prefix, Convertor<String, RID> ridConvertor) {
        this.prefix = prefix;
        this.ridConvertor = ridConvertor;
    }

    public ShortStaffMapper(String prefix) {
        this.prefix = prefix;
        this.ridConvertor = new StringToRidConvertor();
    }


    @Override
    public Staff mapRow(ResultSet rs, int row) throws SQLException {
        return Staff.builder()
                .id(extractId(prefix, "id", rs))
                .position(rs.getString(prefix + "position"))
                .phoneNumber(rs.getString(prefix + "position"))
                .build();
    }

    private RID extractId(String prefix, String name, ResultSet rs) throws SQLException {
        return ridConvertor.convert(rs.getString(prefix + name));
    }
}
