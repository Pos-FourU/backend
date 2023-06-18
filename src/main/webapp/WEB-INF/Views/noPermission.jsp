<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-18
  Time: 오후 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <%@ include file="/nav_bar.jsp" %>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }

    h1 {
      color: #333;
      text-align: center;
    }

    .container {
      width: 500px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .info {
      margin-bottom: 20px;
    }

    .info label {
      font-weight: bold;
    }

    .info span {
      margin-left: 10px;
    }

  </style>
</head>
<body>
<div class="info">
 로그인이 필요합니다..
  <a href="/">로그인창 가기</a>
</div>
<div id="footer">
    <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
