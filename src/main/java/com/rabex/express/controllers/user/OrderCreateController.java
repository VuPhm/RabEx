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

@WebServlet("/nguoi-dung/tao-don")
public class OrderCreateController extends HttpServlet {
    @Inject
    OrderHistoryService orderHistoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderHistoryService.getOrderHistory();
        System.out.println(orders);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/user/order-create.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
}
