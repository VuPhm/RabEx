package com.rabex.express.controllers.guest;

import com.rabex.express.core.web.WebUtils;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/dich-vu", "/dich-vu/*"})
public class ShippingServController extends HttpServlet {
    @Inject
    ShippingServService shippingServService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // /dich-vu/*
        if (WebUtils.getSubPaths(req).length > 0) {
            String slug = WebUtils.getSubPaths(req)[0];
            ShippingServ service = shippingServService.findBySlug(slug);

            if (service == null) {
                req.setAttribute("service", service);
                req.getRequestDispatcher("/WEB-INF/views/guest/service-details.jsp").forward(req, resp);
            } else { // not found service
                resp.sendRedirect(req.getContextPath() + "/dich-vu");
            }
            return;
        }

        // /dich-vu
        req.setAttribute("services", shippingServService.findAll());
        req.getRequestDispatcher("/WEB-INF/views/guest/services.jsp").forward(req, resp);
    }
}
