package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/UpdatePasswordServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class UpdatePasswordServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 UpdatePasswordServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정
        PrintWriter out = response.getWriter(); // 응답을 위한 PrintWriter 객체 생성

        String username = request.getParameter("username"); // 요청 파라미터 중 "username" 값을 가져와 username 변수에 저장
        String newPassword = request.getParameter("newPassword"); // 요청 파라미터 중 "newPassword" 값을 가져와 newPassword 변수에 저장
        String confirmPassword = request.getParameter("confirmPassword"); // 요청 파라미터 중 "confirmPassword" 값을 가져와 confirmPassword 변수에 저장

        if (!newPassword.equals(confirmPassword)) { // newPassword와 confirmPassword가 일치하지 않는 경우
            out.println("새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다."); // 오류 메시지 출력
            return; // 메소드 종료
        }

        // 해시된 비밀번호 생성
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt()); // newPassword를 해싱하여 hashedPassword 변수에 저장

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 데이터베이스에 비밀번호 업데이트
            String query = "UPDATE users SET password=? WHERE username=?"; // 사용자의 비밀번호를 수정하는 SQL 쿼리문
            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
            pst.setString(1, hashedPassword); // 첫번째 인자에 hashedPassword 값을 설정
            pst.setString(2, username); // 두번째 인자에 username 값을 설정

            int rowsAffected = pst.executeUpdate(); // SQL 쿼리 실행하고 결과를 int 타입의 rowsAffected 변수에 저장

            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        // Login.jsp로 리다이렉트
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp"); // RequestDispatcher 객체 생성
        dispatcher.forward(request, response); // Login.jsp 페이지로 포워드
    }
}
