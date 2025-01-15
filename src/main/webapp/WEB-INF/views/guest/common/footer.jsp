<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container-fluid bg-dark text-light footer pt-5 wow fadeIn" data-wow-delay="0.1s" style="margin-top: 6rem; visibility: visible; animation-delay: 0.1s; animation-name: fadeIn;">
    <div class="container py-5">
        <div class="row g-5">
            <div class="col-lg-3 col-md-6">
                <h4 class="text-light mb-4">Địa chỉ</h4>
                <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>KP6, Linh Trung, Thủ Đức, Việt Nam</p>
                <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>1900 1009</p>
                <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@rabex.vn</p>
                <div class="d-flex pt-2">
                    <a class="btn btn-outline-light btn-social" href="http://www.x.com"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-outline-light btn-social" href="http://www.facebook.com"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-outline-light btn-social" href="http://www.youtube.com"><i class="fab fa-youtube"></i></a>
                    <a class="btn btn-outline-light btn-social" href="http://www.linkedin.com"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="text-light mb-4">Dịch vụ</h4>
                <%--@elvariable id="services" type="java.util.List"--%>
                <c:forEach var="service" items="${services}">
                    <a class="btn btn-link" href="dich-vu/${service.slug}">${service.name}</a>
                </c:forEach>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="text-light mb-4">Truy cập nhanh</h4>
                <a href="ve-chung-toi" class="btn btn-link">Về chúng tôi</a>
                <a href="lien-he" class="btn btn-link">Liên hệ</a>
                <a href="dich-vu" class="btn btn-link">Dịch vụ</a>
            </div>
            <div class="col-lg-3 col-md-6">
                <h4 class="text-light mb-4">Cập nhật thông tin</h4>
                <p>Đăng ký nhận thông tin về uu đãi và dịch vụ mới.</p>
                <div class="position-relative mx-auto" style="max-width: 400px;">
                    <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Email của bạn">
                    <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">Đăng ký
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- Feature End -->
    <div class="container">
        <div class="copyright">
            <div class="row">
                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                    © <a class="border-bottom" href="<c:url value="/"/> >">RabEx</a>
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/guest/common/script-links.jsp" %>
