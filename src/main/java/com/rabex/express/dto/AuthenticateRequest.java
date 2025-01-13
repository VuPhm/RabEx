package com.rabex.express.dto;

public record AuthenticateRequest(
        String email,
        String password,
        boolean remember
) {
}
