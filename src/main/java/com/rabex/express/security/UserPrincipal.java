package com.rabex.express.security;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.RoleName;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
public class UserPrincipal implements Principal {
    private RID id;
    private Set<GrantedAuthority> roles;
    private boolean isVerified;
    private String name;
    private String avatar;


    @Override
    public RID id() {
        return id;
    }

    @Override
    public Collection<GrantedAuthority> authorities() {
        return roles;
    }
}
