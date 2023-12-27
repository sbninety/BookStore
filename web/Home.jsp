<%@page import="java.util.List"%>
<%@page import="Model.Sach"%>
<%@page import="Model.Sach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                    <%
                        if(request.getAttribute("listSach")!=null){
                            List<Sach> sach = (List<Sach>)request.getAttribute("listSach");
                            if(sach!=null){
                    %>
                    <div class="col-sm-9">
                        <div id="content" class="row">
                            <%
                                for(Sach s:sach){
                            %>
                                <div class="product col-12 col-md-6 col-lg-4" style="margin-bottom: 20px">
                                    <div class="card">
                                        <img class="card-img-top" src="<%=s.getHinhAnh()%>" alt="Card image cap" style="height: 350px">
                                        <div class="card-body">
                                            <h4 class="card-title show_txt"><a href="Details?id=<%=s.getMaSach()%>" title="<%=s.getTenSach()%>"><%=s.getTenSach()%></a></h4>
                                            <p class="card-text show_txt"><%=s.getTacGia()%></p>
                                            <div class="row">
                                                <div class="col">
                                                    <p class="btn btn-danger btn-block"><%=s.getGiaBan()%> VND</p>
                                                </div>
                                                <div class="col">
                                                    <a href="Cart?action=Add&id=<%=s.getMaSach()%>" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            <%}}}%>
                        </div>
                    </div>

                </div>
            </div>

        <jsp:include page="Footer.jsp"></jsp:include>
    </body>
</html>

