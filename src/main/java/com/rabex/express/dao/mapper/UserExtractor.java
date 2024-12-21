package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.*;
import com.rabex.express.model.Role;
import com.rabex.express.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExtractor implements ResultSetExtractor<List<User>> {

    private final RowMapper<User> userMapper;
    private final RowMapper<Role> roleMapper;

    public UserExtractor(String userPrefix, String rolePrefix) {
        this.userMapper = new UserMapper(userPrefix);
        this.roleMapper = new RoleMapper(rolePrefix);
    }

    public UserExtractor(RowMapper<User> userMapper, RowMapper<Role> roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }


    private Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    @Override
    public List<User> extractData(ResultSet resultSet) throws SQLException {


        Map<RID, User> users = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            //1
            RID userId = ridConvertor.convert(resultSet.getString(userMapper.getPrefix() + "id"));
            User user = users.get(userId);
            if (user == null) {
                user = userMapper.mapRow(resultSet, i);
                user.setRoles(new ArrayList<>());
                users.put(userId, user);
            }

            Role role = roleMapper.mapRow(resultSet, i);
            user.getRoles().add(role);

            i++;
        }
        return users.values().stream().toList();

    }
}
