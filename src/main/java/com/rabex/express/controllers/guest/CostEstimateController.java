package com.rabex.express.controllers.guest;

import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.CostEstimateService;
import com.rabex.express.services.ShippingServService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.rabex.express.core.web.WebUtils.getParameter;
import static com.rabex.express.core.web.WebUtils.mapRequestBody;

@WebServlet(urlPatterns = {"/uoc-tinh-chi-phi"})
public class CostEstimateController extends HttpServlet {
    @Inject
    private ShippingServService shippingServService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = req.getParameter("error");
        if (error == null) {
            handleEstimate(req);
        } else {
            handleError(req, error);
        }
        req.getRequestDispatcher("/WEB-INF/views/guest/cost-estimate.jsp").forward(req, resp);
    }

    private void handleEstimate(HttpServletRequest req) {
        CostEstimateRequest cer = (CostEstimateRequest)  req.getSession().getAttribute("estimateRequest");
        if (cer != null) {
            List<ShippingServ> result = shippingServService.findByEstimateRequest(cer);
            if (result != null) {
                req.setAttribute("result", result);
            }
            req.setAttribute("estimateRequest", cer) ;
            req.getSession().removeAttribute("estimateRequest");
        }
    }

    private void handleError(HttpServletRequest req, String error) {
        if ("invalid".equals(error)) {
            req.setAttribute("error", "invalid request");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CostEstimateRequest estimateRequest = mapRequestBody(CostEstimateRequest.class, req);
        if (estimateRequest.isValid()) {
            System.out.println(estimateRequest);
            req.getSession().setAttribute("estimateRequest", estimateRequest);
            resp.sendRedirect("/uoc-tinh-chi-phi");
        } else {
            resp.sendRedirect("/uoc-tinh-chi-phi?error=invalid");
        }
    }

}
