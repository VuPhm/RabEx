package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.UserDao;
import com.rabex.express.dao.mapper.RoleMapper;
import com.rabex.express.dao.mapper.UserExtractor;
import com.rabex.express.dao.mapper.UserMapper;
import com.rabex.express.model.Role;
import com.rabex.express.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class DefaultUserDao extends TemplateDao<User> implements UserDao {
    private static final String QUERY_SQL = "SELECT u.id as user_id, u.avatar as user_avatar , u.email as user_email, u.full_name as user_full_name, u.status as user_satatus, u.refresh_token AS user_refresh_token, u.created_at AS user_created_at, u.hash_password AS user_hash_password, u.modified_at AS user_modified_at, u.verified_at AS user_verified_at, r.id as role_id, r.name AS role_name, r.created_at AS role_created_at, r.updated_at as role_modified_at FROM users u LEFT JOIN users_roles ur ON u.id = ur.user_id LEFT JOIN roles r ON r.id = ur.role_id";
    private UserMapper userMapper;

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
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM users";
    }

    @Override
    protected ResultSetExtractor<List<User>> extractor() {
        return new UserExtractor(rowMapper(), new RoleMapper("role_"));
    }

    @Override
    public boolean existByEmail(String email) {
        String sql = new StringJoiner(" ")
                .add(QUERY_SQL)
                .add("WHERE u.email = ?")
                .toString();
        return count(sql, email) > 0;
    }

    @Override
    public User findByEmail(String email) {
        String sql = new StringJoiner(" ")
                .add(QUERY_SQL)
                .add("WHERE u.email = ?")
                .toString();
        List<User> users = query(sql, extractor(), email);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public boolean insert(User user) {
        String insertUsers = "INSERT INTO users(id, full_name, email, status, avatar, hash_password, verifiedAt, refreshToken) VALUES(?, ?, ? ,? ,? ,? ,? ,?)";

        // insert new user to database
        boolean success = insert(insertUsers, user.getId(), user.getFullName(), user.getEmail(), user.getStatus(), user.getAvatar(), user.getHashPassword(), user.getVerifiedAt(), user.getRefreshToken());

        //check result
        if (!success) return false;

        // insert relationship between Users And Roles
        return insertRelationShip(user.getId(), user.getRoles());
    }

    public boolean insertRelationShip(RID userId, List<Role> roles) {
        String insertRoles = "INSERT INTO users_roles(user_id, roles_id) VALUES";
        StringJoiner tmp = new StringJoiner(",");
        List<Object> insertRoleValue = new ArrayList<>();
        roles.forEach((role -> {
            tmp.add("(?, ?)");
            insertRoleValue.add(userId);
            insertRoleValue.add(role.getId());
        }));
        String sql = insertRoles + " " + tmp.toString();
        System.out.println(sql);
        System.out.println(insertRoleValue);
        return insert(sql, insertRoleValue.toArray());
    }

    @Override
    public boolean update(RID id, User request) {
        return false;
    }
}
