package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.PersonInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonInfoMapper implements RowMapper<PersonInfo> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();


    public PersonInfoMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public PersonInfo mapRow(ResultSet resultSet, int row) throws SQLException {
        return PersonInfo.builder().id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .phoneNumber(resultSet.getString(prefix+"phone_number"))
                .fullName(resultSet.getString(prefix + "full_name"))
                .email(resultSet.getString(prefix + "email"))
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    //
}
