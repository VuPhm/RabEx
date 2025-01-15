package com.rabex.express.model.enumm;

import lombok.Getter;

@Getter
public enum RecordAction {
    PROCESSING, CREATED, DELIVERING, ARRIVED, RETURNING, RETURNED, RECEIVED, FAILED;

    @Override
    public String toString() {
        return switch (this) {
            case PROCESSING -> "Đang được xử lý";
            case CREATED -> "Đơn đã được tạo";
            case DELIVERING -> "Đang vận chuyển";
            case ARRIVED -> "Đã đến bưu cục tiếp theo";
            case RETURNING -> "Đang trả về bưu cục";
            case RETURNED -> "Đã trả về";
            case RECEIVED -> "Vận chuyển thành công";
            case FAILED -> "Vận chuyển thất bại";
        };
    }
}
