package com.rabex.express.controllers.user;

import com.rabex.express.model.Order;
import com.rabex.express.services.OrderHistoryService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/lich-su-buu-pham")
public class OrderHistoryController extends HttpServlet {
    @Inject
    OrderHistoryService orderHistoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderHistoryService.getOrderHistory();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/user/order-history.jsp").forward(req, resp);
    }
}
