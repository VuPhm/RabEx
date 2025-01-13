package com.rabex.express.security;

public interface AuthorizeMapping {

    String getPattern();
    boolean verify(Authentication authentication);
    boolean matchedPattern(String pattern);
    default int index(){
        return 0;
    }
}
