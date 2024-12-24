package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

import java.sql.Timestamp;

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

    public Order() {
    }

    public Order(RID id, RID receiverId, RID senderId, Address receiverAddress, Address senderAddress, RID methodId, Parcel parcel, RID deliveryFailedActionId, RID shippingServiceId, OrderStatus status, String code, String note, boolean receiveAtHome, int failedCount, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.receiverAddress = receiverAddress;
        this.senderAddress = senderAddress;
        this.methodId = methodId;
        this.parcel = parcel;
        this.deliveryFailedActionId = deliveryFailedActionId;
        this.shippingServiceId = shippingServiceId;
        this.status = status;
        this.code = code;
        this.note = note;
        this.receiveAtHome = receiveAtHome;
        this.failedCount = failedCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public RID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(RID receiverId) {
        this.receiverId = receiverId;
    }

    public RID getSenderId() {
        return senderId;
    }

    public void setSenderId(RID senderId) {
        this.senderId = senderId;
    }

    public Address getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(Address receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public RID getMethodId() {
        return methodId;
    }

    public void setMethodId(RID methodId) {
        this.methodId = methodId;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public RID getDeliveryFailedActionId() {
        return deliveryFailedActionId;
    }

    public void setDeliveryFailedActionId(RID deliveryFailedActionId) {
        this.deliveryFailedActionId = deliveryFailedActionId;
    }

    public RID getShippingServiceId() {
        return shippingServiceId;
    }

    public void setShippingServiceId(RID shippingServiceId) {
        this.shippingServiceId = shippingServiceId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isReceiveAtHome() {
        return receiveAtHome;
    }

    public void setReceiveAtHome(boolean receiveAtHome) {
        this.receiveAtHome = receiveAtHome;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(int failedCount) {
        this.failedCount = failedCount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
