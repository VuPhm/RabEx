package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

import java.sql.Timestamp;

public class Role {
    private RID id;
    private RoleName name;
    private Timestamp created_at;
    private Timestamp modified_at;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Role{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", created_at=").append(created_at);
        sb.append(", modified_at=").append(modified_at);
        sb.append('}');
        return sb.toString();
    }

    public Role() {
    }

    public Role(RID id) {
        this.id = id;
    }

    public Role(RID id, RoleName name, Timestamp created_at, Timestamp modified_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }
}
