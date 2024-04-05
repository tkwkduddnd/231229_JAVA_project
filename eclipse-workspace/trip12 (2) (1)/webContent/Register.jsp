<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>회원 가입</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 가져옴 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트 연결 -->
    <link rel="stylesheet" type="text/css" href="Register.css"> <!-- Register.css 스타일시트 연결 -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> <!-- jQuery 라이브러리 로드 -->
    <script> <!-- 스크립트 시작 -->
        $(document).ready(function () { // 문서 로드 완료 시
            $("#checkUsernameBtn").click(function () { // checkUsernameBtn 클릭 시
                var username = $("#username").val(); // username의 값을 가져옴

                if (username.trim() !== "") { // username이 공백이 아니면
                    $.ajax({ // AJAX 요청 시작
                        url: "CheckUsernameServlet", // 요청을 보낼 URL
                        type: "POST", // HTTP 메소드
                        data: { username: username }, // 보낼 데이터
                        success: function (data) { // 요청이 성공하면
                            alert(data); // 서버에서 받은 데이터를 알림으로 표시
                        },
                        error: function () { // 요청이 실패하면
                            alert("중복 확인 중 오류가 발생했습니다."); // 오류 메시지 출력
                        }
                    });
                } else { // username이 공백이면
                    alert("아이디를 입력해주세요."); // 알림 출력
                }
            });
        });
    </script> <!-- 스크립트 끝 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <header> <!-- header 태그 시작 -->
        <h1>NH 여행</h1> <!-- 제목 설정 -->
    </header> <!-- header 태그 끝 -->

    <nav> <!-- nav 태그 시작 -->
        <div class="left-nav"> <!-- left-nav 클래스 div 시작 -->
            <a href="Home.jsp">홈</a> <!-- 링크 설정 -->
            <a href="Europe.jsp">유 럽</a> <!-- 링크 설정 -->
            <a href="SoutheastAsia.jsp">동남아</a> <!-- 링크 설정 -->
            <a href="Japan.jsp">일 본</a> <!-- 링크 설정 -->
            <a href="China.jsp">중 국</a> <!-- 링크 설정 -->
            <a href="USA.jsp">미 국</a> <!-- 링크 설정 -->
            <a href="Honeymoon.jsp">허니문</a> <!-- 링크 설정 -->
            <a href="CompanyIntroduction.jsp">회사 소개</a> <!-- 링크 설정 -->
        </div> <!-- left-nav 클래스 div 끝 -->
        <div class="right-nav"> <!-- right-nav 클래스 div 시작 -->
            <a href=Login.jsp>로그인</a> <!-- 링크 설정 -->
            <a href=Register.jsp>회원가입</a> <!-- 링크 설정 -->
            <a href="tripreview.jsp">여행후기</a> <!-- 링크 설정 -->
            <a href="OneToOne.jsp">1:1문의</a> <!-- 링크 설정 -->
        </div> <!-- right-nav 클래스 div 끝 -->
    </nav> <!-- nav 태그 끝 -->

    <section> <!-- section 태그 시작 -->
        <h2>회원 가입</h2> <!-- 제목 설정 -->
        <form action="RegisterServlet" method="post"> <!-- 폼 시작, 제출 시 RegisterServlet으로 POST 요청 보냄 -->
            아이디: <input type="text" id="username" name="username" required> <!-- 아이디 입력 필드 -->
            <button type="button" id="checkUsernameBtn">중복 확인</button> <!-- 중복 확인 버튼 -->
            비밀번호: <input type="password" name="password" required> <!-- 비밀번호 입력 필드 -->
            비밀번호 확인: <input type="password" name="confirmPassword" required> <!-- 비밀번호 확인 입력 필드 -->
            성명: <input type="text" name="fullName" required> <!-- 성명 입력 필드 -->
            성별: <label><input type="radio" name="gender" value="Male">남성</label> <!-- 성별 선택 라디오 버튼 -->
            <label><input type="radio" name="gender" value="Female">여성</label> <!-- 성별 선택 라디오 버튼 -->
            생일: <input type="date" name="birthday" required> <!-- 생일 입력 필드 -->
            <div class="email-group"> <!-- email-group 클래스 div 시작 -->
                <label for="email">이메일:</label> <!-- 라벨 설정 -->
            </div> <!-- email-group 클래스 div 끝 -->
            <div class="email-group"> <!-- email-group 클래스 div 시작 -->
                <input type="text" id="email" name="emailPrefix" required> <!-- 이메일 앞부분 입력 필드 -->
                @ <!-- @ 기호 -->
                <select name="emailDomain"> <!-- 이메일 도메인 선택 -->
                    <option value="naver.com">naver.com</option> <!-- 옵션 설정 -->
                    <option value="daum.net">daum.net</option> <!-- 옵션 설정 -->
                    <option value="gmail.com">gmail.com</option> <!-- 옵션 설정 -->
                    <option value="nate.com">nate.com</option> <!-- 옵션 설정 -->
                </select> <!-- 이메일 도메인 선택 끝 -->
            </div> <!-- email-group 클래스 div 끝 -->
            전화번호: <input type="text" name="phoneNumber" required> <!-- 전화번호 입력 필드 -->
            주소: <input type="text" name="address" required> <!-- 주소 입력 필드 -->
            <input type="submit" value="등록"> <!-- 제출 버튼 -->
            <input type="button" value="취소" onclick="history.back()"> <!-- 취소 버튼, 클릭 시 이전 페이지로 이동 -->
            <br>
        </form> <!-- 폼 끝 -->
    </section> <!-- section 태그 끝 -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일을 include -->

</body> <!-- body 태그 끝 -->

</html> <!-- HTML 끝 -->
