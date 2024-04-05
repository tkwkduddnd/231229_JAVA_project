<%@ page contentType="text/html; charset=utf-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->

<header> <!-- header 태그 시작 -->
    <h1>NH 여행</h1> <!-- 웹페이지 제목 설정 -->
</header> <!-- header 태그 끝 -->

<nav> <!-- nav 태그 시작 -->
    <div class="left-nav"> <!-- left-nav 클래스 div 시작 -->
        <a href="Home.jsp">홈</a> <!-- '홈' 페이지로 이동하는 링크 -->
        <a href="Europe.jsp">유 럽</a> <!-- '유 럽' 페이지로 이동하는 링크 -->
        <a href="SoutheastAsia.jsp">동남아</a> <!-- '동남아' 페이지로 이동하는 링크 -->
        <a href="Japan.jsp">일 본</a> <!-- '일 본' 페이지로 이동하는 링크 -->
        <a href="China.jsp">중 국</a> <!-- '중 국' 페이지로 이동하는 링크 -->
        <a href="USA.jsp">미 국</a> <!-- '미 국' 페이지로 이동하는 링크 -->
        <a href="Honeymoon.jsp">허니문</a> <!-- '허니문' 페이지로 이동하는 링크 -->
        <a href="CompanyIntroduction.jsp">회사 소개</a> <!-- '회사 소개' 페이지로 이동하는 링크 -->
    </div> <!-- left-nav 클래스 div 끝 -->

    <div class="right-nav"> <!-- right-nav 클래스 div 시작 -->
        <% 
        // 세션에서 사용자 이름과 역할 가져오기
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        // 사용자 이름이 null인 경우
        if (username == null) { 
        %>
        <a href="Login.jsp">로그인</a> <!-- '로그인' 페이지로 이동하는 링크 -->
        <a href="Register.jsp">회원가입</a> <!-- '회원가입' 페이지로 이동하는 링크 -->
        <a href="tripreview.jsp">여행후기</a> <!-- '여행후기' 페이지로 이동하는 링크 -->
        <a href="OneToOne.jsp">1:1문의</a> <!-- '1:1문의' 페이지로 이동하는 링크 -->
        <% } else { %>
        <a href="<%= "admin".equals(role) ? "Admin.jsp" : "MyPage.jsp" %>">
            <%= username %>님의 마이페이지 <!-- 'username님의 마이페이지' 라벨, 역할이 'admin'이면 'Admin.jsp'로 이동, 아니면 'MyPage.jsp'로 이동 -->
        </a> 
        <a href="<%= "admin".equals(role) ? "Admin.jsp" : "Cart.jsp" %>">
            장바구니 <!-- '장바구니' 라벨, 역할이 'admin'이면 'Admin.jsp'로 이동, 아니면 'Cart.jsp'로 이동 -->
        </a> 
        <a href="tripreview.jsp">여행후기</a> <!-- '여행후기' 페이지로 이동하는 링크 -->
        <a href="OneToOne.jsp">1:1문의</a> <!-- '1:1문의' 페이지로 이동하는 링크 -->
        <a href="LogoutServlet">로그아웃</a> <!-- '로그아웃' 링크, 클릭하면 'LogoutServlet'으로 이동 -->
        <% } %>
    </div> <!-- right-nav 클래스 div 끝 -->
</nav> <!-- nav 태그 끝 -->
