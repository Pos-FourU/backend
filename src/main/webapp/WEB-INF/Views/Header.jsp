<%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/15
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <style>
        /* 헤더 스타일 */
        .header {
            background-color: #FEE9E1;
            padding: 20px;
            text-align: center;
        }
        .header img {
            width: 100px;
            height: 100px;
            margin-bottom: 10px;
        }
        .header h1 {
            font-size: 24px;
            color: #333;
            margin: 0;
        }
        nav {
            background-color: #FEE9E1;
            padding: 10px;
            text-align: center;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        nav ul li {
            display: inline-block;
            margin-right: 10px;
        }
        nav ul li a {
            /*text-decoration: none;*/
            color: #333;
            padding: 5px 10px;
        }

    </style>
</head>
<body>
<div class="header">
    <img src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fcdn1.iconfinder.com%2Fdata%2Ficons%2Fecologic-awareness-colored-outline%2F512%2FEco_Friendly-512.png&type=sc960_832" alt="텀블러 로고">
    <h1>텀블러 대여 시스템</h1>
</div>


<div>
    <nav>
        <ul>
            <li><a href="/index.jsp">메인</a></li>
            <li><a href="/api/v1/cafe/map">예약하기</a></li>
            <li><a href="/mypage">마이페이지</a></li>
        </ul>
    </nav>
</div>

</body>
</html>
