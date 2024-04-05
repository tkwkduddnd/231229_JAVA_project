<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>비밀번호 변경</title> <!-- 웹페이지 제목 설정 -->
    <link rel="stylesheet" type="text/css" href="PasswordChange.css?after"> <!-- PasswordChange.css 스타일시트 연결 -->

    <script> <!-- 스크립트 시작 -->
        // 비밀번호 일치 여부 확인 함수
        function checkPasswordMatch() {
            var newPassword = document.getElementById("newPassword").value; // newPassword ID를 가진 요소의 값을 가져와 newPassword 변수에 저장
            var confirmPassword = document.getElementById("confirmPassword").value; // confirmPassword ID를 가진 요소의 값을 가져와 confirmPassword 변수에 저장
            var submitButton = document.getElementById("submit"); // submit ID를 가진 요소를 가져와 submitButton 변수에 저장
            if (newPassword != confirmPassword) { // newPassword와 confirmPassword가 일치하지 않으면
                alert("비밀번호가 일치하지 않습니다."); // '비밀번호가 일치하지 않습니다.'라는 경고창 띄움
                submitButton.disabled = true; // submitButton 비활성화
            } else { // newPassword와 confirmPassword가 일치하면
                alert("비밀번호가 일치합니다."); // '비밀번호가 일치합니다.'라는 경고창 띄움
                submitButton.disabled = false; // submitButton 활성화
            }
        }

        // 비밀번호 변경 확인 함수
        function confirmChange() {
            return confirm("비밀번호를 변경하시겠습니까?"); // '비밀번호를 변경하시겠습니까?'라는 확인창 띄우고, 확인 버튼을 클릭하면 true 반환, 취소 버튼을 클릭하면 false 반환
        }
    </script> <!-- 스크립트 끝 -->

</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->
    <div class="password-change-form"> <!-- password-change-form 클래스 div 시작 -->
        <h2>비밀번호 변경</h2> <!-- 제목 설정 -->
        <form action="PasswordChangeServlet" method="post" onsubmit="return confirmChange()"> <!-- 폼 시작, 제출 시 PasswordChangeServlet으로 POST 요청 보냄, 제출 전 confirmChange 함수 실행 -->
            <label for="newPassword">새 비밀번호</label> <!-- 새 비밀번호 라벨 -->
            <input type="password" id="newPassword" name="newPassword" required> <!-- 새 비밀번호 입력 필드, 필수 입력 -->

            <label for="confirmPassword">비밀번호 확인</label> <!-- 비밀번호 확인 라벨 -->
            <input type="password" id="confirmPassword" name="confirmPassword" required> <!-- 비밀번호 확인 입력 필드, 필수 입력 -->

            <button type="button" onclick="checkPasswordMatch()">확인</button> <!-- 확인 버튼, 클릭 시 checkPasswordMatch 함수 실행 -->
            <button type="submit" id="submit" disabled>변경</button> <!-- 제출 버튼, 라벨은 '변경', 비활성화 상태 -->
            <button type="button" onclick="location.href='MyPage.jsp'">취소</button> <!-- 취소 버튼, 클릭 시 MyPage.jsp로 이동 -->
        </form> <!-- 폼 끝 -->
    </div> <!-- password-change-form 클래스 div 끝 -->
</body> <!-- body 태그 끝 -->
</html> <!-- HTML 끝 -->
