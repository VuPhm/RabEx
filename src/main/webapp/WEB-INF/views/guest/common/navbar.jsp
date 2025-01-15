<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--<!-- Spinner Start -->--%>
<%--<div id="spinner"--%>
<%--     class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">--%>
<%--    <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">--%>
<%--        <span class="sr-only">Đang tải...</span>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<!-- Spinner End -->--%>


<nav class="navbar navbar-expand-lg bg-white navbar-light shadow border-top border-5 border-primary sticky-top p-0" style="top: -100px;">
    <a href="<c:url value="/"/>" class="navbar-brand bg-primary d-flex align-items-center px-4 px-lg-5 order-0">
        <h2 class="mb-2 text-white">RabEx</h2>
    </a>
    <button type="button" class="navbar-toggler me-4 order-2" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse order-3 order-lg-1" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
            <a href="<c:url value="/"/>" class="nav-item nav-link active">Trang chủ</a>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">Đơn hàng</a>
                <div class="dropdown-menu fade-up m-0">
                    <a href="<c:url value="/tao-don"/>" class="dropdown-item">Tạo đơn</a>
                    <a href="<c:url value="/tra-cuu-buu-pham"/>" class="dropdown-item">Tra cứu bưu phẩm</a>
                    <a href="<c:url value="/uoc-tinh-chi-phi"/>" class="dropdown-item">Ước tính chi phí</a>
                </div>
            </div>
            <a href="<c:url value="/ve-chung-toi"/>" class="nav-item nav-link">Về chúng tôi</a>
            <a href="<c:url value="/dich-vu"/>" class="nav-item nav-link">Dịch vụ</a>
            <a href="<c:url value="/lien-he"/>" class="nav-item nav-link">Liên hệ</a>
        </div>
    </div>
    <c:if test="${not empty sessionScope.user}">
        <a href="tai-khoan/ca-nhan">${sessionScope.user.email} <span><a href="/tai-khoan?action=dang-xuat">Đăng xuất</a></span></a>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <a href="<c:url value="/dang-nhap"/>" class="btn btn-primary ms-auto me-3 order-1 order-lg-2 h-25">Đăng nhập</a>
    </c:if>

</nav>