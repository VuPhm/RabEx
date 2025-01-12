package com.rabex.express.core.web;


import com.google.gson.Gson;
import com.rabex.express.domain.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

import static com.rabex.express.core.utils.Common.isEmpty;


public class WebUtils {
    public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }

    public static void redirect(HttpServletRequest request, HttpServletResponse response, String uri, boolean local) throws IOException {
        if (local){
            response.sendRedirect(request.getContextPath() + uri);
        } else {
            response.sendRedirect(uri);
        }
    }

    public static <T>void sendApiResponse(int statusCode, boolean success ,T body, HttpServletResponse response) throws IOException {
        response.setStatus(statusCode);
        response.setContentType("application/json");
        Gson gson = new Gson();
        ApiResponse<T> apiResponse = new ApiResponse<>(success, statusCode, body);
        String json = gson.toJson(apiResponse);
        response.getWriter().print(json);
    }

    public static String[] getSubPaths(HttpServletRequest request){
        if(isEmpty(request.getPathInfo())) return new String[0];
        String path = request.getPathInfo().replaceFirst("/", "");
        return path.split("/");
    }

    public static String getParameter(HttpServletRequest request, String name, String defaultValue){
        String param = request.getParameter(name);
        return isEmpty(param) ? defaultValue : param;
    }

    public static Integer getParameter(HttpServletRequest request, String name, Integer defaultValue){
        String param = request.getParameter(name);
        return isEmpty(param) ? defaultValue : Integer.parseInt(param);
    }

    public static Long getParameter(HttpServletRequest request, String name, Long defaultValue){
        String param = request.getParameter(name);
        return isEmpty(param) ? defaultValue : Long.parseLong(param);
    }

    public static <T>T mapRequestBody(Class<T> clazz, HttpServletRequest request){
        try {
            T t = clazz.getConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field: fields){
                field.setAccessible(true);
                if (field.getType().equals(Boolean.class)){
                    field.set(t, Boolean.valueOf(getParameter(request, field.getName(), "false")));
                } else if (field.getType().equals(String.class)){
                    field.set(t, getParameter(request, field.getName(), "none"));
                } else if (field.getType().equals(Integer.class)){
                    field.set(t, Integer.valueOf(getParameter(request, field.getName(), "0")));
                } else if (field.getType().equals(Long.class)){
                    field.set(t, Long.valueOf(getParameter(request, field.getName(), "0")));
                } else if (field.getType().equals(Double.class)){
                    field.set(t, Double.valueOf(getParameter(request, field.getName(), "0")));
                } else if (field.getType().equals(Float.class)){
                    field.set(t, Float.valueOf(getParameter(request, field.getName(), "0")));
                }
                field.setAccessible(false);
            }
            return t;
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCookieValue(HttpServletRequest request, String key){
        return Arrays.stream(request.getCookies()).filter(c -> Objects.equals(key, c.getName())).findFirst().map(Cookie::getValue).orElse(null);
    }

    public static void removeCookie(HttpServletResponse response, String key){
        Cookie cookie = new Cookie(key, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}