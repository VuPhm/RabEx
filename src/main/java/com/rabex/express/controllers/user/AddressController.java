package com.rabex.express.controllers.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;
import com.rabex.express.services.AddressService;
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

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // Get all addresses
            req.setAttribute("addresses", addressService.getAllAddresses());
            req.getRequestDispatcher("/WEB-INF/views/user/address.jsp").forward(req, resp);
        } else {
            // Get address by ID
            try {
                String id = pathInfo.substring(1);
                Address address = addressService.getAddressById(RID.from(id));
                if (address == null) {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    objectMapper.writeValue(resp.getWriter(), "Address not found");
                } else {
                    req.setAttribute("address", address);
                    req.getRequestDispatcher("/WEB-INF/views/user/address.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                objectMapper.writeValue(resp.getWriter(), "Invalid address ID");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            Address address = objectMapper.readValue(req.getReader(), Address.class);
            boolean isCreated = addressService.addAddress(address);
            if (isCreated) {
                resp.setStatus(HttpServletResponse.SC_CREATED);
                objectMapper.writeValue(resp.getWriter(), address);
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                objectMapper.writeValue(resp.getWriter(), "Failed to create address");
            }
        } catch (IllegalArgumentException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(resp.getWriter(), e.getMessage());
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            objectMapper.writeValue(resp.getWriter(), "Failed to create address");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.length() <= 1) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(resp.getWriter(), "Address ID is required");
            return;
        }

        try {
            String id = pathInfo.substring(1);
            Address address = objectMapper.readValue(req.getReader(), Address.class);
            boolean isUpdated = addressService.updateAddress(RID.from(id), address);
            if (!isUpdated) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                objectMapper.writeValue(resp.getWriter(), "Address not found");
            } else {
                resp.setStatus(HttpServletResponse.SC_OK);
                objectMapper.writeValue(resp.getWriter(), address);
            }
        } catch (IllegalArgumentException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(resp.getWriter(), e.getMessage());
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            objectMapper.writeValue(resp.getWriter(), "Failed to update address");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.length() <= 1) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(resp.getWriter(), "Address ID is required");
            return;
        }

        try {
            String id = pathInfo.substring(1);
            boolean deleted = addressService.deleteAddress(RID.from(id));
            if (!deleted) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                objectMapper.writeValue(resp.getWriter(), "Address not found");
            } else {
                resp.setStatus(HttpServletResponse.SC_OK);
                objectMapper.writeValue(resp.getWriter(), "Address deleted successfully");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            objectMapper.writeValue(resp.getWriter(), "Failed to delete address");
        }
    }
}
