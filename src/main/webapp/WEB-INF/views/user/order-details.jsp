<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/user/common/head-link.jsp" %>
    <title>lịch sử bưu phẩm</title>
    <style>
        .dt-search {
            display: none;
        }

        .hidden {
            display: none;
        }

        .visible {
            display: table;
        }
    </style>
</head>
<body>
<%-- Nav --%>
<%@include file="common/navbar.jsp" %>
<%-- End Nav --%>


<%--content--%>
<main id="content">
    <div class="container p-4 ">
        <section class="mb-1">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Đơn</li>
                </ol>
            </nav>
        </section>
        <section class="mb-4">
            <jsp:useBean id="order" scope="request" type="com.rabex.express.model.Order"/>
            <!--/*@thymesVar id=com.rabex.express.model.Order"productForm" type="com.group.sshop.models.dto.ProductForm"*/-->
            <div class="row">
                <div class="col-md-8 mb-4">
                    <div class="card rounded-1 shadow-0 rounded-1  mb-4">
                        <div class="card-header">
                            <div class="d-flex justify-content-between align-items-center align-content-center">
                                <b>${order.code}</b>
                                <div>
                                    <span class="badge badge-info">${order.status}</span>
                                </div>
                            </div>

                        </div>
                        <div class="card-body">
                            <div class="row">
                                <table class="table align-middle mb-0 bg-white">

                                    <tbody>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img
                                                        src="/img/testimonial-1.jpg"
                                                        alt=""
                                                        style="width: 45px; height: 45px"
                                                        class="rounded-circle"
                                                />

                                            </div>
                                        </td>
                                        <td>
                                            <div class="ms-3">
                                                <p class="fw-bold mb-1"
                                                >Phone</p>
                                                <p class="text-muted mb-0">
                                                    4x1x4
                                                </p>
                                            </div>
                                        </td>
                                        <td>
                                            600g
                                        </td>
                                        <td>
                                            x
                                        </td>
                                        <td>
                                            1
                                        </td>

                                        <td>
                                            48.000 vnd
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-7">

                                </div>
                                <div class="col-5">
                                    <table class="table table-borderless text-right table-sm"
                                    >
                                        <thead>
                                        <tr>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody class="text-right">
                                        <tr>
                                            <td>Số Lượng</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Khối Lượng</td>
                                            <td>${order.parcel.weight}</td>
                                        </tr>
                                        <tr>
                                            <td>Cost</td>
                                            <td>40.000đ</td>
                                        </tr>
                                        <tr>
                                            <td>Giảm Giá</td>
                                            <td>0</td>
                                        </tr>
                                        <tr>
                                            <td>COD</td>
                                            <td>100.000 vnd</td>
                                        </tr>
                                        <tr>
                                            <td>Thuế</td>
                                            <td>5.000vnd</td>
                                        </tr>

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-6">
                                    <h6 class="card-title text-danger"> Người gửi</h6>
                                    <p>Ngô Văn - 0385874145</p>
                                    <p>214B Đường Tân Bình Khu phố 2, P.Tam Phú, TP.Thủ Đức, TP.Hồ Chí Minh</p>
                                    <p class="text-secondary">Thời gian hẹn lấy: 04/12/2024, Tối (18h30 - 21h00)</p>

                                </div>
                                <div class="col-6">
                                    <h6 class="card-title text-danger"> Người nhận</h6>
                                    <p>Ngô Kinh - 0989888912</p>
                                    <p>123 Hẻm 1236 Đường Lê Văn Lương, X.Phước Kiển, H.Nhà Bè, TP.Hồ Chí Minh</p>
                                    <p class="text-secondary">Thời gian hẹn giao: Tối</p>
                                </div>
                            </div>

                        </div>
                        <hr class="hr m-0"/>
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-center">
                                <span>
                                    <i class="fa fa-check text-success me-2"></i>
