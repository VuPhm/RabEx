package com.rabex.express.dto;

public record RegisterRequest(
        String email,
        String fullName,
        String password,
        String confirmPassword
) {
}
