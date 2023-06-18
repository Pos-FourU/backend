<%@ page import="Pack01.domain.item.entity.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="Pack01.domain.item.dto.ItemFindAllRespDto" %><%--
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
<%--TODO jwt 적용해서 OO님 환영합니다 --%>
    <jsp:include page="adminHeader_middle.jsp"></jsp:include>
</div>
<div id="contents">
    <%
        List<ItemFindAllRespDto> items = (List<ItemFindAllRespDto>)request.getAttribute("items");
    %>
    <table>
        <thead>
            <tr>
                <th>물품 ID</th>
                <th>물품 상태</th>
                <th>카테고리</th>
                <th>물품 상태 변경</th>
                <th>물품 삭제</th>
            </tr>
        </thead>
        <tbody>
            <%
                for(ItemFindAllRespDto i : items) {
                    out.println("<tr>");
                    out.println("<td>"+i.getItem_id()+"</td>");
                    out.println("<td>"+i.getItem_status().toString()+"</td>");
                    out.println("<td>"+i.getCategory().toString()+"</td>");
                    out.println("<td>");
                    out.println("<form method=\"post\" action=\"manageItem\">");
                    out.println("<select name=\"item_status\">");
                    out.println("<option value=\"VALID\" selected>VALID</option>");
                    out.println("<option value=\"INVALID\">INVALID</option>");
                    out.println("<option value=\"DAMAGED\">DAMAGED</option>");
                    out.println("</select>");
                    out.println("<input type=\"submit\" value=\"적용\">");
                    out.println("</form>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<button onclick=\"deleteItem()\">삭제</button>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            %>
        </tbody>
    </table>
    <button onclick="addItem()">물품 추가</button>
</div>
<div id="footer">
    <jsp:include page="adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
