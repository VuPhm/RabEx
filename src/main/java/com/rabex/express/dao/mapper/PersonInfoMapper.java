package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.model.PersonInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonInfoMapper implements RowMapper<PersonInfo> {
    private String prefix;

    public PersonInfoMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public PersonInfo mapRow(ResultSet resultSet, int row) throws SQLException {
        return new PersonInfo();
    }

    @Override
    public String getPrefix() {
        return RowMapper.super.getPrefix();
    }
}
