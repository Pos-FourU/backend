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
  <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId="></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body>
<div id="map" style="width:100%; height:800px;"></div>

<script>

  $(function() {

    initMap();

  });


  function initMap() {

    let markers = new Array(); // 마커 정보를 담는 배열
    let infoWindows = new Array(); // 정보창을 담는 배열

    var map = new naver.maps.Map('map', {
      center: new naver.maps.LatLng(37.498095, 1127.027610),
      zoom: 15
    });

    var marker = new naver.maps.Marker({
      map: map,
      title: "카페이름",
      position: new naver.maps.LatLng(37.50059716, 127.042813),
      icon: {
        content: '<img src="<c:url value="https://m.bonitahouse.co.kr/layout_dp/img/search_icon_11.png"/>" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 32px; height: 32px; left: 0px; top: 0px;">',
        size: new naver.maps.Size(32, 32),
        anchor: new naver.maps.Point(16, 32)
      }
    });

    /* 정보창 */
    var infoWindow = new naver.maps.InfoWindow({
      content: '<div style="width:200px;text-align:center;padding:10px;">' +
              '<b> 카페이름 </b>' +
              '<br> - 남은 텀블러 수 - ' +
              '<br> n 개 </div>'
    }); // 클릭했을 때 띄워줄 정보 입력

    markers.push(marker); // 생성한 마커를 담는다.
    infoWindows.push(infoWindow); // 생성한 정보창을 담는다.

    function getClickHandler(seq) {

      return function(e) {  // 마커를 클릭하는 부분
        var marker = markers[seq], // 클릭한 마커의 시퀀스로 찾는다.
                infoWindow = infoWindows[seq]; // 클릭한 마커의 시퀀스로 찾는다

        if (infoWindow.getMap()) {
          infoWindow.close();
        } else {
          infoWindow.open(map, marker); // 표출
        }
      }
    }
    for (var i=0, ii=markers.length; i<ii; i++) {
      console.log(markers[i] , getClickHandler(i));
      naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i)); // 클릭한 마커 핸들러
    }
  }


  // var map = new naver.maps.Map('map', {
  //   center: new naver.maps.LatLng(37.5112, 127.0981), // 잠실 롯데월드를 중심으로 하는 지도
  //   zoom: 15
  // });

  // var marker = new naver.maps.Marker({
  //   position: new naver.maps.LatLng(37.5112, 127.0981),
  //   map: map
  // });

</script>

</body>
</html>