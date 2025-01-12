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

<%--@elvariable id="estimateRequest" type="com.rabex.express.dto.CostEstimateRequest"--%>
<%--@elvariable id="pricingTier" type="com.rabex.express.model.PricingTier"--%>
<%--@elvariable id="result" type="java.util.List"--%>


<!-- Cost Estimate Start-->
<div class="container-xxl mt-5 mb-3 wow fadeInDown" id="cost_estimate">

    <div class="container py-3 px-5 service-item">
        <form method="post" action="uoc-tinh-chi-phi">
            <c:if test="${param.get('estimate')=='none'}">
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
                            <input type="number" name="weight" id="weight" class="form-control"
                                   placeholder="Vui lòng nhập thông tin">
                            <div class="input-group-append">
                                <span class="input-group-text bg-light">G</span>
                            </div>
                        </div>
                    </div>
                    <%--                        <div class="form-group form-check">--%>
                    <%--                            <input type="checkbox" class="form-check-input" id="unknownWeight" name="unknownWeight"--%>
                    <%--                                   value="true">--%>
                    <%--                            <label class="form-check-label" for="unknownWeight">Tôi không biết cân nặng chính xác của--%>
                    <%--                                bưu--%>
                    <%--                                gửi</label>--%>
                    <%--                        </div>--%>
                </div>
                <div class="col-md-6">
                    <div class="form-group py-3">
                        <label class="py-3">Kích thước đơn hàng:</label>
                        <i class="bi bi-question-circle"></i>
                        <div class="form-row d-flex flex-wrap">
                            <div class="col">
                                <div class="input-group">
                                    <input type="number" name="longg" class="form-control" placeholder="Dài">
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
                                    <input type="number" name="wide" class="form-control" placeholder="Rộng">
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
                                    <input type="number" name="height" class="form-control" placeholder="Cao">
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
<!-- Result costs Start -->
<c:if test="${result != null}">
    <div id="cost_estimate_result" class="container-xxl wow fadeIn">
        <div class="container py-5 px-5 service-item">
            <h5 class="text-center">Phí vận chuyển sẽ bao gồm phụ phí và trừ đi các khoản chiến khấu/giảm giá bởi
                khuyến mãi.</h5>
            <!-- Bảng cho trường hợp không biết cân nặng -->
            <c:if test="${estimateRequest.unknownWeight}">
                <div id="unknownWeightResult" class="table-responsive d-none">
                    <table class="table table-bordered mt-3 text-center">
                        <thead class="table-light">
                        <tr>
                            <th>Sản phẩm</th>
                            <th colspan="6">Phí vận chuyển ước tính sẽ bao gồm phụ phí và trừ đi các khoản chiến
                                khấu/giảm
                                giá
                                bởi khuyến mãi. (VNĐ)
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Cân nặng của Bưu gửi</td>
                            <td>0.5kg</td>
                            <td>1kg</td>
                            <td>2kg</td>
                            <td>3kg</td>
                            <td>4kg</td>
                            <td>5kg</td>
                        </tr>
                        <tr>
                            <td>Giao hàng Tiêu Chuẩn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                        </tr>
                        <tr>
                            <td>Giao hàng Nhanh</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                        </tr>
                        <tr>
                            <td>Giao hàng Hỏa Tốc</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                            <td>Không có sẵn</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <!-- Bảng cho trường hợp biết cân nặng -->
            <c:if test="${!estimateRequest.unknownWeight}">
                <c:set var="weight" value="${estimateRequest.weight}"/>
                <div id="knownWeightResult" class="table-responsive">
                    <table class="table table-bordered mt-3 text-center">
                        <thead class="table-light">
                        <tr>pricingTier
                            <th>Sản phẩm</th>
                            <th>Phí vận chuyển ước tính (VNĐ)
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Cân nặng của Bưu gửi</td>
                            <td>--</td>
                        </tr>
                            <%--@elvariable id="result" type="java.util.List"--%>
                        <c:forEach var="item" items="${result}">
                            <tr>
                                <td>${item.name}</td>
                                <td>
                                    <c:set var="pricingTier" value="${item.pricingTiers.get(0)}"/>
<%--                                    <fmt:formatNumber value="${item.pricingTiers.get(0).getTotalPrice(weight)}"--%>
                                    <fmt:formatNumber value="${pricingTier.getTotalPrice(weight)}"
                                                      type="currency"
                                                      currencySymbol="" maxFractionDigits="0" groupingUsed="true"/>
                                </td>
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

    // Gọi phương thức init để khởi tạo dropdown
    senderAddress.init();
    receiverAddress.init();

    document.addEventListener("DOMContentLoaded", function () {
        const estReq = {
            senderAddress: '${estimateRequest.senderAddress}',
            receiverAddress: '${estimateRequest.receiverAddress}',
            weight: '${estimateRequest.weight}',
            unknownWeight: '${estimateRequest.unknownWeight}',
            longg: '${estimateRequest.longg}',
            wide: '${estimateRequest.wide}',
            height: '${estimateRequest.height}'
        };

        setInputValues(estReq, ["senderAddress", "receiverAddress", "weight", "unknownWeight", "longg", "wide", "height"]);
    });

</script>
</body>
</html>
