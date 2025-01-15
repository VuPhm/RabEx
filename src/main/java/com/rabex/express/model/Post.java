package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Post {
    private RID id;                // char(16)
    private Address address;         // char(16)
    private String code;              // char(16)
    private String email;             // varchar(320)
    private String phoneNumber;       // varchar(10)
//    private RID managerId;         // char(16)
    private User manager;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

}

