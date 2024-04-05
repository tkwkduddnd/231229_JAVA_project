package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt; // BCrypt 클래스 임포트

@WebServlet("/RegisterServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class RegisterServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 RegisterServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
    	request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정
        PrintWriter out = response.getWriter(); // 응답을 위한 PrintWriter 객체 생성

        // 요청 파라미터 값을 가져와 변수에 저장
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String emailPrefix = request.getParameter("emailPrefix");
        String emailDomain = request.getParameter("emailDomain");
        String email = emailPrefix + "@" + emailDomain; // 이메일 주소 생성
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");

        if (!password.equals(confirmPassword)) { // 비밀번호와 비밀번호 확인이 일치하지 않는 경우
            out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다."); // 에러 메시지 출력
            return;
        }

        // 해시된 비밀번호 생성
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt()); // 비밀번호 해싱

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 데이터베이스에 사용자 정보 삽입
            String query = "INSERT INTO users (username, password, fullName, gender, birthday, email, phoneNumber, address) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // 사용자 정보를 삽입하는 SQL 쿼리문
            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
            // SQL 쿼리에 인자 값 설정
            pst.setString(1, username);
            pst.setString(2, hashedPassword);
            pst.setString(3, fullName);
            pst.setString(4, gender);
            pst.setString(5, birthday);
            pst.setString(6, email);
            pst.setString(7, phoneNumber);
            pst.setString(8, address);

            int rowsAffected = pst.executeUpdate(); // SQL 쿼리 실행하고 영향받은 행의 수를 rowsAffected 변수에 저장
            if (rowsAffected > 0) { // SQL 쿼리 실행 결과 영향받은 행의 수가 0보다 큰 경우 (회원 가입 성공)
                out.println("회원 가입이 완료되었습니다."); // 성공 메시지 출력
                // 세션 생성 및 사용자 정보 저장
                HttpSession session = request.getSession(); // HttpSession 객체 생성
                session.setAttribute("username", username); // "username"이라는 이름으로 username 값을 세션에 저장
                // 성공 시 메인 페이지로 리다이렉션
                response.sendRedirect("Home.jsp"); // "Home.jsp" 페이지로 리다이렉트
            } else { // SQL 쿼리 실행 결과 영향받은 행의 수가 0인 경우 (회원 가입 실패)
                out.println("회원 가입에 실패했습니다. 다시 시도해주세요."); // 실패 메시지 출력
            }
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
