<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/18
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    function completeRental(){
        parent.location.reload();
    }
</script>
<%
    Long cafe_manager_id = Long.parseLong(request.getParameter("cafe_manager_id"));
    Long item_id = Long.parseLong(request.getParameter("item_id"));
%>
<form method="post" action="getRentalInfo">
    <label>아이디</label>
    <input type="text" name="member_email"/>

    <label>대여일</label>
    <input type="number" min="1" max="7" name="rental_days"/>

<%--    <input type="hidden" name="rental_time" value="<%=java.sql.Date.valueOf(LocalDate.now())%>"/>--%>
    <input type="hidden" name="cafe_manager_id" value="<%=cafe_manager_id%>"/>
    <input type="hidden" name="item_id" value="<%=item_id%>"/>

    <button type="submit">대여</button>
</form>
</body>
</html>
