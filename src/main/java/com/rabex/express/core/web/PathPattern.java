package com.rabex.express.core.web;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathPattern {
    // /users/{id}
    // /users/name
    private final String stringPattern;
    private HttpMethod method;

    public PathPattern(String stringPattern, HttpMethod method) {
        this.stringPattern = stringPattern;
        this.method = method;
    }

    public Map<String, String> extractPathVariables(String url) {
        // Define a regex to match path variables enclosed in curly braces
        String regex = "\\{([^}]+)}";
        Pattern pathVariablePattern = Pattern.compile(regex);
        Matcher patternMatcher = pathVariablePattern.matcher(stringPattern);

        // Extract path variable names
        List<String> pathVariableNames = new ArrayList<>();
        while (patternMatcher.find()) {
            pathVariableNames.add(patternMatcher.group(1)); // Group 1 contains the name inside the braces
        }

        // Replace {variableName} in the pattern with regex to extract values from the URL
        String urlRegex = stringPattern.replaceAll(regex, "([^/]+)");
        Pattern urlPattern = Pattern.compile(urlRegex);
        Matcher urlMatcher = urlPattern.matcher(url);

        Map<String, String> pathVariableMap = new LinkedHashMap<>();
        if (urlMatcher.matches()) {
            for (int i = 0; i < pathVariableNames.size(); i++) {
                pathVariableMap.put(pathVariableNames.get(i), urlMatcher.group(i + 1)); // Group 1+ matches values
            }
        }
        return pathVariableMap;
    }

    public boolean matches(String path, HttpMethod method) {
        // Define a regex to match path variables enclosed in curly braces
        String regex = "\\{([^}]+)}";
        Pattern pathVariablePattern = Pattern.compile(regex);
        Matcher patternMatcher = pathVariablePattern.matcher(stringPattern);

        // Replace {variableName} in the pattern with regex to extract values from the URL
        String urlRegex = stringPattern.replaceAll(regex, "([^/]+)");


        // Compile the final URL pattern
        Pattern urlPattern = Pattern.compile(urlRegex);
        Matcher urlMatcher = urlPattern.matcher(path);

        // Check if the path matches the pattern
        return urlMatcher.matches() && method.equals(this.method);
    }

    public static boolean arePatternsSimilar(String pattern1, String pattern2) {
        // Normalize the patterns by replacing placeholders with a common token
        String normalizedPattern1 = normalizePattern(pattern1);
        String normalizedPattern2 = normalizePattern(pattern2);

        // Compare the normalized patterns
        return normalizedPattern1.equals(normalizedPattern2);
    }

    private static String normalizePattern(String pattern) {
        // Replace placeholders of the form {anything} with a common placeholder
        return pattern.replaceAll("\\{[^/]+\\}", "{placeholder}");
    }

    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathPattern pattern = (PathPattern) o;
        return arePatternsSimilar(this.stringPattern, pattern.stringPattern) && Objects.equals(method, pattern.getMethod());
    }

    @Override
    public int hashCode() {
        String normalizedPattern = normalizePattern(stringPattern);
        // Generate the hash code for the normalized pattern
        return Objects.hash(normalizedPattern, method);
    }
}
