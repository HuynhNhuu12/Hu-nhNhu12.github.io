<%-- 
    Document   : newjsp
    Created on : Sep 18, 2022, 7:17:01 PM
    Author     : HUYNH NHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="padding: 10px 10px;">

        <!--         Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1" ></li>
            <li data-target="#myCarousel" data-slide-to="2" ></li>
        </ol>

        <!--         The slideshow -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="<c:url value="/resources/image/Nha Trang.jpg"/>" alt="" >
                <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="item">
                <img src="<c:url value="/resources/image/lao cai.jpg"/>" alt="" >
                <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="item">
                <img src="<c:url value="/resources/image/phu quoc.jpg"/>" alt="">
                <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
        </div>

        <!--         Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev" role="button">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next"role="button">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        </a>
        <span class="sr-only">Next</span>
    </div>
    <!--</header>-->

    <c:url value="/" var="action" />
    <form action="${action}" class="d-flex">
        <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tour cần tìm...">
        <button type=" submit" class="btn btn-primary" type="button">Tim</button>
    </form>
       
</html>

<style type="text/css">
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
        color: #fff !important;
    }
</style>
