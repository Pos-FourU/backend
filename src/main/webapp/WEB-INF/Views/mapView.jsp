<%@ page import="Pack01.domain.cafe.application.CafeReadService" %>
<%@ page import="Pack01.domain.cafe.entity.Cafe" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-15
  Time: 오전 10:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
  <title> 지도 </title>
  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3u5p451mjv"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body>
<div id="map" style="width:100%; height:800px;"></div>

<script>

  $(function() {

    initMap();

  });

  <%
    List<Cafe> cafeList = (List<Cafe>)request.getAttribute("cafeList");
  %>
  function initMap() {

    let markers = new Array(); // 마커 정보를 담는 배열
    let infoWindows = new Array(); // 정보창을 담는 배열

    var map = new naver.maps.Map('map', {
      center: new naver.maps.LatLng(37.498095, 1127.027610),
      zoom: 15
    });

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

    /* 정보창 */
    var infoWindow = new naver.maps.InfoWindow({
      content: '<div style="width:200px;text-align:center;padding:10px;">' +
              '<b> <%= cafe.getCafe_name() %> </b>' +
              '<br> - 남은 텀블러 수 - ' +
              '<br> n 개 </div>'
    }); // 클릭했을 때 띄워줄 정보 입력

    markers.push(marker<%= i %>); // 생성한 마커를 담는다.
    infoWindows.push(infoWindow<%= i %>); // 생성한 정보창을 담는다.

    naver.maps.Event.addListener(marker<%= i %>, 'click', getClickHandler<%= i %>); // 클릭 이벤트 핸들러 등록

    function getClickHandler<%= i %>() {
      var marker = markers[<%= i %>];
      var infoWindow = infoWindows[<%= i %>];

      return function(e) {
        if (infoWindow.getMap()) {
          infoWindow.close();
        } else {
          infoWindow.open(map, marker);
        }
      }
    }
    <%
      }
    %>
  }
</script>



</body>
</html>