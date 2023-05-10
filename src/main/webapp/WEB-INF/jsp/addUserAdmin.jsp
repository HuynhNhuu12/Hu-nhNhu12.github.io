<%-- 
    Document   : addUserAdmin
    Created on : Oct 31, 2022, 3:30:30 PM
    Author     : PC
--%>

<%-- 
    Document   : updatePass
    Created on : Sep 3, 2022, 6:46:29 AM
    Author     : dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 

<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
</c:if>

<c:url value="/addUserAdmin" var="action" />
<div class="row justify-content-center">
    <div class="col-lg-7">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4">Thêm User Admin</h3></div>
            <div class="card-body">
                <form:form method="post" action="${action}" modelAttribute="user">
                    
                    <div class="form-group">
                        <label for="username">Username</label>
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
                        
                    <div class="form-group">
                        <input type="submit" value="ĐĂNG KÝ" class="btn btn-danger"/>
                    </div>
                </form:form>
            </div>
            
        </div>
    </div>
</div>

