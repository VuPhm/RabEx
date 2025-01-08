package com.rabex.express.controllers.user;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.ShippingAddressForm;
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

import static com.rabex.express.core.web.WebUtils.*;

@WebServlet("/nguoi-dung/dia-chi")
public class AddressController extends HttpServlet {

    RID userId = RID.from("01HZY0M93WZXABCDEF12345712");

    @Inject
    private AddressService addressService;

    @Inject
    private CustomerService customerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = customerService.findById(userId);

        if (customerService != null) {
            req.setAttribute("customer", customer);
        }
        System.out.println(customer);
        req.getRequestDispatcher("/WEB-INF/views/user/address.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            handleDelete(req, resp);
        } else if ("edit".equals(action)) {
            handleEdit(req, resp);
        } else {
            handlePost(req, resp);
        }
    }

    private void handleEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RID addressId = RID.from(req.getParameter("addressId"));
        RID personInfoId = RID.from(req.getParameter("personInfoId"));
        ShippingAddressForm request = mapRequestBody(ShippingAddressForm.class, req);
        customerService.updateShippingAddress(addressId, personInfoId, request);
        redirect(req, resp, "/nguoi-dung/dia-chi", true);
    }

    private void handleDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RID addressId = RID.from(req.getParameter("addressId"));
        RID personInfoId = RID.from(req.getParameter("personInfoId"));
        customerService.removeAddress(userId, addressId, personInfoId);
        redirect(req, resp, "/nguoi-dung/dia-chi", true);
    }

    private void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ShippingAddressForm request = mapRequestBody(ShippingAddressForm.class, req);
        System.out.println(request);
        customerService.addAddress(userId, request);
        redirect(req, resp, "/nguoi-dung/dia-chi", true);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
