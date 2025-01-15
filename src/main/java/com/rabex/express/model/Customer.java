package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private RID id;
    private RID defaultAddressId;
    private String phoneNumber;
    private String fullName;
    private String email;
    private String companyName;
    private String industry;
    private String channel;
    private List<ShippingAddress> addresses = new ArrayList<>();
}
