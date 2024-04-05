package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 입출력 예외 처리를 위한 라이브러리
import java.sql.Connection; // 데이터베이스 연결을 위한 라이브러리
import java.sql.DriverManager; // 데이터베이스 드라이버 관리를 위한 라이브러리
import java.sql.PreparedStatement; // SQL 쿼리를 실행하기 위한 라이브러리
import java.sql.ResultSet; // SQL 쿼리 결과를 저장하기 위한 라이브러리
import java.sql.SQLException; // SQL 예외 처리를 위한 라이브러리
import java.util.ArrayList; // ArrayList를 사용하기 위한 라이브러리
import java.util.List; // List를 사용하기 위한 라이브러리

import javax.servlet.ServletException; // 서블릿 예외 처리를 위한 라이브러리
import javax.servlet.annotation.WebServlet; // 서블릿 연결을 위한 어노테이션 라이브러리
import javax.servlet.http.HttpServlet; // HttpServlet 클래스를 위한 라이브러리
import javax.servlet.http.HttpServletRequest; // HTTP 요청을 처리하기 위한 라이브러리
import javax.servlet.http.HttpServletResponse; // HTTP 응답을 처리하기 위한 라이브러리

@WebServlet("/ChinaServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/ChinaServlet" 요청을 하면 이 서블릿이 처리
public class ChinaServlet extends HttpServlet { // HttpServlet을 상속받는 ChinaServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) // HTTP POST 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답의 컨텐츠 타입을 HTML로, 문자 인코딩을 UTF-8로 설정

        String theme = request.getParameter("theme"); // 요청에서 theme 파라미터 값을 가져옴
        String keyword = request.getParameter("keyword"); // 요청에서 keyword 파라미터 값을 가져옴
        request.getSession().setAttribute("keyword", keyword); // 세션에 keyword 속성을 설정

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 수정된 부분: 쿼리를 동적으로 생성하여 키워드에 따라 검색
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM products WHERE theme=? AND theme='중국'"); // products 테이블에서 특정 테마의 상품을 검색하는 SQL 쿼리
            if (keyword != null && !keyword.isEmpty()) { // keyword가 null이 아니고 비어 있지 않으면
                queryBuilder.append(" AND productName LIKE ?"); // SQL 쿼리에 상품 이름을 기준으로 하는 검색 조건 추가
            }

            String query = queryBuilder.toString(); // SQL 쿼리 문자열로 변환
            PreparedStatement pst = con.prepareStatement(query); // SQL 쿼리를 실행할 PreparedStatement 객체 생성
            pst.setString(1, theme); // SQL 쿼리의 첫 번째 인자 값으로 theme 설정

            if (keyword != null && !keyword.isEmpty()) { // keyword가 null이 아니고 비어 있지 않으면
                pst.setString(2, "%" + keyword + "%"); // SQL 쿼리의 두 번째 인자 값으로 keyword 설정
            }

            ResultSet rs = pst.executeQuery(); // SQL 쿼리를 실행하고 결과를 ResultSet 객체에 저장

            // 결과를 리스트에 저장
            List<Product> productList = new ArrayList<>(); // Product 객체를 저장할 ArrayList 생성
            while (rs.next()) { // ResultSet 객체에 다음 행이 있으면
                Product product = new Product(); // Product 객체 생성
                product.setId(rs.getInt("id")); // Product 객체의 id 값을 설정
                product.setTheme(rs.getString("theme")); // Product 객체의 theme 값을 설정
                product.setProductImage(rs.getString("productImage")); // Product 객체의 productImage 값을 설정
                product.setProductCode(rs.getString("productCode")); // Product 객체의 productCode 값을 설정
                product.setProductName(rs.getString("productName")); // Product 객체의 productName 값을 설정
                product.setDepartureTime(rs.getString("departureTime")); // Product 객체의 departureTime 값을 설정
                product.setArrivalTime(rs.getString("arrivalTime")); // Product 객체의 arrivalTime 값을 설정
                product.setRemainingCount(rs.getInt("remainingCount")); // Product 객체의 remainingCount 값을 설정
                product.setProductStatus(rs.getString("productStatus")); // Product 객체의 productStatus 값을 설정
                product.setPrice(rs.getInt("price")); // Product 객체의 price 값을 설정
                product.setDetails(rs.getString("details")); // Product 객체의 details 값을 설정

                productList.add(product); // ArrayList에 Product 객체 추가
            }

            // JSP 페이지로 전달
            request.setAttribute("productList", productList); // request 객체에 productList 속성을 설정

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException이나 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        // China.jsp로 포워딩
        request.getRequestDispatcher("China.jsp").forward(request, response); // China.jsp 페이지로 요청을 포워딩
    }
}
