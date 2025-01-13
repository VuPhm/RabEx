package com.rabex.express.security;

import com.rabex.express.core.dao.RID;

import java.util.Collection;

public interface Principal {
    RID id();
    Collection<GrantedAuthority> authorities();
}
