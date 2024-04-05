package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 입출력 예외 처리를 위한 라이브러리
import java.sql.Connection; // 데이터베이스 연결을 위한 라이브러리
import java.sql.DriverManager; // 데이터베이스 드라이버 관리를 위한 라이브러리
import java.sql.PreparedStatement; // SQL 쿼리를 실행하기 위한 라이브러리
import java.sql.SQLException; // SQL 예외 처리를 위한 라이브러리

import javax.servlet.ServletException; // 서블릿 예외 처리를 위한 라이브러리
import javax.servlet.annotation.WebServlet; // 서블릿 연결을 위한 어노테이션 라이브러리
import javax.servlet.http.HttpServlet; // HttpServlet 클래스를 위한 라이브러리
import javax.servlet.http.HttpServletRequest; // HTTP 요청을 처리하기 위한 라이브러리
import javax.servlet.http.HttpServletResponse; // HTTP 응답을 처리하기 위한 라이브러리
import javax.servlet.http.HttpSession; // HTTP 세션을 처리하기 위한 라이브러리

import org.mindrot.jbcrypt.BCrypt; // 비밀번호 암호화를 위한 라이브러리

@WebServlet("/DeleteAccountServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/DeleteAccountServlet" 요청을 하면 이 서블릿이 처리
public class DeleteAccountServlet extends HttpServlet { // HttpServlet을 상속받는 DeleteAccountServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) // HTTP POST 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답의 컨텐츠 타입을 HTML로, 문자 인코딩을 UTF-8로 설정

        HttpSession session = request.getSession(); // 현재 세션을 가져옴
        String username = (String) session.getAttribute("username"); // 세션에서 username 속성 값을 가져옴
        String enteredPassword = request.getParameter("password"); // 요청에서 password 파라미터 값을 가져옴

        // 비밀번호가 입력되지 않았을 경우
        if (enteredPassword == null || enteredPassword.trim().isEmpty()) { // enteredPassword가 null이거나 공백이면
            response.getWriter().println("<script>alert('비밀번호 확인을 해주세요.'); history.go(-1);</script>"); // 비밀번호 확인 요청 메시지를 응답으로 쓰기
            return; // 메소드 종료
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 비밀번호 확인
            String checkPasswordQuery = "SELECT password FROM users WHERE username = ?"; // users 테이블에서 특정 사용자의 비밀번호를 검색하는 SQL 쿼리
            try (PreparedStatement checkPasswordStmt = con.prepareStatement(checkPasswordQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                checkPasswordStmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
                var resultSet = checkPasswordStmt.executeQuery(); // SQL 쿼리를 실행하고 결과를 ResultSet 객체에 저장

                if (resultSet.next()) { // ResultSet 객체에 다음 행이 있으면
                    String storedPassword = resultSet.getString("password"); // ResultSet 객체에서 password 값을 가져옴

                    if (BCrypt.checkpw(enteredPassword, storedPassword)) { // 입력된 비밀번호와 저장된 비밀번호를 비교
                        // 비밀번호 일치 - 관련된 레코드 삭제
                        String deleteOrderItemsQuery = "DELETE FROM order_items WHERE order_id IN (SELECT order_id FROM orders WHERE user_id = (SELECT id FROM users WHERE username = ?))"; // users, orders, order_items 테이블에서 특정 사용자와 관련된 레코드를 삭제하는 SQL 쿼리
                        try (PreparedStatement deleteOrderItemsStmt = con.prepareStatement(deleteOrderItemsQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                            deleteOrderItemsStmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
                            deleteOrderItemsStmt.executeUpdate(); // SQL 쿼리 실행
                        }

                        // orders 테이블의 레코드 삭제
                        String deleteOrdersQuery = "DELETE FROM orders WHERE user_id = (SELECT id FROM users WHERE username = ?)"; // orders 테이블에서 특정 사용자와 관련된 레코드를 삭제하는 SQL 쿼리
                        try (PreparedStatement deleteOrdersStmt = con.prepareStatement(deleteOrdersQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                            deleteOrdersStmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
                            deleteOrdersStmt.executeUpdate(); // SQL 쿼리 실행
                        }

                     // cart 테이블의 레코드 삭제
                        String deleteCartQuery = "DELETE FROM cart WHERE user_id = (SELECT id FROM users WHERE username = ?)"; // cart 테이블에서 특정 사용자와 관련된 레코드를 삭제하는 SQL 쿼리
                        try (PreparedStatement deleteCartStmt = con.prepareStatement(deleteCartQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                            deleteCartStmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
                            deleteCartStmt.executeUpdate(); // SQL 쿼리 실행
                        }

                        // 계정 삭제
                        String deleteAccountQuery = "DELETE FROM users WHERE username = ?"; // users 테이블에서 특정 사용자의 레코드를 삭제하는 SQL 쿼리
                        try (PreparedStatement deleteAccountStmt = con.prepareStatement(deleteAccountQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                            deleteAccountStmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
                            int affectedRows = deleteAccountStmt.executeUpdate(); // SQL 쿼리 실행하고 영향 받은 행의 수를 저장

                            if (affectedRows > 0) { // 영향 받은 행의 수가 0보다 크면 (즉, 레코드가 삭제되었으면)
                                // 세션 및 쿠키 초기화
                                session.invalidate(); // 세션 무효화 (즉, 세션에서 모든 속성 제거)
                                // 탈퇴 성공 시 메시지 출력
                                response.getWriter().println("<script>alert('계정 탈퇴가 완료되었습니다.'); window.location.href='Home.jsp';</script>"); // 계정 탈퇴 성공 메시지를 응답으로 쓰기
                                return; // 메소드 종료
                            }
                        }
                    }
                }
            }
                        // 비밀번호가 일치하지 않는 경우
                        response.getWriter().println("<script>alert('비밀번호가 일치하지 않습니다. 다시 시도해주세요.'); history.go(-1);</script>"); // 비밀번호 불일치 메시지를 응답으로 쓰기

                        con.close(); // Connection 객체 닫기
                        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException이나 SQLException 발생 시
                            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
                        }
                        }

}
