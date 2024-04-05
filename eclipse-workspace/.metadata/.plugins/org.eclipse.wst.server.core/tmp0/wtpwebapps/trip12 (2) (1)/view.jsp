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
    <link rel="stylesheet" href="view.css?after">
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
            // 세션에서 사용자 정보를 가져옴
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
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebTrip", "root", "@tmvlzj12");

                // 게시글 조회수 증가
                String updateQuery = "UPDATE board SET viewCount = viewCount + 1 WHERE id = ?";
                PreparedStatement updatePst = con.prepareStatement(updateQuery);
                updatePst.setInt(1, id);
                updatePst.executeUpdate();

                // 게시글 내용 조회
                String selectQuery = "SELECT * FROM board WHERE id = ?";
                PreparedStatement selectPst = con.prepareStatement(selectQuery);
                selectPst.setInt(1, id);
                ResultSet rs = selectPst.executeQuery();

                if (rs.next()) {
                    String author = rs.getString("author");
            %>
            <!-- 게시글 제목 표시 -->
            <h1>
                제목:
                <%= rs.getString("title") %></h1>
            <!-- 게시글 작성자와 조회수 표시 -->
            <div>
                <p>
                    작성자:
                    <%= rs.getString("author") %></p>
                <p>
                    조회수:
                    <%= rs.getInt("viewCount") %></p>
            </div>
            <!-- 게시글 작성일 표시 -->
            <p>
                작성일:
                <%= rs.getDate("date") %></p>
            <hr>
            <!-- 게시글 내용 표시 -->
            <p>
                내용:
                <%= rs.getString("content") %></p>

            <!-- 버튼 그룹: 목록으로 돌아가기 버튼 및 수정, 삭제 버튼 -->
            <div class="button-group">
                <button class="custom-button1" type="button" onclick="goBack()">목록으로 돌아가기</button>
                <% if (username != null && username.equals(author)) { %>
                <!-- 작성자인 경우에만 수정, 삭제 버튼 표시 -->
                <div class="edit-delete">
                    <button class="custom-button2" type="button" onclick="location.href='edit.jsp?id=<%= id %>'">수정</button>
                    <button class="custom-button2" type="button" onclick="deletePost()">삭제</button>
                </div>
                <% } %>
            </div>
            <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
        </div>
    </section>
    <!-- 푸터 섹션: footer.jsp 페이지 포함 -->
    <jsp:include page="footer.jsp" />

    <!-- 스크립트: 게시글 삭제 및 뒤로 가기 기능 구현 -->
    <script>
        // 게시글 삭제 함수
        function deletePost() {
            var confirmDelete = confirm('선택한 게시물을 삭제하시겠습니까?');
            if (confirmDelete) {
                var form = document.createElement('form');
                form.method = 'post';
                form.action = 'DeleteServlet';
                var hiddenField = document.createElement('input');
                hiddenField.type = 'hidden';
                hiddenField.name = 'id';
                hiddenField.value = '<%=id%>';
                form.appendChild(hiddenField);
                document.body.appendChild(form);
                form.submit();
            }
        }

     // 한글: 사용자의 역할에 따라 돌아갈 목록 페이지를 결정하는 함수
        function goBack() {
            var userRole = '<%= session.getAttribute("role") %>';
            var destinationURL;

            if (userRole === 'USER') {
                destinationURL = 'tripreview.jsp';
            } else if (userRole === 'admin') {
                destinationURL = 'ReviewManage.jsp';
            } else {
                // 다른 역할이나 상황에 따라 처리 필요
                destinationURL = 'tripreview.jsp';
            }

            location.href = destinationURL;
        }
    </script>
    <!-- 푸터 섹션: footer.jsp 페이지 포함 -->
    <jsp:include page="footer.jsp" />
</body>
</html>