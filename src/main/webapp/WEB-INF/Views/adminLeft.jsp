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
    <title>Title</title>
</head>
<body>
<%
    Jwt jwt = new Jwt();
    Claims claims = jwt.getJwtContents(session.getAttribute("token").toString());
    MemberRole role = MemberRole.valueOf(claims.get("role").toString());

    if(role==MemberRole.MANAGER){
        out.println("<button onclick=\"menuClick('manageRental')\">대여 관리</button><br/>");
        out.println("<button onclick=\"menuClick('manageItem')\">물품 관리</button><br/>");
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
