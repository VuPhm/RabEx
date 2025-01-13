<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/user/head-link.jsp" %>
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
<%@include file="../common/user/navbar.jsp" %>
<%-- End Nav --%>


<%--content--%>
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
