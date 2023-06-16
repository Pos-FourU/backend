<%@ page import="Pack01.domain.member.dto.MemberFindAllRespDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/15
  Time: 5:42 PM
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
        List<MemberFindAllRespDto> members = (List<MemberFindAllRespDto>)request.getAttribute("members");
    %>
    <table>
        <thead>
        <tr>
            <th>사용자 ID</th>
            <th>사용자 이메일</th>
            <th>사용자 이름</th>
            <th>사용자 핸드폰 번호</th>
            <th>블랙리스트 해제</th>
        </tr>
        </thead>
        <tbody>
        <tr><%
            for(MemberFindAllRespDto i : members) {
                out.println("<td>"+i.getMember_id()+"</td>");
                out.println("<td>"+i.getMember_email()+"</td>");
                out.println("<td>"+i.getMember_name()+"</td>");
                out.println("<td>"+i.getMember_phone()+"</td>");
            }
        %>
            <td>
                <button onclick="">해제</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div id="footer">
    <jsp:include page="adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
