<%--
  Created by IntelliJ IDEA.
  User: kimheeah
  Date: 2023/06/15
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
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
    #header {
        width: 100%;
        height: 10%;
        background-color: #90EE90;
    }

    body {
        display: flex;
        flex-direction: column;
    }

    #contents {
        width: 100%;
        height: 80%;
        display: flex;
    }

    #left {
        width: 10%;
    }

    #footer {
        width: 100%;
        height: 10%;
        background-color: #90EE90;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: center;
        padding: 8px;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
</style>
<body>
<div id="header">
    <jsp:include page="/adminHeader.jsp"></jsp:include>
</div>
<div id="contents">
    <%
        long admin_id=1L;
        List<MemberFindAllRespDto> members = (List<MemberFindAllRespDto>) request.getAttribute("members");
    %>
    <table>
        <thead>
        <tr>
            <th>사용자 ID</th>
            <th>사용자 이메일</th>
            <th>사용자 이름</th>
            <th>사용자 핸드폰 번호</th>
            <th>사용자 경고 횟수</th>
            <th>사용자 상태</th>
            <th>사용자 상태 변경</th>
        </tr>
        </thead>
        <tbody>
        <% for(MemberFindAllRespDto i : members) { %>
        <tr>
            <td><%= i.getMember_id() %></td>
            <td><%= i.getMember_email() %></td>
            <td><%= i.getMember_name() %></td>
            <td><%= i.getMember_phone() %></td>
            <td><%= i.getWarning_count() %></td>
            <td><%= i.getMember_role() %></td>
            <form action="updateRole" method="get">
                <td>
                    <input type="hidden" name="admin" value="<%= admin_id %>">
                    <input type="hidden" name="member_id" value="<%= i.getMember_id() %>">
                    <select name="role">
                        <option value="USER" <% if (i.getMember_role().equals("USER")) { %>selected<% } %>>USER</option>
                        <option value="BLACK_LIST" <% if (i.getMember_role().equals("BLACK_LIST")) { %>selected<% } %>>BLACK_LIST</option>
                    </select>
                </td>
                <td>
                    <button type="submit">신청</button>
                </td>
            </form>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<div id="footer">
    <jsp:include page="/adminFooter.jsp"></jsp:include>
</div>
</body>
</html>
