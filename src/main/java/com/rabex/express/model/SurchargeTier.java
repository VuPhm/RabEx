package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.UnitType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@ToString
public class SurchargeTier {
    private RID id;
    private String description;
    private RID serviceId;
    private double weightStart;
    private double weightEnd;
    private double stepIncrement = 0.00;
    private double pricePerStep = 0.00;
    private double basePrice;
    private UnitType unitType;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public String displayInfo() {
        int price;
        if (unitType == UnitType.NONE) {
            price = (int) basePrice;
            return price > 0 ? price + "đ/bưu phẩm" : "Miễn phí";
        } else if (unitType == UnitType.VNĐ) {
            return ((pricePerStep / stepIncrement)*1000 > 0) ? (pricePerStep / stepIncrement) + "% giá trị kiện hàng" : "Miễn phí";
        } else if (unitType == UnitType.KG) {
            price = (int) (basePrice + pricePerStep);
            return (price > 0) ? (price) + "đ/kg" : "Miễn phi";
        }
        return "";
    }
}
