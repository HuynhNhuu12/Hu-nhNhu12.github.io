<%-- 
    Document   : admin-left
    Created on : Nov 3, 2022, 10:02:44 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- A vertical navbar -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<nav class="navbar bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/cateStats"></c:url>">Thống kê sản phẩm theo danh mục</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/prodStats"></c:url>"">Thống kê doanh thu theo từng sản phẩm</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/prodMonthStats"></c:url>">Thống kê doanh thu theo thời gian</a>
    </li>
  </ul>

</nav>
