package com.rabex.express.controllers.user;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.OrderCreateForm;
import com.rabex.express.dto.ShippingAddressForm;
import com.rabex.express.model.Customer;
import com.rabex.express.model.Order;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.OrderHistoryService;
import com.rabex.express.services.OrderService;
import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.rabex.express.core.web.WebUtils.mapRequestBody;
import static com.rabex.express.core.web.WebUtils.redirect;

@WebServlet("/nguoi-dung/tao-don")
public class OrderCreateController extends HttpServlet {
    RID userId = RID.from("01HZY0M93WZXABCDEF12345713");
    @Inject
    OrderService orderService;

    @Inject
    ShippingServService shippingService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShippingServ> shippingServ = shippingService.findAll();
        shippingServ.remove(shippingServ.size() - 1);
        req.setAttribute("services", shippingServ);
        req.getRequestDispatcher("/WEB-INF/views/user/order-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderCreateForm request = mapRequestBody(OrderCreateForm.class, req);
        System.out.println(request);
        orderService.addOrder(userId, request);
        redirect(req, resp, "/nguoi-dung/tao-don", true);
    }
}
