// 패키지 선언
package com.yourcompany.servlets;

// 필요한 클래스를 임포트
import java.io.IOException;
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

// 웹 서블릿 어노테이션을 이용해 이 클래스가 웹 서블릿임을 선언
@WebServlet("/EuropeServlet")
public class EuropeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doPost 메서드 선언
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청과 응답의 문자 인코딩을 UTF-8로 설정
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 요청에서 테마와 키워드를 가져옴
        String theme = request.getParameter("theme");
        String keyword = request.getParameter("keyword");
        // 키워드를 세션에 저장
        request.getSession().setAttribute("keyword", keyword);

        try {
            // 데이터베이스 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234");

            // 키워드에 따라 검색하는 쿼리를 동적으로 생성
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM products WHERE theme=?");
            if (keyword != null && !keyword.isEmpty()) {
                queryBuilder.append(" AND productName LIKE ?");
            }

            String query = queryBuilder.toString();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, theme);

            if (keyword != null && !keyword.isEmpty()) {
                pst.setString(2, "%" + keyword + "%");
            }

            // 쿼리 실행
            ResultSet rs = pst.executeQuery();

            // 결과를 리스트에 저장
            List<Product> productList = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
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

                productList.add(product);
            }

            // 결과를 JSP 페이지로 전달
            request.setAttribute("productList", productList);

            // 자원 해제
            rs.close();
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            // 예외 처리
            e.printStackTrace();
        }

        // Europe.jsp로 포워딩
        request.getRequestDispatcher("Europe.jsp").forward(request, response);
    }
}
