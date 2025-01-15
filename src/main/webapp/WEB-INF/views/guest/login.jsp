<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/guest/common/head-link.jsp" %>
    <title>Đăng nhập</title>
    <base href="${pageContext.request.contextPath}/" />

</head>
<body>
<%-- Nav --%>
<%@include file="/WEB-INF/views/guest/common/navbar.jsp" %>
<%-- End Nav --%>

<%--&lt;%&ndash; carousel &ndash;%&gt;--%>
<%--<%@include file="/WEB-INF/views/guest/common/carousel.jsp" %>--%>
<%--&lt;%&ndash; carousel end &ndash;%&gt;--%>


<div class="container overflow-hidden py-5 px-lg-0">
    <div class="container about py-5 px-lg-0">
        <div class="row g-5 ">
            <div class="col-lg-6 wow fadeInLeft d-none d-lg-block" data-wow-delay="0.1s">
                <img src="${pageContext.request.contextPath}/static/img/about.jpg"
                     alt="" style="width: 100%">
            </div>
            <form action="dang-nhap" method="post" class="col-lg-6 row wow fadeInUp align-items-center" data-wow-delay="0.3s">
                <div class="text-center wow fadeInUp mb-5 p-2" data-wow-delay="0.1s"
                     style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
                    <h1 class=""> Đăng Nhập
                    </h1>
                </div>
                <div class="col-md-12 col-lg-12 fadeInUp py-3" data-wow-delay="0.3s">

                    <div class="form-floating">
                        <input type="password" class="form-control" name="email" id="email" placeholder="Password">
                        <label for="floatingPassword">Địa chỉ email</label>
                    </div>
                </div>
                <div class="col-md-12 col-lg-12 fadeInUp py-3" data-wow-delay="0.3s">

                    <div class="form-floating">
                        <input type="password" name="password" class="form-control" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">Mật khẩu</label>
                    </div>
                </div>
                <div class="col-md-12 col-lg-12 fadeInUp py-3" data-wow-delay="0.3s">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="d-flex">
                                <input class="form-check me-2" type="checkbox" name="remember" id="remember">
                                <label for="remember" class="form-check-label">Nhớ Đăng nhập</label>
                            </div>
                        </div>
                        <div>
                            <a class="link-primary">Quên Mật Khẩu ?</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 col-lg-12 fadeInUp" data-wow-delay="0.3s">
                    <button type="submit" class="btn btn-lg btn-primary w-100">
                        Đăng Nhập
                    </button>
                </div>
                <div class="col-md-12 col-lg-12 fadeInUp text-center mb-1" data-wow-delay="0.3s">
                    Chưa có tài khoản ?
                    <a class="link-primary">Đăng Ký Ngay</a>

                </div>
                <div class="col-md-12 col-lg-12 fadeInUp " data-wow-delay="0.3s">
                    <hr/>
                </div>
                <div class="col-md-12 col-lg-12 fadeInUp d-flex justify-content-center " data-wow-delay="0.3s">
                    <a class="brand-btn">
                        <i class="fab fa-facebook"></i>
                    </a>

                    <a class="brand-btn">
                        <i class="fab fa-google"></i>
                    </a>
                </div>
            </form>

        </div>

    </div>
</div>



<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
