<%@ page import="Pack01.domain.rental.dto.RentalFindAllRespDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/15
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #header{
        width:100%;
        height:10%;
        background-color: aqua;
    }
    body{
        display:flex;
        flex-direction: column;
    }
    #contents{
        width:100%;
        height:80%;
        display:flex;
    }
    #left{
        width:10%;
    }
    #footer{
        width:100%;
        height:10%;
        background-color: aqua;
    }
</style>
<body>
<div id="header">
    <jsp:include page="adminHeader.jsp"></jsp:include>
</div>
<div id="contents">
    <div id="left">
        <jsp:include page="adminLeft.jsp"></jsp:include>
    </div>
    <%
        List<RentalFindAllRespDto> rentals = (List<RentalFindAllRespDto>)request.getAttribute("rentals");
    %>
    <table>
        <thead>
        <tr>
            <th>대여 ID</th>
            <th>대여 회원 ID</th>
            <th>대여 물품 ID</th>
            <th>대여 시간</th>
            <th>반납 시간</th>
        </tr>
        </thead>
        <tbody>
        <tr><%
            for(RentalFindAllRespDto i : rentals) {
                out.println("<td>"+i.getRental_id()+"</td>");
                out.println("<td>"+i.getMember_id()+"</td>");
                out.println("<td>"+i.getItem_id()+"</td>");
                out.println("<td>"+i.getRental_time()+"</td>");
                out.println("<td>"+i.getReturn_time()+"</td>");
            }
        %>
        </tr>
        </tbody>
    </table>
    <button onclick="">대여</button>
    <button onclick="">반납</button>
    <button onclick="">훼손/분실</button>
</div>
<div id="footer">
    <jsp:include page="adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
