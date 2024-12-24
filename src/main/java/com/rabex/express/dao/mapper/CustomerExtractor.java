package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Address;
import com.rabex.express.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerExtractor implements ResultSetExtractor<List<Customer>> {
    private final RowMapper<Customer> customerMapper;
    private final RowMapper<Address> addressMapper;

    public CustomerExtractor(RowMapper<Customer> customerMapper, RowMapper<Address> addressMapper) {
        this.customerMapper = customerMapper;
        this.addressMapper = addressMapper;
    }

    private Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    @Override
    public List<Customer> extractData(ResultSet resultSet) throws SQLException {


        Map<RID, Customer> customers = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            //1
            RID customerId = ridConvertor.convert(resultSet.getString(customerMapper.getPrefix() + "id"));
            Customer customer = customers.get(customerId);
            if (customer == null) {
                customer = customerMapper.mapRow(resultSet, i);
                customer.setAddresses(new ArrayList<>());
                customers.put(customerId, customer);
            }

            Address address = addressMapper.mapRow(resultSet, i);
            customer.getAddresses().add(address);

            i++;
        }
        return customers.values().stream().toList();

    }
}
