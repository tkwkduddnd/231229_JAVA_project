package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductListServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class ProductListServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 ProductListServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정

        String selectedTheme = request.getParameter("theme"); // 요청 파라미터인 "theme" 값을 selectedTheme 변수에 저장

        // 만약 selectedTheme이 null이면 "선택"로 설정
        if (selectedTheme == null || selectedTheme.isEmpty()) {
            selectedTheme = "선택";
        }

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 테마별로 SQL 쿼리를 다르게 작성
            String query;
            if ("all".equals(selectedTheme)) { // selectedTheme 값이 "all"인 경우
                query = "SELECT * FROM products"; // 모든 상품을 조회하는 SQL 쿼리문
            } else { // selectedTheme 값이 "all"이 아닌 경우
                query = "SELECT * FROM products WHERE theme=?"; // 특정 테마의 상품을 조회하는 SQL 쿼리문
            }

            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성

            if (!"all".equals(selectedTheme)) { // selectedTheme 값이 "all"이 아닌 경우
                pst.setString(1, selectedTheme); // SQL 쿼리문의 첫 번째 인자 값으로 selectedTheme 값을 설정
            }

            ResultSet rs = pst.executeQuery(); // SQL 쿼리문 실행하고 결과를 ResultSet 객체에 저장

            // 결과를 리스트에 저장
            List<Product> productList = new ArrayList<>(); // Product 객체를 저장할 ArrayList 객체 생성
            while (rs.next()) { // ResultSet 객체에 다음 행이 있으면
                Product product = new Product(); // Product 객체 생성
                // ResultSet 객체에서 상품 정보를 가져와 Product 객체에 설정
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

                productList.add(product); // productList에 Product 객체 추가
            }

            // JSP 페이지로 전달
            request.setAttribute("productList", productList); // "productList"이라는 이름으로 productList를 request에 저장

            // JSP 페이지로 테마 정보 전달
            request.setAttribute("selectedTheme", selectedTheme); // "selectedTheme"이라는 이름으로 selectedTheme 값을 request에 저장

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        // ProductList.jsp로 포워딩
        request.getRequestDispatcher("ProductList.jsp").forward(request, response); // "ProductList.jsp" 페이지로 포워딩
    }
}
