package com.rabex.express.security;

import java.util.regex.Pattern;

public abstract class AbstractAuthorizeMapping implements AuthorizeMapping{
    private final String pattern;

    public AbstractAuthorizeMapping(String pattern) {
        this.pattern = validatePattern(pattern);
    }

    private String validatePattern(String pattern){
        return pattern;
    }

    @Override
    public boolean matchedPattern(String path) {
        String regex;

        // Determine pattern type
        if (getPattern().endsWith("/**")) {
            // Wildcard pattern: /admin/**
            String basePath = getPattern().substring(0, getPattern().length() - 3); // Remove `/**`
            regex = String.format("^%s(/.*)?$", Pattern.quote(basePath));
        } else if (getPattern().endsWith("/*")) {
            // Segment pattern: /admin/*
            String basePath = getPattern().substring(0, getPattern().length() - 2); // Remove `/*`
            regex = String.format("^%s(/[^/]+)?$", Pattern.quote(basePath));
        } else {
            // Exact match pattern: /admin
            regex = String.format("^%s$", Pattern.quote(getPattern()));
        }

        return Pattern.matches(regex, path);
    }

    @Override
    public String getPattern() {
        return pattern;
    }
}
