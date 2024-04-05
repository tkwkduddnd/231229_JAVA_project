<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<%@ page import="java.sql.*"%> <!-- java.sql 패키지의 모든 클래스 임포트 -->
<%@ page import="com.yourcompany.servlets.OneToOneDTO"%> <!-- com.yourcompany.servlets.OneToOneDTO 클래스 임포트 -->
<%@ page import="java.util.List"%> <!-- java.util.List 클래스 임포트 -->

<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
<meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
<title>1:1 문의</title> <!-- 웹페이지 제목 설정 -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 연결 -->
<link rel="stylesheet" href="OneToOne.css?after"> <!-- OneToOne.css 스타일시트 연결 -->


<script> <!-- 스크립트 시작 -->
    // formSection 보여주고, tableSection 숨기는 함수
    function showForm() {
        document.getElementById('tableSection').style.display = 'none'; // tableSection ID를 가진 요소를 숨김
        document.getElementById('formSection').style.display = 'block'; // formSection ID를 가진 요소를 보여줌
    }
</script> <!-- 스크립트 끝 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->
    <header> <!-- header 태그 시작 -->
        <h1>NH 여행</h1> <!-- 제목 설정 -->
    </header> <!-- header 태그 끝 -->

    <nav> <!-- nav 태그 시작 -->
        <div class="left-nav"> <!-- left-nav 클래스 div 시작 -->
            <a href="Home.jsp">홈</a> <a href="Europe.jsp">유 럽</a> <a
                href="SoutheastAsia.jsp">동남아</a> <a href="Japan.jsp">일 본</a> <a
                href="China.jsp">중 국</a> <a href="USA.jsp">미 국</a> <a
                href="Honeymoon.jsp">허니문</a> <a href="CompanyIntroduction.jsp">회사
                소개</a> <!-- 각 페이지로 이동하는 링크 -->
        </div> <!-- left-nav 클래스 div 끝 -->
        <div class="right-nav"> <!-- right-nav 클래스 div 시작 -->
            <% 
            // 세션에서 사용자 이름과 역할 가져오기
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            // 사용자 이름이 null이면
            if (username == null) { 
            %>
            <a href="Login.jsp">로그인</a> <a href="Register.jsp">회원가입</a> <a
                href="tripreview.jsp">여행후기</a> <a href="OneToOne.jsp">1:1문의</a> <!-- 로그인, 회원가입, 여행후기, 1:1문의 페이지로 이동하는 링크 -->
            <% } else { %> <!-- 사용자 이름이 null이 아니면 -->
            <a href="<%= "admin".equals(role) ? "Admin.jsp" : "MyPage.jsp" %>">
                <%= username %>님의 마이페이지 <!-- 'username님의 마이페이지' 라벨, 역할이 'admin'이면 'Admin.jsp'로 이동, 아니면 'MyPage.jsp'로 이동 -->
            </a> <a href="<%= "admin".equals(role) ? "Admin.jsp" : "Cart.jsp" %>">장바구니 </a> <a href="tripreview.jsp">여행후기</a> <a href="OneToOne.jsp">1:1문의</a>
            <a href="LogoutServlet">로그아웃</a> <!-- 로그아웃 링크, 클릭하면 'LogoutServlet'으로 이동 -->
            <% } %>
        </div> <!-- right-nav 클래스 div 끝 -->
    </nav> <!-- nav 태그 끝 -->
    <section id="tableSection"> <!-- tableSection ID를 가진 section 태그 시작 -->
        <h2>1:1 문의</h2> <!-- 제목 설정 -->
        <form action="SearchOneToOneServlet" method="get"> <!-- 폼 시작, 제출 시 SearchOneToOneServlet으로 GET 요청 보냄 -->
            <input type="text" name="search" placeholder="검색어를 입력하세요."> <!-- 검색어 입력 필드 -->
            <input type="submit" value="검색"> <!-- 제출 버튼, 라벨은 '검색' -->
        </form> <!-- 폼 끝 -->
        <table class = "OTO-table"> <!-- OTO-table 클래스 테이블 시작 -->
            <tr> <!-- 행 시작 -->
                <th>번호</th> <!-- 헤더 셀, 라벨은 '번호' -->
                <th>제목</th> <!-- 헤더 셀, 라벨은 '제목' -->
                <th>작성자</th> <!-- 헤더 셀, 라벨은 '작성자' -->
                <th>날짜</th> <!-- 헤더 셀, 라벨은 '날짜' -->
                <th>조회수</th> <!-- 헤더 셀, 라벨은 '조회수' -->
            </tr> <!-- 행 끝 -->

            <% 
            // 세션에서 검색 결과 가져오기
            List<OneToOneDTO> searchResult = null;
            if(session != null){
                searchResult = (List<OneToOneDTO>) session.getAttribute("searchResult");
                session.removeAttribute("searchResult");
            }

            // DB 연결과 쿼리 실행을 위한 변수 선언
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            
try {
    // MySQL DB 드라이버 로드
    Class.forName("com.mysql.cj.jdbc.Driver");
    // DB 연결 설정
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");
    // Statement 객체 생성
    stmt = conn.createStatement();

    // searchResult가 null인 경우, DB에서 질의 수행
    if(searchResult == null){
        rs = stmt.executeQuery("SELECT * FROM onetooneboard ORDER BY id ASC");
    } else {
        rs = null;
    }

    // searchResult가 null이 아닌 경우, searchResult의 내용을 테이블에 표시
    if(searchResult != null){
        for(OneToOneDTO dto : searchResult){
%>
    <tr>
        <td><%= dto.getId() %></td> <!-- 셀, dto의 id 출력 -->
        <td><a href="viewOneToOne.jsp?id=<%= dto.getId() %>"><%= dto.getTitle() %></a></td> <!-- 셀, dto의 title 출력, 클릭 시 viewOneToOne.jsp 페이지로 이동 -->
        <td><%= dto.getAuthor() %></td> <!-- 셀, dto의 author 출력 -->
        <td><%= dto.getDate() %></td> <!-- 셀, dto의 date 출력 -->
        <td><%= dto.getViewCount() %></td> <!-- 셀, dto의 viewCount 출력 -->
    </tr>
    <%
        }
    } else {
        // searchResult가 null인 경우, DB 질의 결과를 테이블에 표시
        while(rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("id") %></td> <!-- 셀, id 컬럼의 값 출력 -->
        <td><a href="viewOneToOne.jsp?id=<%= rs.getInt("id") %>"><%= rs.getString("title") %></a></td> <!-- 셀, title 컬럼의 값 출력, 클릭 시 viewOneToOne.jsp 페이지로 이동 -->
        <td><%= rs.getString("author") %></td> <!-- 셀, author 컬럼의 값 출력 -->
        <td><%= rs.getTimestamp("date") %></td> <!-- 셀, date 컬럼의 값 출력 -->
        <td><%= rs.getInt("viewCount") %></td> <!-- 셀, viewCount 컬럼의 값 출력 -->
    </tr>
    <%
        }
    }
} catch(Exception e) {
    // 예외 처리, 스택 트레이스 출력
    e.printStackTrace();
} finally {
    // 리소스 해제
    try {
        if (rs != null) rs.close(); // ResultSet 객체가 null이 아닌 경우, ResultSet 객체 닫기
        if (stmt != null) stmt.close(); // Statement 객체가 null이 아닌 경우, Statement 객체 닫기
        if (conn != null) conn.close(); // Connection 객체가 null이 아닌 경우, Connection 객체 닫기
    } catch (SQLException e) {
        // 예외 처리, 스택 트레이스 출력
        e.printStackTrace();
    }
}
%>
</table> <!-- 테이블 끝 -->
<div style="text-align: right;"> <!-- 오른쪽 정렬 div 시작 -->
    <%  
    // 사용자 이름이 null이 아닌 경우, 글쓰기 버튼을 보여줌
    if (username != null) {  
    %>
    <button onclick="showForm()">글쓰기</button> <!-- '글쓰기' 버튼, 클릭 시 showForm 함수 실행 -->
    <%
    } 
