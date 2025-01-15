<%--<jsp:useBean id="order" scope="request" type="com.rabex.express.model.Order"/>--%>
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


<!--Order Status Start-->
<c:if test="${order!=null}">
    <div class="container-xxl wow fadeInDown" id="order_history">
        <div class="container">
            <div class="p-3 h3">
                Mã Bưu Phẩm: ${param.get("code")}
                <span class="order-status-tag alert-success h-25 rounded-3 my-auto px-2 py-1 fs-6 text-nowrap">
                        ${order.status.toString()}
                </span>
            </div>
            <div class="p-3 h5">Ngày lấy dự kiến: ${order.expectedDate}</div>
            <div class="order-status ps-5">
                <ul class="order-process-detail-list list-group list-unstyled">
                    <jsp:useBean id="records" scope="request" type="java.util.List"/>
                        <%--@elvariable id="rec" type="com.rabex.express.model.TrackingRecord"--%>
                    <c:forEach items="${records}" var="rec">
                        <li class="detail-list-item mb-3 row">
                            <div class="item-date col-3">${rec.modifiedAt}</div>
                            <div class="item-desc col-8">
                                <div class="item-text-box">[${rec.post}] ${rec.action.toString()}</div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</c:if>
<!--Order Status End-->


<%-- search result end--%>


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
