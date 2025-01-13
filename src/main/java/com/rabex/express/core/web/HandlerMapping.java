package com.rabex.express.core.web;

import jakarta.servlet.http.HttpServletRequest;

public interface HandlerMapping {
    RequestHandler getHandler();
    PathPattern getPathPattern();
}
