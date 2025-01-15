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


<!-- Page Header Start -->
<div class="container-fluid page-header py-5">
    <div class="container py-5">
        <h1 class="display-3 text-white mb-3 animated slideInDown">Về RabEx</h1>
        <nav aria-label="breadcrumb animated slideInDown">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="text-white" href="<c:url value="/"/>">Trang chủ</a></li>
                <li class="breadcrumb-item text-white active" aria-current="page">Về chúng tôi</li>
            </ol>
        </nav>
    </div>
</div>
<!-- Page Header End -->


<!-- About Start -->
<div class="container-fluid overflow-hidden py-5 px-lg-0">
    <div class="container about py-5 px-lg-0">
        <div class="row g-5 mx-lg-0">
            <div class="col-lg-6 ps-lg-0 wow fadeInLeft" data-wow-delay="0.1s" style="min-height: 400px; visibility: visible; animation-delay: 0.1s; animation-name: fadeInLeft;">
                <div class="position-relative h-100">
                    <img class="position-absolute img-fluid w-100 h-100" src="${pageContext.request.contextPath}/static/img/c2.png" style="object-fit: cover;" alt="">
                </div>
            </div>
            <div class="col-lg-6 about-text wow fadeInUp" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
                <h6 class="text-secondary text-uppercase mb-3">Về chúng tôi</h6>
                <h1 class="mb-5">DỊCH VỤ VẬN CHUYỂN BƯU PHẨM</h1>
                <p class="mb-5">Dịch vụ vẫn chuyển nhanh chóng và đáng tin cậy, giá thành hợp lý</p>
                <div class="row g-4 mb-5">
                    <div class="col-sm-6 wow fadeIn" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeIn;">
                        <i class="fa fa-globe fa-3x text-primary mb-3"></i>
                        <h5>Mạng lưới toàn quốc</h5>
                        <p class="m-0">Chúng tôi có mạng lưới bưu cục khắp 60 tỉnh thành của Việt Nam</p>
                    </div>
                    <div class="col-sm-6 wow fadeIn" data-wow-delay="0.7s" style="visibility: visible; animation-delay: 0.7s; animation-name: fadeIn;">
                        <i class="fa fa-shipping-fast fa-3x text-primary mb-3"></i>
                        <h5>Vận chuyển trực tiếp</h5>
                        <p class="m-0">Vận chuyển ít khâu trung gian nhất, đảm bảo tận tay người nhận.</p>
                    </div>
                </div>
                <a href="dich-vu" class="btn btn-primary py-3 px-5">Xem các dịch vụ</a>
            </div>
        </div>
    </div>
</div>
<!-- About End -->


<!-- Fact Start -->
<div class="container-xxl py-5">
    <div class="container py-5">
        <div class="row g-5">
            <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                <h6 class="text-secondary text-uppercase mb-3">ĐIỂM NỔI BẬT</h6>
                <h1 class="mb-5">Nằm trong TOP 5 đươn vị vận chuyển toàn quốc</h1>
                <p class="mb-5">Giải thưởng Đơn vị vận chuyển tiêu biểu năm 2023</p>
                <div class="d-flex align-items-center">
                    <i class="fa fa-headphones fa-2x flex-shrink-0 bg-primary p-3 text-white"></i>
                    <div class="ps-4">
                        <h6>Gọi ngay cho chúng tôi</h6>
                        <h3 class="text-primary m-0">1900.1009</h3>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="row g-4 align-items-center">
                    <div class="col-sm-6">
                        <div class="bg-primary p-4 mb-4 wow fadeIn" data-wow-delay="0.3s" style="visibility: visible; animation-delay: 0.3s; animation-name: fadeIn;">
                            <i class="fa fa-users fa-2x text-white mb-3"></i>
                            <h2 class="text-white mb-2">>7.000</h2>
                            <!--                            <h2 class="text-white mb-2" data-toggle="counter-up">&gt;7.000</h2>-->
                            <p class="text-white mb-0">Khách hàng hài lòng</p>
                        </div>
                        <div class="bg-secondary p-4 wow fadeIn" data-wow-delay="0.5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeIn;">
                            <i class="fa fa-ship fa-2x text-white mb-3"></i>
                            <h2 class="text-white mb-2">>100.000</h2>
                            <!--                            <h2 class="text-white mb-2" data-toggle="counter-up">&gt;100.000</h2>-->
                            <p class="text-white mb-0">Bưu phẩm đã vận chuyển</p>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="bg-success p-4 wow fadeIn" data-wow-delay="0.7s" style="visibility: visible; animation-delay: 0.7s; animation-name: fadeIn;">
                            <i class="fa fa-star fa-2x text-white mb-3"></i>
                            <h2 class="text-white mb-2">>6.000</h2>
                            <!--                            <h2 class="text-white mb-2" data-toggle="counter-up">&gt;6.000</h2>-->
                            <p class="text-white mb-0">Khách hàng đánh giá cao</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fact End -->


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
