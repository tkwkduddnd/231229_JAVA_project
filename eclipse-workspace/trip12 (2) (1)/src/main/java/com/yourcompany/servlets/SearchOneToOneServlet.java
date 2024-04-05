package com.yourcompany.servlets; // 패키지 선언

import com.yourcompany.servlets.OneToOneDTO; // OneToOneDTO 클래스 임포트
import javax.servlet.*; // 필요한 클래스들을 임포트
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchOneToOneServlet", value = "/SearchOneToOneServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class SearchOneToOneServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 SearchOneToOneServlet 클래스 선언
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP GET 요청을 처리하는 메소드
        String search = request.getParameter("search"); // 요청 파라미터 중 "search" 값을 가져와 search 변수에 저장
        List<OneToOneDTO> list = new ArrayList<>(); // OneToOneDTO 객체를 저장할 ArrayList 객체 생성

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM onetooneboard WHERE title LIKE ? ORDER BY id DESC"); // 제목이 search를 포함하는 게시글을 검색하는 SQL 쿼리문
            pstmt.setString(1, "%" + search + "%"); // 첫번째 인자에 search 값을 설정
            ResultSet rs = pstmt.executeQuery(); // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장

            while (rs.next()) { // ResultSet 객체에 다음 행이 있는 동안
                OneToOneDTO dto = new OneToOneDTO(); // OneToOneDTO 객체 생성
                dto.setId(rs.getInt("id")); // id 값을 설정
                dto.setTitle(rs.getString("title")); // title 값을 설정
                dto.setAuthor(rs.getString("author")); // author 값을 설정
                dto.setDate(rs.getTimestamp("date")); // date 값을 설정
                dto.setViewCount(rs.getInt("viewCount")); // viewCount 값을 설정
                list.add(dto); // list에 dto 추가
            }
            rs.close(); // ResultSet 객체 닫기
            pstmt.close(); // PreparedStatement 객체 닫기
            conn.close(); // Connection 객체 닫기
        } catch (Exception e) { // Exception 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        HttpSession session = request.getSession(); // HttpSession 객체 생성
        session.setAttribute("searchResult", list); // "searchResult"이라는 이름으로 list를 세션에 저장
        response.sendRedirect("OneToOne.jsp"); // "OneToOne.jsp" 페이지로 리다이렉트
    }
}
