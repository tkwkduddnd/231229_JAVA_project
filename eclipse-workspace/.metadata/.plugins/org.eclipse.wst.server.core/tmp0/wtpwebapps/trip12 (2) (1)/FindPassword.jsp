<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
    <title>비밀번호 찾기</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- 공통 CSS 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="FindPassword.css?after"> <!-- 비밀번호 찾기 페이지 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
    <script>
        // 서블릿에서 받은 메시지를 처리하는 함수
        function handleMessage(message) {
            alert(message);
        }
    </script> <!-- 서블릿에서 받은 메시지를 알림창으로 보여주는 자바스크립트 함수 선언 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="find-password-form"> <!-- find-password-form 클래스 div 시작 -->
            <h2>비밀번호 찾기</h2> <!-- 섹션 제목 설정 -->
            <form action="FindPasswordServlet" method="post" onsubmit="return validateForm();"> <!-- post 방식으로 FindPasswordServlet에 데이터 전송하는 form 시작, 제출 시 validateForm() 함수 실행 -->
                <!-- 레이블과 입력 필드 설정, 필수 입력 -->
                <label for="username">아이디</label> <input type="text" id="username" name="username" required>
                <label for="fullName">성명</label> <input type="text" id="fullName" name="fullName" required>
                <label for="email">이메일</label> <input type="text" id="email" name="email" required>
                <label for="birthday">생년월일</label> <input type="date" id="birthday" name="birthday" required>

                <button type="submit">비밀번호 찾기</button> <!-- 제출 버튼 설정 -->
            </form> <!-- form 끝 -->
        </div> <!-- find-password-form 클래스 div 끝 -->

        <script>
            // 서블릿에서 전달한 메시지를 처리
            var message = '<%= request.getAttribute("message") %>';
            if (message !== "" && message !== null && message !== 'null') {
                handleMessage(message);
            }
        </script> <!-- 서블릿에서 전달한 메시지를 가져와서 알림창으로 보여주는 자바스크립트 코드 -->
    </section> <!-- section 태그 끝 -->
</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
