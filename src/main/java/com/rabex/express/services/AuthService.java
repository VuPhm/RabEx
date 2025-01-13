package com.rabex.express.services;

import com.rabex.express.dto.RegisterRequest;
import com.rabex.express.security.Authentication;

public interface AuthService {
    Authentication authenticate(String email, String password);

    boolean register(RegisterRequest request);

    boolean requestPasswordCode(String email);

    boolean requestVerifyCode(String email);

    boolean verify(String email, String code);


    boolean resetPassword(String email, String tokenValue, String password);
}
