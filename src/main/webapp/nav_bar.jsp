<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-17
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
</head>
<style>

  /* 네비게이션 바 스타일 */
  .navbar {
    background-color: #FEE9E1;
    position: relative;
    padding: 10px;
  }

  .navbar ul {
    list-style-type: none;
    text-align: center;
    margin: 0;
    padding: 0;
  }

  .navbar li {
    display: inline-block;
    margin-right: 10px;
  }

  .navbar li a {
    text-decoration: none;
    text-align: center;
    color: #333;
    padding: 5px 10px;
  }

  .navbar .logout {
    position: absolute;
    top: 5px;
    right: 10px;
    font-size: 12px;
  }
</style>
<body>

<div class="navbar">
  <ul>
    <li><a href="/">메인</a></li>
    <li><a href="/api/v1/cafe/map">예약하기</a></li>
    <li><a href="/api/v1/member/mypage">마이페이지</a></li>
  </ul>
  <a href="/logout" class="logout">로그아웃</a>
</div>


</body>
</html>
