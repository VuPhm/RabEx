package com.rabex.express.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddressForm {
    private String fullName;
    private String phoneNumber;
    private String addressType;
    private String province;
    private String district;
    private String ward;
    private String description;
    private Boolean addressDefault;
    private String address;
}
