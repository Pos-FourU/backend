<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-18
  Time: 오전 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
      text-align: center;
      margin-bottom: 20px;
    }

    .info label {
      font-weight: bold;
    }

    .info span {
      margin-left: 10px;
    }

    button {
      margin: 20px;
    }
    .w-btn-green {
      background-color: #77af9c;
      color: #d7fff1;
    }

  </style>
  <title> 회원 정보 수정 </title>
</head>
<body>

<h1> 회원 정보 수정 </h1>
  <div class="info">
<p> 이름과 전화번호를 수정할 수 있습니다.</p>
<form action="/api/v1/member/mypage/update" method="post">
  <label for="memberName">이름:</label>
  <input type="text" id="memberName" name="memberName" value="${member.member_name}" required>
  <br>

  <label for="memberEmail">이메일:</label>
  <input type="email" id="memberEmail" name="memberEmail" value="${member.member_email}" required>
  <br>

  <button class="w-btn w-btn-green" type="submit">
    수정하기
  </button>

</form>
</div>

</body>
</html>
