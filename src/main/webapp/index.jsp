
<%@ page language="java" contentType="text/html; ccharset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header_footer.jsp" %>
<html>
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
    <form id="rentalRequestForm" action="api/v1/member/manager" method="post" >
        <h3> 남은 텀블러 양은 </h3>
        <input type="text" name="member_name" id = "member_name" placeholder="사용자의 이름을 작성해주세요" required>
        <input type="text" name="member_phone" id = "member_phone" placeholder="사용자의 전화번호를 작성해주세요" required>
        <input type="text" name="member_email" id = "member_email" placeholder="사용자의 이메일을 작성해주세요" required>
        <input type="password" name="member_pw" id = "member_pw" placeholder="사용자의 비밀번호를 작성해주세요" required>
        <input name="submit" type="submit" value="관리자 신청"/>
    </form>
</div>

<div id="result"></div>
<%
    //  session.getAttribute("member_id");
    Long member_id = 1l;
%>

<script>
    document.getElementById('rentalRequestForm').addEventListener('submit', function(e) {
        e.preventDefault(); // 기본 폼 제출 동작 막기

        // 폼 데이터 가져오기
        let formData = new FormData(document.getElementById('rentalRequestForm'));
        let cafeId = document.getElementById('cafeId').value;

        // AJAX를 사용하여 서버에 폼 데이터 전송
        let xhr = new XMLHttpRequest();
        xhr.open('POST', 'reservationResult', true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                // 결과 페이지를 include할 영역에 결과 데이터 출력
                document.getElementById('result').innerHTML = xhr.responseText;
            } else {
                console.error('Error:', xhr.status);
            }
        };
        xhr.send(formData);
    });
</script>

</body>
</html>e