package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.RegisterRequest;
import com.rabex.express.model.UserPrincpal;

public interface UserService {
    RID register(RegisterRequest request);

    UserPrincpal authenticate(String email, String password, Boolean remember);
}
