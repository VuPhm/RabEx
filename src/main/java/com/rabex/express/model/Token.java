package com.rabex.express.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record Token(
        String value,
        Timestamp expiredAt
) {

    public boolean validate(String value){
        if (this.value ==  null) return false;
        if (LocalDateTime.now().isAfter(expiredAt.toLocalDateTime()))
            return false;
        return this.value.equals(value);
    }
}
