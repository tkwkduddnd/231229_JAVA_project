// 패키지 정의
package com.yourcompany.servlets;

// 필요한 라이브러리 임포트
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 서블릿 어노테이션으로 이 클래스가 서블릿임을 정의
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    // 직렬화에 사용되는 버전 ID
    private static final long serialVersionUID = 1L;

    // 클라이언트의 POST 요청을 처리하는 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청과 응답의 인코딩을 UTF-8로 설정
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 삭제할 상품 코드를 가져옴
        String productCode = request.getParameter("productCode");

        try {
            // 데이터베이스 연결을 위한 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 상품을 삭제하는 SQL 쿼리 작성
            String query = "DELETE FROM products WHERE productCode=?";
            // 쿼리를 준비하는 PreparedStatement 생성
            PreparedStatement pst = con.prepareStatement(query);
            // 쿼리의 첫 번째 물음표 자리에 상품 코드를 설정
            pst.setString(1, productCode);

            // 쿼리 실행 및 영향 받은 로우 수 반환
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // 삭제 성공 시, ProductList.jsp로 리다이렉션
                response.sendRedirect("ProductList.jsp");
            } else {
                // 삭제 실패 시, 실패 메시지 출력
                response.getWriter().println("상품 삭제에 실패했습니다.");
            }

            // PreparedStatement와 Connection을 닫음
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 발생 시, 스택 트레이스 출력
            e.printStackTrace();
        }
    }
}
