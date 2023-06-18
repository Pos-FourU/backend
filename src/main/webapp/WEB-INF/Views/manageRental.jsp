<%@ page import="Pack01.domain.rental.dto.RentalFindAllRespDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
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
</style>
<body>
<div id="header">
    <jsp:include page="/adminHeader_middle.jsp"></jsp:include>
</div>
<div id="contents">
    <%
        List<RentalFindAllRespDto> rentals = (List<RentalFindAllRespDto>) request.getAttribute("rentals");
    %>
    <table>
        <thead>
        <tr>
            <th>대여 ID</th>
            <th>대여 회원 ID</th>
            <th>대여 물품 ID</th>
            <th>대여 날짜</th>
            <th>대여 기간</th>
            <th>반납 날짜</th>
            <th>반납</th>
        </tr>
        </thead>
        <tbody>
        <%
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (RentalFindAllRespDto i : rentals) {
                out.println("<tr>");
                out.println("<td>" + i.getRental_id() + "</td>");
                out.println("<td>" + i.getMember_id() + "</td>");
                out.println("<td>" + i.getItem_id() + "</td>");
                out.println("<td>" + formatter.format(i.getRental_time()) + "</td>");
                out.println("<td>" + formatter.format(i.getRental_days()) + "</td>");
                if (i.getReturn_time() == null) {
                    out.println("<td></td>");
                    out.println("<td>");
                    out.println("<button onclick=\"\">반납</button>");
                    out.println("</td>");
                }
                else {
                    out.println("<td>" + formatter.format(i.getReturn_time()) + "</td>");
                    out.println("<td>");
                    out.println("<button onclick=\"\" disabled>반납</button>");
                    out.println("</td>");
                }
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
</div>

<div id="footer">
    <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
