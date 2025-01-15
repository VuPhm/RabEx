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
        return !(longg * 1000 > 0 && wide * 1000 > 0 && height * 1000 > 0);
    }

    // unit: gram
    public double getOrTransformedWeight() {
        return !getUnknownWeight() ? getWeight()
                : (!unknownVolume() ? this.longg * this.wide * this.height / 5 : -1);
    }

    public boolean isInProvince() {
        return getProvince(senderAddress).equals(getProvince(receiverAddress));
    }

    public String getProvince(String address) {
        return address.split("/")[0].trim();
    }

    public boolean isValid() {
        return !(getSenderAddress().equals("none") || getReceiverAddress().equals("none"));
    }
}
