<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>

<%--TODO 특정 IP만 접속 가능하게?--%>

<body>
<h1>AdminPage</h1>
<form action="admin/login" method="post">
  <div>
    <label>ID</label>
    <input name="adminId" type="text"/>
  </div>
  <div>
    <label>PW</label>
    <input name="adminPw" type="password"/>
  </div>
  <input name="submit" type="submit" value="로그인"/>
</form>
</body>
</html>
