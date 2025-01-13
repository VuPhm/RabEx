package com.rabex.express.security;

import com.rabex.express.core.dao.RID;

import java.util.Collection;

public interface Authentication {

    boolean isAuthenticated();

    Collection<? extends GrantedAuthority> authorities();

    RID identity();

    Principal principal();
}
