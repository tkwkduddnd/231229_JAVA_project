<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
    <title>아이디 찾기</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- 공통 CSS 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="FindUsername.css?after"> <!-- 아이디 찾기 페이지 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="find-username-form"> <!-- find-username-form 클래스 div 시작 -->
            <h2>아이디 찾기</h2> <!-- 섹션 제목 설정 -->
            <form action="FindUsernameServlet" method="post"> <!-- post 방식으로 FindUsernameServlet에 데이터 전송하는 form 시작 -->
                <label for="fullName">성명</label> <!-- 레이블 설정 -->
                <input type="text" id="fullName" name="fullName" required> <!-- 입력받는 텍스트 필드 설정, 필수 입력 -->

                <label for="email">이메일</label> <!-- 레이블 설정 -->
                <input type="text" id="email" name="email" required> <!-- 입력받는 텍스트 필드 설정, 필수 입력 -->

                <label for="birthday">생년월일</label> <!-- 레이블 설정 -->
                <input type="date" id="birthday" name="birthday" required> <!-- 입력받는 date 필드 설정, 필수 입력 -->

                <button type="submit">아이디 찾기</button> <!-- 제출 버튼 설정 -->
            </form> <!-- form 끝 -->
        </div> <!-- find-username-form 클래스 div 끝 -->
    </section> <!-- section 태그 끝 -->
</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
