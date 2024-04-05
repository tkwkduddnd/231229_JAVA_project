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

@WebServlet("/WriteServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class WriteServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 WriteServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    public WriteServlet() { // WriteServlet 클래스의 생성자
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP GET 요청을 처리하는 메소드
        response.getWriter().append("Served at: ").append(request.getContextPath()); // 클라이언트에 "Served at: "와 컨텍스트 경로를 반환
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        String title = request.getParameter("title"); // 요청 파라미터 중 "title" 값을 가져와 title 변수에 저장
        String content = request.getParameter("content"); // 요청 파라미터 중 "content" 값을 가져와 content 변수에 저장

        // 세션에서 작성자 정보 가져오기
        String author = (String) request.getSession().getAttribute("username"); // 세션에서 "username" 속성 값을 가져와 author 변수에 저장

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            String query = "INSERT INTO board (title, author, content) VALUES (?, ?, ?)"; // SQL 쿼리문 작성
            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
            pst.setString(1, title); // 첫번째 인자에 title 값을 설정
            pst.setString(2, author);  // 두번째 인자에 author 값을 설정
            pst.setString(3, content); // 세번째 인자에 content 값을 설정

            pst.executeUpdate(); // SQL 쿼리 실행
            
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        response.sendRedirect("tripreview.jsp"); // tripreview.jsp 페이지로 리다이렉트
    }
}
