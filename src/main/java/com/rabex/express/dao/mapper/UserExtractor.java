package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Role;
import com.rabex.express.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExtractor implements ResultSetExtractor<List<User>> {

    public UserExtractor(String userPrefix, String rolePrefix) {
        this.userPrefix = userPrefix;
        this.rolePrefix = rolePrefix;
    }

    private String userPrefix;
    private String rolePrefix;

    private Convertor<String, RID> ridConvertor = new StringToRidConvertor();

    @Override
    public List<User> extractData(ResultSet resultSet) throws SQLException {
        UserMapper userMapper = new UserMapper(userPrefix);
        RoleMapper roleMapper = new RoleMapper(rolePrefix);

        Map<RID, User> users = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            //1
            RID userId = ridConvertor.convert(resultSet.getString(userPrefix + "id"));
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
