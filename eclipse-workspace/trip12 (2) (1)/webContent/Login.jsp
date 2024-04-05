<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
<meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
<title>로그인</title> <!-- 웹페이지 제목 설정 -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 스타일시트 링크 -->
<link rel="stylesheet" type="text/css" href="Login.css?after"> <!-- 로그인 페이지 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
<link rel="stylesheet" type="text/css" href="Common.css"> <!-- 공통 CSS 스타일시트 링크 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->

	<header> <!-- header 태그 시작 -->
		<h1>NH 여행</h1> <!-- 웹페이지 제목 설정 -->
	</header> <!-- header 태그 끝 -->

	<nav> <!-- nav 태그 시작 -->
		<div class="left-nav"> <!-- left-nav 클래스 div 시작 -->
			<a href="Home.jsp">홈</a> <!-- '홈' 페이지로 이동하는 링크 -->
            <a href="Europe.jsp">유 럽</a> <!-- '유 럽' 페이지로 이동하는 링크 -->
            <a href="SoutheastAsia.jsp">동남아</a> <!-- '동남아' 페이지로 이동하는 링크 -->
            <a href="Japan.jsp">일 본</a> <!-- '일 본' 페이지로 이동하는 링크 -->
            <a href="China.jsp">중 국</a> <!-- '중 국' 페이지로 이동하는 링크 -->
            <a href="USA.jsp">미 국</a> <!-- '미 국' 페이지로 이동하는 링크 -->
            <a href="Honeymoon.jsp">허니문</a> <!-- '허니문' 페이지로 이동하는 링크 -->
            <a href="CompanyIntroduction.jsp">회사 소개</a> <!-- '회사 소개' 페이지로 이동하는 링크 -->
		</div> <!-- left-nav 클래스 div 끝 -->
		<div class="right-nav"> <!-- right-nav 클래스 div 시작 -->
			<a href=Login.jsp>로그인</a> <!-- '로그인' 페이지로 이동하는 링크 -->
		 	<a href=Register.jsp>회원가입</a> <!-- '회원가입' 페이지로 이동하는 링크 -->
		 	<a href="tripreview.jsp">여행후기</a> <!-- '여행후기' 페이지로 이동하는 링크 -->
        	<a href="OneToOne.jsp">1:1문의</a> <!-- '1:1문의' 페이지로 이동하는 링크 -->
		</div> <!-- right-nav 클래스 div 끝 -->
	</nav> <!-- nav 태그 끝 -->

	<section> <!-- section 태그 시작 -->
		<div class="login-form"> <!-- login-form 클래스 div 시작 -->
			<h2>로그인</h2> <!-- 섹션 제목 설정 -->
			<c:if test="${not empty requestScope.updateStatus}"> <!-- requestScope.updateStatus 값이 비어있지 않다면 아래 코드 실행 -->
				<p style="text-align: center; color: green; font-weight: bold;">${requestScope.updateStatus}</p> <!-- 업데이트 상태 메시지 표시 -->
			</c:if>
			<form action="LoginServlet" method="post"> <!-- 로그인 서블릿으로 POST 방식으로 form 데이터 전송 -->
				<div class="input-container">
					<label for="username">아이디 :</label> <!-- 아이디 입력 라벨 -->
					<input type="text" id="username" name="username" required> <!-- 아이디 입력 필드, 필수 입력 -->
				</div>

				<div class="input-container">
					<label for="password">비밀번호 :</label> <!-- 비밀번호 입력 라벨 -->
					<input type="password" id="password" name="password" required> <!-- 비밀번호 입력 필드, 필수 입력 -->
				</div>

				<button type="submit" class="login-button">로그인</button> <!-- 로그인 버튼, 클릭 시 form 데이터 전송 -->
			</form> <!-- form 태그 끝 -->

			<p class="find-info"> <!-- find-info 클래스 p 태그 시작 -->
				<a href="FindUsername.jsp">아이디</a> <!-- '아이디 찾기' 페이지로 이동하는 링크 -->
				| <!-- 구분자 -->
				<a href="FindPassword.jsp">비밀번호 찾기</a> <!-- '비밀번호 찾기' 페이지로 이동하는 링크 -->
			</p> <!-- find-info 클래스 p 태그 끝 -->
		</div> <!-- login-form 클래스 div 끝 -->
	</section> <!-- section 태그 끝 -->


	<jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
