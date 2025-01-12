package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.ShippingRange;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
public class PricingTier {
    private RID id;
    private String description;
    private RID serviceId;
    private double weightStart;
    private double weightEnd;
    private double stepIncrement = 0.00;
    private double pricePerStep = 0.00;
    private ShippingRange shippingRange;
    private double basePrice;
    private Timestamp created_at;
    private Timestamp updated_at;

    public double getTotalPrice(double requestWeight){
        return stepIncrement == 0.0 ? basePrice : (basePrice + pricePerStep * (requestWeight - weightStart) / stepIncrement);
    }

}
