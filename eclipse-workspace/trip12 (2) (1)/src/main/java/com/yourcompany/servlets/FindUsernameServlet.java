package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 입출력 예외 처리를 위한 라이브러리
import java.io.PrintWriter; // 출력 스트림을 위한 라이브러리
import java.sql.Connection; // 데이터베이스 연결을 위한 라이브러리
import java.sql.DriverManager; // 데이터베이스 드라이버 관리를 위한 라이브러리
import java.sql.PreparedStatement; // SQL 쿼리를 실행하기 위한 라이브러리
import java.sql.ResultSet; // SQL 쿼리 결과를 저장하기 위한 라이브러리
import java.sql.SQLException; // SQL 예외 처리를 위한 라이브러리

import javax.servlet.ServletException; // 서블릿 예외 처리를 위한 라이브러리
import javax.servlet.annotation.WebServlet; // 서블릿 연결을 위한 어노테이션 라이브러리
import javax.servlet.http.HttpServlet; // HttpServlet 클래스를 위한 라이브러리
import javax.servlet.http.HttpServletRequest; // HTTP 요청을 처리하기 위한 라이브러리
import javax.servlet.http.HttpServletResponse; // HTTP 응답을 처리하기 위한 라이브러리

@WebServlet("/FindUsernameServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/FindUsernameServlet" 요청을 하면 이 서블릿이 처리
public class FindUsernameServlet extends HttpServlet { // HttpServlet을 상속받는 FindUsernameServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) // HTTP POST 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        response.setContentType("text/html;charset=UTF-8"); // 응답의 컨텐츠 타입을 HTML로, 문자 인코딩을 UTF-8로 설정
        PrintWriter out = response.getWriter(); // 응답을 위한 PrintWriter 객체 생성

        String fullName = request.getParameter("fullName"); // 요청에서 fullName 파라미터 값을 가져옴
        String email = request.getParameter("email"); // 요청에서 email 파라미터 값을 가져옴
        String birthday = request.getParameter("birthday"); // 요청에서 birthday 파라미터 값을 가져옴

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 데이터베이스에서 아이디 조회
            String query = "SELECT username FROM users WHERE fullName=? AND email=? AND birthday=?"; // 아이디를 조회하는 SQL 쿼리
            PreparedStatement pst = con.prepareStatement(query); // SQL 쿼리를 실행할 PreparedStatement 객체 생성
            pst.setString(1, fullName); // SQL 쿼리의 첫 번째 인자 값으로 fullName 설정
            pst.setString(2, email); // SQL 쿼리의 두 번째 인자 값으로 email 설정
            pst.setString(3, birthday); // SQL 쿼리의 세 번째 인자 값으로 birthday 설정

            ResultSet rs = pst.executeQuery(); // SQL 쿼리를 실행하고 결과를 ResultSet 객체에 저장
            if (rs.next()) { // ResultSet 객체에 다음 행이 있으면
                // 아이디 출력
                String username = rs.getString("username"); // ResultSet 객체에서 username 값을 가져옴
                out.println("<script>alert('회원님의 아이디는: " + username + "입니다.'); window.location.href='Login.jsp';</script>"); // 아이디를 출력하고 로그인 페이지로 리다이렉트
            } else {
                out.println("<script>alert('입력한 정보로 조회된 회원이 없습니다.'); window.location.href='FindUsername.jsp';</script>"); // 회원이 없다는 메시지를 출력하고 아이디 찾기 페이지로 리다이렉트
            }

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException이나 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
