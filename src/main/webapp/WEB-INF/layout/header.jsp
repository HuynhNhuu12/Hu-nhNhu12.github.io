<%-- 
    Document   : header
    Created on : Aug 19, 2022, 3:23:47 PM
    Author     : HUYNH NHU
--%>
<!DOCTYPE html>
<html>
    <%-- 
    Document   : header
    Created on : Aug 19, 2022, 3:23:47 PM
    Author     : HUYNH NHU
    --%>

    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>


<!--    <div class="menuNav hidden-sm hidden-xs">
        <ul>
            <li><a href="/he-thong-van-phong-du-lich"><span class="fa-sitemap">Hệ thống giao dịch</span></a></li>
            <li><a href="/dang-ky-van-phong-du-lich"><span style="padding-left:20px" class="fa-address-card-o"> Đăng ký đại lý</span></a></li>
            <li><a href="/gop-y"><span class="fa-file-text-o">Phiếu góp ý</span></a></li>
        </ul>
    </div>-->

    <nav class="navbar margin-0 navbar-expand-sm navbar-dark bg-dark"  style="margin-bottom: 2px">
        <div class="container-fluid" >
            <img class="img-icon" src="<c:url value="/resources/image/travel2.png"/>" alt="" width="50px" />
            <!--<a class="navbar-brand" href="javascript:void(0)">Travel</a>-->
            <img class="img-text" src="<c:url value="/resources/image/travel_text.png" />" alt="" />

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/" />"> Trang chủ</a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="#">Khách sạn</a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="#">Dịch vụ VISA</a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="#">Tin tức</a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="<c:url value="/introduce"/>">Giới thiệu</a>
                    </li>


                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/login" />"> Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/register" />"> Đăng kí</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/" />">
                                ${pageContext.session.getAttribute("currentUser").firstName}
                                ${pageContext.session.getAttribute("currentUser").lastName}
                                (<sec:authentication property="principal.username" />)
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link text-infor" href="<c:url value="/logout" />"> Đăng xuất</a>
                        </li>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="<c:url value="/admin/tours" />"> Quan ly tour du lich</a>
                        </li>
                    </sec:authorize>

                    <%--<c:forEach items="${categories}" var ="c">
                        <li class="nav-item">
                            <a class="nav-link" href="#">${c}</a>
                        </li>
                    </c:forEach>--%>

                </ul>
            </div>
        </div>
    </nav>
    <header class="container-fluid" id="home">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="padding: 10px 10px;">

                 <!--Indicators--> 
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1" ></li>
            <li data-target="#myCarousel" data-slide-to="2" ></li>
        </ol>

                 <!--The slideshow--> 
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="<c:url value="/resources/image/Nha Trang.jpg"/>" alt="" >
                <div class="carousel-caption">
                    <h3>TRAVEL</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="item">
                <img src="<c:url value="/resources/image/PhuYen.jpg"/>" alt="" >
                <div class="carousel-caption">
                    <h3>TRAVEL</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="item">
                <img src="<c:url value="/resources/image/phu quoc.jpg"/>" alt="">
                <div class="carousel-caption">
                    <h3>TRAVEL</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
        </div>

                 <!--Left and right controls--> 
        <a class="left carousel-control" href="#myCarousel" data-slide="prev" role="button">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next"role="button">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        </a>
        <span class="sr-only">Next</span>
    </div>
    </header>

    <c:url value="/" var="action" />
    <form action="${action}" class="d-flex">
        <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tour cần tìm...">
        <button type=" submit" class="btn btn-primary" type="button">Tim</button>
    </form>

</html>
<style type="text/css">
    /*css navbar*/
    .navbar{
        margin-bottom: 5px;
        background-color: lightskyblue !important;
    }
    .navbar-brand {
        font-size: 20px;
        margin-left: 20px;
    }
    .img-icon{
        width: 80px;
        height: 60px;
    }

    .img-text{
        width: 117px;
    }
    .nav-item{
        margin-right: 20px;
    }
    .me-auto{
        margin-left: 122px;
        font-size: 20px;
    }
    .me-auto a:hover {
        color: red;
    }

    .nav-link{
        color: black !important;
    }
    .navbar-brand{
        color: black !important;
    }

    
    /*carousel*/
    .d-flex {
        padding-top: 10px;
        width: 50%;
        height: 50px;
        margin: auto;
    }   
    .form-control {
        height: 50px;
    }
    .btn-primary{
        height: 50px;
    }

    #myCarousel {
        width: 100%;
        height: 500px;
        margin: 0 auto;
        padding: 0 !important;
    }
    .carousel-inner img {
        width: 100%;   /* Set width to 100% */
        margin: 0 auto;
        height: 500px !important ;
    }

    .carousel-caption h3 {
        color: #D3D3D3 !important;
    }
    
    #home {
        padding-right: 0px !important;
        padding-left: 0px !important;
    }
</style>  