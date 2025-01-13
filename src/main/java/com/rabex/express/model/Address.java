package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.*;

import java.sql.Timestamp;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private RID id;              // char(16)
    private String description;     // text
    private String ward;            // varchar(45)
    private String district;        // varchar(45)
    private String province;        // varchar(45)
    private AddressType addressType;
    private Timestamp createdAt;    // timestamp
    private Timestamp modifiedAt;   // timestamp
}

