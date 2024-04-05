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

@WebServlet("/DeleteUserServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/DeleteUserServlet" 요청을 하면 이 서블릿이 처리
public class DeleteUserServlet extends HttpServlet { // HttpServlet을 상속받는 DeleteUserServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) // HTTP POST 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답의 컨텐츠 타입을 HTML로, 문자 인코딩을 UTF-8로 설정

        String userId = request.getParameter("userId"); // 요청에서 userId 파라미터 값을 가져옴

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // Begin a transaction
            con.setAutoCommit(false); // 자동 커밋을 비활성화하여 트랜잭션 시작

            try {
                // Delete from order_items
                String deleteOrderItemsQuery = "DELETE FROM order_items WHERE order_id IN (SELECT order_id FROM orders WHERE user_id=?)"; // order_items 테이블에서 특정 사용자의 주문 항목을 삭제하는 SQL 쿼리
                try (PreparedStatement deleteOrderItemsStmt = con.prepareStatement(deleteOrderItemsQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                    deleteOrderItemsStmt.setString(1, userId); // SQL 쿼리의 첫 번째 인자 값으로 userId 설정
                    deleteOrderItemsStmt.executeUpdate(); // SQL 쿼리 실행
                }

                // Delete from orders
                String deleteOrdersQuery = "DELETE FROM orders WHERE user_id=?"; // orders 테이블에서 특정 사용자의 주문을 삭제하는 SQL 쿼리
                try (PreparedStatement deleteOrdersStmt = con.prepareStatement(deleteOrdersQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                    deleteOrdersStmt.setString(1, userId); // SQL 쿼리의 첫 번째 인자 값으로 userId 설정
                    deleteOrdersStmt.executeUpdate(); // SQL 쿼리 실행
                }

                // Delete from cart
                String deleteCartQuery = "DELETE FROM cart WHERE user_id=?"; // cart 테이블에서 특정 사용자의 장바구니 항목을 삭제하는 SQL 쿼리
                try (PreparedStatement deleteCartStmt = con.prepareStatement(deleteCartQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                    deleteCartStmt.setString(1, userId); // SQL 쿼리의 첫 번째 인자 값으로 userId 설정
                    deleteCartStmt.executeUpdate(); // SQL 쿼리 실행
                }

                // Delete from users
                String deleteUserQuery = "DELETE FROM users WHERE id=?"; // users 테이블에서 특정 사용자를 삭제하는 SQL 쿼리
                try (PreparedStatement deleteUserStmt = con.prepareStatement(deleteUserQuery)) { // SQL 쿼리를 실행할 PreparedStatement 객체 생성
                    deleteUserStmt.setString(1, userId); // SQL 쿼리의 첫 번째 인자 값으로 userId 설정
                    deleteUserStmt.executeUpdate(); // SQL 쿼리 실행
                }

                // Commit the transaction if all operations succeed
                con.commit(); // 모든 작업이 성공적으로 완료되면 트랜잭션 커밋
                response.sendRedirect("UserManagement.jsp"); // 사용자 관리 페이지로 리다이렉트
            } catch (SQLException e) { // SQLException 발생 시
                // Rollback the transaction if any operation fails
                con.rollback(); // 작업 중 하나라도 실패하면 트랜잭션 롤백
                e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
                response.getWriter().println("회원 삭제에 실패했습니다."); // 응답에 실패 메시지 출력
            } finally {
                // Restore the default auto-commit behavior
                con.setAutoCommit(true); // 자동 커밋을 다시 활성화하여 기본 동작을 복원
            }

            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException이나 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
