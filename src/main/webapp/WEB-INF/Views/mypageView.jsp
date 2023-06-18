<%@ page import="Pack01.domain.member.entity.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="Pack01.domain.member.dto.MemberFindAllRespDto" %><%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-17
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/nav_bar.jsp" %>
    <title> 마이페이지 </title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        .container {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .info {
            margin-bottom: 20px;
        }

        .info label {
            font-weight: bold;
        }

        .info span {
            margin-left: 10px;
        }

    </style>
</head>
<body>
<h1> 마이페이지 </h1>
<%  Integer countThismonth = (Integer) request.getAttribute("countThismonth");

    MemberFindAllRespDto members = (MemberFindAllRespDto) request.getAttribute("members");
%>

<%--    Member members = (Member) request.getAttribute("members");--%>


<%--    이메일 : <%= members.getMember_email()%> <br/>--%>
    이름 : <%= members.getMember_name()%> <br/>

<%--    전화번호 : <%= members.getMember_phone()%> <br/>--%>
<%--    <a href="memberUpdate"> 수정하기 </a> <br/>--%>

<div class="info">
    이번달 총 대여 횟수는 <%= countThismonth %> 번입니다.
</div>
<div class="info">
    환경 보호에 동참해주셔서 감사합니다.
</div>

</body>
</html>
