package com.rabex.express.dto;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.ShippingRange;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class PricingTiersTable {
    private RID id;
    private String description;
    private RID serviceId;
    private double weightStart;
    private double weightEnd;
    private double stepIncrement = 0.00;
    private double InPricePerStep = 0.00;
    private double outPricePerStep = 0.00;
    private double inProvinceBasePrice;
    private double outProvinceBasePrice;
}
