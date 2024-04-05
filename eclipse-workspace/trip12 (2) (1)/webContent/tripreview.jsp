<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행사 홈페이지</title>
    <!-- Google 폰트 및 스타일시트 연결 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <!-- 여행 후기 스타일시트 연결 -->
    <link rel="stylesheet" href="tripreview.css?after">

    <!-- jQuery 라이브러리 연결 -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function () {
            // 버튼 이벤트 리스너 등록
            $(".button-left").on("click", function () {
                showWriteForm();
            });

            // 글쓰기 폼 표시 함수
            function showWriteForm() {
                $.ajax({
                    type: "GET",
                    url: "Write.jsp",
                    success: function (data) {
                        // 글쓰기 폼 표시
                        document.getElementById('writeForm').innerHTML = data;
                        document.getElementById('writeForm').style.display = 'block';

                        // 글 목록 숨기기
                        document.getElementById('postList').style.display = 'none';

                        // 글쓰기 폼 제출 버튼 이벤트 리스너 등록
                        document.getElementById('submitWriteForm').addEventListener('click', function () {
                            submitWriteForm();
                        });
                    },
                    error: function () {
                        alert("Write.jsp 로드에 실패했습니다.");
                    }
                });
            }

            // 글쓰기 폼 제출 함수
            function submitWriteForm() {
                // 폼 제출 로직 처리
                // 필요에 따라 AJAX를 사용하여 서버로 폼 데이터를 전송하거나 다른 방법을 사용할 수 있음

                // 폼 제출 후, 글 목록을 갱신
                refreshPostList();

                // 선택적으로 글쓰기 폼을 숨기고 글 목록을 다시 표시할 수 있음
                document.getElementById('writeForm').style.display = 'none';
                document.getElementById('postList').style.display = 'block';
            }

            // 글 목록 갱신 함수
            function refreshPostList() {
                // 최신 데이터를 가져와서 글 목록을 갱신하는 로직을 구현
                // AJAX 호출을 사용하여 최신 데이터를 가져오고 글 목록을 업데이트할 수 있음
            }

            // 글쓰기 폼 닫기 함수
            function closeWriteForm() {
                // 글쓰기 폼 숨기기
                document.getElementById('writeForm').style.display = 'none';

                // 글 목록 표시
                document.getElementById('postList').style.display = 'block';
            }
        });
    </script>
</head>
<body>
    <!-- 헤더 -->
	<header>
		<h1>NH 여행</h1>
	</header>

    <!-- 네비게이션 -->
	<nav>
		<div class="left-nav">
			<a href="Home.jsp">홈</a> <a href="Europe.jsp">유 럽</a> <a
				href="SoutheastAsia.jsp">동남아</a> <a href="Japan.jsp">일 본</a> <a
				href="China.jsp">중 국</a> <a href="USA.jsp">미 국</a> <a
				href="Honeymoon.jsp">허니문</a> <a href="CompanyIntroduction.jsp">회사
				소개</a>
		</div>

		<div class="right-nav">
            <% 
                // 세션에서 사용자 정보 가져오기
                String username = (String) session.getAttribute("username");
                String role = (String) session.getAttribute("role");

                // 로그인 여부에 따라 네비게이션 메뉴 표시
                if (username == null) { 
            %>
                <a href="Login.jsp">로그인</a> 
                <a href="Register.jsp">회원가입</a> 
                <a href="tripreview.jsp">여행후기</a> 
                <a href="OneToOne.jsp">1:1문의</a>
            <% } else { %>
                <a href="<%= "admin".equals(role) ? "Admin.jsp" : "MyPage.jsp" %>">
                    <%= username %>님의 마이페이지
                </a> 
                <a href="<%= "admin".equals(role) ? "Admin.jsp" : "Cart.jsp" %>">
                    장바구니 
                </a> 
                <a href="tripreview.jsp">여행후기</a> 
                <a href="OneToOne.jsp">1:1문의</a>
                <a href="LogoutServlet">로그아웃</a>
            <% } %>
		</div>
	</nav>

    <!-- 여행 후기 섹션 -->
	<section id="postList">
		<h2>여행 후기</h2>
		<!-- 여행 후기 목록 테이블 -->
		<table class="review-table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
            <!-- 여행 후기 데이터 조회 및 출력 -->
			<%
                try {
                    // JDBC를 사용하여 데이터베이스에서 여행 후기 데이터 조회
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

                    String query = "SELECT * FROM board ORDER BY id DESC"; // 내림차순 정렬
                    PreparedStatement pst = con.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();

                    List<Object[]> resultList = new ArrayList<>(); // Object 배열을 사용하는 List

                    while (rs.next()) {
                        Object[] rowData = {rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDate("date"), rs.getInt("viewCount")};
                        resultList.add(rowData);
                    }
                    int postNumber = 1; // 출력 시 사용할 글 번호

                    // 최신 글부터 역순으로 출력
                    for (int i = resultList.size() - 1; i >= 0; i--) {
                        Object[] reversedRs = resultList.get(i);

                        String title = (String) reversedRs[1];
                        int viewCount = (int) reversedRs[4];
                        String hitMarker = "";

                        // 조회수에 따라 Hot 마커 표시
                        if (viewCount >= 15) {
                            hitMarker = " <span class='hot'>Hit</span>";
                        }

                        // 글 목록 출력
                        out.println("<tr>");
                        out.println("<td>" + postNumber++ + "</td>");
                        out.println("<td><a href='view.jsp?id=" + reversedRs[0] + "'>" + title + "</a>" + hitMarker + "</td>");
                        out.println("<td>" + reversedRs[2] + "</td>");
                        out.println("<td>" + reversedRs[3] + "</td>");
                        out.println("<td>" + viewCount + "</td>");
                        out.println("</tr>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
		</table>

		<div class="button-container">
            <!-- 로그인 상태에 따라 글쓰기 버튼 표시 -->
			<% if (username != null) { %>
                <button class="button-left" type="button" onclick="showWriteForm()">글쓰기</button>
			<% } else { %>
                <!-- 로그인되지 않은 경우 로그인 페이지로 이동하는 버튼 표시 -->
                <button class="button-left" type="button" onclick="redirectToLogin()">글쓰기</button>
			<% } %>
		</div>
	</section>

    <!-- 글쓰기 폼 -->
	<div id="writeForm" style="display: none;">
        <!-- Write.jsp의 내용을 여기에 삽입 -->
	</div>

    <!-- 푸터 및 게시글 삭제 성공 메시지 처리 -->
	<jsp:include page="footer.jsp" />

	<script>
        // 글쓰기 폼 표시 함수
        function showWriteForm() {
            $.ajax({
                type: "GET",
                url: "Write.jsp",
                success: function (data) {
                    document.getElementById('writeForm').innerHTML = data;
                    document.getElementById('writeForm').style.display = 'block';
                },
                error: function () {
                    alert("Write.jsp 로드에 실패했습니다.");
                }
            });
        }

        // 로그인 페이지로 이동 함수
        function redirectToLogin() {
            if (confirm('로그인 후 사용 가능합니다. 로그인 페이지로 이동하시겠습니까?')) {
                location.href = 'Login.jsp';
            }
        }
    </script>

    <!-- 게시글 삭제 성공 메시지 처리 -->
	<% 
    String message = request.getParameter("message");
    if (message != null && message.equals("deleteSuccess")) {
    %>
    <script>
        alert('게시글이 정상적으로 삭제되었습니다.');
    </script>
    <%
    }
    %>
</body>
</html>
