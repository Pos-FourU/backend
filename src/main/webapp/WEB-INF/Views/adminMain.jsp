<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Admin</h1>
<div id="left">
    <button onclick="menuClick('manageRental')">대여 관리</button><br/>
    <button onclick="menuClick('manageItem')">물품 관리</button><br/>
    <button onclick="menuClick('registerAdmin')">관리자 등록</button><br/>
</div>
<div id="contentView">
    <div id="manageRental" style="display:block;">
        <jsp:include page="manageRental.jsp"/>
    </div>
    <div id="manageItem" style="display:none;">
        <jsp:include page="manageItem.jsp"/>
    </div>
    <div id="registerAdmin" style="display:none;">
        <jsp:include page="registerAdmin.jsp"/>
    </div>
</div>
<script>
    let currentMenu="manageRental";
    function menuClick(s){
        document.getElementById(currentMenu).style.display="none";
        currentMenu=s;
        document.getElementById(s).style.display="block";
    }
</script>
</body>
</html>
