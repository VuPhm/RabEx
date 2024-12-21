package com.rabex.express.model;
import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class User {
    private RID id;                // binary(16)
    private String hashPassword;      // varchar(45)
    private String fullName;          // varchar(45)
    private boolean deleted;          // boolean
    private UserStatus status;             // smallint
    private Timestamp createdAt;      // timestamp
    private Timestamp modifiedAt;     // timestamp
    private String email;             // varchar(320)
    private Timestamp verifiedAt;     // timestamp (nullable)
    private String refreshToken;      // varchar(45)
    private String avatar;            // string
    private List<Role> roles;






}

