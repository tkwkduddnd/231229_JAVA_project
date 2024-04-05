// 패키지 정의
package com.yourcompany.servlets;

// 필요한 라이브러리 임포트
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

// 웹 서블릿 어노테이션으로 이 클래스가 서블릿임을 정의
@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
    // 직렬화에 사용되는 버전 ID
    private static final long serialVersionUID = 1L;

    // 클라이언트의 POST 요청을 처리하는 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 응답을 UTF-8로 보내도록 설정
        response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 응답을 위한 PrintWriter 객체 생성
        PrintWriter out = response.getWriter();

        // 사용자가 입력한 아이디를 가져옴
        String username = request.getParameter("username");

        try {
            // 데이터베이스 연결을 위한 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 사용자가 입력한 아이디가 데이터베이스에 이미 존재하는지 확인하는 쿼리 작성
            String query = "SELECT username FROM users WHERE username=?";
            // 쿼리를 준비하는 PreparedStatement 생성
            PreparedStatement pst = con.prepareStatement(query);
            // 쿼리의 첫 번째 물음표 자리에 사용자가 입력한 아이디를 설정
            pst.setString(1, username);

            // 쿼리 실행하고 결과를 ResultSet 객체에 저장
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // 중복된 아이디가 있을 경우 메시지 출력
                out.print("중복된 아이디입니다.");
            } else {
                // 중복된 아이디가 없을 경우 메시지 출력
                out.print("사용 가능한 아이디입니다.");
            }

            // 리소스 정리
            rs.close();
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 발생 시, 스택 트레이스 출력 및 오류 메시지 출력
            e.printStackTrace();
            out.print("중복 확인 중 오류가 발생했습니다.");
        }
    }
}
