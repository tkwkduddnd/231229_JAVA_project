// 패키지 선언
package com.yourcompany.servlets;

// 필요한 라이브러리와 클래스들을 임포트
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;
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

// Servlet 어노테이션을 사용하여 웹 서버에 이 클래스가 서블릿임을 알림
@WebServlet("/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doPost 메서드를 오버라이드하여 POST 요청을 처리
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 응답 컨텐츠 타입을 설정하고 출력 스트림을 가져옴
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 요청에서 새 비밀번호와 확인 비밀번호를 가져옴
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        try {
            // MySQL 데이터베이스 드라이버를 로드하고 연결을 설정
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 세션에서 사용자 이름을 가져옴
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            // 새 비밀번호를 해시 처리
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

            // 사용자 정보를 업데이트하는 SQL 쿼리를 준비
            String query = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, hashedPassword);
            pst.setString(2, username);

            // 쿼리를 실행하고 영향을 받은 행의 수를 가져옴
            int rowsAffected = pst.executeUpdate();

            // 비밀번호 변경 성공 여부를 확인하고 결과를 출력
            if (rowsAffected > 0) {
                out.println("<script>alert('비밀번호가 성공적으로 변경되었습니다. 다시 로그인 해주세요.');</script>");
                session.invalidate(); // 세션 무효화
                out.println("<script>location.href='Home.jsp';</script>");
            } else {
                out.println("<script>alert('비밀번호 변경에 실패했습니다.');</script>");
            }

            // PreparedStatement와 Connection을 닫음
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 발생 시 스택 추적을 출력
            e.printStackTrace();
        }
    }
}
