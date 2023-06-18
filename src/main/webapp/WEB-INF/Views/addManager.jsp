<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-15
  Time: 오후 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <title> 카페 관리자 추가 </title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f5f5f5;
    }

    h3 {
      margin-top: 0;
      font-size: 20px;
      color: #333;
    }

    form {
      max-width: 400px;
      margin: 20px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 10px;
      font-weight: bold;
      color: #555;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
      box-sizing: border-box;
      font-size: 14px;
    }

    button[type="submit"] {
      display: block;
      width: 100%;
      padding: 10px;
      margin-top: 20px;
      background-color: #4CAF50;
      color: #fff;
      font-size: 16px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    button[type="submit"]:hover {
      background-color: #45a049;
    }

    #result {
      margin-top: 20px;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<body>
<%
%>

<div id="cafeAdminForm">
  <h3>카페 관리자 추가 </h3>
  <form action="/api/v1/member/manager" method="post" >
    <h3> 남은 텀블러 양은 </h3>
    <input type="text" name="memberEmail"  placeholder="사용자의 이메일을 작성해주세요" >
    <input type="password" name="memberPw" placeholder="사용자의 비밀번호를 작성해주세요" >
    <input type="text" name="memberPhone"  placeholder="사용자의 전화번호를 작성해주세요" >
    <input type="text" name="memberName"  placeholder="사용자의 이름을 작성해주세요" >

    <input name="submit" type="submit" value="관리자 신청"/>
  </form>
</div>

<div id="footer">
  <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>

</body>
</html>