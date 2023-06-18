<%@ page import="Pack01.domain.member.entity.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="Pack01.domain.member.dto.MemberFindAllRespDto" %><%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-17
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            text-align: center;
            margin-bottom: 20px;
        }

        .info label {
            font-weight: bold;
        }

        .info span {
            margin-left: 10px;
        }
        .info a {
            float: right;
        }
    </style>
</head>
<body>
<h1> 마이페이지 </h1>
<%
    Integer countThismonth = (Integer) request.getAttribute("countThismonth");
    Member members = (Member) request.getAttribute("member");
%>
<div class="info">
    <%= members.getMember_name() %>님의 정보 입니다.
</div>
<div class="info">
<a href="/api/v1/member/mypage/toupdate" > 회원정보 수정 </a>

<%--    <%= members.getMember_name()%> 님 의 이용 내역--%>
    이번달 총 대여 횟수는 <%= countThismonth %> 번입니다.
</div>

<div class="info">
    <img src="https://thumb.mt.co.kr/06/2015/02/2015020211298527688_1.jpg/dims/optimize/"><br/>
    환경 보호에 동참해주셔서 감사합니다.
</div>

<div id="footer">
    <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>

</body>
</html>
