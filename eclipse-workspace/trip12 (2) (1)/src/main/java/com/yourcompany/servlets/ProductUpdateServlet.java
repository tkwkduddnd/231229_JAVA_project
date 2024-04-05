package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
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

@WebServlet("/ProductUpdateServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class ProductUpdateServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 ProductUpdateServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정

        String productCode = request.getParameter("productCode"); // 요청 파라미터 중 "productCode" 값을 가져와 productCode 변수에 저장

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

         // 해당 상품 정보 가져오기
            String query = "SELECT * FROM products WHERE productCode=?"; // productCode가 일치하는 상품을 검색하는 SQL 쿼리문
            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
            pst.setString(1, productCode); // 첫번째 인자에 productCode 값을 설정
            ResultSet rs = pst.executeQuery(); // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장

            if (rs.next()) { // ResultSet 객체에 다음 행이 있는 경우 (검색 결과가 있는 경우)
                Product product = new Product(); // Product 객체 생성
                // Product 객체에 상품 정보 설정
                product.setTheme(rs.getString("theme"));
                product.setProductImage(rs.getString("productImage"));
                product.setProductCode(rs.getString("productCode"));
                product.setProductName(rs.getString("productName"));
                product.setDepartureTime(rs.getString("departureTime"));
                product.setArrivalTime(rs.getString("arrivalTime"));
                product.setRemainingCount(rs.getInt("remainingCount"));
                product.setProductStatus(rs.getString("productStatus"));
                product.setPrice(rs.getInt("price"));
                product.setDetails(rs.getString("details"));

                // 상품 정보를 request에 저장
                request.setAttribute("product", product); // "product"이라는 이름으로 product 객체를 request에 저장

                // ProductUpdate.jsp로 포워딩
                request.getRequestDispatcher("ProductUpdate.jsp").forward(request, response); // "ProductUpdate.jsp" 페이지로 포워딩
            } else { // ResultSet 객체에 다음 행이 없는 경우 (검색 결과가 없는 경우)
                // 해당 상품이 없을 경우 에러 메시지 처리
                request.setAttribute("message", "해당 상품을 찾을 수 없습니다."); // "message"이라는 이름으로 에러 메시지를 request에 저장
                request.getRequestDispatcher("ProductList.jsp").forward(request, response); // "ProductList.jsp" 페이지로 포워딩
            }

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기

        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }
    }
}
