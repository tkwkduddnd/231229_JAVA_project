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
import javax.servlet.http.HttpSession;

@WebServlet("/WriteOneToOneServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class WriteOneToOneServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 WriteOneToOneServlet 클래스 선언
	private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    public WriteOneToOneServlet() { // WriteOneToOneServlet 클래스의 생성자
        super(); // 부모 클래스의 생성자 호출
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
		request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정

		HttpSession session = request.getSession(); // 세션 정보를 가져옴
		String username = (String) session.getAttribute("username"); // 세션에서 "username" 속성 값을 가져와 username 변수에 저장

		String title = request.getParameter("title"); // 요청 파라미터 중 "title" 값을 가져와 title 변수에 저장
		String content = request.getParameter("content"); // 요청 파라미터 중 "content" 값을 가져와 content 변수에 저장

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결
			conn.setAutoCommit(false); // 자동 커밋 비활성화

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO onetooneboard (title, content, author) VALUES (?, ?, ?)"); // SQL 쿼리문 작성 및 PreparedStatement 객체 생성

			pstmt.setString(1, title); // 첫번째 인자에 title 값을 설정
			pstmt.setString(2, content); // 두번째 인자에 content 값을 설정
			pstmt.setString(3, username); // 세번째 인자에 username 값을 설정
			pstmt.executeUpdate(); // SQL 쿼리 실행
			conn.commit(); // 커밋
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
		}

		response.sendRedirect("OneToOne.jsp"); // OneToOne.jsp 페이지로 리다이렉트
	}
}
