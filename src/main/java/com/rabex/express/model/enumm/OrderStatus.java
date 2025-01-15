package com.rabex.express.model.enumm;

public enum OrderStatus {
    PENDING, PROCESSED, CANCELLED, DONE, RETURNED, TRANSIT;
    @Override
    public String toString() {
        return switch (this) {
            case PENDING -> "Đang chờ xử lý";
            case PROCESSED -> "Đã xử lý";
            case CANCELLED -> "Đã hủy";
            case DONE -> "Đã hoàn thành";
            case RETURNED -> "Đã trả lại";
            case TRANSIT -> "Đang vận chuyển";
        };
    }

    }
