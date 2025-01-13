package com.rabex.express.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingAddressForm {
    private String fullName;
    private String phoneNumber;
    private String addressType;
    private String province;
    private String district;
    private String ward;
    private String description;
    private Boolean addressDefault;
}
