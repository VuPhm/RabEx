package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class ShippingServ {
    private RID id;
    private String name;
    private String slug;
    private String shortDescription;
    private String details;
    private double methodCoefficient;
    private double unitCost;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
