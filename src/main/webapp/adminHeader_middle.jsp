<%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/15
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        /* 네비게이션 바 스타일 */
        .navbar {
            background-color: #90EE90;
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
            text-decoration: none;
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
<div class="navbar">
    <ul>
        <li><a href="/api/v1/admin/manageItem"> 대여 물품 관리</a></li>
        <li><a href="/api/v1/admin/manageRental"> 대여 관리 </a></li>
        <li><a href="/api/v1/admin/manageReservation">예약 관리</a></li>

        <li><a href="/api/v1/member/logout" class="logout">로그아웃</a></li>
    </ul>
</div>

</body>
</html>
