<%-- 
    Document   : CheckOut
    Created on : Apr 18, 2023, 2:41:58 PM
    Author     : vannh
--%>

<%@page import="Model.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>BookStore</title>
    <!-- Required meta tags always come first -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="generator" content="Checkout - One Step Checkout , Responsive Bootstrap 4 template , bootstrap 4 starter template, bootstrap4 template, checkout template">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" lang="en" content="Checkout Bootstrap 4 pricing template , Responsive and Modern HTML5 Template made from bootstrap 4.">
    <meta name="keywords" lang="en" content="pricing template, bootstrap 4 template,bootstrap 4 checkout template, responsive bootstrap 4 template, bootstrap 4, bootstraping, bootstrap4, oribitthemes">
    <meta name="robots" content="index, follow">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
    <meta name="description" content="">
    <!--Font Awesome-->
    <link rel="stylesheet" href="dist/font-awesome/css/font-awesome.min.css" />
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/main.min.css">
</head>

<body>
    <jsp:include page="Menu.jsp"></jsp:include>
    <main id="main" role="main">
        <section id="checkout-container">
            <div class="container">
                <div class="row py-5">
                    <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted">Your cart</span>
                            <span class="badge badge-secondary badge-pill"></span>
                        </h4>
                        <ul class="list-group mb-3">
                            <%
                                List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
                                                if(listCart != null){
                                                    for(Cart c:listCart){
                                            %>
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h6 class="my-0"><%=c.getSach().getTenSach()%></h6>
                                    <small class="text-muted">Số lượng: <%=c.getSoLuong()%></small>
                                </div>
                                <span class="text-muted"><%=c.getSach().getGiaBan() * c.getSoLuong()%></span>
                            </li>
                            
                            
                            <%}}%>
                            
                            <%
                            double sum = 0;
                            for(Cart c:listCart){
                                sum = sum + c.getSach().getGiaBan() * c.getSoLuong();
                            }
                            %>    
                            <li class="list-group-item d-flex justify-content-between">
                                <span>Tong tien(VND)</span>
                                <strong><%=sum+10000%> VND</strong>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-8 order-md-1">
                        <h4 class="mb-3">Nhập thông tin cá nhân</h4>
                        <form class="needs-validation" action="CheckOutServlet" method="post" novalidate>
                            <input type="hidden" name="TongTien" value="<%=sum+10000%>" >
                            <div class="row">
                                <div class="col-md-6">
                                    <label for="firstName">Tên người nhận</label>
                                    <input type="text" name="name" class="form-control" id="firstName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Valid name is required.
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                            <div class="col-md-6">
                                <label for="address">Địa chỉ</label>
                                <input type="text" name="address" class="form-control" id="address" placeholder="" required>
                                <div class="invalid-feedback">
                                    Please enter your shipping address.
                                </div>
                            </div>
                            </div>
                            <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="username">Số điện thoại</label>
                                    <input type="text" name="phone" class="form-control" id="phone" placeholder="" required>
                                    <div class="invalid-feedback" style="width: 100%;">
                                        Please enter your phone number.
                                    </div>
                            </div>
                            </div>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
                        </form>
                    </div>
                </div>
            </div>
            <a href="#" class="btn btn-primary scrollUp">
                <i class="fa fa-arrow-circle-o-up"></i>
            </a>
        </section>
    </main>
    <!-- Footer -->
    <jsp:include page="Footer.jsp"></jsp:include>

</body>

</html>
