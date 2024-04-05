// 패키지 선언
package com.yourcompany.servlets;

// 필요한 클래스를 임포트
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

// 웹 서블릿 어노테이션을 이용해 이 클래스가 웹 서블릿임을 선언
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doPost 메서드 선언
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 응답의 컨텐트 타입을 설정
        response.setContentType("text/html;charset=UTF-8");
        // PrintWriter 객체 생성
        PrintWriter out = response.getWriter();

        // 요청에서 사용자 이름과 비밀번호를 가져옴
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // 데이터베이스 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 사용자 정보를 조회하는 쿼리 생성
            String query = "SELECT * FROM users WHERE username=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);

            // 쿼리 실행
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // 결과셋에서 비밀번호와 역할을 가져옴
                String hashedPassword = rs.getString("password");
                String role = rs.getString("role");

                // 입력받은 비밀번호와 데이터베이스에서 가져온 비밀번호를 비교
                if (BCrypt.checkpw(password, hashedPassword)) {
                    // 세션 생성 및 사용자 이름과 역할을 세션에 저장
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("role", role);
                    System.out.println("username: " + username);
                    System.out.println("hashedPassword: " + hashedPassword);
                    System.out.println("role: " + role);

                    // 역할에 따라 리다이렉트
                    if ("admin".equals(role)) {
                        response.sendRedirect("Admin.jsp");
                    } else {
                        response.sendRedirect("Home.jsp");
                    }
                } else {
                    // 비밀번호가 일치하지 않는 경우
                    out.println("<script>alert('비밀번호가 틀렸습니다.'); location.href='Login.jsp';</script>");
                    System.out.println("username: " + username);
                    System.out.println("hashedPassword: " + hashedPassword);
                    System.out.println("role: " + role);
                }
            } else {
                // 사용자가 존재하지 않는 경우
                out.println("<script>alert('사용자가 존재하지 않습니다.'); location.href='Login.jsp';</script>");
            }

            // 자원 해제
            rs.close();
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 처리
            e.printStackTrace();
        }
    }
}
