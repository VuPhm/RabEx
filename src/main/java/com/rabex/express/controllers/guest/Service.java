package com.rabex.express.controllers.guest;

import com.rabex.express.core.web.WebUtils;
import com.rabex.express.dto.PricingTiersTable;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.model.SurchargeTier;
import com.rabex.express.model.enumm.ShippingServiceType;
import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/dich-vu", "/dich-vu/*"})
public class Service extends HttpServlet {
    @Inject
    ShippingServService shippingServService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // /dich-vu/*
        if (WebUtils.getSubPaths(req).length > 0) {
            String slug = WebUtils.getSubPaths(req)[0];
            ShippingServ service = shippingServService.findBySlug(slug);

            if (service != null) {
                if (service.getType() == ShippingServiceType.DELIVERY){
                    List<PricingTiersTable> tiers = shippingServService.findPricingTiers(service.getId());
                    req.setAttribute("tiers", tiers);
                } else if (service.getType() == ShippingServiceType.ADD_ON) {
                    List<SurchargeTier> tiers = shippingServService.findSurchargeTiers(service.getId());
                    req.setAttribute("tiers", tiers);
                }
                req.setAttribute("service", service);
                req.getRequestDispatcher("/WEB-INF/views/guest/service-details.jsp").forward(req, resp);
            } else {
                req.setAttribute("errorMessage", "Không tìm thấy dịch vụ");
                req.getRequestDispatcher("/404.jsp").forward(req, resp);
            }
            return;
        }

        // /dich-vu
        req.setAttribute("services", shippingServService.findAll());
        req.getRequestDispatcher("/WEB-INF/views/guest/services.jsp").forward(req, resp);
    }
}
