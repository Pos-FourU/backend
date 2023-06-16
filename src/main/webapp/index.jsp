<%@ page language="java" contentType="text/html; ccharset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header_footer.jsp" %>
<head>
    <title>메인 페이지</title>
</head>

<body>
    <jsp:include page="WEB-INF/Views/Header.jsp"/>
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

    <a href="/api/v1/cafe/map"> ToMap </a><br/>


</body>