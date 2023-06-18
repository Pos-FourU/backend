
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp" %>

<html>
<head>
    <title>로그인</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        div {
            margin-bottom: 10px;
        }

        label {
            display: inline-block;
            width: 80px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            padding: 5px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            display: block;
            margin: 0 auto;
            padding: 10px 20px;
            background-color: #3CB371;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2E8B57;
        }
    </style>
</head>
<%--TODO 특정 IP만 접속 가능하게?--%>
<body>

<h1>로그인</h1>
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
<form action="/api/v1/member" method="get">
    <input name="submit" type="submit" value="회원가입"/>
</form>

<div id="footer">
    <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>
</body>
</html>