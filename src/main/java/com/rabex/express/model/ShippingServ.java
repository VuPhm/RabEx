package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
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
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
