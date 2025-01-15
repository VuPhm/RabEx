<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/guest/common/head-link.jsp" %>
    <title>Dịch vụ</title>
    <base href="${pageContext.request.contextPath}/" />

</head>
<body>
<%-- Nav --%>
<%@include file="/WEB-INF/views/guest/common/navbar.jsp" %>
<%-- End Nav --%>


<!-- Service Start -->
<div class="container-xxl py-5">
    <div class="container py-5">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s"
             style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
            <h6 class="text-secondary text-uppercase">Dịch vụ</h6>
            <h1 class="mb-5">Danh sách dịch vụ vận chuyển</h1>
        </div>
        <div class="row g-4">
            <c:forEach var="s" items="${services}">
                <div class="col-md-6 col-lg-4 wow fadeInUp" data-wow-delay="0.3s"
                     style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
                    <div class="service-item p-4">
                        <div class="mb-4">
                            <img class="img-fluid" src="/static/img/service1.png" alt="">
                        </div>
                        <h4 class="mb-3">${s.name}</h4>
                        <p>Là dịch vụ nhận gửi, vận chuyển và phát các loại thư, tài liệu, thư từ trong nước theo chỉ
                            tiêu thời gian tiêu chuẩn. Không áp dụng với các đơn hàng có thu hộ COD.

                        </p>
                        <a class="btn-slide mt-2" href="<c:url value="dich-vu/${s.slug}"/>"><i class="fa fa-arrow-right"></i><span>Xem thêm</span></a>
                    </div>
                </div>
            </c:forEach>
        </div> <!--list end-->
    </div>
</div>
<!-- Service End -->


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
