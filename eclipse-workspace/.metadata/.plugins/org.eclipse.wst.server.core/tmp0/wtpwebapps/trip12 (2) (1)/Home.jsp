<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
<meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
<title>여행사 홈페이지</title> <!-- 웹페이지 제목 설정 -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 스타일시트 링크 -->
<link rel="stylesheet" type="text/css" href="Common.css?after"> <!-- 공통 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
<link rel="stylesheet" type="text/css" href="Home.css?after"> <!-- 홈페이지 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->

<!-- 스타일 태그 시작 -->
<style>
    .mySlides img {
        margin: auto;
        display: block;
    }
    .mySlides {
        position: relative;
        animation: fadein 2s;
    }
    @keyframes fadein {
        from {opacity: 0;}
        to {opacity: 1;}
    }
    .sparkle {
        animation: sparkle 3s infinite;
        font-size: 2em;
    }
    @keyframes sparkle {
        0% {color: #000; opacity: 1;}
        50% {color: #000; opacity: 0;}
        100% {color: #000; opacity: 1;}
    }
    .carousel {
        display: flex;
        overflow-x: auto;
    }
    .carousel-item {
        flex: 0 0 auto;
        border: 1px solid #ccc;
        border-radius: 8px;
        padding: 20px;
        text-align: center;
    }
    .carousel-item img {
        width: 370px;
        height: 200px;
        object-fit: cover;
    }
</style> <!-- 스타일 태그 끝 -->

<!-- 스크립트 태그 시작 -->
<script>
    var slideIndex = 0;
    window.onload = function() {
        carousel();
    };
    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > x.length) {
            slideIndex = 1
        }
        x[slideIndex - 1].style.display = "block";
        setTimeout(carousel, 6000);
    }
</script> <!-- 스크립트 태그 끝 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <header> <!-- 헤더 태그 시작 -->
        <h1>NH 여행</h1> <!-- 웹페이지 헤더 제목 설정 -->
    </header> <!-- 헤더 태그 끝 -->

    <nav> <!-- 네비게이션 태그 시작 -->
        <div class="left-nav"> <!-- left-nav 클래스 div 시작 -->
            <a href="Home.jsp">홈</a> <a href="Europe.jsp">유 럽</a> <a
                href="SoutheastAsia.jsp">동남아</a> <a href="Japan.jsp">일 본</a> <a
                href="China.jsp">중 국</a> <a href="USA.jsp">미 국</a> <a
                href="Honeymoon.jsp">허니문</a> <a href="CompanyIntroduction.jsp">회사
                소개</a> <!-- 각각의 링크로 이동하는 하이퍼링크 -->
        </div> <!-- left-nav 클래스 div 끝 -->

        <div class="right-nav"> <!-- right-nav 클래스 div 시작 -->
            <%
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            if (username == null) { // 사용자 이름이 null이면 로그인하지 않은 상태이므로 아래 코드 실행
            %>
            <a href="Login.jsp">로그인</a> <a href="Register.jsp">회원가입</a> <a
                href="tripreview.jsp">여행후기</a> <a href="OneToOne.jsp">1:1문의</a> <!-- 로그인, 회원가입, 여행후기, 1:1문의로 이동하는 하이퍼링크 -->
            <%
            } else { // 로그인한 상태이면 아래 코드 실행
            %>
            <a href="<%="admin".equals(role) ? "Admin.jsp" : "MyPage.jsp"%>">
                <%=username%>님의 마이페이지
            </a> <a href="<%="admin".equals(role) ? "Admin.jsp" : "Cart.jsp"%>">
                장바구니 </a> <a href="tripreview.jsp">여행후기</a> <a href="OneToOne.jsp">1:1문의</a>
            <a href="LogoutServlet">로그아웃</a> <!-- 마이페이지, 장바구니, 여행후기, 1:1문의, 로그아웃으로 이동하는 하이퍼링크 -->
            <%
            }
            %>
        </div> <!-- right-nav 클래스 div 끝 -->
    </nav> <!-- 네비게이션 태그 끝 -->
<section> <!-- section 태그 시작 -->
    <div class="home-content"> <!-- home-content 클래스 div 시작 -->
        <h2>환영합니다!</h2> <!-- 섹션 제목 설정 -->
        <p>여행을 더욱 특별하게 만드는 여행사와 함께하세요.</p> <!-- 섹션 설명문 설정 -->
        <div class="mySlides"> <!-- mySlides 클래스 div 시작 -->
            <img src="images/main/Sydney.jpg" alt="메인페이지" style="width: 30%"> <!-- 이미지 출력, 너비는 30% -->
        </div> <!-- mySlides 클래스 div 끝 -->
        <div class="mySlides"> <!-- mySlides 클래스 div 시작 -->
            <img src="images/main/Coloseum.jpg" alt="Deal 1" style="width: 30%"> <!-- 이미지 출력, 너비는 30% -->
        </div> <!-- mySlides 클래스 div 끝 -->
        <div class="mySlides"> <!-- mySlides 클래스 div 시작 -->
            <img src="images/main/Moldive.jpg" alt="Deal 2" style="width: 30%"> <!-- 이미지 출력, 너비는 30% -->
        </div> <!-- mySlides 클래스 div 끝 -->
        <div class="mySlides"> <!-- mySlides 클래스 div 시작 -->
            <img src="images/main/Santorini.jpg" alt="Deal 3" style="width: 30%"> <!-- 이미지 출력, 너비는 30% -->
        </div> <!-- mySlides 클래스 div 끝 -->
    </div> <!-- home-content 클래스 div 끝 -->

    <div class="feature-box"> <!-- feature-box 클래스 div 시작 -->
        <div class="feature"> <!-- feature 클래스 div 시작 -->
            <h3>다양한 여행지</h3> <!-- 피쳐 제목 설정 -->
            <p>세계 각지의 아름다운 여행지를 경험하세요.</p> <!-- 피쳐 설명문 설정 -->
        </div> <!-- feature 클래스 div 끝 -->
        <div class="feature"> <!-- feature 클래스 div 시작 -->
            <h3>편리한 예약</h3> <!-- 피쳐 제목 설정 -->
            <p>간편한 예약 시스템을 통해 여행을 계획하세요.</p> <!-- 피쳐 설명문 설정 -->
        </div> <!-- feature 클래스 div 끝 -->
        <div class="feature"> <!-- feature 클래스 div 시작 -->
            <h3>고객 지원</h3> <!-- 피쳐 제목 설정 -->
            <p>24/7 고객 서비스로 여행 도중 발생하는 문제를 해결하세요.</p> <!-- 피쳐 설명문 설정 -->
        </div> <!-- feature 클래스 div 끝 -->
    </div> <!-- feature-box 클래스 div 끝 -->

    <section class="popular-destinations"> <!-- popular-destinations 클래스 섹션 시작 -->
        <h2 class="sparkle">인기 여행지 TOP 5</h2> <!-- 섹션 제목 설정 -->
        <div class="destinations-container"> <!-- destinations-container 클래스 div 시작 -->
            <div class="carousel"> <!-- carousel 클래스 div 시작 -->
                <!-- 각각의 carousel-item 클래스 div 시작, 클릭 시 해당 여행지 페이지로 이동 -->
                <div class="carousel-item">
                    <a href="PATAGONIA.jsp"> 
                        <img src="images/main/PATAGONIA.jpg" alt="Destination 1">
                    </a>
                    <p>인기 여행지 TOP 1</p>
                </div>
                <div class="carousel-item">
                    <a href="Santorini.jsp"> 
                        <img src="images/main/Santorini.jpg" alt="Destination 2">
                    </a>
                    <p>인기 여행지 TOP 2</p>
                </div>
                <div class="carousel-item">
                    <a href="Iceland.jsp"> 
                        <img src="images/main/Iceland.jpg" alt="Destination 3">
                    </a>
                    <p>인기 여행지 TOP 3</p>
                </div>
                <div class="carousel-item">
                    <a href="Hwaii.jsp"> 
                        <img src="images/main/Hwaii.jpg" alt="Destination 4">
                    </a>
                    <p>인기 여행지 TOP 4</p>
                </div>
                <div class="carousel-item">
                    <a href="Follow.jsp"> 
                        <img src="images/main/Follow.jpg" alt="Destination 5">
                    </a>
                    <p>인기 여행지 TOP 5</p>
                </div> <!-- 각각의 carousel-item 클래스 div 끝 -->
            </div> <!-- carousel 클래스 div 끝 -->
        </div> <!-- destinations-container 클래스 div 끝 -->
    </section> <!-- popular-destinations 클래스 섹션 끝 -->
</section> <!-- section 태그 끝 -->

<jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
    