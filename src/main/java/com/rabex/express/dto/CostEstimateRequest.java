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
        return (this.getLongg() > 0 && this.getHeight() > 0 && this.getWeight() > 0);
    }

    public double getOrTransformedWeight() {
        return !getUnknownWeight() ? getWeight()
                : (unknownVolume() ? this.longg * this.wide * this.height / 5000 : -1);
    }

    public boolean isInProvince() {
        return getProvince(senderAddress).equals(getProvince(receiverAddress));
    }

    public String getProvince(String address) {
        return address.split("/")[0].trim();
    }

    public boolean isValid() {
        return !(getSenderAddress().equals("none") || getReceiverAddress().equals("none"))
                && !(unknownVolume() && getUnknownWeight());

    }
}
