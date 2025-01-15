package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Customer;
import com.rabex.express.model.User;

import java.util.List;

public interface UserInfoService {
    List<User> findAll();

    // Tìm địa chỉ theo id
    User findById(RID id);
}
