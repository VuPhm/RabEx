package com.rabex.express.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CostEstimateRequest {
    private Address senderAddress;
    private Address receiverAddress;
    private double weight;
    private double length;
    private double width;
    private double height;
}
