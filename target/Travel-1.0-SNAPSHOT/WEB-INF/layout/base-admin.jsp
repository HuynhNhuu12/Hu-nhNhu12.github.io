<%-- 
    Document   : base-admin
    Created on : Nov 3, 2022, 9:54:11 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <%--<tiles:insertAttribute name="title" />--%>
            <tiles:insertAttribute name="title"/>
        </title>
        <!--        <link href="styles.css"  type="text/css" />-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>
        <<h1 class="text-center text-info">TRANG THỐNG KÊ - BÁO CÁO</h1>
        <div class="container">
            <div class="rơw">
                <div class="col-md-4 col-xs-12">
                    <tiles:insertAttribute name="left" />
                    <%--<tiles:insertAttribute name="carousel" />--%>
                </div>  
                <div class="col-md-12 col-xs-12">
                    <tiles:insertAttribute name="content" />
                </div>
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
                <script src="<c:url value="/js/stats.js"></c:url>"></script>
    </body>
</html>
