<%@ page import="Pack01.domain.cafe.application.CafeReadService" %>
<%@ page import="Pack01.domain.cafe.entity.Cafe" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
  <title>지도</title>
  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3u5p451mjv"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <style>
    #map {
      width: 100%;
      height: 800px;
    }
  </style>
</head>
<body>
<div id="map"></div>
<div id="rentalForm" style="display: none;">
  <h3>텀블러 대여 신청</h3>
  <form id="rentalRequestForm" method="post" action="/rental/request">
    <input type="hidden" id="cafeId" name="cafeId">
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="phone">전화번호:</label>
    <input type="text" id="phone" name="phone" required>
    <br>
    <button type="submit">신청</button>
  </form>
</div>

<%
  List<Cafe> cafeList = (List<Cafe>)request.getAttribute("cafeList");
%>

<script>
  $(function() {
    initMap();
  });

  function initMap() {
    var map = new naver.maps.Map('map', {
      center: new naver.maps.LatLng(37.498095, 127.027610),
      zoom: 15
    });

    var markers = [];
    var infoWindows = [];

    <%
      for (int i = 0; i < cafeList.size(); i++) {
        Cafe cafe = cafeList.get(i);
        double latitude = cafe.getCafe_latitude();
        double longitude = cafe.getCafe_longitude();
    %>

    var marker<%= i %> = new naver.maps.Marker({
      map: map,
      title: "<%= cafe.getCafe_name() %>",
      position: new naver.maps.LatLng(<%= latitude %>, <%= longitude %>),
      icon: {
        content: '<img src="<c:url value="https://m.bonitahouse.co.kr/layout_dp/img/search_icon_11.png"/>" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 32px; height: 32px; left: 0px; top: 0px;">',
        size: new naver.maps.Size(32, 32),
        anchor: new naver.maps.Point(16, 32)
      }
    });

    var infoWindow<%= i %> = new naver.maps.InfoWindow({
      content: '<div style="width:200px;text-align:center;padding:10px;">' +
              '<b> <%= cafe.getCafe_name() %> </b>' +
              '<br> - 남은 텀블러 수 - ' +
              '<br> n 개 ' +
              '<br> <button onclick="showRentalForm(<%= i %>)">대여하기</button> </div>'
    });

    markers.push(marker<%= i %>);
    infoWindows.push(infoWindow<%= i %>);

    naver.maps.Event.addListener(marker<%= i %>, 'click', getClickHandler(<%= i %>));

    <%
      }
    %>

    function getClickHandler(index) {
      return function(e) {
        let marker = markers[index];
        let infoWindow = infoWindows[index];

        if (infoWindow.getMap()) {
          infoWindow.close();
        } else {
          infoWindow.open(map, marker);
        }
      }
    }
    function showRentalForm(index) {
      let cafeId = markers[index].title;
      document.getElementById('cafeId').value = cafeId;
      document.getElementById('rentalForm').style.display = 'block';
    }

    document.getElementById('rentalRequestForm').addEventListener('submit', function(e) {
      let cafeId = document.getElementById('cafeId').value;
      if (cafeId === '') {
        alert('카페 ID를 선택하세요.');
        e.preventDefault();
      } else {
        alert('텀블러 대여 신청이 완료되었습니다.');
      }
    });
  }
</script>
</body>
</html>