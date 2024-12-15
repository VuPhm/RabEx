package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();

    private String prefix;

    public UserMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public User mapRow(ResultSet resultSet, int row) throws SQLException {
        return new User(idConvertor.convert(resultSet.getString(prefix + "id")),
                resultSet.getString(prefix + "hashPassword"),
                resultSet.getString(prefix + "fullName"),
                resultSet.getBoolean(prefix + "deleted"),
                resultSet.getShort(prefix + "status"),
                resultSet.getTimestamp(prefix + "created_at"),
                resultSet.getTimestamp(prefix +"modified_at"),
                resultSet.getString(prefix + "email"),
                resultSet.getTimestamp(prefix + "verified_at"),
                resultSet.getString(prefix + "refreshToken"),
                resultSet.getString(prefix + "avatar"));
    }
}
