package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Data;

@Data
public class PersonInfo {
    private RID id;                // binary(16)
    private String fullName;          // varchar(45)
    private String email;
}
