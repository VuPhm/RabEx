package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.UserDao;
import com.rabex.express.dto.RegisterRequest;
import com.rabex.express.model.UserPrincpal;
import com.rabex.express.services.UserService;
import jakarta.inject.Inject;

public class DefaultUserService implements UserService {

    @Inject
    private UserDao userDao;


    @Override
    public RID register(RegisterRequest request) {
        return null;
    }

    @Override
    public UserPrincpal authenticate(String email, String password, Boolean remember) {
        return null;
    }
}
