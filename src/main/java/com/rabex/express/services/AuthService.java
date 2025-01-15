package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.User;

public interface AuthService {
    User login(String email, String hashPassword);
}
