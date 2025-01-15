<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/guest/common/head-link.jsp" %>
    <title>Dịch vụ</title>
    <base href="${pageContext.request.contextPath}/"/>

</head>
<body>

<%-- Nav --%>
<%@include file="/WEB-INF/views/guest/common/navbar.jsp" %>
<%-- End Nav --%>


<!-- Header Start-->
<div class="bg-primary container-fluid pb-3 pt-5 wow slideInDown"
     style="margin-bottom: 35px; visibility: visible; animation-name: slideInDown;">
    <div class="container">
        <div class="h2 text-white text-uppercase">Ước tính chi phí</div>
    </div>
</div>
<!-- Header End -->


<!-- Cost Estimate Start-->
<div class="container-xxl mt-5 mb-3 wow fadeInDown" id="cost_estimate">

    <div class="container py-3 px-5 service-item">
        <form method="post" action="uoc-tinh-chi-phi">
            <c:if test="${param.get('error')=='invalid request'}">
                <div class="row">
                    <h5 style="color: red">Vui lòng chọn địa chỉ!</h5>
                </div>
            </c:if>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="py-3">* Địa chỉ người gửi:</label>
                        <div class="dropdown" id="sender_address">
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="py-3">* Địa chỉ người nhận:</label>
                        <div class="dropdown" id="receiver_address">
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group py-3">
                        <label class="py-3" for="weight"> Tổng khối lượng:</label>
                        <i class="bi bi-question-circle" id="weight-info"></i>
                        <div class="input-group">
                            <input required type="number" name="weight" id="weight" class="form-control"
                                   placeholder="Vui lòng nhập thông tin">
                            <div class="input-group-append">
                                <span class="input-group-text bg-light">G</span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="unknownWeight" name="unknownWeight"
                               value="true">
                        <label class="form-check-label" for="unknownWeight">Tôi không biết cân nặng chính xác của bưu
                            gửi</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group py-3">
                        <label class="py-3">Kích thước đơn hàng:</label>
                        <i class="bi bi-question-circle"></i>
                        <div class="form-row d-flex flex-wrap">
                            <div class="col">
                                <div class="input-group">
                                    <input type="number" id="longg" name="longg" class="form-control" placeholder="Dài">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-light">CM</span>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center">
                                <i class="bi bi-x "></i>
                            </div>
                            <div class="col">
                                <div class="input-group">
                                    <input type="number" id="wide" name="wide" class="form-control" placeholder="Rộng">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-light">CM</span>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center">
                                <i class="bi bi-x "></i>
                            </div>
                            <div class="col">
                                <div class="input-group">
                                    <input type="number" id="height" name="height" class="form-control"
                                           placeholder="Cao">
                                    <div class="input-group-append">
                                        <span class="input-group-text bg-light">CM</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary mt-4">Tính Phí Giao Hàng</button>
                    <a href="dich-vu" class="text-primary text-decoration-underline mt-4">Xem toàn bộ biểu phí</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- Cost Estimate End-->

<%--@elvariable id="result" type="java.util.List"--%>
<%--@elvariable id="service" type="com.rabex.express.model.ShippingServ"--%>
<%--@elvariable id="tier" type="com.rabex.express.model.PricingTier"--%>
<%--@elvariable id="estimateRequest" type="com.rabex.express.dto.CostEstimateRequest"--%>

<fmt:formatNumber var="weight" value="${estimateRequest.orTransformedWeight}" maxFractionDigits="0"/>

