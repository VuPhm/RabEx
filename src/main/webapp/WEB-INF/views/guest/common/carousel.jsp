<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- Carousel Start -->
<div class="container-fluid p-0">
    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <a class="carousel-item active" href="tao-don" data-bs-interval="3000">
                <img src="${pageContext.request.contextPath}/static/img/c1.png" class="d-block w-100 img-fluid" alt="..."
                     style="height: 50vh; object-fit: cover;">
            </a>
            <a class="carousel-item" href="tao-don" data-bs-interval="3000">
                <img src="${pageContext.request.contextPath}/static/img/c2.png" class="d-block w-100 img-fluid" alt="..."
                     style="height: 50vh; object-fit: cover;">
            </a>
            <a class="carousel-item" href="dich-vu" data-bs-interval="3000">
                <img src="${pageContext.request.contextPath}/static/img/c3.png" class="d-block w-100 img-fluid" alt="..."
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
