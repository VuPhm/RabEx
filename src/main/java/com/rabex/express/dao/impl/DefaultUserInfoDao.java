package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.UserInfoDao;
import com.rabex.express.dao.mapper.UserMapper;
import com.rabex.express.model.Customer;
import com.rabex.express.model.User;

public class DefaultUserInfoDao extends TemplateDao<User> implements UserInfoDao {
    private final static String QUERY_SQL = "SELECT this.id AS user_id, this.email AS user_email, this.avatar AS user_avatar, this.hash_password AS user_hash_password, this.full_name AS user_full_name, this.status AS user_status, this.modified_at AS user_modified_at, this.created_at AS user_created_at, this.verified_at AS user_verified_at, this.deleted AS user_deleted, this.refresh_token AS user_refresh_token, c.id AS cus_id, c.default_address_id AS cus_default_address, c.phone_number AS cus_phone_number, c.full_name AS cus_full_name, c.email AS cus_email, c.company_name AS cus_company, c.industry AS cus_industry, c.channel AS cus_channel FROM users this LEFT JOIN customers c on this.id = c.id";
    private UserMapper userMapper;
    @Override
    protected String table() {
        return "users";
    }

    @Override
    protected RowMapper<User> rowMapper() {
        if (userMapper == null)
            userMapper = new UserMapper("user_");
        return userMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    public boolean insert(User request) {
        return false;
    }

    @Override
    public boolean update(RID id, User request) {
        String updateUser = "UPDATE users SET full_name = ?, email = ?, status = ?, avatar = ?, hash_password = ?, verified_at = ?, refresh_token = ? WHERE id = ?";
        // Update `users` table
        return update(updateUser,
                request.getFullName(),
                request.getEmail(),
                request.getStatus(),
                request.getAvatar(),
                request.getHashPassword(),
                request.getVerifiedAt(),
                request.getRefreshToken(),
                id);
    }

    public Customer findCustomerByUserId(RID userId) {
        String query = "SELECT id, default_address_id, phone_number, full_name, email, company_name, industry, channel FROM customers WHERE id = ?";

        try {
            // Sử dụng phương thức query tiện ích (nếu có)
            return query(query, resultSet -> {
                Customer customer = new Customer();
                customer.setId(resultSet.getObject("id", RID.class));
                customer.setDefaultAddressId(resultSet.getObject("default_address_id", RID.class));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
                customer.setFullName(resultSet.getString("full_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setCompanyName(resultSet.getString("company_name"));
                customer.setIndustry(resultSet.getString("industry"));
                customer.setChannel(resultSet.getString("channel"));
                return customer;
            }, userId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving customer by user ID", e);
        }
    }
}