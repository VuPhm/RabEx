package com.rabex.express.model;

import java.sql.Timestamp;

public record Token(
        String value,
        Timestamp expiredAt
) {
}
