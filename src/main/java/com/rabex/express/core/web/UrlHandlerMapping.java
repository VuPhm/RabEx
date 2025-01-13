package com.rabex.express.core.web;

import jakarta.servlet.http.HttpServletRequest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class UrlHandlerMapping implements HandlerMapping{
    private RequestHandler requestHandler;
    private PathPattern pattern;

    public UrlHandlerMapping(RequestHandler requestHandler, String stringPattern, HttpMethod method) {
        this.requestHandler = requestHandler;
        this.pattern = new PathPattern(stringPattern, method);
    }

    @Override
    public RequestHandler getHandler() {
        return requestHandler;
    }

    @Override
    public PathPattern getPathPattern() {
        return pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlHandlerMapping that = (UrlHandlerMapping) o;
        return that.pattern.equals(this.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern);
    }
}
