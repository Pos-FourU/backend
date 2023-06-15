<%@ page language="java" contentType="text/html; ccharset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <title>메인 페이지</title>
</head>

<body>
    <%=new Date()%>
    <h2>Hello World</h2>
    <a href="t1">링크1</a><br/>
    <a href="t2">링크2</a><br/>
    <a href="t3?name=apple">링크3</a><br/>
    <a href="t4?name=apple&age=30">링크4</a><br/>
    <a href="t5?name=apple&age=40">링크5</a><br/>
    <a href="t6">링크6</a><br/>
    <a href="t7?name=apple?age=60">링크7</a><br/>
    <a href="t8">링크8</a><br/>
    <a href="t9?select=true">링크9(true)</a><br/>
    <a href="t9?select=false">링크9(false)</a><br/>
    <a href="t10">링크10</a><br/>

<form method="post" action="t11">
    <input type="text" name="id" value="tiger"><br/>
    <input type="number" name="pw" value=23><br/>
    <input type="submit" value="전송"><br/>
</form>
    <a href="t12">링크12</a><br/>
    <a href="t13">링크13</a><br/>
    <a href="register/t14">링크14</a><br/>

    <FORM METHOD=POST action="t16">
        <INPUT TYPE="text" NAME="item[0]" VALUE="소나무"><br />
        <INPUT TYPE="text" NAME="item[1]" VALUE="중나무"><br />
        <INPUT TYPE="text" NAME="item[2]" VALUE="대나무"><br />
        <INPUT TYPE="submit" VALUE="전송">
    </FORM>
</body>