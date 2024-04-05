<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>게시글 조회</title>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="viewOneToOne.css?after">
</head>
<body>
	<!-- 헤더 섹션: 여행사 이름 표시 -->
	<header>
		<h1>NH 여행</h1>
	</header>

	<!-- 네비게이션 섹션: 홈, 여행지별 링크 및 로그인/회원가입/마이페이지 등의 링크 -->
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
        // 세션에서 사용자 이름과 역할을 가져옴
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        // 사용자가 로그인하지 않은 경우 로그인과 회원가입 링크 표시
        if (username == null) { 
        %>
			<a href="Login.jsp">로그인</a> <a href="Register.jsp">회원가입</a> <a
				href="tripreview.jsp">여행후기</a> <a href="OneToOne.jsp">1:1문의</a>
			<% } else { %>
			<!-- 사용자가 로그인한 경우 -->
			<a href="<%= "admin".equals(role) ? "Admin.jsp" : "MyPage.jsp" %>">
				<%= username %>님의 마이페이지
			</a> <a href="<%= "admin".equals(role) ? "Admin.jsp" : "Cart.jsp" %>">
				장바구니 </a> <a href="tripreview.jsp">여행후기</a> <a href="OneToOne.jsp">1:1문의</a>
			<a href="LogoutServlet">로그아웃</a>
			<% } %>
		</div>

	</nav>
	
	<!-- 섹션: 게시글 상세 내용 표시 -->
	<section>
		<div class="container">
			<% 
            // 세션이 존재하면 사용자 이름 가져옴
            if (session != null) {
                username = (String) session.getAttribute("username");
            }

            // 게시글 ID를 파라미터에서 가져옴
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                // MySQL 드라이버 로드 및 데이터베이스 연결
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

                // 게시글 조회수 증가
                String updateQuery = "UPDATE onetooneboard SET viewCount = viewCount + 1 WHERE id = ?";
                PreparedStatement updatePst = con.prepareStatement(updateQuery);
                updatePst.setInt(1, id);
                updatePst.executeUpdate();

                // 게시글 내용 조회
                String selectQuery = "SELECT * FROM onetooneboard WHERE id = ?";
                PreparedStatement selectPst = con.prepareStatement(selectQuery);
                selectPst.setInt(1, id);
                ResultSet rs = selectPst.executeQuery();

                if (rs.next()) {
                    String author = rs.getString("author");

                    // 작성자 또는 ADMIN 역할 사용자만 게시글을 볼 수 있음
                    if (username != null && (username.equals(author) || role.equals("admin"))) {
        %>
			<h1>
				제목:
				<%= rs.getString("title") %></h1>
			<div style="display: flex; justify-content: space-between; border: 1px solid #ddd; padding: 10px; border-radius: 5px;">
				<p>
					작성자:
					<%= rs.getString("author") %></p>
				<p>
					조회수:
					<%= rs.getInt("viewCount") %></p>
			</div>
			<p>
				작성일:
				<%= rs.getDate("date") %></p>
			<hr>
			<p>
				내용:
				<%= rs.getString("content") %></p>

			<div style="display: flex; justify-content: space-between;">
				<button type="button" onclick="goBack()">목록으로 돌아가기</button>
				<div>
					<button type="button"
						onclick="location.href='editOneToOne.jsp?id=<%= id %>'">수정</button>
					<button type="button" onclick="deletePost()">삭제</button>
				</div>
			</div>
			<% 
                    } else {
        %>
			<!-- 작성자 또는 ADMIN 역할이 아닌 경우 경고창 출력 후 뒤로 이동 -->
			<script>
                            alert('작성자의 권한이 없으면 볼수 없습니다.');
                            history.back();
                        </script>
			<% 
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
		</div>
	</section>
	<jsp:include page="footer.jsp" />

	<!-- 스크립트: 게시글 삭제 및 뒤로 가기 기능 구현 -->
	<script>
        function deletePost() {
            var confirmDelete = confirm('선택한 게시물을 삭제하시겠습니까?');
            if (confirmDelete) {
                var form = document.createElement('form');
                form.method = 'post';
                form.action = 'DeleteOneToOneServlet';
                var hiddenField = document.createElement('input');
                hiddenField.type = 'hidden';
                hiddenField.name = 'id';
                 hiddenField.value = '<%=id%>';
                form.appendChild(hiddenField);
                document.body.appendChild(form);
                form.submit();
            }
        }

        function goBack() {
            var userRole = '<%= session.getAttribute("role") %>';
            var destinationURL;

            if (userRole === 'USER') {
                destinationURL = 'OneToOne.jsp';
            } else if (userRole === 'admin') {
                destinationURL = 'EnquiryAdmin.jsp';
            } else {
                // 다른 역할이나 상황에 따라 처리 필요
                destinationURL = 'OneToOne.jsp';
            }

            location.href = destinationURL;
        }
    </script>
    <jsp:include page="footer.jsp" />
</body>
</html>