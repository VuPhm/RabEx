package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.User;
import com.rabex.express.model.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    private Convertor<String, RID> idConvertor = new StringToRidConvertor();
    private Convertor<String, UserStatus> enumConvertor = new StringToEnumConvertor<UserStatus>(UserStatus.class);
    private String prefix;

    public UserMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public User mapRow(ResultSet resultSet, int row) throws SQLException {
        return User.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .email(resultSet.getString(prefix + "email"))
                .avatar(resultSet.getString(prefix + "avatar"))
                .hashPassword(resultSet.getString(prefix + "hash_password"))
                .fullName(resultSet.getString(prefix + "full_name"))
                .status(enumConvertor.convert(resultSet.getString("user_status")) )
                .modifiedAt(resultSet.getTimestamp(prefix +"modified_at"))
                .createdAt(resultSet.getTimestamp(prefix + "created_at"))
                .verifiedAt(resultSet.getTimestamp(prefix + "verified_at"))
                .deleted(resultSet.getBoolean(prefix + "deleted"))
                .refreshToken(resultSet.getString(prefix + "refresh_token"))
                .build();

    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
