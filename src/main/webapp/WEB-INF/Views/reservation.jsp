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
    <title> 텀블러 대여 예약 </title>
</head>
<body>
<%
  Long cafeId = (Long) request.getAttribute("cafe_id");
%>

<div id="rentalForm">
  <h3>텀블러 대여 예약신청 </h3>
  <form id="rentalRequestForm" method="post" action="reservationResult">
    <input type="hidden" id="<%=cafeId%>" name="<%=cafeId%>">
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="phone">전화번호:</label>
    <input type="text" id="phone" name="phone" required>
    <br>
    <button type="submit">신청</button>
  </form>
</div>

<div id="result"></div>

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
</html>
