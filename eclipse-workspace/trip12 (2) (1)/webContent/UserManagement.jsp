<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.yourcompany.servlets.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 관리</title>
    <!-- Google 폰트 및 스타일시트 연결 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <!-- 공통 스타일시트 및 ProductList.css 연결 -->
    <link rel="stylesheet" type="text/css" href="Common.css">
    <link rel="stylesheet" type="text/css" href="ProductList.css?after">
    <!-- JavaScript 함수 정의 -->
    <script>
        // 확인 및 알림 함수 정의
        function confirmAndAlert(confirmationMessage, message) {
            if (confirm(confirmationMessage)) {
                alert(message);
                return true; // 폼 제출
            }
            return false; // 폼 제출 취소
        }
    </script>
</head>
<body>

    <!-- 관리자 네비게이션을 포함한 페이지 상단 부분 -->
    <jsp:include page="AdminNav.jsp" />

    <!-- 회원 관리 섹션 -->
    <section>
        <!-- 관리자 콘텐츠 영역 -->
        <div class="admin-content">
            <h2>회원 관리</h2>

            <!-- 회원 검색 폼 -->
            <form action="UserManagementServlet" method="post">
                <label for="search">이름으로 검색:</label>
                <input type="text" name="search" id="search">
                <input type="submit" value="검색">
            </form>

            <!-- 회원 목록 테이블 -->
            <table border="1">
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>성별</th>
                    <th>생년월일</th>
                    <th>삭제</th>
                </tr>

                <% 
                    // Servlet에서 전달받은 회원 목록을 가져와서 표시
                    List<User> userList = (List<User>)request.getAttribute("userList");
                    if (userList != null && !userList.isEmpty()) {
                        for (User user : userList) {
                %>
                            <!-- 회원 정보 행 -->
                            <tr>
                                <td><%= user.getUsername() %></td>
                                <td><%= user.getFullName() %></td>
                                <td><%= user.getGender() %></td>
                                <td><%= user.getBirthday() %></td>
                                <!-- 회원 삭제 폼 -->
                                <td>
                                    <form action="DeleteUserServlet" method="post" onsubmit="return confirmAndAlert('정말로 삭제하시겠습니까?', '삭제 완료하였습니다.');">
                                        <input type="hidden" name="userId" value="<%= user.getId() %>">
                                        <input type="submit" value="삭제">
                                    </form>
                                </td>
                            </tr>
                <% 
                        }
                    } else if (request.getAttribute("searchNotFound") != null) {
                %>
                        <!-- 검색 결과 없는 경우 메시지 표시 -->
                        <tr>
                            <td colspan="5">검색 결과가 없습니다.</td>
                        </tr>
                <%
                    }
                %>
            </table>
        </div>
    </section>

    <!-- 푸터 영역 -->
    <jsp:include page="footer.jsp" />

</body>
</html>
