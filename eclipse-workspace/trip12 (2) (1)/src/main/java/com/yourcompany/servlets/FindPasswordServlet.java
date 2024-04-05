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

// 웹 서블릿 어노테이션을 이용해 이 클래스가 웹 서블릿임을 선언
@WebServlet("/FindPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doPost 메서드 선언
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 응답의 컨텐트 타입을 설정
        response.setContentType("text/html;charset=UTF-8");
        // PrintWriter 객체 생성
        PrintWriter out = response.getWriter();

        // 요청에서 아이디, 이름, 이메일, 생년월일을 가져옴
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");

        try {
            // 데이터베이스 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 아이디와 관련된 정보를 조회하는 쿼리 생성
            String query = "SELECT * FROM users WHERE username=? AND fullName=? AND email=? AND birthday=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, fullName);
            pst.setString(3, email);
            pst.setString(4, birthday);

            // 쿼리 실행
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // 아이디와 관련된 정보가 일치하면 새로운 비밀번호 설정 페이지로 이동
                response.sendRedirect("PasswordUpdate.jsp?username=" + username);
            } else {
                // 아이디와 관련된 정보가 일치하지 않으면 메시지를 JSP로 전달
                request.setAttribute("message", "입력한 정보로 조회된 회원이 없습니다.");
                request.getRequestDispatcher("FindPassword.jsp").forward(request, response);
            }

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) {
            
            e.printStackTrace();// 예외 발생 시 스택 트레이스 출력
        }
    }
}
