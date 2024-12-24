package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.*;
import com.rabex.express.dao.CustomerDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.AddressMapper;
import com.rabex.express.dao.mapper.CustomerExtractor;
import com.rabex.express.dao.mapper.CustomerMapper;
import com.rabex.express.dao.mapper.PersonInfoMapper;
import com.rabex.express.model.Address;
import com.rabex.express.model.Customer;
import com.rabex.express.model.PersonInfo;
import com.rabex.express.model.ShippingAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DefaultCustomerDao extends TemplateDao<Customer> implements CustomerDao {
    private static final String QUERY_SQL = "SELECT this.id as cus_id, this.default_address_id as cus_default_address, this.phone_number as cus_phone_number, this.full_name as cus_full_name, this.email as cus_email, this.company_name as cus_company, this.industry as cus_industry, this.channel as cus_channel, a.id as address_id, a.description as address_des, a.ward as address_ward, a.district as address_dis, a.province as address_pro, a.address_type as address_type, a.created_at as address_created_at, a.modified_at as address_modified_at, pi.id as info_id, pi.full_name as info_full_name, pi.phone_number as info_phone FROM customers this LEFT JOIN shipping_address ac ON this.id = ac.customer_id LEFT JOIN address a ON ac.address_id = a.id LEFT JOIN person_info pi on ac.person_info_id = pi.id";
    private static final String INSERT_SQL = "INSERT INTO customers(id, default_address_id, phone_number, full_name, email, company_name, quantity_order, industry, channel) VALUES(?, ?, ? ,? ,? ,? ,? ,? , ?)";

    private CustomerMapper customerMapper;

    @Override
    protected ResultSetExtractor<List<Customer>> extractor() {
        return new CustomerExtractor(rowMapper(), new AddressMapper("address_"), new PersonInfoMapper("info_"));
    }

    @Override
    public boolean insert(Customer customer) {
        return executeTransaction((connection) -> {
            //insert user
            PreparedStatement insertCustomerStatement = connection.prepareStatement(INSERT_SQL);
            setParameter(insertCustomerStatement,
                    customer.getId(),
                    customer.getDefaultAddressId(),
                    customer.getPhoneNumber(),
                    customer.getFullName(),
                    customer.getEmail(),
                    customer.getCompanyName(),
                    customer.getIndustry(),
                    customer.getChannel());
            boolean success = insertCustomerStatement.executeUpdate() > 0;



            return success ;
        });
    }

    public boolean insertCustomerAddressRelationship(Customer customer, Connection connection) {
        // Ensure the customer and address list are valid
        if (customer.getAddresses() == null || customer.getAddresses().isEmpty()) {
            // If the address list is null or empty, return false as no relationships can be created
            return true;
        }

        // SQL query to insert into the address_customers relationship table
        String insertRelationshipSQL = "INSERT INTO shipping_address (address_id, person_info_id, customer_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertRelationshipSQL)) {
            // Iterate over each address associated with the customer
            for (ShippingAddress address : customer.getAddresses()) {

                Convertor<RID, String> idConvertor = new RidToStringConvertor();
                // Set the parameters for the SQL statement
                setParameter(preparedStatement, address.getAddress().getId(), address.getPersonInfo().getId(), customer.getId());
                // customer_id

                // Add the statement to the batch
                preparedStatement.addBatch();
            }

            // Execute the batch to insert all relationships
            int[] results = preparedStatement.executeBatch();

            // Verify if all inserts were successful
            for (int result : results) {
                if (result == PreparedStatement.EXECUTE_FAILED) {
                    return false; // Return false if any insert failed
                }
            }
            return true; // All inserts succeeded
        } catch (Exception e) {
            // Log the exception (or handle accordingly)
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(RID id, Customer request) {
        String deleteCustomer = "DELETE FROM address WHERE id = ?";
        return update(deleteCustomer, id);
    }

    @Override
    protected RowMapper<Customer> rowMapper() {
        if (customerMapper == null) customerMapper = new CustomerMapper("cus_");
        return customerMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM customers";
    }
}
