<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-16
  Time: 오전 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
    Long cafeId = Long.parseLong(request.getParameter("cafeId"));
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");






    out.println("<h3>텀블러 대여 예약이 완료되었습니다.</h3>");

%>
</body>
</html>
