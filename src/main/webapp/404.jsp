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


<!-- Carousel Start -->
<div class="container-fluid p-0">
    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <a class="carousel-item active" href="pages/guest/login.html" data-bs-interval="3000">
                <img src="img/c1.png" class="d-block w-100 img-fluid" alt="..."
                     style="height: 50vh; object-fit: cover;">
            </a>
            <a class="carousel-item" href="pages/guest/login.html" data-bs-interval="3000">
                <img src="img/c2.png" class="d-block w-100 img-fluid" alt="..."
                     style="height: 50vh; object-fit: cover;">
            </a>
            <a class="carousel-item" href="pages/guest/service.html" data-bs-interval="3000">
                <img src="img/c3.png" class="d-block w-100 img-fluid" alt="..."
                     style="height: 50vh; object-fit: cover;">
            </a>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<!-- Carousel End -->

<!-- 404 Start -->
<div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
    <div class="container text-center py-5">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <i class="bi bi-exclamation-triangle display-1 text-primary"></i>
                <h1 class="display-1">404</h1>
                <h1 class="mb-4">Không tìm thấy trang!</h1>
                <p class="mb-4">We’re sorry, the page you have looked for does not exist in our website! Maybe go to our
                    home page or try to use a search?</p>
                <a class="btn btn-primary rounded-pill py-3 px-5" href="javascript:window.history.back()">Quay lại</a>
            </div>
        </div>
    </div>
</div>
<!-- 404 End -->

<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>

<script src="<c:url value="/static/js/mdb.umd.min.js"/>"></script>
<script src="<c:url value="/static/js/address.dropdown.js"/>"></script>
</body>
</html>