%>
</div> <!-- 오른쪽 정렬 div 끝 -->
</section> <!-- tableSection ID를 가진 section 태그 끝 -->

<section id="formSection" style="display: none;"> <!-- formSection ID를 가진 section 태그 시작, 초기 상태는 숨김 -->
    <h2 style="margin-bottom: 20px;">1:1 문의 글쓰기</h2> <!-- 제목 설정 -->
    <form action="WriteOneToOneServlet" method="post"
        style="max-width: 600px; margin: 0 auto;"> <!-- 폼 시작, 제출 시 WriteOneToOneServlet으로 POST 요청 보냄 -->
        <label for="title"
            style="display: block; margin-bottom: 10px; font-weight: bold;">제목</label> <!-- '제목' 라벨 -->
        <input type="text" id="title" name="title" required
            style="width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;"> <!-- 제목 입력 필드 -->

        <label for="content"
            style="display: block; margin-bottom: 10px; font-weight: bold;">내용</label> <!-- '내용' 라벨 -->
        <textarea id="content" name="content" rows="8" required
            style="width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box;"></textarea> <!-- 내용 입력 필드 -->

        <input type="submit" value="제출"
            style="background-color: #333; color: white; border: none; padding: 10px 24px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; cursor: pointer; border-radius: 5px; transition-duration: 0.4s;"> <!-- 제출 버튼, 라벨은 '제출' -->
    </form> <!-- 폼 끝 -->
</section> <!-- formSection ID를 가진 section 태그 끝 -->
<jsp:include page="footer.jsp" /> <!-- footer.jsp 포함 -->
</body> <!-- body 태그 끝 -->
</html> <!-- HTML 끝 -->
            