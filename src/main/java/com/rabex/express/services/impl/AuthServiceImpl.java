package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.UserDao;
import com.rabex.express.model.User;
import com.rabex.express.services.AuthService;
import jakarta.inject.Inject;

public class AuthServiceImpl implements AuthService {
    @Inject
    private UserDao userDao;

    @Override
    public User login(String email, String hashPassword) {
        if (userDao.existByEmail(email)) {
            User u = userDao.findByEmail(email);
            if (u != null)
                if( u.getHashPassword().equals(hashPassword))
                    return u;
        }
        return null;
    }
}
