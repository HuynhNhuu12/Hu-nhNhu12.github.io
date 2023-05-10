 <%-- 
    Document   : details
    Created on : Sep 3, 2022, 11:54:48 PM
    Author     : HUYNH NHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
    <head>
        <title>${tour.name}</title>
    </head>
</html>
<br>
<br>
<h1 class="text-center text-danger">THÔNG TIN CHI TIẾT TOUR DU LỊCH</h1>
<br>

<!--<div class="container">
    <div id="vnt-main" class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
        <div id="vnt-slide-thumbnail" class="slick-init">
            <div class="item">
                <div class="img">
                    <img src="${tour.image}" alt="${tour.name}"/>
                </div>
            </div>
        </div>
        <div class="hidden-lg hidden-md" >
            <div class="boxPrice">
                <div class="price">
                    <div class="txt">
                        Giá từ: 
                    </div>
                    <div class="red" id="gia_mb">
${tour.priceAdult}
</div>
</div>
<div class="bot">
<div class="form-group">
<input type="text" name="dDate" id="dDate_mb" class="form-control bg-white dDate date-readonly dropdown-toggle" value="${tour.startDate}" readonly="" />
</div>
<div class="btn-booking dt">
<button type="button" class="btn-order-tour">Đặt tour</button>          
</div>
</div>
</div>
</div>

</div>
</div>-->






<div class="row">
    <div class="col-md-8">
        <img src="${tour.image}" alt="${tour.name}" class="img-fluid" />
    </div>
    <div class="col-md-4">
        <table class="table">
            <thead>
                <tr>
                    <th colspan="2">${tour.name}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="width: 100px">Mã Tour</td>
                    <td>${tour.id}</td>

                </tr>
                <tr>
                    <td>Thời gian: </td>
                    <td>${tour.description}</td>
                </tr>
                <tr>
                    <td>Khởi hành: </td>
                    <td>Dooley</td>
                </tr>
                <tr>
                    <td>Xuất phát: </td>
                    <td>Từ Hồ Chí Minh</td>
                </tr>

            </tbody>
        </table> 
        <div class="boxGia">
            <div class="price">
                <div class="text-gia">Giá Từ: </div>
                <div class="red">${tour.priceAdult}</div>
            </div>
            <div class="bot">
                <div class="form">
                    <input type="text" class="date" value="${tour.startDate}"/>
                </div>
                <sec:authorize access="isAuthenticated()">
                    <form:form method="post" action="/SaleWeb/bookTour" modelAttribute="booking">
                <div cla="btn-booking">
                    
                    <!--<input type="text" name="numAdult" path="num" >-->
                  
                    <input type="hidden" name="tourId" value="${tourId}">
                    <input type="hidden" name="userId" value="<sec:authentication property="principal.username"/>">
                    <button class="btn btn-primary" type="submit" href="<c:url value="/booking/id"/>"
                       
                            style="width: 100%" >ĐẶT TOUR </button>
                    
                </div>
                    </form:form>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <div class="text-center ">
                        <strong class="align-middle" >VUI LÒNG <a href="<c:url value="/login" />">ĐĂNG NHẬP</a> ĐỂ ĐẶT TOUR</strong>
                    </div>  
                </sec:authorize>
            </div>

        </div>



<!--        <h1>${tour.name}</h1>
<h3>${tour.priceAdult} VND</h3>    
<h3>${tour.description}</h3>-->
    </div>
</div>
<br>
<c:url value="/api/tours/${tour.id}/comments" var="endpoint"/>
<sec:authorize access="isAuthenticated()" >
    <div class="form-group">
        <textarea class="form-control" id="contentId" placeholder="Noi dung comment"></textarea>
    </div>
    <button class="btn btn-danger" onclick= "addComment('${endpoint}', ${tour.id})">BÌNH LUẬN</button>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <strong>VUI LÒNG <a href="<c:url value="/login" />">ĐĂNG NHẬP</a> ĐỂ BÌNH LUẬN</strong>
</sec:authorize>    

<ul id="comments" class="list-group"></ul>







<script src="<c:url value="/js/tour.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    <c:url value="/api/comments" var="url"/>

        window.onload = function () {
            loadComments('${endpoint}');
        }
</script>

<style>
    .img-fluid{
        width: 100%;
        height: 300px;
    }
    .table{
        height: 200px;
    }
    .table th {
        font-size: 25px;
    }
    .table tr {
        font-size: 17px;
    }
    .boxGia{
        background-color: #66CCFF;
        width: 300px;
        height: 100px;
    }
    .form{
        margin-bottom: -1px;

        border: 1px solid #fff;
    }

    .price{
        margin-left: 10px;
    }
    .text-gia{
        display:inline;
        font-size: 15px;
    }
    .red{
        display:inline;
        font-size: 20px;
        margin-left: 5px;

    }
    .btn-ord {
        width: 100%;
        height:33px;
        font-size: 19px;
    }
    .date {
        width: 100%;
        height:30px;
        font-size: 13px;
    }
    .btn btn-primary {
        font-size: 20px;
    }
</style>
