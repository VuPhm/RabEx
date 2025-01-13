package com.rabex.express.security;

import com.rabex.express.core.dao.RID;

import java.util.Collection;
import java.util.Collections;

public class DefaultAuthentication implements Authentication {
    private Principal principal;

    public DefaultAuthentication(Principal principal) {
        this.principal = principal;
    }

    @Override
    public boolean isAuthenticated() {
        return principal != null;
    }

    @Override
    public Collection<? extends GrantedAuthority> authorities() {
        return principal == null ? Collections.emptyList() : principal.authorities();
    }

    @Override
    public RID identity() {
        return principal == null ? null : principal.id();
    }

    @Override
    public Principal principal() {
        return principal;
    }
}
