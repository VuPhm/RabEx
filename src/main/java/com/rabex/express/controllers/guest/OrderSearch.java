package com.rabex.express.controllers.guest;

import com.rabex.express.model.Order;
import com.rabex.express.model.TrackingRecord;
import com.rabex.express.services.OrderService;
import com.rabex.express.services.ShippingServService;
import com.rabex.express.services.TrackingService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/tra-cuu-buu-pham")
public class OrderSearch extends HttpServlet {
    @Inject
    private ShippingServService shippingServService;
    @Inject
    private TrackingService trackingService;
    @Inject
    private OrderService orderService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("services", shippingServService.findAll());

        String code = req.getParameter("code");
        if (code != null) {
            List<TrackingRecord> records = trackingService.searchByOrderCode(code);
            Order order = orderService.findByCode(code);
            if (records == null || order == null) {
                req.getRequestDispatcher("/WEB-INF/views/guest/order-search.jsp").forward(req, resp);
                return;
            }
            order.setShippingService(shippingServService.findById(order.getShippingService_id()));

            req.setAttribute("order", order);
//            System.out.println(order);
            req.setAttribute("records", records);
        }
        req.getRequestDispatcher("/WEB-INF/views/guest/order-search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        resp.sendRedirect("/tra-cuu-buu-pham?code=" + code);
    }
}
