<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-18
  Time: 오후 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>물품 추가</title>
  <meta charset="UTF-8">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    h1 {
      text-align: center;
      margin-top: 20px;
    }

    form {
      max-width: 400px;
      margin: 20px auto;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #dddddd;
      border-radius: 4px;
      box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 10px;
      font-weight: bold;
    }

    select, input[type="radio"], input[type="submit"] {
      margin-top: 5px;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: #ffffff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<h1>물품 추가</h1>
<form action="/api/v1/item/add" method="post">
  <div>
    <label>물품 카테고리</label>
    <select name="category" required>
      <option value="텀블러">텀블러</option>
    </select>
  </div>
  <div>
    <label>물품 상태</label>
    <div>
      <label>
        <input type="radio" name="status" value="VALID" checked> VALID
      </label>
      <label>
        <input type="radio" name="status" value="INVALID"> INVALID
      </label>
      <label>
        <input type="radio" name="status" value="DAMAGED"> DAMAGED
      </label>
    </div>
  </div>
  <input name="submit" type="submit" value="추가"/>
</form>
</body>
</html>
