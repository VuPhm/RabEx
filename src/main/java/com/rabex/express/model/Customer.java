package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.*;

import java.util.List;
@Getter
@Setter
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
    private String industry;
    private String channel;
    private List<Address> addresses;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", defaultAddressId=" + defaultAddressId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", channel='" + channel + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
