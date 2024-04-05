package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 입출력 예외 처리를 위한 라이브러리
import java.sql.Connection; // 데이터베이스 연결을 위한 라이브러리
import java.sql.DriverManager; // 데이터베이스 드라이버 관리를 위한 라이브러리
import java.sql.PreparedStatement; // SQL 쿼리를 실행하기 위한 라이브러리
import java.sql.Statement; // SQL 쿼리를 실행하기 위한 라이브러리

import javax.servlet.ServletException; // 서블릿 예외 처리를 위한 라이브러리
import javax.servlet.annotation.WebServlet; // 서블릿 연결을 위한 어노테이션 라이브러리
import javax.servlet.http.HttpServlet; // HttpServlet 클래스를 위한 라이브러리
import javax.servlet.http.HttpServletRequest; // HTTP 요청을 처리하기 위한 라이브러리
import javax.servlet.http.HttpServletResponse; // HTTP 응답을 처리하기 위한 라이브러리

@WebServlet("/DeleteOneToOneServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/DeleteOneToOneServlet" 요청을 하면 이 서블릿이 처리
public class DeleteOneToOneServlet extends HttpServlet { // HttpServlet을 상속받는 DeleteOneToOneServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    public DeleteOneToOneServlet() {
        super(); // HttpServlet의 생성자 호출
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) // HTTP POST 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            String id = request.getParameter("id"); // 요청에서 id 파라미터 값을 가져옴

            String query = "DELETE FROM onetooneboard WHERE id=?"; // onetooneboard 테이블에서 특정 id의 레코드를 삭제하는 SQL 쿼리
            PreparedStatement pst = con.prepareStatement(query); // SQL 쿼리를 실행할 PreparedStatement 객체 생성
            pst.setInt(1, Integer.parseInt(id)); // SQL 쿼리의 첫 번째 인자 값으로 id 설정
            pst.executeUpdate(); // SQL 쿼리 실행
            pst.close(); // PreparedStatement 객체 닫기

            String rearrangeQuery = "SET @count = 0"; // 레코드 id를 재정렬하기 위한 SQL 쿼리
            Statement rearrangeStmt = con.createStatement(); // SQL 쿼리를 실행할 Statement 객체 생성
            rearrangeStmt.execute(rearrangeQuery); // SQL 쿼리 실행

            String updateQuery = "UPDATE onetooneboard SET id = @count:= @count + 1"; // onetooneboard 테이블의 id를 재정렬하는 SQL 쿼리
            rearrangeStmt.execute(updateQuery); // SQL 쿼리 실행

            String resetIncrement = "ALTER TABLE onetooneboard AUTO_INCREMENT = 1"; // onetooneboard 테이블의 AUTO_INCREMENT를 초기화하는 SQL 쿼리
            rearrangeStmt.execute(resetIncrement); // SQL 쿼리 실행

            rearrangeStmt.close(); // Statement 객체 닫기

            con.close(); // Connection 객체 닫기

            response.sendRedirect("OneToOne.jsp?message=deleteSuccess"); // 삭제 성공 메시지와 함께 OneToOne.jsp 페이지로 리다이렉트
        } catch (Exception e) { // Exception 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
