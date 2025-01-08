package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Address;
import com.rabex.express.model.Customer;
import com.rabex.express.model.PersonInfo;
import com.rabex.express.model.ShippingAddress;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerExtractor implements ResultSetExtractor<List<Customer>> {
    private final RowMapper<Customer> customerMapper;
    private final RowMapper<Address> addressMapper;
    private final RowMapper<PersonInfo> infoRowMapper;

    public CustomerExtractor(RowMapper<Customer> customerMapper, RowMapper<Address> addressMapper, RowMapper<PersonInfo> infoRowMapper) {
        this.customerMapper = customerMapper;
        this.addressMapper = addressMapper;
        this.infoRowMapper = infoRowMapper;
    }

    private final Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    @Override
    public List<Customer> extractData(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            System.out.println("ResultSet is null");
            return new ArrayList<>();
        }
        Map<RID, Customer> customers = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            //1
            RID customerId = ridConvertor.convert(resultSet.getString(customerMapper.getPrefix() + "id"));

            //lay customer tu map
            Customer customer = customers.get(customerId);
            if (customer == null) {
                // new khong co
                // lay customer tu resulSet
                customer = customerMapper.mapRow(resultSet, i);

                //add vao map
                customers.put(customerId, customer);
                customer.setAddresses(new ArrayList<>());

            }

            Address address = addressMapper.mapRow(resultSet, i);
            PersonInfo personInfo = infoRowMapper.mapRow(resultSet, i);
            if (address != null && personInfo != null)
                customer.getAddresses().add(new ShippingAddress(address, personInfo));

            i++;
        }
        return customers.values().stream().toList();

    }
}
