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
    <div class="container p-4">
        <!-- Section: Sales Performance KPIs -->
        <section class="mb-1">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/">Trang chủ</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Tạo đơn</li>
                </ol>
            </nav>
        </section>
        <!-- Section: Sales Performance KPIs -->
        <form action="<c:url value="/nguoi-dung/tao-don"/>" method="post">

            <!--Section: Shopping Funnel & Product revenue-->
            <section class="mb-1">
                <div class="row ">
                    <div class="col-md-12 mb-2">
                        <div class="card shadow-0 shadow-0 mb-4 p-2 rounded-1">
                            <div class="card-header">Địa chỉ người gửi</div>

                            <div class="card-body p-3">
                                <div class="row g-4 mt-3">
                                    <div class="col-md-6 mt-1">
                                        <label for="phone-number">Số điện thoại <span
                                                class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="basic-addon11">84</span>
                                            <input
                                                    id="phone-number"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="Username"
                                                    aria-describedby="basic-addon11"
                                                    name="senderPhoneNumber"
                                            />
                                        </div>
                                    </div>

                                    <div class="col-md-6 mt-1">
                                        <label for="sender-name">Họ và tên <span class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    id="sender-name"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="Username"
                                                    aria-describedby="basic-addon1"
                                                    name="senderFullName"
                                            />
                                        </div>
                                    </div>
                                    <div class="col-md-6 mt-1">
                                        <label for="sender-address">Chi tiết địa chỉ <span
                                                class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    id="sender-address"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="senderAddress"
                                                    aria-describedby="basic-addon1"
                                                    name="senderAddressDetail"
                                            />
                                        </div>
                                    </div>

                                    <div class="col-md-6 mt-1">
                                        <label for="sender-name">Mã bưu điên <span class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    id="sender-zipcode"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="Username"
                                                    aria-describedby="basic-addon1"
                                                    name="senderCodePost"
                                            />
                                        </div>
                                    </div>
                                    <div class="col-md-6 mt-1">
                                        <label for="address-sender">Địa chỉ <span
                                                class="text-danger">*</span></label>
                                        <div class="dropdown" id="address-sender"></div>
                                    </div>
                                    <div class="col-md-6 mt-1">
                                        <label for="sender-name">Hướng dẫn giao hàng</label>
                                        <div class="input-group mb-3">
                                            <textarea class="form-control" id="textAreaExample1"
                                                      placeholder="Vui lòng nhập thông tin " rows="3" name="instruction"></textarea>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--Section: Shopping Funnel & Product revenue-->

            <section class="mb-2">
                <div class="row ">
                    <div class="col-md-12 mb-2">
                        <div class="card shadow-0 shadow-0 mb-4 p-2 rounded-1">
                            <div class="card-header">Địa chỉ người nhận</div>

                            <div class="card-body p-3">
                                <div class="row g-4 mt-3">
                                    <div class="col-md-6 mt-1">
                                        <label for="phone-number">Số điện thoại <span
                                                class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="basic-addon1">84</span>
                                            <input
                                                    id="receiver-phone-number"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="Username"
                                                    aria-describedby="basic-addon1"
                                                    name="receiverPhoneNumber"
                                            />
                                        </div>
                                    </div>

                                    <div class="col-md-6 mt-1">
                                        <label for="receiver-name">Họ và tên <span class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    id="receiver-name"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="Username"
                                                    aria-describedby="basic-addon1"
                                                    name="receiverFullName"
                                            />
                                        </div>
                                    </div>
                                    <div class="col-md-6 mt-1">
                                        <label for="receiver-address">Chi tiết địa chỉ <span
                                                class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    id="receiver-address"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="receiverAddress"
                                                    aria-describedby="basic-addon1"
                                                    name="receiverAddressDetail"
                                            />
                                        </div>
                                    </div>

                                    <div class="col-md-6 mt-1">
                                        <label for="receiver-name">Mã bưu điên <span
                                                class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    id="receiver-zipcode"
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin "
                                                    aria-label="Username"
                                                    aria-describedby="basic-addon1"
                                                    name="receiverCodePost"
                                            />
                                        </div>
                                    </div>
                                    <div class="col-md-6 mt-1">
                                        <label for="address-receiver">Địa chỉ <span
                                                class="text-danger">*</span></label>
                                        <div class="dropdown" id="address-receiver"></div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class="mb-1">
                <div class="row ">
                    <div class="col-md-12 mb-2">
                        <div class="card shadow-0 shadow-0 mb-4 p-2 rounded-1">
                            <div class="card-header">Thông tin bưu kiện</div>

                            <div class="card-body p-3">
                                <div class="row g-4 mt-1">
                                    <div class="col-md-10">
                                        <label for="receiver-name">Tên bưu kiện <span class="text-danger">*</span></label>
                                        <div class="input-group">
                                            <input
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin"
                                                    aria-label="Recipient's username"
                                                    aria-describedby="basic-addon2"
                                                    name="nameParcel"
                                            />
                                        </div>
                                    </div>
                                    <div class="col-md-3 mt-3">
                                        <label for="receiver-name">Khối lương <span class="text-danger">*</span></label>
                                        <div class="input-group mb-3">
                                            <input
                                                    type="text"
                                                    class="form-control"
                                                    placeholder="Vui lòng nhập thông tin"
                                                    aria-label="Recipient's username"
                                                    aria-describedby="basic-addon2"
                                                    name="weight"
                                            />
                                            <span class="input-group-text" id="basic-addon2">Kg</span>
                                        </div>
                                    </div>
                                    <div class="col-md-9 mt-3 ">
                                        <label for="receiver-name">Kích thước <span class="text-danger">*</span></label>
                                        <div class="d-flex align-items-center justify-content-around">
                                            <div>
                                                <div class="input-group">
                                                    <input
                                                            type="text"
                                                            class="form-control"
                                                            placeholder="Vui lòng nhập thông tin"
                                                            aria-label="Recipient's username"
                                                            aria-describedby="basic-addon2"
                                                            name="longg"
                                                    />
                                                    <span class="input-group-text">cm</span>
                                                </div>
                                            </div>
                                            <div>x</div>
                                            <div>
                                                <div class="input-group">
                                                    <input
                                                            type="text"
                                                            class="form-control"
                                                            placeholder="Vui lòng nhập thông tin"
                                                            aria-label="Recipient's username"
                                                            aria-describedby="basic-addon2"
                                                            name="high"
                                                    />
                                                    <span class="input-group-text">cm</span>
                                                </div>
                                            </div>
                                            <div>x</div>
                                            <div>
                                                <div class="input-group">
                                                    <input
                                                            type="text"
                                                            class="form-control"
                                                            placeholder="Vui lòng nhập thông tin"
                                                            aria-label="Recipient's username"
                                                            aria-describedby="basic-addon2"
                                                            name="wide"
                                                    />
                                                    <span class="input-group-text">cm</span>
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                    <div class="col-md-12 mt-1">
                                        <label for="receiver-name">Thu Hộ <span class="text-danger">*</span></label> <%--này chưa xử lý được thằng lồn. Mai tiếp tục làm xử lý load bằng script ditmethanglon--%>
                                        <div class="input-group">
                                            <div class="input-group-text">
                                                <input class="form-check-input mt-0" type="radio" value=""
                                                       aria-label="Radio button for following text input" name="collecter"/>
                                            </div>
                                            <input type="text" class="form-control"
                                                   aria-label="Text input with radio button" name="costCollecter"/>
                                            <div class="input-group-text">
                                                đ
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-4 mt-4">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" value=""
                                                   id="flexCheckDefault" name="fragile"/>
                                            <label class="form-check-label" for="flexCheckDefault">Dễ vỡ</label>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>

            <section class="mb-1">
                <div class="row">
                    <div class="col-md-12 mb-2">
                        <div class="card shadow-0 mb-4 p-2 rounded-1">
                            <div class="card-header">Phương thức vận chuyển</div>
                            <div class="card-body p-3">
                                <div class="row g-5">
                                    <jsp:useBean id="services" type="java.util.List" scope="request"/>
                                    <c:forEach var="service" items="${services}" varStatus="status">
                                        <div class="col-md-3">
                                            <div class="border-2 border-primary d-flex align-items-center gap-3">
                                                <input class="form-check-input" type="radio"
                                                       name="shippingService"
                                                       id="shippingService${status.index}"
                                                       value="${service.id}"/>
                                                <i class="fa fa-truck" style="font-size: 30px"></i>
                                                <div>
                                        <span class="text-uppercase fw-bold">
                                                ${service.name}
                                        </span>
                                                    <br/>
                                                    <span class="text-muted">${service.expectedTime}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class="mb-1">
                <div class="row ">
                    <div class="col-md-12 mb-2">
                        <div class="card shadow-0 shadow-0 mb-4 p-4 rounded-1">
                            <form action="<c:url value="/nguoi-dung/tao-don"/>" method="post">
                            <button type="submit" class="btn btn-primary w-auto">
                                Tạo
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    </div>
</main>
<%--content--%>

<script src="<c:url value='/static/js/mdb.umd.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.2/dist/quill.js"></script>
<script src="<c:url value='/static/js/main.js'/>"></script>
<script src="<c:url value="/static/js/address.dropdown.js"/>"></script>
<script src="<c:url value="/static/data/dvhc.json"/>"></script>
<script>
    const addressSender = new AddressDropdown("#address-sender", {
        url: "<c:url value='/static/data/dvhc.json'/>",
        placeholder: "address",
        name: "address"
    })
    addressSender.init()
    const addressReceiver = new AddressDropdown("#address-receiver", {
        url: "<c:url value='/static/data/dvhc.json'/>",
        placeholder: "address",
        name: "address"
    })
    addressReceiver.init()

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
