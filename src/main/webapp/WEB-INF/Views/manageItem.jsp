<%@ page import="Pack01.domain.item.entity.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="Pack01.domain.item.dto.ItemFindAllRespDto" %>
<%@ page import="Pack01.global.jwt.Jwt" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #header{
            width:100%;
            height:10%;
            background-color:#90EE90;
        }

        body {
            display: flex;
            flex-direction: column;
        }

        #contents {
            width: 100%;
            height: 80%;
            display: flex;
        }

        #left {
            width: 10%;
        }
        #footer{
            width:100%;
            height:10%;
            background-color:#90EE90;

        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: center;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        button {
            margin-top: 10px;
        }

        #contents{
            display: flex;
            flex-direction: column;
        }
    </style>
</head>
<body>
<div id="header">
    <%--TODO jwt 적용해서 OO님 환영합니다 --%>
    <jsp:include page="/adminHeader_middle.jsp"></jsp:include>
</div>
<div id="contents">
    <div>
    <%
        Jwt jwt = new Jwt();
        String member_id = jwt.getJwtContents(session.getAttribute("token").toString()).get("id").toString();
        List<ItemFindAllRespDto> items = (List<ItemFindAllRespDto>) request.getAttribute("items");
    %>
    <table>
        <thead>
        <tr>
            <th>물품 ID</th>
            <th>상태</th>
            <th>카테고리</th>
            <th>대여자 email</th>
            <th>대여 기간</th>
            <th>대여</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (ItemFindAllRespDto i : items) {
                out.println("<tr>");
                out.println("<td>" + i.getItem_id() + "</td>");
                out.println("<td>" + i.getItem_status().toString() + "</td>");
                out.println("<td>" + i.getCategory().toString() + "</td>");

                out.println("</td>");
                out.println("<td>");
                out.println("<form name=\"insertRentalInfo\" method=\"post\" action=\"insertRentalInfo\">");
                out.println("<td>");
                if (i.getItem_status().toString() != "VALID") {
                    out.println("<input type=\"text\" name=\"member_email\" disabled/>");
                } else {
                    out.println("<input type=\"text\" name=\"member_email\"/>");
                }
                out.println("</td>");
                out.println("<td>");
                if (i.getItem_status().toString() != "VALID") {
                    out.println("<input type=\"number\" min=\"1\" max=\"7\" name=\"rental_days\" disabled/>");
                } else {
                    out.println("<input type=\"number\" min=\"1\" max=\"7\" name=\"rental_days\"/>");
                }
                out.println("<input type=\"text\" value=\"" + i.getItem_id() + "\" name=\"item_id\" style=\"display:none;\">");
                out.println("<input type=\"text\" value=\"" + member_id + "\" name=\"cafe_manager_id\" style=\"display:none;\">");
                out.println("<input type=\"text\" value=\"" + LocalDate.now() + "\" name=\"rental_time\" style=\"display:none;\">");
                if (i.getItem_status().toString() != "VALID") {
                    out.println("<input type=\"submit\" disabled/>");
                } else {
                    out.println("<input type=\"submit\"/>");
                }
                out.println("</form>");
                out.println("</td>");
                if (i.getItem_status().toString() != "VALID") {
                    out.println("<td>");
                    out.println("<button disabled>삭제</button>");
                    out.println("</td>");
                } else {
                    out.println("<td>");
                    out.println("<button onclick=\"deleteItem()\">삭제</button>");
                    out.println("</td>");
                }

                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
    </div>
    <div>
    <a href="/api/v1/item">물품 추가</a>
    </div>
</div>
<div id="footer">
    <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
