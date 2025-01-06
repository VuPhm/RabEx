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
        Customer customer = customerService.findById(RID.from("01JFVW84PVN5CNT6AAB4ZM7SG6"));
        if (customerService != null) {
            req.setAttribute("customer", customer);
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
        String pathInfo = req.getPathInfo(); // Lấy đường dẫn ví dụ: /dia-chi/{id}
        if (pathInfo == null || pathInfo.length() <= 1) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid address ID");
            return;
        }
        String addressId = pathInfo.substring(1); // Lấy ID từ URL
        RID rid = RID.from(addressId);
        try {
            boolean deleted = addressService.deleteAddress(rid);
            if (deleted) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Address deleted successfully");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("Address not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Error deleting address");
        }
    }
}
