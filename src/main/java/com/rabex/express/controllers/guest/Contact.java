package com.rabex.express.controllers.guest;

import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/lien-he")
public class Contact extends HttpServlet {
    @Inject
    private ShippingServService shippingServService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("services", shippingServService.findAll());
        req.getRequestDispatcher("/WEB-INF/views/guest/contact.jsp").forward(req, resp);
    }
}