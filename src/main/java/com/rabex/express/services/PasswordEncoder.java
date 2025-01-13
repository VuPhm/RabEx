package com.rabex.express.services;

public interface PasswordEncoder {
    String encode(String s);
    boolean match(String encoded, String nonEncoded);
}
