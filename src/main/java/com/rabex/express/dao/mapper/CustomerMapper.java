package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerMapper implements RowMapper<Customer> {
    private String prefix;

    public CustomerMapper(String prefix) {
        this.prefix = prefix;
    }

    private Convertor<String, RID> idConvertor = new StringToRidConvertor();

    @Override
    public Customer mapRow(ResultSet resultSet, int row) throws SQLException {
        return Customer.builder()
                .id(idConvertor.convert(resultSet.getString(prefix + "id")))
                .defaultAddressId(idConvertor.convert(resultSet.getString(prefix + "default_address")))
                .phoneNumber(resultSet.getString(prefix + "phone_number"))
                .fullName(resultSet.getString(prefix + "full_name"))
                .email(resultSet.getString(prefix + "email"))
                .companyName(resultSet.getString(prefix + "company"))
                .industry(resultSet.getString(prefix + "industry"))
                .channel(resultSet.getString(prefix + "channel"))
                .addresses(new ArrayList<>())
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
