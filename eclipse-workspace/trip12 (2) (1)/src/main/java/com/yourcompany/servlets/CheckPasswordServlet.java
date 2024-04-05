package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 입출력 예외 처리를 위한 라이브러리
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
import javax.servlet.http.HttpSession; // HTTP 세션을 처리하기 위한 라이브러리

import org.mindrot.jbcrypt.BCrypt; // 비밀번호 암호화를 위한 라이브러리

@WebServlet("/CheckPasswordServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/CheckPasswordServlet" 요청을 하면 이 서블릿이 처리
public class CheckPasswordServlet extends HttpServlet { // HttpServlet을 상속받는 CheckPasswordServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) // HTTP POST 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정
        response.setContentType("text/plain;charset=UTF-8"); // 응답의 컨텐츠 타입을 일반 텍스트로, 문자 인코딩을 UTF-8로 설정

        HttpSession session = request.getSession(); // 현재 세션을 가져옴
        String username = (String) session.getAttribute("username"); // 세션에서 username 속성 값을 가져옴
        String enteredPassword = request.getParameter("password"); // 요청에서 password 파라미터 값을 가져옴

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 비밀번호 확인
            String checkPasswordQuery = "SELECT password FROM users WHERE username = ?"; // users 테이블에서 특정 사용자의 비밀번호를 검색하는 SQL 쿼리
            try (PreparedStatement checkPasswordStmt = con.prepareStatement(checkPasswordQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                checkPasswordStmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
                try (ResultSet resultSet = checkPasswordStmt.executeQuery()) { // SQL 쿼리를 실행하고 결과를 ResultSet 객체에 저장
                    if (resultSet.next()) { // ResultSet 객체에 다음 행이 있으면
                        String storedPassword = resultSet.getString("password"); // ResultSet 객체에서 password 값을 가져옴

                        if (BCrypt.checkpw(enteredPassword, storedPassword)) { // 입력된 비밀번호와 저장된 비밀번호를 비교
                            response.getWriter().write("true"); // 비밀번호가 일치하면 true를 응답으로 쓰기
                        } else {
                            response.getWriter().write("false"); // 비밀번호가 일치하지 않으면 false를 응답으로 쓰기
                        }
                    }
                }
            }

            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException이나 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
