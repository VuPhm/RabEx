package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

public class Staff {
    private RID id;
    private RID post_id;
    private String position;
    private String phone_number;

    public Staff() {
    }

    public Staff(RID id, RID post_id, String position, String phone_number) {
        this.id = id;
        this.post_id = post_id;
        this.position = position;
        this.phone_number = phone_number;
    }

    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public RID getPost_id() {
        return post_id;
    }

    public void setPost_id(RID post_id) {
        this.post_id = post_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
