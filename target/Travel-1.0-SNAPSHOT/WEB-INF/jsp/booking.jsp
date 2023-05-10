<%-- 
    Document   : booking
    Created on : Oct 17, 2022, 8:07:55 PM
    Author     : HUYNH NHU
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">THÔNG TIN CHI TIẾT ĐẶT TOUR</h1>

<div class="container">
    <div class="row" style="margin-top: 3rem">
        <div class="col-md-5">
            <img class="card-img-left" src="${tour.image}" alt="Card image cap">


        </div>
        <div class="col-md-7">
            <div class="card" >
                <div class="card-header">
                    ${tour.name}
                </div>
                <div class="card-body">
                    <div class="row ">
                        <div class="col-md-4 font-weight-light">Mã tour</div>
                        <div class="col-md-8">${tour.id}</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Thời gian</div>
                        <div class="col-md-8">${tour.description}</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Giá</div>
                        <div class="col-md-8"><fmt:formatNumber value="${tour.priceAdult}" maxFractionDigits="3" type = "number" /> VND</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Ngày khởi hành</div>
                        <div class="col-md-8"><fmt:formatDate type = "date" pattern="dd-MM-yyyy" dateStyle = "short" timeStyle = "short" value = "${startDate}" /></div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Nơi khởi hành</div>
                        <div class="col-md-8">Hồ Chí Minh</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Số chỗ còn nhận</div>
                        <div class="col-md-8">${tour.limit}</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card border-danger mb-3" style="margin-top: 1rem">
            <div class="card-body text-danger">
                <p class="card-text">Các khoản phí phát sinh (nếu có) như: phụ thu dành cho khách nước ngoài, việt kiều; phụ thu phòng đơn; phụ thu chênh lệch giá tour… Nhân viên Du Lịch Travel sẽ gọi điện thoại tư vấn cho quý khách ngay sau khi có phiếu xác nhận booking. (Trong giờ hành chính)
                    <br>Trường hợp quý khách không đồng ý các khoản phát sinh, phiếu xác nhận đặt phòng của quý khách sẽ không có hiệu lực.</p>
            </div>
        </div>

        <div class="col-12">
            <hr>
            <h3 class="text-center text-uppercase">BẢNG GIÁ TOUR CHI TIẾT</h3>
            <table class="table table-bordered table-dark">
                <thead>
                    <tr>
                        <th scope="col">Loại giá\Độ tuổi</th>
                        <th scope="col">Người lớn</th>
                        <th scope="col">Trẻ nhỏ</th>
                        <th scope="col">Sơ sinh</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">Giá</th>
                        <th scope="row"><fmt:formatNumber value="${tour.priceAdult}" maxFractionDigits="3" type = "number" /> VND</th>
                        <th scope="row"><fmt:formatNumber value="${tour.priceChild}" maxFractionDigits="3" type = "number" /> VND</th>
                        <th scope="row"><fmt:formatNumber value="${tour.priceInfant}" maxFractionDigits="3" type = "number" /> VND</th>

                    </tr>
                </tbody>
            </table>
        </div>

        <div class="col-12">
            <br>
            <h3 class="text-center text-uppercase">THÔNG TIN LIÊN HỆ</h3>
            
                <div class="row mb-3">
                    <form:form method="post" action="${action}" modelAttribute="booking" >
                    <div class="col-md-4">
                        <div class="form-floating mb-3 mb-md-0">
                            <label for="inputName">Họ và tên</label>
                            <input class="form-control" id="inputName" type="text"
                                        placeholder="Nguyễn Văn A...." path="customerName" required="required"/>
                        </div>
                    </div>
                   
                    <div class="col-md-4">
                        <div class="form-floating mb-3">
                            <label for="phone">Số điện thoại</label>
                            <input class="form-control" id="phone" type="text"
                                        placeholder="Nhập số điện thoại..." path="customerPhone" required="required"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-floating mb-3">
                            <label for="address">Địa chỉ</label>
                            <input class="form-control" id="address" type="text"
                                        placeholder="Nhập địa chỉ..."/>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-floating mb-3">
                            <label for="note">Ghi chú</label>
                            <input class="form-control" id="note" type="text"
                                        placeholder="Nhập ghi chú..." />
                        </div>
                    </div>

                   
                    
                    <hr>

                    <p class="col-12">Tổng giá trị:</p>

                    <h3 class="col-12 text-center text-uppercase" style="margin-bottom: 1rem">Phương thức thanh toán</h3>

                    <%--                    Check way to abate--%>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="abateType" id="radioDefault"
                               value="radioDefault" checked>
                        <label class="form-check-label" for="radioDefault">
                            Thanh toán tại quầy TravelMore
                        </label>
                    </div>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="abateType" id="radioMomo"
                               value="radioMomo">
                        <label class="form-check-label" for="radioMomo">
                            Thanh toán qua ví Momo
                        </label>
                    </div>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="abateType" id="radioBanking"
                               value="radioBaking">
                        <label class="form-check-label" for="radioBanking">
                            Thanh toán chuyển khoản qua ngân hàng
                        </label>
                    </div>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="abateType" id="radioVnpay"
                               value="radioVnpay">
                        <label class="form-check-label" for="radioVnpay">
                            Thanh toán qua VNPAY
                        </label>
                    </div>
                    <div class="col-12 ">
                        <div class="form-group" >
                            <input class="btn btn-primary btn-block text-uppercase "
                                   type="submit" value="hoàn thành"
                                   style="max-width: 10rem; margin: auto; margin-top: 2rem">
                        </div>
                    </div>
                    </form:form>
                </div>
        </div>
    </div>
</div>