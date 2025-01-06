package com.rabex.express.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ShippingAddress {
    private Address address;
    private PersonInfo personInfo;


}
