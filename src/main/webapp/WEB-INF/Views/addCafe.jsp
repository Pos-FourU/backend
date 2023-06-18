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
  <title> 카페 등록 </title>
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
  Long member_id = (Long) request.getAttribute("member_id");
%>

<div id="rentalForm">
  <h3>카페 정보 추가 </h3>
  <form action="/api/v1/cafe/register" method="post" >
    <h3> 카페 정보 추가 </h3>
    <input type="hidden" name="member_id" value="<%= member_id %>">
    <input type="text" name="cafe_name" id = "cafe_name" placeholder="카페이름을 작성해주세요" required>
    <input type="text" name="cafe_address" id = "cafe_address" placeholder="카페주소를 작성해주세요" required>
    <button type="submit">신청</button>
  </form>
</div>

<div id="result"></div>

<%

%>

</body>
</html>