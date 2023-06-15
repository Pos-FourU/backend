<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%--
  Created by IntelliJ IDEA.
  User: ys000
  Date: 2023-06-15
  Time: ���� 10:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
  <title> ���� </title>
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

    let markers = new Array(); // ��Ŀ ������ ��� �迭
    let infoWindows = new Array(); // ����â�� ��� �迭

    var map = new naver.maps.Map('map', {
      center: new naver.maps.LatLng(37.498095, 1127.027610),
      zoom: 15
    });

    var marker = new naver.maps.Marker({
      map: map,
      title: "ī���̸�",
      position: new naver.maps.LatLng(37.50059716, 127.042813),
      icon: {
        content: '<img src="<c:url value="https://m.bonitahouse.co.kr/layout_dp/img/search_icon_11.png"/>" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 32px; height: 32px; left: 0px; top: 0px;">',
        size: new naver.maps.Size(32, 32),
        anchor: new naver.maps.Point(16, 32)
      }
    });

    /* ����â */
    var infoWindow = new naver.maps.InfoWindow({
      content: '<div style="width:200px;text-align:center;padding:10px;">' +
              '<b> ī���̸� </b>' +
              '<br> - ���� �Һ� �� - ' +
              '<br> n �� </div>'
    }); // Ŭ������ �� ����� ���� �Է�

    markers.push(marker); // ������ ��Ŀ�� ��´�.
    infoWindows.push(infoWindow); // ������ ����â�� ��´�.

    function getClickHandler(seq) {

      return function(e) {  // ��Ŀ�� Ŭ���ϴ� �κ�
        var marker = markers[seq], // Ŭ���� ��Ŀ�� �������� ã�´�.
                infoWindow = infoWindows[seq]; // Ŭ���� ��Ŀ�� �������� ã�´�

        if (infoWindow.getMap()) {
          infoWindow.close();
        } else {
          infoWindow.open(map, marker); // ǥ��
        }
      }
    }
    for (var i=0, ii=markers.length; i<ii; i++) {
      console.log(markers[i] , getClickHandler(i));
      naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i)); // Ŭ���� ��Ŀ �ڵ鷯
    }
  }


  // var map = new naver.maps.Map('map', {
  //   center: new naver.maps.LatLng(37.5112, 127.0981), // ��� �Ե����带 �߽����� �ϴ� ����
  //   zoom: 15
  // });

  // var marker = new naver.maps.Marker({
  //   position: new naver.maps.LatLng(37.5112, 127.0981),
  //   map: map
  // });

</script>

</body>
</html>