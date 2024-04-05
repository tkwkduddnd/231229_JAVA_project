<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어 -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 viewport 설정 -->
    <title>회사 소개</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 링크 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="Home.css?after"> <!-- Home.css 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="home-content"> <!-- home-content 클래스 div 시작 -->
            <h2>우리 회사 소개</h2> <!-- 섹션 제목 설정 -->
            <p>NH 여행은 여행사로서 최고의 서비스를 제공하기 위해 노력하고 있습니다. 고객 여러분의 특별한 순간을 만들기
                위해 우리는 다양한 여행지와 편리한 예약 시스템을 제공하고 있습니다.</p> <!-- 회사 소개 텍스트 -->
            <p>여행은 삶을 더욱 풍요롭게 만들어주는 소중한 경험입니다. NH 여행은 고객 여러분이 편안하고 즐거운 여행을 즐길
                수 있도록 최선을 다하고 있습니다.</p> <!-- 회사 소개 텍스트 -->
        </div> <!-- home-content 클래스 div 끝 -->

        <div class="feature-box"> <!-- feature-box 클래스 div 시작 -->
            <div class="feature"> <!-- feature 클래스 div 시작 -->
                <h3>다양한 여행지</h3> <!-- 기능 제목 설정 -->
                <p>세계 각지의 아름다운 여행지를 경험하세요.</p> <!-- 기능 설명 텍스트 -->
            </div> <!-- feature 클래스 div 끝 -->
            <div class="feature"> <!-- feature 클래스 div 시작 -->
                <h3>편리한 예약</h3> <!-- 기능 제목 설정 -->
                <p>간편한 예약 시스템을 통해 여행을 계획하세요.</p> <!-- 기능 설명 텍스트 -->
            </div> <!-- feature 클래스 div 끝 -->
            <div class="feature"> <!-- feature 클래스 div 시작 -->
                <h3>고객 지원</h3> <!-- 기능 제목 설정 -->
                <p>24/7 고객 서비스로 여행 도중 발생하는 문제를 해결하세요.</p> <!-- 기능 설명 텍스트 -->
            </div> <!-- feature 클래스 div 끝 -->
        </div> <!-- feature-box 클래스 div 끝 -->
    </section> <!-- section 태그 끝 -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->
</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
