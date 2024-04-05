<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>산토리니</title>
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
    const myLatLng = { lat: 36.3932, lng: 25.4615 };
    map = new google.maps.Map(document.getElementById("Santorini-map"), {
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
            { lat: 36.40694, lng: 25.44716 },
            { lat: 36.41016, lng: 25.44661 },
            { lat: 36.41076, lng: 25.44825 },
            { lat: 36.41913, lng: 25.43118 },
            { lat: 36.42040, lng: 25.43188 },
            { lat: 36.41847, lng: 25.43459 },
            { lat: 36.41872, lng: 25.43590 },
            { lat: 36.42361, lng: 25.43276 },
            { lat: 36.43503, lng: 25.42169 },
            { lat: 36.41622, lng: 25.43097 },
            { lat: 36.41517, lng: 25.43201 },
            { lat: 36.38409, lng: 25.46223 },
            { lat: 36.37999, lng: 25.48534 },
            { lat: 36.37681, lng: 25.48483 },
            { lat: 36.37205, lng: 25.48093 }
            
            
            
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
            
            
            /*... 나머지 숙박업소 이름들 ...*/
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
<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="destination-content">
            <h2>산토리니</h2>
            <div style="display: flex; justify-content: space-between;"> <!-- 이미지들을 한 줄로 표시 -->
                <img src="images/main/Santorini.jpg" alt="이미지" style="width: 24%; margin-right: 1%;">
                <img src="images/main/Santorini4.jpg" alt="이미지1" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지1 -->
                <img src="images/main/Santorini2.jpg" alt="이미지2" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지2 -->
                <img src="images/main/Santorini3.jpg" alt="이미지3" style="width: 24%;"> <!-- 추가 이미지3 -->
            </div>
            <p>산토리니는 그리스의 아름다운 섬으로, 멋진 해변과 흰색 건물, 파란 지붕의 교회로 유명합니다. 
            이 섬에서는 햇살 아래에서 휴식을 즐기거나, 맛있는 그리스 음식을 즐길 수 있습니다. 
            또한, 산토리니의 아름다운 일몰은 세계에서 가장 멋진 일몰 중 하나로 꼽힙니다.</p>
        </div>

        <div class="destination-content">
            <h2>휴양지 위치</h2>
            <div id="Santorini-map" style="height:500px;"></div>
            <p>휴양지는 산토리니 섬 내에 위치해 있습니다. 
            섬 전체가 휴양지로, 어디에서나 멋진 풍경과 문화를 즐길 수 있습니다.</p>
        </div>
    </section> <!-- 이 섹션에서는 산토리니에 대한 설명과 이미지, 그리고 Google Maps를 이용한 위치 정보를 보여주고 있습니다. -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->
</body> <!-- body 태그 끝 -->

</html> <!-- HTML 끝 -->
