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
<%--TODO jwt 적용해서 OO님 환영합니다--%>
    <jsp:include page="adminHeader.jsp"></jsp:include>
</div>
<div id="contents">
    <div id="left">
        <jsp:include page="adminLeft.jsp"></jsp:include>
    </div>
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
            <tr><%
                for(ItemFindAllRespDto i : items) {
                    out.println("<td>"+i.getItem_id()+"</td>");
                    out.println("<td>"+i.getItem_status()+"</td>");
                    out.println("<td>"+i.getCategory()+"</td>");
                }
            %>
                <td>
                <form method="post" action="manageItem">
                    <select name="item_status">
                        <option value="VALID" selected>VALID</option>
                        <option value="INVALID">INVALID</option>
                        <option value="DAMAGED">DAMAGED</option>
                    </select>
                    <input type="submit" value="적용">
                </form>
                </td>
                <td>
                    <button onclick="deleteItem()">삭제</button>
                </td>
            </tr>
        </tbody>
    </table>
    <button onclick="addItem()">물품 추가</button>
</div>
<div id="footer">
    <jsp:include page="adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
