package com.rabex.express.security;

public class SimpleGrantedAuthority implements GrantedAuthority{
    public SimpleGrantedAuthority(String authority) {
        this.authority = authority;
    }

    private String authority;
    @Override
    public String getAuthority() {
        return this.authority;
    }
}
