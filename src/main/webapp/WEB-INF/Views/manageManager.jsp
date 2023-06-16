<%@ page import="Pack01.domain.member.dto.MemberFindAllRespDto" %>
<%@ page import="java.util.List" %>
<%@ page import="Pack01.domain.member.dto.ManagerFindAllRespDto" %><%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/16
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
  #header{
    width:100%;
    height:10%;
    background-color: aqua;
  }
  body{
    display:flex;
    flex-direction: column;
  }
  #contents{
    width:100%;
    height:80%;
    display:flex;
  }
  #left{
    width:10%;
  }
  #footer{
    width:100%;
    height:10%;
    background-color: aqua;
  }
</style>
<body>
<div id="header">
  <jsp:include page="adminHeader.jsp"></jsp:include>
</div>
<div id="contents">
  <div id="left">
    <jsp:include page="adminLeft.jsp"></jsp:include>
  </div>
  <%
    List<ManagerFindAllRespDto> managers = (List<ManagerFindAllRespDto>)request.getAttribute("managers");
  %>
  <table>
    <thead>
    <tr>
      <th>카페 ID</th>
      <th>카페 관리인 ID</th>
      <th>카페 이름</th>
      <th>카페 주소</th>
      <th>카페 관리인 이름</th>
      <th>카페 관리인 이메일</th>
      <th>카페 관리인 핸드폰 번호</th>
    </tr>
    </thead>
    <tbody>
    <tr><%
      for(ManagerFindAllRespDto i : managers) {
        out.println("<td>"+i.getCafe_id()+"</td>");
        out.println("<td>"+i.getMember_id()+"</td>");
        out.println("<td>"+i.getCafe_name()+"</td>");
        out.println("<td>"+i.getCafe_address()+"</td>");
        out.println("<td>"+i.getMember_name()+"</td>");
        out.println("<td>"+i.getMember_email()+"</td>");
        out.println("<td>"+i.getMember_phone()+"</td>");
      }
    %>
    </tr>
    </tbody>
  </table>
</div>
<div id="footer">
  <jsp:include page="adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
