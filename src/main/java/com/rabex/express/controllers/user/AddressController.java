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
        try {
            // Lấy `addressId` từ URL hoặc query parameter
            String addressId = req.getParameter("addressId");
            if (addressId == null || addressId.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Missing addressId");
                return;
            }

            // Tìm khách hàng (có thể là khách hàng hiện tại hoặc theo một logic xác định trước)
            String customerId = req.getParameter("customerId");
            if (customerId == null || customerId.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("Missing customerId");
                return;
            }

            // Lấy đối tượng Customer
            RID customerRID = RID.from(customerId);
            Customer customer = customerService.findById(customerRID);

            if (customer == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("Customer not found");
                return;
            }

            // Kiểm tra xem addressId có tồn tại trong danh sách địa chỉ của khách hàng không
            boolean addressExists = customer.getAddresses().stream()
                    .anyMatch(shippingAddress -> shippingAddress.getAddress().getId().equals(addressId));

            if (!addressExists) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("Address not found for the customer");
                return;
            }

            // Gọi service để xóa địa chỉ
            boolean success = addressService.deleteAddress(RID.from(addressId));

            // Phản hồi kết quả
            if (success) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Address deleted successfully");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to delete address");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("An error occurred: " + e.getMessage());
        }
    }
}
