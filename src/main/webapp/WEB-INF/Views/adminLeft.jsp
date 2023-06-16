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
<script>
    function menuClick(s){
        location.href=s;
    }
</script>
<button onclick="menuClick('manageRental')">대여 관리</button><br/>
<button onclick="menuClick('manageItem')">물품 관리</button><br/>
<button onclick="menuClick('manageMember')">유저 관리</button><br/>
<button onclick="menuClick('manageAdmin')">관리자 관리</button><br/>
</body>
</html>
