package com.rabex.express.core.web;

import com.rabex.express.core.dao.RID;
import com.rabex.express.security.Authentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import static com.rabex.express.core.web.WebUtils.mapRequestBody;

class ServletHandlerAction implements HandlerAction {
    private HttpServletRequest request;
    private Authentication authentication;
    private HttpServletResponse response;
    private Map<String, String> pathVariables;

    @Override
    public <T> T getPathVariable(String name, Class<T> clazz) {
        String originalValue = pathVariables.get(name);
        return from(originalValue, clazz);
    }

    @Override
    public <T> T getParam(String name, Class<T> clazz, T defaultValue) {
        String originalValue = request.getParameter(name);
        if (originalValue == null) return defaultValue;
        return from(originalValue, clazz);
    }


    private <T> T from(String originalValue, Class<T> clazz) {
        try {
            if (clazz == Integer.class) {
                return (T) Integer.valueOf(originalValue);
            } else if (clazz == Double.class) {
                return (T) Double.valueOf(originalValue);
            } else if (clazz == Boolean.class) {
                return (T) Boolean.valueOf(originalValue);
            } else if (clazz == String.class) {
                return (T) originalValue;
            } else if (clazz == RID.class) {

                return (T) RID.from(originalValue);
            } else {
                throw new IllegalArgumentException("Unsupported type: " + clazz);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to convert value: " + originalValue + " to type: " + clazz, e);
        }
    }


    @Override
    public OutputStream getOutputStream() throws IOException {
        return response.getOutputStream();
    }

    @Override
    public <T> BindingResult<T> bindingResult(Class<T> clazz) {
        T body = mapRequestBody(clazz, request);
        return new DefaultBindingResult<>(null, body);
    }

    @Override
    public <T> BindingResult<T> bindingResult(Class<T> clazz, Validator<T> validator) {
        T body = mapRequestBody(clazz, request);
        var errors = validator.validate(body);
        return new DefaultBindingResult<>(errors, body);
    }


    public static final class ServletHandlerActionBuilder {
        private HttpServletRequest request;
        private Authentication authentication;
        private HttpServletResponse response;
        private Map<String, String> pathVariables;

        private ServletHandlerActionBuilder() {
        }

        public static ServletHandlerActionBuilder aServletHandlerAction() {
            return new ServletHandlerActionBuilder();
        }

        public ServletHandlerActionBuilder request(HttpServletRequest request) {
            this.request = request;
            return this;
        }

        public ServletHandlerActionBuilder authentication(Authentication authentication) {
            this.authentication = authentication;
            return this;
        }

        public ServletHandlerActionBuilder response(HttpServletResponse response) {
            this.response = response;
            return this;
        }

        public ServletHandlerActionBuilder pathVariables(Map<String, String> pathVariables) {
            this.pathVariables = pathVariables;
            return this;
        }


        public ServletHandlerAction build() {
            ServletHandlerAction servletHandlerAction = new ServletHandlerAction();
            servletHandlerAction.pathVariables = this.pathVariables;
            servletHandlerAction.request = this.request;
            servletHandlerAction.authentication = this.authentication;
            servletHandlerAction.response = this.response;
            return servletHandlerAction;
        }
    }
}

