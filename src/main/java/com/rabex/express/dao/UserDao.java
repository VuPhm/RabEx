package com.rabex.express.dao;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;
import com.rabex.express.model.User;

public interface UserDao {
    User findUserById(RID id);

    Page<User> findAllUsers(Pageable pageable);

    boolean insert(User user);
}
