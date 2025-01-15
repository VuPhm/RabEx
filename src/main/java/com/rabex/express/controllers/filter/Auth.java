package com.rabex.express.controllers.filter;

import com.rabex.express.model.Role;
import com.rabex.express.model.User;
import com.rabex.express.model.enumm.RoleName;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/tai-khoan/*", "/nhan-vien/*", "/admin/*"}) // Áp dụng cho tất cả URL bắt đầu với /secured/
public class Auth implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo nếu cần
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        User user = (User) session.getAttribute("user");
        List<Role> roles = user != null?
                user.getRoles() : null;

        // Kiểm tra role
        if (roles != null && hasRequiredRole(httpRequest, roles)) {
            chain.doFilter(request, response);
        } else if (user != null) {
            httpResponse.sendRedirect("/404.jsp");
        } else {
            httpResponse.sendRedirect("/dang-nhap");
        }
    }

    private boolean hasRequiredRole(HttpServletRequest httpRequest, List<Role> roles) {
        String uri = httpRequest.getRequestURI(); // Ví dụ: /tai-khoan/chi-tiet
        String requestString = uri.split("/")[1].trim();
        RoleName roleName;
        switch (requestString) {
            case "tai-khoan": roleName = RoleName.USER; break;
            case "nhan-vien": roleName = RoleName.STAFF; break;
            case "admin": roleName = RoleName.ADMIN; break;
            default: return false;
        }

        for (Role role : roles) {
            if (roleName.equals(role.getName())) {
                return true;
            }
        }
        return false;
    }

}
