<%--@elvariable id="service" type="com.rabex.express.model.ShippingServ"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/guest/common/head-link.jsp" %>
    <title>Dịch vụ</title>
</head>
<body>
<%-- Nav --%>
<%@include file="/WEB-INF/views/guest/common/navbar.jsp" %>
<%-- End Nav --%>


<!-- Service Detail Begin -->
<div class="container mb3">
    <div class="h2 text-uppercase mb-3">Thông tin Dịch vụ ${service.name}</div>
    <div class="h3 text-primary text-uppercase">I. ĐỊNH NGHĨA</div>
    <p>
        <b class="text-primary">${service.name}</b> ${service.details} mô tả là dịch vụ nhận gửi, vận chuyển và phát các
        loại hàng hóa, vật phẩm, tài liệu trong nước, không giới hạn mức trọng lượng, theo chỉ tiêu thời gian nhanh.
        Bảng giá không áp dụng với các đơn hàng có thu hộ COD.
    </p>
    <div class="h3 text-primary text-uppercase">II. BẢNG GIÁ DỊCH VỤ
    </div>
    <div class="table-responsive">
        <table class="table table-bordered mt-3 text-center" style="table-layout: auto;">
            <thead class="table-light">
            <tr>
                <th>TRỌNG LƯỢNG
                    (Gram)
                </th>
                <th>GIÁ NỘI TỈNH</th>
                <th>GIÁ NGOẠI TỈNH</th>
            </tr>
            </thead>
            <tbody>
            <%--@elvariable id="tiers" type="java.util.List"--%>
            <%--@elvariable id="tier" type="com.rabex.express.dto.PricingTiersTable"--%>
            <c:forEach var="tier" items="${tiers}">
                <c:if test="${tier.stepIncrement*1000 == 0}">
                    <tr>
                        <fmt:formatNumber var="wStart" value="${tier.weightStart}" maxFractionDigits="0"/>
                        <fmt:formatNumber var="wEnd" value="${tier.weightEnd}" maxFractionDigits="0"/>
                        <fmt:formatNumber var="inPrice" value="${tier.inProvinceBasePrice}" maxFractionDigits="0"/>
                        <fmt:formatNumber var="outPrice" value="${tier.outProvinceBasePrice}" maxFractionDigits="0"/>
                        <td>${wStart} - ${wEnd}</td>
                        <td>${inPrice}</td>
                        <td>${outPrice}</td>
                    </tr>
                </c:if>
                <c:if test="${tier.stepIncrement*1000 != 0}">
                    <tr>
                        <fmt:formatNumber var="step" value="${tier.stepIncrement}" maxFractionDigits="0"/>
                        <fmt:formatNumber var="inPerStep" value="${tier.inPricePerStep}" maxFractionDigits="0"/>
                        <fmt:formatNumber var="outPerStep" value="${tier.outPricePerStep}" maxFractionDigits="0"/>
                        <td>Mỗi ${step}gram tiếp theo</td>
                        <td>${inPerStep}</td>
                        <td>${outPerStep}</td>
                    </tr>

                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <img src="${service.image}" class="img-fluid" alt=""/>
</div>
<!-- Service Detail End -->


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
