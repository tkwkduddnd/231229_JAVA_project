<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새로운 비밀번호 설정</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="Common.css">
    <link rel="stylesheet" type="text/css" href="PasswordUpdate.css?after">
</head>
<body>

    <jsp:include page="Nav.jsp" />

    <section>
        <div class="password-update-form">
            <h2>새로운 비밀번호 설정</h2>
            <form action="UpdatePasswordServlet" method="post" onsubmit="showMessage()">
                <input type="hidden" name="username" value="${param.username}">
                <label for="newPassword">새로운 비밀번호:</label>
                <input type="password" id="newPassword" name="newPassword" required>

                <label for="confirmPassword">비밀번호 확인:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>

                <button type="submit">비밀번호 변경</button>
            </form>
        </div>
    </section>

    <script>
        function showMessage() {
            // 비밀번호 변경 성공 메시지를 알림창으로 표시
            alert('비밀번호가 성공적으로 업데이트되었습니다!');
            return true; // 폼 전송 허용
        }
    </script>

</body>
</html>
