package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.ShippingServiceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ShippingServ {
    private RID id;
    private String name;
    private String slug;
    private String shortDescription;
    private String details;
    private String image;
    private String expectedTime;
    private List<PricingTier> pricingTiers;
    private ShippingServiceType type;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    private int expectedDay = 3;
    public static void main(String[] args) {
    }
}
