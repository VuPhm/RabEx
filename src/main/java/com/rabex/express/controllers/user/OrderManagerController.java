package com.rabex.express.controllers.user;
import com.rabex.express.dao.OrderDao;
import com.rabex.express.dao.impl.DefaultOrderHistoryDao;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderHistoryService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/nguoi-dung/quan-ly-buu-pham")
public class OrderManagerController extends HttpServlet {
    @Inject
    OrderHistoryService orderHistoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderHistoryService.getOrderHistory();
        System.out.println(orders);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/user/order-manager.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
}
