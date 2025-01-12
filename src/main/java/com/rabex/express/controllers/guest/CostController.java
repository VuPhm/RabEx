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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.rabex.express.core.web.WebUtils.*;

@WebServlet(urlPatterns = {"/uoc-tinh-chi-phi/*"})
public class CostController extends HttpServlet {
    @Inject
    private CostEstimateService costEstimateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestName = getSubPaths(req).length != 0 ? getSubPaths(req)[0] : null;
        if (requestName != null) {
            CostEstimateRequest request = (CostEstimateRequest) req.getSession().getAttribute(URLDecoder.decode(requestName, StandardCharsets.UTF_8));
            if (request != null) {
                List<ShippingServ> result = costEstimateService.getEstimating(request);
                req.setAttribute("result", result);
                req.setAttribute("requestName", requestName);
            }
        }
        req.getRequestDispatcher("/WEB-INF/views/guest/cost-estimate.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CostEstimateRequest request = mapRequestBody(CostEstimateRequest.class, req);
        req.getSession().setAttribute(request.toString(), request);
        resp.sendRedirect("/uoc-tinh-chi-phi/" + URLEncoder.encode(request.toString(), StandardCharsets.UTF_8));
    }

}
