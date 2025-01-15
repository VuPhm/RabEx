package com.rabex.express.controllers.guest;

import com.rabex.express.model.User;
import com.rabex.express.services.AuthService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/dang-nhap", "/login"})
public class Login extends HttpServlet {
    @Inject
    private AuthService authService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");

        if ("error".equals(status)) {
            req.setAttribute("status", "error");
        }
        req.getRequestDispatcher("/WEB-INF/views/guest/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = String.valueOf(req.getParameter("password").hashCode());

        User loginUser = authService.login(email, password);
        if (loginUser != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.sendRedirect(req.getContextPath() + "/dang-nhap?status=error");
        }
    }
}
