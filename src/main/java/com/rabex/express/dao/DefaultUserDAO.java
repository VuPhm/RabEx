package com.rabex.express.dao;

import com.rabex.express.core.dao.AbstractDao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.data.*;
import com.rabex.express.dao.mapper.UserExtractor;
import com.rabex.express.dao.mapper.UserMapper;
import com.rabex.express.model.Role;
import com.rabex.express.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class DefaultUserDAO extends AbstractDao<User> implements UserDao {

    private static final String SELECT_SQL = "Select u.id as user_id FROM Users u LEFT JOIN users_roles ur ON u.user_id = ur.user_id LEFT JOIN ROlE r ON r.id = ur.role_id  ";
    private static final UserMapper DEFAULT_MAPPER = new UserMapper("user_id");

    public User findUserById(RID id) {
        String sql = SELECT_SQL + " where id = ?, deleted = ?";
        // sử dụng Extractor để mà map Users vs đầy đủ roles, dùng khi object phức tạp (Có chứ list model khác)
        List<User> users = query(sql, new UserExtractor("user_", "role_"), id, false);
        // sử RowMapper khi model đơn giản chỉ quan hệ 1:1 hoặc nhiều:1 (ở Model có 1 model khác)

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        String custome = "";
        return null;
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

    public List<User> findUsers() {
        return null;
    }

    public Page<User> findUsers(Pageable pageable) {
        Pageable test = new PageRequest(10, 3, Sort.UNSORTED);
        String selectSql = "Select * From Users where deleted = false";
        String countSql = "Select count(*) Users where deleted = false";

        return queryPage(selectSql, countSql, pageable, new UserMapper(""));
    }
}
