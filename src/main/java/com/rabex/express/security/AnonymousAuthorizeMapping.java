package com.rabex.express.security;

public class AnonymousAuthorizeMapping extends AbstractAuthorizeMapping{

    public AnonymousAuthorizeMapping(String pattern) {
        super(pattern);
    }

    @Override
    public boolean verify(Authentication authentication) {
        return !authentication.isAuthenticated();
    }
}
