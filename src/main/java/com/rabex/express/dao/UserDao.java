package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    boolean existByEmail(String email);

    Optional<User> findByEmail(String email);
}
