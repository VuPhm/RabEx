<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--nav bar--%>
<nav id="main-navbar" class="navbar navbar-expand-lg navbar-light bg-white fixed-top shadow-1" style="">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Toggler -->
        <button data-mdb-toggle="sidenav" data-mdb-target="#main-sidenav"
                class="btn shadow-0 p-0 me-3 d-block d-xxl-none" data-mdb-ripple-init="" aria-controls="#main-sidenav"
                aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-bars fa-lg"></i>
        </button>

        <!-- Search form -->
        <form class="d-none d-md-flex input-group w-auto my-auto">
            <input id="search-focus" autocomplete="off" type="search" class="form-control rounded"
                   placeholder="Tìm kiếm (ctrl + alt)" style="min-width: 225px">
            <span class="input-group-text border-0"><i class="fas fa-search text-secondary"></i></span>
        </form>

        <!-- Right links -->
        <ul class="navbar-nav ms-auto d-flex flex-row align-items-center ">
            <li class="nav-item me-4">
                <a class="btn btn-outline-primary" href="order-create.html">
                    <i class="fas fa-plus fa-fw me-3"></i>Tạo Đơn</a>
            </li>
            <!-- Notification dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link me-3 me-lg-0 dropdown-toggle hidden-arrow" href="#" id="navbarDropdownMenuLink2"
                   role="button" data-mdb-dropdown-init="" aria-expanded="false" data-mdb-dropdown-initialized="true">
                    <i class="fas fa-bell link-secondary"></i>
                    <span class="badge rounded-pill badge-notification bg-danger">1</span>
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink2">
                    <li><a class="dropdown-item" href="#">Some news</a></li>
                    <li><a class="dropdown-item" href="#">Another news</a></li>
                    <li>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </li>
                </ul>
            </li>

            <!-- Icon dropdown -->

            <!-- Avatar -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center" href="#"
                   id="navbarDropdownMenuLink" role="button" data-mdb-dropdown-init="" aria-expanded="false"
                   data-mdb-dropdown-initialized="true">
                    <img src="./../../img/testimonial-1.jpg" class="rounded-circle" height="32" alt="Avatar"
                         loading="lazy">
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMenuLink">
                    <li><a class="dropdown-item " href="user-info.html">My profile</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="/logout">Logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- Container wrapper -->
</nav>
<%--side bar--%>
<nav id="main-sidenav" data-mdb-sidenav-init="" class="sidenav sidenav-sm shadow-1 sidenav-primary ps ps--active-y"
     data-mdb-hidden="false" data-mdb-accordion="true"
     style="width: 240px; height: 100vh; position: fixed; transition-duration: 0.3s; transition-property: transform, width, padding, margin; transition-timing-function: linear; transform: translateX(0%);"
     data-mdb-sidenav-initialized="true">
    <a class="d-flex justify-content-center pt-4 pb-2" href="#" data-mdb-ripple-init="" data-mdb-ripple-color="primary">
        <h2 class="mb-2 text-primary">RabEx</h2>
    </a>

    <hr class="hr">

    <ul class="sidenav-menu px-2 pb-5">


        <li class="sidenav-item pt-3">
            <span class="sidenav-subheading text-muted text-uppercase fw-bold">Dashboard</span>
        </li>
        <li class="sidenav-item">
            <a class="sidenav-link ripple-surface" href="./../dashboard.html" data-mdb-ripple-initialized="true"
               tabindex="1">
                <i class="fas fa-plus fa-fw me-3"></i><span>Dashboard</span></a>
        </li>

        <li class="sidenav-item pt-3">
            <span class="sidenav-subheading text-muted text-uppercase fw-bold">Quản lý đơn hàng</span>
        </li>
        <li class="sidenav-item">
            <a class="sidenav-link ripple-surface" href="order-manager.html" data-mdb-ripple-initialized="true"
               tabindex="1">
                <i class="fas fa-cubes fa-fw me-3"></i><span>Theo dõi đơn hàng</span></a>
        </li>
        <li class="sidenav-item">
            <a class="sidenav-link ripple-surface" href="order-history.html" data-mdb-ripple-initialized="true"
               tabindex="1">
                <i class="fas fa-list-alt fa-fw me-3"></i><span>Lịch sử đơn hàng</span></a>
        </li>

    </ul>
    <div class="ps__rail-x" style="left: 0px; bottom: 0px;">
        <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>
    </div>
    <div class="ps__rail-y" style="top: 0px; height: 677px; right: 0px;">
        <div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 676px;"></div>
    </div>
    <!-- Heading -->
    <section class="text-center text-md-start">
        <!-- Background gradient -->
        <div style="height: 60px;">
        </div>
        <!-- Background gradient -->

    </section>
    <!-- Heading -->
</nav>