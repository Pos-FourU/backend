<%@ page import="Pack01.domain.member.entity.MemberRole" %>
<%@ page import="Pack01.global.jwt.Jwt" %>
<%@ page import="io.jsonwebtoken.Claims" %>
<%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/15
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }

        button {
            display: block;
            margin-bottom: 10px;
            padding: 10px 20px;
            background-color: #3CB371;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #2E8B57;
        }
    </style>
</head>
<body>
<%
    Jwt jwt = new Jwt();
    Claims claims = jwt.getJwtContents(session.getAttribute("token").toString());
    MemberRole role = MemberRole.valueOf(claims.get("role").toString());

    if(role==MemberRole.MANAGER){
        out.println("<button onclick=\"menuClick('manageRental')\">대여 관리</button><br/>");
        out.println("<button onclick=\"menuClick('manageItem')\">물품 관리</button><br/>");
        out.println("<button onclick=\"menuClick('manageReservation')\">예약 관리</button><br/>");
    }
    else if(role==MemberRole.ADMIN){
        out.println("<button onclick=\"menuClick('manageMember')\">유저 관리</button><br/>");
        out.println("<button onclick=\"menuClick('manageManager')\">관리자 관리</button><br/>");
    }
    else{
        throw new RuntimeException();
    }
%>
<script>
    function menuClick(s){
        location.href=s;
    }
</script>

</body>
</html>
