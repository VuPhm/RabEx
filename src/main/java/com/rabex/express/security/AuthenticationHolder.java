package com.rabex.express.security;

import jakarta.servlet.http.HttpServletRequest;

public class AuthenticationHolder {
    public static Authentication getAuthentication(HttpServletRequest request){
        return (Authentication) request.getSession(true).getAttribute("AUTHENTICATION");
    }
}
