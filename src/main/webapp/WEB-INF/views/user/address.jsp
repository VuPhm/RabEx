<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<html>
<head>
  <%@include file="/WEB-INF/views/common/user/head-link.jsp" %>
  <title>Địa chỉ</title>
  <style>
    .address-item {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 15px;
      border-bottom: 1px solid #e0e0e0;
    }

    .address-details {
      flex-grow: 1;
    }

    .address-actions {
      display: flex;
      gap: 10px;
    }

    .address-table {
      width: 100%;
      border-collapse: collapse;
    }

    .address-table th, .address-table td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }

    .address-table th {
      background-color: #f2f2f2;
      font-weight: bold;
    }
  </style>
</head>
<body>
<%-- Nav --%>
<%@include file="../common/user/navbar.jsp" %>
<%-- End Nav --%>


</body>
</html>
