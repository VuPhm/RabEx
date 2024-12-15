package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Role;
import com.rabex.express.model.RoleName;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    private String prefix;
    private Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    private Convertor<String, RoleName> enumConvertor = new StringToEnumConvertor<>(RoleName.class);

    public RoleMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Role mapRow(ResultSet resultSet, int row) throws SQLException {
        return new Role(
                ridConvertor.convert(resultSet.getString(prefix + "id")),
                enumConvertor.convert(resultSet.getString(prefix + "role_name")),
                resultSet.getTimestamp(prefix + "created_at"),
                resultSet.getTimestamp(prefix + "modified_at")

        );
    }
}
