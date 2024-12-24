package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.AddressMapper;
import com.rabex.express.model.Address;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Singleton
public class DefaultAddressDao extends TemplateDao<Address> implements AddressDao {
    private static final String QUERY_SQL = "SELECT this.id as address_id, this.description as address_des, this.ward as address_ward, this.district as address_dis, this.province as address_pro, this.address_type as address_type, this.created_at as address_created_at, this.modified_at as address_modified_at from address this";
    private static final String INSERT_SQL = "INSERT INTO address(id, description, ward, district, province, address_type, created_at, modified_at) VALUES(?, ?, ? ,? ,? ,? ,? ,?)";

    private AddressMapper addressMapper;

    public DefaultAddressDao() {
    }


    @Override
    public boolean insert(Address address) {
        return executeTransaction((connection) -> {
            //insert user
            PreparedStatement insertUsersStatement = connection.prepareStatement(INSERT_SQL);
            setParameter(insertUsersStatement,
                    address.getId(),
                    address.getDescription(),
                    address.getWard(),
                    address.getDistrict(),
                    address.getProvince(),
                    address.getAddressType(),
                    address.getCreatedAt(),
                    address.getModifiedAt());
            boolean success = insertUsersStatement.executeUpdate() > 0;

            return success && insertAddressCustomerRelationship(address, connection);
        });
    }

    protected boolean insertAddressCustomerRelationship(Address address, Connection connection) {
//        // Ensure the customerId exists in the address object
//        if (address.getCustomerId() == null || address.getCustomerId().isEmpty()) {
//            // If customerId is null or empty, return false as we cannot create the relationship
//            return false;
//        }
//
//        // SQL query to insert into the address_customers relationship table
//        String insertRelationshipSQL = "INSERT INTO address_customers(address_id, customer_id) VALUES (?, ?)";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(insertRelationshipSQL)) {
//            // Set the parameters for the SQL statement
//            preparedStatement.setString(1, address.getId()); // address_id
//            preparedStatement.setString(2, address.getCustomerId()); // customer_id
//
//            // Execute the statement to insert the relationship
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            // Return true if the insertion was successful (at least one row was affected)
//            return rowsAffected > 0;
//        } catch (Exception e) {
//            // Log the exception (or handle accordingly)
//            e.printStackTrace();
//            return false;
//        }
        return false;
    }


    @Override
    public boolean update(RID id, Address address) {
        String updateAddress = "UPDATE address SET description = ?, ward = ?, district = ?, province = ?, address_type =?, modified_at = ? WHERE id = ?";
        // Update address
        return update(updateAddress,
                address.getDescription(),
                address.getWard(),
                address.getDistrict(),
                address.getProvince(),
                address.getAddressType(),
                address.getModifiedAt()
                );
    }

    @Override
    public boolean delete(RID id) {
        String deleteAddress = "DELETE FROM address WHERE id = ?";
        // Delete address
        return update(deleteAddress, id);
    }

    @Override
    protected RowMapper<Address> rowMapper() {
        if (addressMapper == null)
            addressMapper = new AddressMapper("address_");
        return addressMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM address";
    }

}
