package com.rabex.express.controllers.guest;

import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/dich-vu/*"})
public class ShippingServController extends HttpServlet {
    @Inject
    ShippingServService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {

            req.setAttribute("services", service.findAll());
            req.getRequestDispatcher("/WEB-INF/views/guest/services.jsp").forward(req, resp);
            return;
        }

        String slug = pathInfo.substring(1);
        ShippingServ shippingServ = service.findBySlug(slug);

        if (service == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Dịch vụ không tồn tại.");
            return;
        }

        req.setAttribute("service", shippingServ);
        resp.sendRedirect(req.getContextPath() + "/dich-vu/" + slug);
    }
}
