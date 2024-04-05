<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>하와이</title>
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
    </style>  <!-- 여기서는 p 태그와 img 태그, 그리고 custom-map-control-button 클래스에 대한 스타일을 정의하고 있습니다. -->
    <script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBE2juc0GW5qbVinSt7uwyLqCbISbKly7c&callback=initMap&libraries=&v=weekly"
    defer
    ></script>
    <script>
let map; // 전역 변수로 선언
let markers = [];
let showHotelsState = false;

function initMap() {
    const myLatLng = { lat: 21.3069, lng: -157.8583 };
    map = new google.maps.Map(document.getElementById("map"), {
        zoom: 8,
        center: myLatLng,
        mapTypeId: "satellite"
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
    showHotelsButton.addEventListener('click', function () {
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
            { lat: 21.70096, lng: -157.98801 },
            { lat: 21.65014, lng: -157.93435 },
            { lat: 21.33222, lng: -158.05232 },
            { lat: 21.33028, lng: -158.07525 },
            { lat: 21.70496, lng: -157.99614 },
            { lat: 21.33875, lng: -158.12333 },
            { lat: 21.33230, lng: -157.90067 },
            { lat: 21.27840, lng: -157.82732 },
            { lat: 21.27933, lng: -157.82616 },
            { lat: 21.28076, lng: -157.82711 },
            { lat: 20.94232, lng: -156.69049 },
            { lat: 20.92640, lng: -156.69427 },
            { lat: 20.91975, lng: -156.69501 },
            { lat: 20.83626, lng: -156.91735 },
            { lat: 20.74167, lng: -156.89633 },
            { lat: 20.75424, lng: -155.98721 }
            
            
            
            
            
            
        ]; 
        const hotelNames = [
            "숙박업소 1",
            "숙박업소 2",
            "숙박업소 3",
            "숙박업소 4",
            "숙박업소 5",
            "숙박업소 6",
            "숙박업소 7",
            "숙박업소 8",
            "숙박업소 9",
            "숙박업소 10",
            "숙박업소 11",
            "숙박업소 12",
            "숙박업소 13",
            "숙박업소 14",
            "숙박업소 15"
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
    </script>
</head>
<body>

    <jsp:include page="Nav.jsp" />

    <section>
        <div class="destination-content">
            <h2>하와이</h2>
            <div style="display: flex; justify-content: space-between;"> <!-- 이미지들을 한 줄로 표시 -->
                <img src="images/main/Hwaii.jpg" alt="이미지" style="width: 24%; margin-right: 1%;">
                <img src="images/main/Hwaii1.jpg" alt="이미지1" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지1 -->
                <img src="images/main/Hwaii2.jpg" alt="이미지2" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지2 -->
                <img src="images/main/Hwaii3.jpg" alt="이미지3" style="width: 24%;"> <!-- 추가 이미지3 -->
            </div>
            <p>산토리니는 그리스의 아름다운 섬으로, 멋진 해변과 흰색 건물, 파란 지붕의 교회로 유명합니다. 
            이 섬에서는 햇살 아래에서 휴식을 즐기거나, 맛있는 그리스 음식을 즐길 수 있습니다. 
            또한, 산토리니의 아름다운 일몰은 세계에서 가장 멋진 일몰 중 하나로 꼽힙니다.</p>
        </div>

        <div class="destination-content">
            <h2>휴양지 위치</h2>
            <div id="map" style="height:500px;"></div>
            <p>휴양지는 하와이 전역에 퍼져 있습니다. 
            하와이는 자연의 아름다움을 즐기는 데 최적의 장소로, 어디에서나 멋진 해변과 화산을 만날 수 있습니다.</p>
        </div>
    </section>

    <jsp:include page="footer.jsp" />

</body>
</html>
