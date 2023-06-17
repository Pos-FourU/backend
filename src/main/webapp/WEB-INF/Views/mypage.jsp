<%@ page import="Pack01.domain.member.entity.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-17
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 마이페이지 </title>
</head>
<body>

<%
    List<Member> members = (List<Member>) session.getAttribute("members");
    Member member = members.get(0);
    <%= member.getMember_email()%>
    <%= member.getMember_name()%>
    <%= member.getMember_phone()%>
    <%= member.getMember_role()%>
    <%= member.getMember_status()%>

%>
</body>
</html>
