package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.Role;
import com.rabex.express.model.enumm.RoleName;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {
    Optional<Role> findByRoleName(RoleName roleName);
}
