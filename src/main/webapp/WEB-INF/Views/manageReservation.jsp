<%@ page import="Pack01.domain.reservation.dto.ReservationFindRespDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/18
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        List<ReservationFindRespDto> reservations = (List<ReservationFindRespDto>) request.getAttribute("reservations");
    %>
    <table>
        <thead>
        <tr>
            <th>예약 ID</th>
            <th>예약 회원 ID</th>
            <th>예약 날짜</th>
        </tr>
        </thead>
        <tbody>
        <%
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (ReservationFindRespDto i : reservations) {
                out.println("<tr>");
                out.println("<td>" + i.getReservation_id() + "</td>");
                out.println("<td>" + i.getMember_id() + "</td>");
                out.println("<td>" + formatter.format(i.getReservation_time()) + "</td>");
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
