package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.*;

import java.sql.Timestamp;
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private RID id;
    private RID receiverId;
    private RID senderId;
    private Address receiverAddress;
    private Address senderAddress;
    private RID methodId;
    private Parcel parcel;
    private RID deliveryFailedActionId;
    private RID shippingServiceId;
    private OrderStatus status;
    private String code;
    private String note;
    private boolean receiveAtHome;
    private int failedCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
