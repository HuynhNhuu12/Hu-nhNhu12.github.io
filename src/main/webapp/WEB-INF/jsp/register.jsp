<%-- 
    Document   : register
    Created on : Sep 9, 2022, 10:48:27 PM
    Author     : HUYNH NHU
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
</c:if>


<c:url value="/register" var="action" />
<div class="row justify-content-center">
    <div class="col-lg-7">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4">TẠO TÀI KHOẢN</h3></div>
            <div class="card-body">
                <form:form method="post" action="${action}" modelAttribute="user">
                    <div class="form-group">
                        <label for="firstname">Tên</label>
                        <form:input type="text" id="firstname" path="firstName" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="lastname">Họ</label>
                        <form:input type="text" id="lastname" path="lastName" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <form:input type="text" id="email" path="email" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="username">Tên đăng nhập</label>
                        <form:input type="text" id="username" path="username" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu</label>
                        <form:input type="password" id="password" path="password" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="confirm-password">Nhập lại mật khẩu</label>
                        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
                    </div>
                        <label for="image">Ảnh đại diện</label>
                        <div class="form-floating mt-3 mb-3">
                            <form:input type="file" class="form-control"  path="file" id="file"/>
                        </div>
                    <div class="form-group">
                        <input type="submit" value="ĐĂNG KÝ" class="btn btn-danger"/>
                    </div>
                </form:form>
            </div>
            <div class="card-footer text-center py-3">
                <div class="small">
                    <a href="<c:url value="/login"/>">Đã có tài khoản? Tiếp tục đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
</div>



