package com.rabex.express.controllers.guest;

import com.rabex.express.dto.CostEstimateRequest;
import com.rabex.express.model.PricingTier;
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
        String error = req.getParameter("error");
        if (error == null) {
            List<PricingTier> result = handleEstimate(req);
            req.setAttribute("result", result);
        } else if ("invalid".equals(error)) {
            req.setAttribute("error", "invalid request");
        }
        req.getRequestDispatcher("/WEB-INF/views/guest/cost-estimate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CostEstimateRequest estimateRequest = mapRequestBody(CostEstimateRequest.class, req);
        if (estimateRequest.isValid()) {
//            resp.sendRedirect("/uoc-tinh-chi-phi?E=" + RID.fast() + "&" + estimateParam(estimateRequest));
            resp.sendRedirect("/uoc-tinh-chi-phi?" + estimateParams(estimateRequest));
        } else {
            resp.sendRedirect("/uoc-tinh-chi-phi?error=invalid");
        }
    }

    private List<PricingTier> handleEstimate(HttpServletRequest req) {
        String senderProvince = getParameter(req, "from", "");
        String receiverProvince = getParameter(req, "to", "");
        double weight = getParameter(req, "W", -1.0);

        if (weight < 0 || senderProvince.isEmpty() || receiverProvince.isEmpty()) {
            return null;
        }

        req.setAttribute("requestWeight", weight);
        List<PricingTier> result = costEstimateService.getEstimating(senderProvince, receiverProvince, weight);
        result.forEach(t -> t.setTotalPrice(t.calcTotalPrice(weight)));
        return result;
    }

    private static String estimateParams(CostEstimateRequest estimateRequest) {
        if (estimateRequest == null || !estimateRequest.isValid()) {
            return "";
        }
        String senderProvince = estimateRequest.getProvince(estimateRequest.getSenderAddress());
        String requestProvince = estimateRequest.getProvince(estimateRequest.getReceiverAddress());
        double weight = estimateRequest.getOrTransformedWeight(); // => -1 if not request weight
        if (weight*1000 == -1000) { // (double) weight "equals" -1
            return "from=" + URLEncoder.encode(senderProvince, StandardCharsets.UTF_8) +
                   "&to=" + URLEncoder.encode(requestProvince, StandardCharsets.UTF_8);
        }
        return "from=" + URLEncoder.encode(senderProvince, StandardCharsets.UTF_8) +
                "&to=" + URLEncoder.encode(requestProvince, StandardCharsets.UTF_8) +
                "&W=" + weight;
    }
}
