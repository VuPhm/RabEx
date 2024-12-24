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
        <b class="text-primary">${service.name}</b> ${service.details} là dịch vụ nhận gửi, vận chuyển và phát các loại hàng hóa, vật phẩm, tài liệu trong nước, không giới hạn mức trọng lượng, theo chỉ tiêu thời gian nhanh. Bảng giá không áp dụng với các đơn hàng có thu hộ COD.
    </p>
    <div class="h3 text-primary text-uppercase">II. BẢNG GIÁ DỊCH VỤ
    </div>
    <img src="../../img/price.png" class="img-fluid" alt=""/>
</div>
<!-- Service Detail End -->


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
