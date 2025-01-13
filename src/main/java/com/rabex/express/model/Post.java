package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Data
@Builder
public class Post {
    private RID id;                // char(16)
    private Address address;         // char(16)
    private String code;              // char(16)
    private String email;             // varchar(320)
    private String phoneNumber;       // varchar(10)
    private Staff manager;         // char(16)
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public Post() {
    }

    public Post(RID id, Address address, String code, String email, String phoneNumber, Staff manager, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.address = address;
        this.code = code;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.manager = manager;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }


}

