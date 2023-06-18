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
</head>
<body>
<h1>물품 추가</h1>
<form action="api/v1/item/add" method="post">
  <div>
    <label>물품 카테고리</label>
    <select name="category" required>
      <option value="카테고리1">카테고리1</option>
      <option value="카테고리2">카테고리2</option>
      <option value="카테고리3">카테고리3</option>
      <!-- 다른 카테고리 옵션들 추가 -->
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