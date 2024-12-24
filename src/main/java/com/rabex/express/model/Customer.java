package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private RID id;
    private RID defaultAddressId;
    private String phoneNumber;
    private String fullName;
    private String email;
    private String companyName;
    private String quantityOrder;
    private String industry;
    private String channel;
    private List<Address> addresses;
}
