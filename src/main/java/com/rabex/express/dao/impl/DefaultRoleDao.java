package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.RoleDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.RoleMapper;
import com.rabex.express.model.Role;
import com.rabex.express.model.enumm.RoleName;

import java.util.List;
import java.util.Optional;

public class DefaultRoleDao extends TemplateDao<Role> implements RoleDao {
    private RoleMapper roleMapper;

    @Override
    protected RowMapper<Role> rowMapper() {
        if (roleMapper == null)
            roleMapper = new RoleMapper("role_");
        return roleMapper;
    }

    @Override
    protected String querySql() {
        return "SELECT this.name as role_name, this.id role_id, this.created_at as role_created_at, this.modified_at as role_modified_at FROM roles this";
    }

    @Override
    protected String table() {
        return "roles";
    }

    @Override
    public boolean insert(Role request) {
        return insert("INSERT INTO roles(id, name) VALUE (?, ?)", request.getId(), request.getName());

    }

    @Override
    public boolean update(RID id, Role request) {
        return false;
    }

    @Override
    public Optional<Role> findByRoleName(RoleName roleName) {
        String sql = querySql() + " WHERE this.name = ?";
        List<Role> roles = query(sql, rowMapper(), roleName);
        return roles.stream().findFirst();
    }
}
