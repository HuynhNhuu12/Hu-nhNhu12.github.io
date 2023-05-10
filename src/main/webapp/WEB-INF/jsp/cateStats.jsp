<%-- 
    Document   : cateStats
    Created on : Nov 3, 2022, 10:07:41 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center">THỐNG KÊ SẢN PHẨM THEO DANH MỤC</h1>

<div>
  <canvas id="myCateStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã danh mục</th>
        <th>Tên danh mục</th>
        <th>Số lượng sản phẩm</th>
        
    </tr>
    <c:forEach items="${cateStats}" var="c">
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>
            <td>${c[2]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let cateLabels = [], cateInfo = [];
    
    <c:forEach items="${cateStats}" var="c">
        cateLabels.push('${c[1]}')
        cateInfo.push(${c[2]})
    </c:forEach>
    
    window.onload = function() {
        cateChart("myCateStatsChart", cateLabels, cateInfo);   
    };
    
</script>