package com.rabex.express.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateForm {
    private String receiverPhoneNumber;
    private String receiverFullName;
    private String receiverCodePost;
    private String receiverAddressDetail; // nguyên cái địa chỉ luôn :c
    private String receiverAddress; // nguyên cái địa chỉ luôn :c
    private String instruction; // hướng dẫn giao hàng: note trong db
    private String senderPhoneNumber;
    private String senderFullName;
    private String senderCodePost;
    private String senderAddressDetail; // nguyên cái địa chỉ luôn :c
    private String senderAddress; // nguyên cái địa chỉ luôn :c
    private double weight;
    private double longg;
    private double high;
    private double wide;
    private boolean collecter; // thu hộ
    private boolean fragile;
    private boolean shippingService;
}
