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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringJoiner;

public class DefaultUserDao extends TemplateDao<User> implements UserDao {
    private static final String QUERY_SQL = "SELECT this.id as user_id, this.deleted as user_deleted, this.avatar as user_avatar , this.email as user_email, this.full_name as user_full_name, this.status as user_status, this.refresh_token AS user_refresh_token, this.created_at AS user_created_at, this.hash_password AS user_hash_password, this.modified_at AS user_modified_at, this.verified_at AS user_verified_at, r.id as role_id, r.name AS role_name, r.created_at AS role_created_at, r.modified_at as role_modified_at FROM users this LEFT JOIN users_roles ur ON this.id = ur.user_id LEFT JOIN roles r ON r.id = ur.role_id";
    private static final String INSERT_SQL = "INSERT INTO users(id, full_name, email, status, avatar, hash_password, verified_at, refresh_token) VALUES(?, ?, ? ,? ,? ,? ,? ,?)";
    private static final String USER_PREFIX = "user_";
    private static final String ROLE_PREFIX = "role_";

    private UserMapper userMapper;

    @Override
    protected RowMapper<User> rowMapper() {
        if (userMapper == null)
            userMapper = new UserMapper(USER_PREFIX);
        return userMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }


    @Override
    protected String table() {
        return "users";
    }

    @Override
    protected ResultSetExtractor<List<User>> extractor() {
        return new UserExtractor(rowMapper(), new RoleMapper(ROLE_PREFIX));
    }

    @Override
    public boolean existByEmail(String email) {
        String sql = countAllSql() + " WHERE email = ?";
        return count(sql, email) > 0;
    }

    @Override
    public User findByEmail(String email) {
        String sql = new StringJoiner(" ")
                .add(QUERY_SQL)
                .add("WHERE this.email = ?")
                .toString();
        List<User> users = query(sql, extractor(), email);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public boolean insert(User user) {
        return executeTransaction((connection) -> {
            //insert user
            PreparedStatement insertUsersStatement = connection.prepareStatement(INSERT_SQL);
            setParameter(insertUsersStatement, user.getId(), user.getFullName(), user.getEmail(), user.getStatus(), user.getAvatar(), user.getHashPassword(), user.getVerifiedAt(), user.getRefreshToken());
            boolean success = insertUsersStatement.executeUpdate() > 0;

            return success && insertUserRoleRelationship(user, connection);
        });
    }

    @Override
    public boolean update(RID id, User user) {
        String updatesUserSql = "UPDATE users SET full_name = ?, email = ?, status = ?, avatar = ?, hash_password = ?, verified_at = ?, refresh_token = ? WHERE id = ?;";
        String deleteRelationshipSql = "DELETE FROM users_roles WHERE user_id = ?";

        return executeTransaction(connection -> {
            boolean success = false;

            PreparedStatement s1 = connection.prepareStatement(updatesUserSql);
            setParameter(s1, user.getFullName(), user.getEmail(), user.getStatus(), user.getAvatar(), user.getHashPassword(), user.getVerifiedAt(), user.getRefreshToken(), id);
            success = s1.execute();

            PreparedStatement s2 = connection.prepareStatement(deleteRelationshipSql);
            setParameter(s2, id);
            success = success && s2.execute();

            success = success && insertUserRoleRelationship(user, connection);

            System.out.println(success);
            return success;
        });
    }

    protected boolean isSuccessAll(int[] affectedRows) {
        boolean rolesInserted = true;
        for (int affectedRow : affectedRows) {
            if (affectedRow <= 0) {
                rolesInserted = false;
                break;
            }
        }
        return rolesInserted;
    }

    protected boolean insertUserRoleRelationship(User user, Connection connection) throws SQLException {
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            String insertRelationshipSql = "INSERT INTO users_roles(user_id, role_id) VALUES (?, ?)";
            PreparedStatement insertRelationshipStatement = connection.prepareStatement(insertRelationshipSql);
            for (Role role : user.getRoles()) {
                setParameter(insertRelationshipStatement, user.getId(), role.getId());
                insertRelationshipStatement.addBatch();
            }
            int[] affectedRows = insertRelationshipStatement.executeBatch();
            return isSuccessAll(affectedRows);
        } else {
            return false;
        }

    }
}
