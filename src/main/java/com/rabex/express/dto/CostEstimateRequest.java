package com.rabex.express.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CostEstimateRequest {
    String senderAddress;
    String receiverAddress;
    Double weight;
    Boolean unknownWeight = false;
    Double longg;
    Double wide;
    Double height;

    public boolean unknownVolume() {
        return this.getLongg() <= 0 || this.getHeight() <= 0 || this.getWeight() <= 0;
    }

    public double getOrTransformedWeight() {
        return getUnknownWeight() ?
                (unknownVolume() ? 0 : this.longg * this.wide * this.height / 5000)
                : getWeight(); // cm to kg
    }

    public boolean isInProvince() {
        return getProvince(senderAddress).equals(getProvince(receiverAddress));
    }

    public String getProvince(String address) {
        return address.split("/")[0].trim();
    }

}