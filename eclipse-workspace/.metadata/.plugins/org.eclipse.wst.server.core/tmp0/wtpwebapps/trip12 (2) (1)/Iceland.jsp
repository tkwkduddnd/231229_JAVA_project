<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이슬란드</title>
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
        const myLatLng = { lat: 64.9631, lng: -19.0208 };
        map = new google.maps.Map(document.getElementById("Iceland-map"), {
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
            { lat: 65.25822, lng: -14.40722 },
            { lat: 65.26035, lng: -14.39678 },
            { lat: 65.26330, lng: -14.42568 },
            { lat: 64.93435, lng: -14.02113 },
            { lat: 64.92629, lng: -14.00088 },
            { lat: 64.80242, lng: -14.12306 },
            { lat: 64.21735, lng: -15.71738 },
            { lat: 64.14587, lng: -21.93068 },
            { lat: 64.14675, lng: -21.93279 },
            { lat: 64.14397, lng: -21.92191 },
            { lat: 64.14655, lng: -21.87475 },
            { lat: 64.11218, lng: -21.87676 },
            { lat: 64.18728, lng: -21.61413 },
            { lat: 64.29413, lng: -21.80648 },
            { lat: 64.33515, lng: -21.68077 },
            { lat: 65.68406, lng: -18.09172 }
            
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
            "숙박업소 15",
            "숙박업소 16"
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
    </script>  <!-- 이 스크립트에서는 Google Maps API를 이용하여 지도를 출력하고, 숙박업소 보기 버튼을 생성하고 있습니다. -->
</head>
<body>

    <jsp:include page="Nav.jsp" />

    <section>
        <div class="destination-content">
            <h2>아이슬란드</h2>
            <div style="display: flex; justify-content: space-between;"> <!-- 이미지들을 한 줄로 표시 -->
                <img src="images/main/Iceland.jpg" alt="이미지" style="width: 24%; margin-right: 1%;">
                <img src="images/main/Iceland1.jpg" alt="이미지1" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지1 -->
                <img src="images/main/Iceland2.jpg" alt="이미지2" style="width: 24%; margin-right: 1%;"> <!-- 추가 이미지2 -->
                <img src="images/main/Iceland3.jpg" alt="이미지3" style="width: 24%;"> <!-- 추가 이미지3 -->
            </div>
            <p>아이슬란드는 북유럽의 섬나라로, 아름다운 빙하, 폭포, 온천 등 자연 경관이 매력적인 곳입니다. 
            이 곳에서는 걷기, 등산, 캠핑 등 다양한 야외 활동을 즐길 수 있습니다. 
            특히, 북극광을 볼 수 있는 최적의 장소로 알려져 있습니다.</p>
        </div>

        <div class="destination-content">
            <h2>휴양지 위치</h2>
            <div id="Iceland-map" style="height:500px;"></div>
            <p>휴양지는 아이슬란드 전역에 퍼져 있습니다. 
            아이슬란드는 자연의 아름다움을 즐기는 데 최적의 장소로, 어디에서나 폭포, 빙하, 온천 등을 만날 수 있습니다.</p>
        </div>
    </section> <!-- 이 섹션에서는 산토리니에 대한 설명과 이미지, 그리고 Google Maps를 이용한 위치 정보를 보여주고 있습니다. -->

    <jsp:include page="footer.jsp" />
    
</body>
</html>
