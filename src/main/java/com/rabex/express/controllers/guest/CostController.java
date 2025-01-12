package com.rabex.express.controllers.guest;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.ShippingServ;
import com.rabex.express.services.CostEstimateService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.rabex.express.core.web.WebUtils.getParameter;
import static com.rabex.express.core.web.WebUtils.mapRequestBody;

@WebServlet(urlPatterns = {"/uoc-tinh-chi-phi"})
public class CostController extends HttpServlet {
    @Inject
    private CostEstimateService costEstimateService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String estimateId = getParameter(req, "estimate", "none");
        if (!"none".equals(estimateId)) {
            CostEstimateRequest estimateRequest = (CostEstimateRequest) req.getSession().getAttribute(estimateId);
            if (estimateRequest != null) {
                req.setAttribute("request", estimateRequest);
                List<ShippingServ> result = costEstimateService.getEstimating(estimateRequest);
                req.setAttribute("result", result);
            }
        }
        req.getRequestDispatcher("/WEB-INF/views/guest/cost-estimate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderAddress = getParameter(req, "senderAddress", "none");
        String receiverAddress = getParameter(req, "receiverAddress", "none");
        CostEstimateRequest estimateRequest = ("none".equals(senderAddress) || "none".equals(receiverAddress)) ?
                null : mapRequestBody(CostEstimateRequest.class, req);

        if (estimateRequest == null) {
            resp.sendRedirect("/uoc-tinh-chi-phi?estimate=none");
            return;
        }
        String estimateId = RID.fast().toString();

        req.getSession().setAttribute(estimateId, estimateRequest);

        resp.sendRedirect("/uoc-tinh-chi-phi?estimate=" + estimateId + "&" + estimateParam(estimateRequest));
    }

    private static String estimateParam(CostEstimateRequest estimateRequest) {
        if (estimateRequest == null) {
            return "";
        }
        String senderProvince = estimateRequest.getProvince(estimateRequest.getSenderAddress());
        String requestProvince = estimateRequest.getProvince(estimateRequest.getReceiverAddress());
        double weight = estimateRequest.getWeight();
        return "from=" + URLEncoder.encode(senderProvince, StandardCharsets.UTF_8) +
                "&to=" + URLEncoder.encode(requestProvince, StandardCharsets.UTF_8) +
                "&w=" + weight;
    }
}
