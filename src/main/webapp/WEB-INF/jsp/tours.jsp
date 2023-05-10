<%-- 
    Document   : tours
    Created on : Aug 27, 2022, 7:59:09 PM
    Author     : HUYNH NHU
--%>
<%--enctype="multipart/form-data" --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-infor">QUAN LY TOUR DU LICH</h1>

<c:url value="/admin/tours" var="action"/>
<form:form method="post" action="${action}" modelAttribute="tour" >
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="name" id="name" />
        <label for="email">Tên tour</label>
        <form:errors path="name" element="div" cssClass="invalid-feedback"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input class="form-control"  path="price_adult" id="price_adult"/>
        <label for="pwd">Giá</label>
        <form:errors path="price_adult" element="div" cssClass="invalid-feedback"/>
    </div>
    
<!--    <label for="pwd">Ảnh tour</label>
    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control"  path="file" id="file"/>
    </div>-->
    <div class="form-floating">
        <form:select path="categoryId" class="form-select" id="sel1" name="sellist">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh muc dia diem</label>
    </div>

    <input type="submit" value="Them tour" class="btn btn-danger"/>
</form:form>

<div class="spinner-border text-muted" id="myLoading"></div>
<table class="table">
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tbody id="adminTour">

    </tbody>
</table>
<script src="<c:url value="/js/tour.js"/>"></script>
<script>
    <c:url value="/api/tours" var="endpoint"/>

    window.onload = function () {
        loadAdminTours('${endpoint}');
    };
</script>

