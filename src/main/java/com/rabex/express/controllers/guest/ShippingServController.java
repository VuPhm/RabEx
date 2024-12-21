package com.rabex.express.controllers.guest;

import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/dich-vu", "/service"})
public class ShippingServController extends HttpServlet {
    @Inject
    ShippingServService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("count", service.countAll());
        req.getRequestDispatcher("/WEB-INF/views/guest/services.jsp").forward(req, resp);
    }
}
