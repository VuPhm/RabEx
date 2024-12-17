package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.User;

public interface UserDao extends Dao<User> {
    boolean existByEmail(String email);

    User findByEmail(String email);
}
