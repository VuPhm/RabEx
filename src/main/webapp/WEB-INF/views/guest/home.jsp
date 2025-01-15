<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <%@include file="/WEB-INF/views/guest/common/head-link.jsp" %>
    <title>Trang chủ</title>
    <base href="${pageContext.request.contextPath}/"/>

</head>
<body>
<%-- Nav --%>
<%@include file="/WEB-INF/views/guest/common/navbar.jsp" %>
<%-- End Nav --%>

<%-- carousel --%>
<%@include file="/WEB-INF/views/guest/common/carousel.jsp" %>
<%-- carousel end --%>


<%-- carousel --%>
<%@include file="/WEB-INF/views/guest/common/quick-action.jsp" %>
<%-- carousel end --%>


<%-- Footer --%>
<%@include file="/WEB-INF/views/guest/common/footer.jsp" %>
<%-- End Footer --%>
</body>
</html>
