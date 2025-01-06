package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonInfo {
    private RID id;                // binary(16)
    private String phoneNumber;
    private String fullName;          // varchar(45)
    private String email;
}
