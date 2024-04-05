<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어 -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 viewport 설정 -->
    <title>계정 탈퇴</title> <!-- 웹페이지 제목 설정 -->
    <link rel="stylesheet" type="text/css" href="deleteAccount.css?after"> <!-- deleteAccount.css 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
    <script> <!-- 스크립트 시작 -->
        function confirmPassword() { // 비밀번호 확인 함수
            var enteredPassword = document.getElementById("password").value; // 입력된 비밀번호 가져오기

            // 비밀번호가 입력되지 않았을 경우
            if (!enteredPassword.trim()) {
                alert("비밀번호를 입력해주세요.");
                return;
            }

            // Ajax를 사용하여 서버에 비밀번호 확인 요청
            var xhr = new XMLHttpRequest(); // XMLHttpRequest 객체 생성
            xhr.onreadystatechange = function () { // readystatechange 이벤트에 대한 이벤트 핸들러 설정
                if (xhr.readyState == 4 && xhr.status == 200) { // 통신이 완료되고 HTTP 상태 코드가 정상일 때
                    var response = xhr.responseText; // 응답 텍스트 가져오기
                    if (response.trim() === "true") { // 비밀번호 확인 완료 시
                        // "탈퇴" 버튼 활성화
                        document.getElementById("withdrawalBtn").disabled = false;
                        alert("비밀번호가 일치합니다.");
                    } else { // 비밀번호가 일치하지 않을 경우
                        // "탈퇴" 버튼 비활성화
                        document.getElementById("withdrawalBtn").disabled = true;
                        alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
                    }
                }
            };

            xhr.open("POST", "CheckPasswordServlet", true); // POST 방식으로 CheckPasswordServlet에 요청
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // 요청 헤더 설정
            xhr.send("password=" + enteredPassword); // 요청 보내기
        }

        function confirmWithdrawal() { // 탈퇴 확인 함수
            var confirmed = confirm("정말 탈퇴하시겠습니까?"); // 확인창 표시
            if (confirmed) { // 확인 버튼을 눌렀을 경우
                // 탈퇴 서블릿 호출
                document.forms["deleteForm"].submit(); // deleteForm 제출
            }
        }
    </script> <!-- 스크립트 끝 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->
    <div class="container"> <!-- container 클래스 div 시작 -->
        <h2>계정 탈퇴</h2> <!-- 섹션 제목 설정 -->
        <form id="deleteForm" action="DeleteAccountServlet" method="post"> <!-- 계정 탈퇴를 위한 form 태그 시작, post 방식 -->
            <label for="password">비밀번호</label> <!-- label 태그를 사용하여 input에 라벨 지정 -->
            <input type="password" id="password" name="password" required> <!-- 필수 입력 비밀번호 input -->
            <button type="button" onclick="confirmPassword()">비밀번호 확인</button> <!-- 비밀번호 확인 버튼, 클릭 시 confirmPassword 함수 호출 -->
            <button type="button" onclick="confirmWithdrawal()" id="withdrawalBtn" disabled>탈퇴</button> <!-- 탈퇴 버튼, 클릭 시 confirmWithdrawal 함수 호출, 기본적으로 비활성화 -->
        </form> <!-- form 태그 끝 -->
    </div> <!-- container 클래스 div 끝 -->
</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
