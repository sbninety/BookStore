
<%@page import="java.util.List"%>
<%@page import="Model.TheLoai"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Thể Loại</div>
        <ul class="list-group category_block">
            <%
                if(request.getAttribute("listTheLoai") != null){
                    List<TheLoai> theloai = (List<TheLoai>)request.getAttribute("listTheLoai");
                    if(theloai != null){
                        for(TheLoai tl:theloai){
            %>
                <li class="list-group-item text-white"><a href="TheLoai?MaTheLoai=<%=tl.getMaTheLoai()%>"><%=tl.getTenTheLoai()%></a></li>
            <%}}}%>
        </ul>
    </div>
</div>