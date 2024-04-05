// 패키지 정의
package com.yourcompany.servlets;

// 필요한 라이브러리 임포트
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 서블릿 어노테이션으로 이 클래스가 서블릿임을 정의
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    // 직렬화에 사용되는 버전 ID
    private static final long serialVersionUID = 1L;

    // 기본 생성자
    public DeleteServlet() {
        super();
    }

    // 클라이언트의 POST 요청을 처리하는 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 데이터베이스 연결을 위한 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 삭제할 게시물의 아이디를 가져옴
            String id = request.getParameter("id");

            // 게시물을 삭제하는 SQL 쿼리 작성
            String query = "DELETE FROM board WHERE id=?";
            // 쿼리를 준비하는 PreparedStatement 생성
            PreparedStatement pst = con.prepareStatement(query);
            // 쿼리의 첫 번째 물음표 자리에 게시물의 아이디를 설정
            pst.setInt(1, Integer.parseInt(id));
            // 쿼리 실행
            pst.executeUpdate();
            // PreparedStatement 닫기
            pst.close();

            // 게시물 아이디 재정렬 쿼리
            String rearrangeQuery = "SET @count = 0";
            // Statement 생성
            Statement rearrangeStmt = con.createStatement();
            // 재정렬 쿼리 실행
            rearrangeStmt.execute(rearrangeQuery);

            // 아이디 업데이트 쿼리
            String updateQuery = "UPDATE board SET id = @count:= @count + 1";
            // 업데이트 쿼리 실행
            rearrangeStmt.execute(updateQuery);

            // auto increment 리셋 쿼리
            String resetIncrement = "ALTER TABLE board AUTO_INCREMENT = 1";
            // 리셋 쿼리 실행
            rearrangeStmt.execute(resetIncrement);

            // Statement 닫기
            rearrangeStmt.close();

            // 데이터베이스 연결 닫기
            con.close();

            // 삭제 성공 메시지와 함께 tripreview.jsp 페이지로 리다이렉트
            response.sendRedirect("tripreview.jsp?message=deleteSuccess");
        } catch (Exception e) {
            // 예외 발생 시, 스택 트레이스 출력
            e.printStackTrace();
        }
    }
}
