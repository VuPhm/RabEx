package com.rabex.express.security;

import java.util.Set;
       
public class AuthorityAuthorizeMapping extends AbstractAuthorizeMapping {
    private final Set<String> authorities;

    public AuthorityAuthorizeMapping(String pattern, Set<String> authorities) {
        super(pattern);
        this.authorities = authorities;
    }

    @Override
    public boolean verify(Authentication authentication) {
        return authentication.authorities().stream().map(GrantedAuthority::getAuthority).anyMatch(this.authorities::contains);
    }
}
