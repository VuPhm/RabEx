package com.rabex.express.model;

import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
public class ShippingAddress {
    private Address address;
    private PersonInfo personInfo;
}
