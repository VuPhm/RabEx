<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/guest/common/head-link.jsp" %>
    <title>Tra cứu bưu phẩm</title>
    <base href="${pageContext.request.contextPath}/"/>

    <link href="<c:url value="/static/css/guest/order-search.css"/>" rel="stylesheet">
</head>
<body>
<%-- Nav --%>
<%@include file="/WEB-INF/views/guest/common/navbar.jsp" %>
<%-- End Nav --%>

<%-- carousel --%>
<%@include file="/WEB-INF/views/guest/common/carousel.jsp" %>
<%-- carousel end --%>


<%-- quick search action --%>
<%@include file="/WEB-INF/views/guest/common/quick-action.jsp" %>
<%-- quick search action end --%>


<%-- search result--%>



<!--Order Header Start-->
<div class="container-xxl mb-3 wow fadeInDown">
    <div class="container" id="header_order">
        <div class="row g-3">
            <div class=" col-lg-4 col-md-4 col-12">
                <div class="header-order" style="">
                    <div class="title text-bold">THÔNG TIN BƯU PHẨM</div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Mã đơn hàng:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">G8W868XG</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Ngày lấy dự kiến:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">Thứ 6, 06/09/2024</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Ngày giao dự kiến:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">Thứ 2, 09/09/2024</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Trạng thái hiện tại:</div>
                            </div>
                            <div class="value text-bold">
                                <div class="status">Giao hàng thành công</div>
                                <br><span class="block-center block-left block-wrap"><span
                                    class="text-normal"></span></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=" col-lg-4 col-md-4 col-12">
                <div class="header-order" style="">
                    <div class="title text-bold">NGƯỜI GỬI</div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Họ và tên:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">xxxx ouse</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Điện thoại:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">xxxx 4311</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Địa chỉ:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">xxxx Quận 12 Hồ Chí Minh</span></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class=" col-lg-4 col-md-4 col-12">
                <div class="header-order" style="">
                    <div class="title text-bold">NGƯỜI NHẬN</div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Họ và tên:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">xxxx Vũ&lt;&gt;</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Điện thoại:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">xxxx 5002</span></span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="table-row">
                            <div class="label">
                                <div>Địa chỉ:</div>
                            </div>
                            <div class="value text-bold"><span class="block-center block-left block-wrap"><span
                                    class="">xxxx Thành phố Dĩ An Bình Dương</span></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--Order Header End-->

<!--Order Status Start-->
<div class="container-xxl wow fadeInDown" id="order_history">
    <div class="container">
        <div class="p-3 h3">
            Mã Bưu Phẩm: RBX04276830906A
            <span class="order-status-tag alert-success h-25 rounded-3 my-auto px-2 py-1 fs-6 text-nowrap">
                Giao hàng thành công
            </span>
        </div>
        <div class="order-status ps-5">
            <ul class="order-process-detail-list list-group list-unstyled">
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">14/10/2024 12:48:52</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">[63-BDG Di An Hub] Đơn hàng đã giao thành công</div>
                    </div>
                </li>
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">14/10/2024 10:51:48</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">[63-BDG Di An Hub] Nhân viên giao hàng đang tiến hành giao</div>
                    </div>
                </li>
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">14/10/2024 10:09:10</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">[63-BDG Di An Hub] Đã tới bưu cục phát</div>
                    </div>
                </li>
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">11/10/2024 17:07:56</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">[20-HNI Tay Ho 2 Hub] Đang được luân chuyển đến [HN2 SOC]</div>
                    </div>
                </li>
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">11/10/2024 16:38:05</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">[20-HNI Tay Ho 2 Hub] Đã chuyển tới bưu cục lấy</div>
                    </div>
                </li>
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">11/10/2024 16:35:34</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">[20-HNI Tay Ho 2 Hub] Đơn vị vận chuyển đã lấy hàng</div>
                    </div>
                </li>
                <li class="detail-list-item mb-3 row">
                    <div class="item-date col-3">11/10/2024 08:48:52</div>
                    <div class="item-desc col-8">
                        <div class="item-text-box">Đơn hàng đã được tạo</div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--Order Status End-->


<%-- search result end--%>


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