<!-- Result costs Start -->
<c:if test="${result != null}">
    <div id="cost_estimate_result" class="container-xxl wow fadeIn">
        <div class="container py-5 px-5 service-item">
            <h5 class="text-center">Phí vận chuyển sẽ bao gồm phụ phí và trừ đi các khoản chiến khấu/giảm giá bởi
                khuyến mãi.</h5>

                <%--1/2 can nang va the tich KHONG xac dinh--%>
            <c:if test="${estimateRequest.unknownWeight && estimateRequest.unknownVolume()}">
                <div class="table-responsive">
                    <table class="table table-bordered mt-3 text-center" style="table-layout: auto;">
                        <thead class="table-light">
                        <tr>
                            <th>Dịch vụ</th>
                            <th colspan="14">Phí vận chuyển ước tính (VNĐ / bưu phẩm)
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="service" items="${result}">
                            <c:set var="size" value="${14 / service.pricingTiers.size()}"/>
                            <tr>
                                <td rowspan="2" style="vertical-align: middle;">${service.name}</td>
                                <c:forEach var="tier" items="${service.pricingTiers}">
                                    <fmt:formatNumber var="weightStart" value="${tier.weightStart}"
                                                      maxFractionDigits="0"/>
                                    <fmt:formatNumber var="weightEnd" value="${tier.weightEnd}" maxFractionDigits="0"/>
                                    <c:if test="${tier.stepIncrement*1000 == 0}">
                                        <td colspan="${size}" class="bg-light"><i>${weightStart}-${weightEnd}g</i></td>
                                    </c:if>
                                    <c:if test="${tier.stepIncrement*1000 != 0}">
                                        <fmt:formatNumber var="weightStartKG" value="${tier.weightStart/1000}"
                                                          maxFractionDigits="0"/>
                                        <td colspan="${size}" class="bg-light"><i>> ${weightStartKG}kg</i></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <tr>
                                <c:forEach var="tier" items="${service.pricingTiers}">
                                    <fmt:formatNumber var="basePrice" value="${tier.basePrice}" maxFractionDigits="0"/>
                                    <c:if test="${tier.stepIncrement*1000 == 0}">
                                        <td colspan="${size}"><b>${basePrice}đ</b></td>
                                    </c:if>
                                    <c:if test="${tier.stepIncrement*1000 != 0}">
                                        <td colspan="${size}"><a href="dich-vu/${service.slug}"
                                                                 class="btn-link text-primary"><b>Xem chi tiết</b></a>
                                        </td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

                <%--2/2 can nang hoac kich thuoc xac dinh--%>
            <c:if test="${!(estimateRequest.unknownWeight && estimateRequest.unknownVolume())}">
                <div class="table-responsive">
                    <table class="table table-bordered mt-3 text-center" style="table-layout: auto;">
                        <thead class="table-light">
                        <tr>
                            <th>Dịch vụ</th>
                            <th colspan="10">Phí vận chuyển ước tính (VNĐ / bưu phẩm)
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td><i>Cân nặng bưu phẩm</i></td>
                            <td><i>${weight}g</i></td>
                        </tr>
                        <c:forEach var="service" items="${result}">
                            <tr>
                                <td>${service.name}</td>

                                <c:choose>
                                    <c:when test="${service.pricingTiers.size() !=0}">
                                        <c:set var="size" value="${14 / service.pricingTiers.size()}"/>
                                        <c:forEach var="tier" items="${service.pricingTiers}">
                                            <fmt:formatNumber var="price" value="${tier.calcTotalPrice(weight)}"
                                                              maxFractionDigits="0"/>
                                            <td colspan="${size}"><b>${price}đ</b></td>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <td colspan="14"><a href="dich-vu/${service.slug}"
                                                            class="btn-link text-primary"><b>Xem chi tiết</b></a></td>
                                    </c:otherwise>
                                </c:choose>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

        </div>
    </div>
</c:if>
<!-- Result costs End -->


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>

<script src="<c:url value="/static/js/mdb.umd.min.js"/>"></script>
<script src="<c:url value="/static/js/address.dropdown.js"/>"></script>
<script src="<c:url value="/static/js/utils.js"/>"></script>
<script>

    document.addEventListener("DOMContentLoaded", function () {
        // Khởi tạo AddressDropdown
        const senderAddress = new AddressDropdown("#sender_address", {
            url: "/static/data/dvhc.json",
            placeholder: "Chọn Tỉnh/Thành phố",
            name: "senderAddress"
        });
        const receiverAddress = new AddressDropdown("#receiver_address", {
            url: "/static/data/dvhc.json",
            placeholder: "Chọn Tỉnh/Thành phố",
            name: "receiverAddress"
        });
        senderAddress.init();
        receiverAddress.init();

        // Xu ly thao tac nhap khoi luong
        const unknownWeightCheckbox = document.getElementById("unknownWeight");
        unknownWeightCheckbox.addEventListener("change", function () {
            const isChecked = this.checked;
            // Select inputs
            const inputWeight = document.getElementById("weight");
            if (isChecked) {
                inputWeight.removeAttribute("required");
                inputWeight.setAttribute("disabled", "true");
            } else {
                inputWeight.setAttribute("required", "true");
                inputWeight.removeAttribute("disabled")
            }
        });

        // mang theo du lieu da nhap vao

    });

</script>
</body>
</html>
