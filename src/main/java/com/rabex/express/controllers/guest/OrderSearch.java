package com.rabex.express.controllers.guest;

import com.rabex.express.services.ShippingServService;
import com.rabex.express.services.TrackingService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/tra-cuu-buu-pham")
public class OrderSearch extends HttpServlet {
    @Inject
    private ShippingServService shippingServService;
    @Inject
    private TrackingService trackingService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("services", shippingServService.findAll());
        req.getRequestDispatcher("/WEB-INF/views/guest/order-search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
    }
}
