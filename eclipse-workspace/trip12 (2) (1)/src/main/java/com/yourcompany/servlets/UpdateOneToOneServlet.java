package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateOneToOneServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class UpdateOneToOneServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 UpdateOneToOneServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    public UpdateOneToOneServlet() { // 기본 생성자 정의
        super(); // 부모 클래스인 HttpServlet의 생성자 호출
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        try {
            // 데이터베이스 연결
            request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 클라이언트로부터 받은 파라미터를 변수에 저장
            String id = request.getParameter("id"); // 요청 파라미터 중 "id" 값을 가져와 id 변수에 저장
            String title = request.getParameter("title"); // 요청 파라미터 중 "title" 값을 가져와 title 변수에 저장
            String content = request.getParameter("content"); // 요청 파라미터 중 "content" 값을 가져와 content 변수에 저장

            // SQL 쿼리 준비
            String query = "UPDATE onetooneboard SET title=?, content=? WHERE id=?"; // 게시글의 title과 content를 수정하는 SQL 쿼리문
            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성

            // Prepared Statement에 파라미터 설정
            pst.setString(1, title); // 첫번째 인자에 title 값을 설정
            pst.setString(2, content); // 두번째 인자에 content 값을 설정
            pst.setInt(3, Integer.parseInt(id)); // 세번째 인자에 id 값을 설정

            // SQL 쿼리 실행
            int result = pst.executeUpdate(); // SQL 쿼리 실행하고 결과를 int 타입의 result 변수에 저장

            // 결과 처리
            if (result > 0) { // SQL 쿼리 실행 결과가 0보다 큰 경우(수정 성공 시)
                response.sendRedirect("viewOneToOne.jsp?id=" + id); // 해당 게시글로 리다이렉트
            } else { // SQL 쿼리 실행 결과가 0인 경우(수정 실패 시)
                response.sendRedirect("editOneToOne.jsp?id=" + id); // 수정 페이지로 다시 리다이렉트
            }

            // 자원 반납
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (Exception e) { // Exception 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
