package com.rabex.express.controllers.user;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;
import com.rabex.express.model.Customer;
import com.rabex.express.services.AddressService;
import com.rabex.express.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dia-chi/*")
public class AddressController extends HttpServlet {

    @Inject
    private AddressService addressService;

    @Inject
    private CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = customerService.findById(RID.from("01JFVEQ45VDEWERDXVJ9DBKYW6"));
        if (customerService != null) {
            req.setAttribute("addresses", customer.getAddresses());
        }
        req.getRequestDispatcher("/WEB-INF/views/user/address.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
