package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.OrderStatus;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private RID id;
    private PersonInfo receiver;
    private PersonInfo sender;
    private Address receiverAddress;
    private Address senderAddress;
    private Parcel parcel;
    private DeliveryFailedAction deliveryFailedAction;
    private ShippingServ shippingService;
    private RID shippingService_id;
    private ShippingServ addOnShippingService;
    private OrderStatus status;
    private String code;
    private String note;
    private boolean receiveAtHome;
    private int failedCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public LocalDate getExpectedDate(){
        LocalDate date = createdAt.toLocalDateTime().toLocalDate();
        if (!date.isAfter(LocalDate.now())) return LocalDate.now().plusDays(1);
        return date.plusDays(shippingService.getExpectedDay());
    }
}
