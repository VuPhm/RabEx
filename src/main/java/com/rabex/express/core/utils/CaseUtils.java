package com.rabex.express.core.utils;

public class CaseUtils {
    public static String toSnakeCase(String camelCase) {
        if (camelCase == null || camelCase.isEmpty()) {
            return camelCase;
        }
        // Convert camelCase to snake_case using regex
        return camelCase.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    public static String toSnakeCaseWithDots(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Replace dots with underscores
        input = input.replace(".", "_");

        // Handle camelCase to snake_case
        input = input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

        return input;
    }
}
