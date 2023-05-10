<%-- 
    Document   : prodStats
    Created on : Nov 4, 2022, 9:40:40 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center">THỐNG KÊ SẢN PHẨM THEO SẢN PHẨM</h1>

<form action="">
    <div class="form-group">
        <label>Từ khóa</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div>
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control"/>

    </div>
    <input type="submit" value="Bao cao" class="btn btn-success">
</form>

<div>
    <canvas id="myProdStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã danh mục</th>
        <th>Tên sản phẩm</th>
        <th>Doanh thu</th>

    </tr>
    <c:forEach items="${prodStats}" var="p">
        <tr>
            <td>${p[0]}</td>
            <td>${p[1]}</td>
            <td>${p[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let prodLabels = [], prodInfo = [];

    <c:forEach items="${prodStats}" var="p">
    prodLabels.push('${p[1]}')
    prodInfo.push(${p[2]})
    </c:forEach>

    window.onload = function () {
        prodChart("myProdStatsChart", prodLabels, prodInfo);
    };

</script>