
<%@page import="Model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="Model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="/BookStore">BookStore</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <%
                    Account acc = (Account)session.getAttribute("acc");
                    if(acc != null){
                %>
                <%
                    if(acc.getKhachHang() == 1){
                %>
                    <li class="nav-item">
                        <a class="nav-link" href="Order">QL Đơn Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Logout">Logout</a>
                    </li> 
                <%
                    }
                %>
                <%
                    if(acc.getNhanVien() == 1){
                %>
                    <li class="nav-item">
                        <a class="nav-link" href="EOrder">QL Đơn Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ManagerBook">QL Sách</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Logout">Logout</a>
                    </li> 
                <%
                    }
                %>
                <%
                    }
                %>
                <%
                    if(acc == null){
                %>
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                <%
                    }
                %>
            </ul>

            <form action="Search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="Cart">
                    <%
                        List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
                        int size = 0;
                        if(listCart != null){
                            size = listCart.size();
                        }
                    %>
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light"><%=size%></span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Siêu thị sách chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các cuốn sách sách nhập từ Trung Quốc</p>
    </div>
</section>
<!--end of menu-->
