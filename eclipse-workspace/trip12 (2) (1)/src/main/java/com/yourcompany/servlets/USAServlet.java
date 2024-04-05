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

@WebServlet("/USAServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class USAServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 USAServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정

        String theme = request.getParameter("theme"); // 요청 파라미터 중 "theme" 값을 가져와 theme 변수에 저장
        String keyword = request.getParameter("keyword"); // 요청 파라미터 중 "keyword" 값을 가져와 keyword 변수에 저장
        request.getSession().setAttribute("keyword", keyword); // 세션에 "keyword" 속성 추가

        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 수정된 부분: 쿼리를 동적으로 생성하여 키워드에 따라 검색
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM products WHERE theme=? AND theme='미국'"); // SQL 쿼리문을 동적으로 생성
            if (keyword != null && !keyword.isEmpty()) { // keyword가 null이 아니고 비어있지 않은 경우
                queryBuilder.append(" AND productName LIKE ?"); // productName이 keyword를 포함하는 제품을 검색하는 쿼리문 추가
            }

            String query = queryBuilder.toString(); // StringBuilder 객체를 String 객체로 변환
            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
            pst.setString(1, theme); // 첫번째 인자에 theme 값을 설정

            if (keyword != null && !keyword.isEmpty()) { // keyword가 null이 아니고 비어있지 않은 경우
                pst.setString(2, "%" + keyword + "%"); // 두번째 인자에 keyword를 포함하는 문자열을 설정
            }

            ResultSet rs = pst.executeQuery(); // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장

            // 결과를 리스트에 저장
            List<Product> productList = new ArrayList<>(); // Product 객체를 저장할 productList 생성
            while (rs.next()) { // ResultSet 객체에 다음 행이 있을 때까지 반복
                Product product = new Product(); // Product 객체 생성
                product.setId(rs.getInt("id")); // id 값을 가져와 product 객체에 설정
                product.setTheme(rs.getString("theme")); // theme 값을 가져와 product 객체에 설정
                product.setProductImage(rs.getString("productImage")); // productImage 값을 가져와 product 객체에 설정
                product.setProductCode(rs.getString("productCode")); // productCode 값을 가져와 product 객체에 설정
                product.setProductName(rs.getString("productName")); // productName 값을 가져와 product 객체에 설정
                product.setDepartureTime(rs.getString("departureTime")); // departureTime 값을 가져와 product 객체에 설정
                product.setArrivalTime(rs.getString("arrivalTime")); // arrivalTime 값을 가져와 product 객체에 설정
                product.setRemainingCount(rs.getInt("remainingCount")); // remainingCount 값을 가져와 product 객체에 설정
                product.setProductStatus(rs.getString("productStatus")); // productStatus 값을 가져와 product 객체에 설정
                product.setPrice(rs.getInt("price")); // price 값을 가져와 product 객체에 설정
                product.setDetails(rs.getString("details")); // details 값을 가져와 product 객체에 설정

                productList.add(product); // productList에 product 객체 추가
            }

            // JSP 페이지로 전달
            request.setAttribute("productList", productList); // request 객체에 productList 속성 추가

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        // USA.jsp로 포워딩
        request.getRequestDispatcher("USA.jsp").forward(request, response); // USA.jsp 페이지로 포워드
    }
}
