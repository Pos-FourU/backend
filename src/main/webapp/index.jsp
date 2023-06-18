
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp" %>
<%@ include file="nav_bar.jsp" %>

<html>
<head>
    <title>로그인</title>
    <meta charset="UTF-8">
</head>
<%--TODO 특정 IP만 접속 가능하게?--%>
<body>

<h1>AdminPage</h1>
<form action="api/v1/member/login" method="post">
    <div>
        <label>ID</label>
        <input name="id" type="text"/>
    </div>
    <div>
        <label>PW</label>
        <input name="pw" type="password"/>
    </div>
    <input name="submit" type="submit" value="로그인"/>
</form>
</body>
</html>