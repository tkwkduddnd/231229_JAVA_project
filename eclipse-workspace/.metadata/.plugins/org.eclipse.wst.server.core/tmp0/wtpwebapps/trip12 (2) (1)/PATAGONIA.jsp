<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파타고니아</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="Common.css?after">
    <link rel="stylesheet" type="text/css" href="Home.css?after">
    <style>
        p {
            font-size: 1.5em; /* 글자 크기를 1.5배로 키움 */
        }
        img {
            width: 500px; /* 이미지 너비를 500px로 통일 */
            height: 300px; /* 이미지 높이는 원본 비율을 유지 */
        }
        .custom-map-control-button {
            background-color: #5C5C5B;
            border: none;
            color: white;
            padding: 10px;
            font-size: 14px;
            cursor: pointer;
            margin: 10px;
            border-radius: 3px;
            opacity: 0.9;
        }
    </style> <!-- 여기서는 p 태그와 img 태그, 그리고 custom-map-control-button 클래스에 대한 스타일을 정의하고 있습니다. -->
    <script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBE2juc0GW5qbVinSt7uwyLqCbISbKly7c&callback=initMap&libraries=&v=weekly"
    defer
    ></script>
    <script>
    let map; // 전역 변수로 선언
    let markers = [];
    let showHotelsState = false;

    function initMap() {
    	
        const myLatLng = { lat: -49.3314941, lng: -72.886325 };

        map = new google.maps.Map(document.getElementById("map"), {
            zoom: 8,
            center: myLatLng,
            mapTypeId: "satellite",
        });

        new google.maps.Marker({
            position: myLatLng,
            map,
            title: "휴양지 위치",
        });

        const showHotelsButton = document.createElement('button');
        showHotelsButton.textContent = '숙박업소 보기';
        showHotelsButton.classList.add('custom-map-control-button');
        map.controls[google.maps.ControlPosition.TOP_CENTER].push(showHotelsButton);
        showHotelsButton.addEventListener('click', function() {
            showHotelsState = !showHotelsState;
            if (showHotelsState) {
                showHotels();
            } else {
                hideHotels();
            }
        });
    }

    function showHotels() {
        // 예시 숙박업소 위치들, 실제로는 각 숙박업소의 위도, 경도를 입력해야 합니다.
        const hotelLatLngs = [
            { lat: -49.32893, lng: -72.88569 },
            { lat: -49.32931, lng: -72.88315 },
            { lat: -49.33115, lng: -72.88315 },
            { lat: -49.33257, lng: -72.88958 },
            { lat: -49.32654, lng: -72.89126 },
            { lat: -49.32649, lng: -72.89359 },
            { lat: -49.32601, lng: -72.88801 }
        ]; 
        const hotelNames = [
            "숙박업소 1",
            "숙박업소 2",
            "숙박업소 3",
            "숙박업소 4",
            "숙박업소 5",
            "숙박업소 6",
            "숙박업소 7",
            
        ];

        // 새로운 마커들 추가하기
        for (let i = 0; i < hotelLatLngs.length; i++) {
            const marker = new google.maps.Marker({
                position: hotelLatLngs[i],
                map,
                title: "숙박업소 위치 " + (i + 1),
                icon: {
                    url: "http://maps.google.com/mapfiles/ms/icons/green-dot.png"
                }
            });
            const infoWindow = new google.maps.InfoWindow({
                content: hotelNames[i]
            });

            marker.addListener('mouseover', function() {
                infoWindow.open(map, marker);
            });

            marker.addListener('mouseout', function() {
                infoWindow.close();
            });
            markers.push(marker);
        }

        map.setCenter(hotelLatLngs[0]);
    }

    function hideHotels() {
        // 마커들을 지우기
        for (let i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }
        markers = [];
    }
    </script> <!-- 이 스크립트에서는 Google Maps API를 이용하여 지도를 출력하고, 숙박업소 보기 버튼을 생성하고 있습니다. -->
</head>
<body>

    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section>
        <div class="destination-content">
            <h2>파타고니아</h2>
            <div style="display: flex; justify-content: space-between;"> <!-- 이미지들을 한 줄로 표시 -->
                <img src="images/main/PATAGONIA.jpg" alt="파타고니아" style="width: 24%; margin-right: 1%;">
                <img src="images/main/PATAGONIA1.jpg" alt="이미지1" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지1 -->
                <img src="images/main/PATAGONIA2.jpg" alt="이미지2" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지2 -->
                <img src="images/main/PATAGONIA3.jpg" alt="이미지3" style="width: 24%;"> <!-- 추가 이미지3 -->
            </div>
            <p>파타고니아는 남미의 가장 남단에 위치한 지역으로, 아름다운 자연 경치로 유명합니다. 
            산, 강, 호수, 빙하 등 다양한 풍경을 즐길 수 있습니다. 
            여기에서는 트레킹, 카누, 캠핑 등 다양한 야외 활동을 즐길 수 있습니다.</p>
        </div>

        <div class="destination-content">
            <h2>휴양지 위치</h2>
            <div id="map" style="height:500px;"></div>
            <p>휴양지는 파타고니아의 동쪽에 위치해 있습니다. 
            가장 가까운 공항에서 차로 약 2시간 거리에 있으며, 공항에서는 렌터카 서비스를 이용할 수 있습니다.</p>
        </div>
    </section> <!-- 이 섹션에서는 산토리니에 대한 설명과 이미지, 그리고 Google Maps를 이용한 위치 정보를 보여주고 있습니다. -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body>
</html>
