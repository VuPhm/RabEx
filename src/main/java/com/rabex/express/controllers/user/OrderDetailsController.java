package com.rabex.express.controllers.user;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Order;
import com.rabex.express.services.OrderHistoryService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/nguoi-dung/chi-tiet-buu-pham")
public class OrderDetailsController extends HttpServlet {
    @Inject
    OrderHistoryService orderHistoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy order id từ tham số URL
        String orderId = req.getParameter("id");

        if (orderId != null && !orderId.trim().isEmpty()) {
            Order order = orderHistoryService.getOrderDetails(RID.from(orderId));

            if (order != null) {
                req.setAttribute("order", order);
                req.getRequestDispatcher("/WEB-INF/views/user/order-details.jsp").forward(req, resp);
            } else {
                // Xử lý khi không tìm thấy order
                resp.sendRedirect("/nguoi-dung/lich-su-buu-pham");
            }
        } else {
            // Nếu không có id, chuyển hướng về trang lịch sử
            resp.sendRedirect("/nguoi-dung/lich-su-buu-pham");
        }
    }
}