Đã Xác Nhận                                </span>
                                <div>

                                </div>

                            </div>
                            <!--                            <div class="d-flex justify-content-between align-items-center">-->
                            <!--                                <span>-->
                            <!--                                    <i class="fa-regular fa-hourglass-start me-2"></i>-->
                            <!--                                    Waiting confirm-->
                            <!--                                </span>-->
                            <!--                                <div>-->
                            <!--                                    <a class="btn btn-outline-secondary shadow-0">-->
                            <!--                                        Confirm-->
                            <!--                                    </a>-->
                            <!--                                </div>-->
                            <!--                            </div>-->
                        </div>
                        <hr class="hr m-0"/>
                        <div class="card-body">
                            <!--                            <div class="d-flex justify-content-between align-items-center">-->
                            <!--                                <span>-->
                            <!--                                    <i class="fa fa-check text-success me-2"></i>-->
                            <!--                                    <span></span>-->
                            <!--                                </span>-->
                            <!--                                <div>-->
                            <!--                                    <button class="btn btn-outline-secondary shadow-0">-->
                            <!--                                        Refund-->
                            <!--                                    </button>-->
                            <!--                                </div>-->

                            <!--                            </div>-->
                            <div class="d-flex justify-content-between align-items-center"
                            >
                                <span>
                                    <i class="fa-regular fa-hourglass-start me-2"></i>
                                    Chờ Thanh Toán
                                </span>
                                <div>
                                    <a class="btn btn-outline-secondary">
                                        Xác Nhận Thanh Toán
                                    </a>
                                </div>
                            </div>
                        </div>
                        <hr class="hr m-0"/>
                        <div class="card-body">
                            <!--                            <div class="d-flex justify-content-between align-items-center">-->
                            <!--                                <span>-->
                            <!--                                    <i class="fa fa-check text-success me-2"></i>-->
                            <!--                                    <span>-->
                            <!--                                        Delivery-->
                            <!--                                    </span>-->
                            <!--                                </span>-->
                            <!--                                <div>-->
                            <!--                                </div>-->

                            <!--                            </div>-->
                            <div class="d-flex justify-content-between align-items-center">
                                <span>
                                    <i class="fa-regular fa-hourglass-start me-2"></i>
                                    Đang Vận Chuyên
                                </span>
                                <div>
                                    <a class="btn btn-outline-secondary shadow-0">
                                        Xác nhận đã nhận
                                    </a>
                                </div>
                            </div>
                            <div class="card-body mt-2">
                                <div class="row mb-3">
                                    <div class="col-6">
                                        <span class="small text-muted text-uppercase fw-bold d-inline-block w-35">
                                            Vị trí
                                        </span>
                                        <span class="text-primary">
                                            Bưu cục Linh Trung - TP HCM
                                        </span>
                                    </div>
                                    <div class="col-6">
                                        <span class="small text-muted text-uppercase fw-bold d-inline-block w-35">
                                            Trạng Thái
                                        </span>
                                        <span class="badge badge-info">
                                            Đang vận chuyển
                                        </span>
                                    </div>


                                    <div class="col-6">
                                        <span class="small text-muted text-uppercase fw-bold d-inline-block w-35">
                                            Tạo Lúc
                                        </span>
                                        <br/>
                                        <span>

                                        </span>
                                    </div>
                                    <div class="col-6">
                                        <span class="small text-muted text-uppercase fw-bold d-inline-block w-35">
                                            Cập nhật lúc
                                        </span>
                                        <br/>
                                        <span>

                                        </span>

                                    </div>
                                    <div class="col-6"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="card rounded-1 shadow-0 shadow-0 mb-4">
                        <div class="card-header">
                            Customer
                        </div>
                        <div class="card-body">
                            <div class="d-flex ">
                                <img
                                        src="/img/testimonial-1.jpg"
                                        alt=""
                                        style="width: 45px; height: 45px"
                                        class="rounded-circle"
                                />
                                <div class="ms-3">
                                    <p class="fw-bold mb-1" >John Doe</p>
                                    <p class="text-muted mb-0" >john.doe@gmail.com</p>
                                    <p class="text-muted mb-0"><i class="fa fa-cube me-2"></i><span></span>
                                    </p>
                                </div>
                            </div>
                            <div>
                            </div>
                            <div>
                            </div>
                        </div>
                    </div>
                    <div class="card rounded-1 shadow-0 shadow-0 mb-4">
                        <div class="card-header">
                            Thông tin đơn
                        </div>
                        <div class="card-body">
                            <p><strong>Mã đơn hàng:</strong> #BP12345</p>
                            <p><strong>Ngày lập:</strong> 03/12/2024 05:05:23</p>
                            <p><strong>Ngày nhận hàng dự kiến:</strong> Đơn cập nhật</p>
                            <p><strong>Trạng thái:</strong> Hỏa tốc, hẹn giờ</p>
                            <p><strong>Dịch vụ cộng thêm:</strong> Zalo thông báo đơn hàng</p>
                        </div>
                    </div>

                </div>
            </div>

        </section>
    </div>
</main>

<%--content--%>

<script src="<c:url value='/static/js/mdb.umd.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
<script src="<c:url value='/static/js/main.js'/>"></script>
<script>
    const sidenav = document.getElementById("main-sidenav");

    const sidenavInstance = mdb.Sidenav.getInstance(sidenav);

    const currencyFormat = Intl.NumberFormat("vi-VN", {style: 'currency', currency: 'VND'})


    let innerWidth = null;

    //

    const setMode = (e) => {
        // Check necessary for Android devices
        if (window.innerWidth === innerWidth) {
            return;
        }

        innerWidth = window.innerWidth;

        if (window.innerWidth < 1400) {
            sidenavInstance.changeMode("over");
            sidenavInstance.hide();
        } else {
            sidenavInstance.changeMode("side");
            sidenavInstance.show();
        }
    };

    setMode();

    // Event listeners
    window.addEventListener("resize", setMode);

    const searchFocus = document.getElementById('search-focus');
    const keys = [
        {keyCode: 'AltLeft', isTriggered: false},
        {keyCode: 'ControlLeft', isTriggered: false},
    ];

    window.addEventListener('keydown', (e) => {
        keys.forEach((obj) => {
            if (obj.keyCode === e.code) {
                obj.isTriggered = true;
            }
        });

        const shortcutTriggered = keys.filter((obj) => obj.isTriggered).length === keys.length;

        if (shortcutTriggered) {
            searchFocus.focus();
        }
    });

    window.addEventListener('keyup', (e) => {
        keys.forEach((obj) => {
            if (obj.keyCode === e.code) {
                obj.isTriggered = false;
            }
        });
    });

    // Phân trang
    let currentPage = 1; // Bắt đầu ở trang 1
    const totalPages = 3; // Tổng số trang

    function showPage(pageNumber) {
        if (pageNumber < 1 || pageNumber > totalPages) {
            return; // Không làm gì nếu vượt quá giới hạn
        }

        // Ẩn tất cả bảng
        document.querySelectorAll("table").forEach((table) => {
            table.classList.add("hidden");
            table.classList.remove("visible");
        });

        // Hiện bảng của trang hiện tại
        document.querySelector("#data-table" + pageNumber).classList.remove("hidden");
        document.querySelector("#data-table" + pageNumber).classList.add("visible");

        currentPage = pageNumber; // Cập nhật trang hiện tại
    }

    function changePage(step) {
        const newPage = currentPage + step; // Tính trang tiếp theo
        showPage(newPage); // Chuyển đến trang mới
    }
</script>
</body>
</html>
