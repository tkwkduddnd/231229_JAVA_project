package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TripReviewServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class TripReviewServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 TripReviewServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    public TripReviewServlet() { // 기본 생성자 정의
        super(); // 부모 클래스인 HttpServlet의 생성자 호출
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP GET 요청을 처리하는 메소드
        try {
            Class.forName("com.mysql.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결
            Statement stmt = conn.createStatement(); // Statement 객체 생성
            String sql = "SELECT * FROM InquiryBoard"; // "InquiryBoard" 테이블의 모든 데이터를 가져오는 SQL 쿼리문
            ResultSet rs = stmt.executeQuery(sql); // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장
            request.setAttribute("resultset", rs); // "resultset"이라는 이름으로 ResultSet 객체를 request 객체에 저장
            request.getRequestDispatcher("/tripreview.jsp").forward(request, response); // "tripreview.jsp" 페이지로 포워드
        } catch (Exception e) { // Exception 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        doGet(request, response); // HTTP GET 요청을 처리하는 메소드를 호출
    }
}
