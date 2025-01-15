package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.UserInfoDao;
import com.rabex.express.model.User;
import com.rabex.express.services.UserInfoService;
import jakarta.inject.Inject;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {
    @Inject
    private UserInfoDao userInfoDao;

    @Override
    public List<User> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public User findById(RID id) {
        return userInfoDao.findById(id).orElse(null);
    }
}
