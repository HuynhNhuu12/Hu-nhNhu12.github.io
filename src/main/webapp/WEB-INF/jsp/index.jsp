<%-- 
    Document   : index
    Created on : Jul 24, 2022, 11:42:28 PM
    Author     : HUYNH NHU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${tours.size() == 0}">
    <p>
        <strong>Khong co san pham nao!!!</strong>
    </p>
</c:if> 
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(tourCounter/8)}" var="i">
        <c:url value="/" var="c">
            <c:param value="${i}" name="page" />
        </c:url> 
         <li class="page-item"><a class="page-link" href="${c}">${i}</a></li>
    </c:forEach>

</ul>

<div class="row">
    <c:forEach items="${tours}" var="t">
        <div class="col-md-3 col-xs-12">
            <div class="card" style="width:250px" style="padding: 5px">
                <img src="${t.image}" class="card-img-top" class="img-fluid" alt="Card image" style="width: 250px"/></td>

                <!--<img class="card-img-top" class="img-fluid" src="https://res.cloudinary.com/huynhnhu/image/upload/v1660650494/phu_quoc_qeym3v.jpg" alt="Card image">-->
                <div class="card-body">
                    <h4 class="card-title">${t.name}</h4>
                    <!--                    <p class="card-text">
                    <fmt:formatNumber value="${t.priceAdult}" maxFractionDigits="3" type = "number" /> VND
                </p>-->
                    <a href="<c:url value="/tours/${t.id}" />" class="btn btn-primary">Xem chi tiết</a>

                </div>
            </div>
        </div>
    </c:forEach>
</div>
<style>
    .btn-primary {
        height: 38px;
    }
    .btn  {
        font-size: 16px;
    }
</style>


