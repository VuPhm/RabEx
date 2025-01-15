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
        <section class="mb-4">
            <div class="card">
                <div class="card-header bg-white py-3">
                    <h5 class="mb-0">Lịch sử bưu phẩm</h5>
                </div>
                <div class="card-body">
                    <table class="table table-hover visible" id="data-table1">
                        <thead>
                        <tr>
                            <th>Mã bưu phẩm</th>
                            <th>Ngày gửi</th>
                            <th>Loại bưu phẩm</th>
                            <th>Khối lượng</th>
                            <th>Trạng thái</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <jsp:useBean id="orders" scope="request" type="java.util.List"/>
                        <c:forEach items="${orders}" var="o">
                            <tr>
                                <td>${o.code}</td>
                                <td>${o.createdAt}</td>
                                <td>${o.shippingService.name}</td>
                                <td>${o.parcel.weight}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${o.status == 'PENDING'}">
                                            <span class="badge bg-warning">Đang chờ</span>
                                        </c:when>
                                        <c:when test="${o.status == 'PROCESSED'}">
                                            <span class="badge bg-info">Đã xử lý</span>
                                        </c:when>
                                        <c:when test="${o.status == 'CANCELLED'}">
                                            <span class="badge bg-danger">Đã hủy</span>
                                        </c:when>
                                        <c:when test="${o.status == 'DONE'}">
                                            <span class="badge bg-success">Hoàn thành</span>
                                        </c:when>
                                        <c:when test="${o.status == 'RETURNED'}">
                                            <span class="badge bg-secondary">Đã trả lại</span>
                                        </c:when>
                                        <c:when test="${o.status == 'TRANSIT'}">
                                            <span class="badge bg-primary">Đang vận chuyển</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-light text-dark">Không xác định</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a class="btn btn-sm btn-outline-primary" href="/nguoi-dung/chi-tiet-buu-pham?id=${o.id}">Chi tiết</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <table class="table table-hover hidden" id="data-table2">
                        <thead>
                        <tr>
                            <th>Mã bưu phẩm</th>
                            <th>Ngày gửi</th>
                            <th>Loại bưu phẩm</th>
                            <th>Khối lượng</th>
                            <th>Trạng thái</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#BP12347</td>
                            <td>10/11/2024</td>
                            <td>Bưu phẩm tiết kiệm</td>
                            <td>3 kg</td>
                            <td><span class="badge bg-danger">Chờ xử lý</span></td>
                            <td>
                                <a class="btn btn-sm btn-outline-primary" href="order-details.html">Chi
                                    tiết</a>
                            </td>
                        </tr>
                        <tr>
                            <td>#BP12348</td>
                            <td>05/11/2024</td>
                            <td>Bưu phẩm quốc tế</td>
                            <td>5 kg</td>
                            <td><span class="badge bg-secondary">Hủy</span></td>
                            <td>
                                <a class="btn btn-sm btn-outline-primary" href="order-details.html">Chi
                                    tiết</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table table-hover hidden" id="data-table3">
                        <thead>
                        <tr>
                            <th>Mã bưu phẩm</th>
                            <th>Ngày gửi</th>
                            <th>Loại bưu phẩm</th>
                            <th>Khối lượng</th>
                            <th>Trạng thái</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#BP12348</td>
                            <td>05/11/2024</td>
                            <td>Bưu phẩm hoả tốc</td>
                            <td>5 kg</td>
                            <td><span class="badge bg-secondary">Hủy</span></td>
                            <td>
                                <a class="btn btn-sm btn-outline-primary" href="order-details.html">Chi
                                    tiết</a>
                            </td>
                        </tr>
                        <tr>
                            <td>#BP12347</td>
                            <td>10/11/2024</td>
                            <td>Bưu phẩm hoả tốc</td>
                            <td>3 kg</td>
                            <td><span class="badge bg-danger">Chờ xử lý</span></td>
                            <td>
                                <a class="btn btn-sm btn-outline-primary" href="order-details.html">Chi
                                    tiết</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <!-- Nút phân trang -->
                    <nav aria-label="Pagination" class="mt-4 d-flex justify-content-center">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous" onclick="changePage(-1)">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#data-table1" onclick="showPage(1)">1</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#data-table2" onclick="showPage(2)">2</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#data-table3" onclick="showPage(3)">3</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next" onclick="changePage(+1)">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
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
