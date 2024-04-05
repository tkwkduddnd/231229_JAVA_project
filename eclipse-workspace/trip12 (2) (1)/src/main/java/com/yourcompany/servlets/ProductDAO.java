package com.yourcompany.servlets; // 패키지 선언

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO { // 상품 정보를 처리하는 DAO 클래스

    // productId에 해당하는 Product 객체 가져오기
    public static Product getProductById(int productId) throws SQLException { // productId에 해당하는 상품 정보를 가져오는 메소드
        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?")) { // SQL 쿼리 준비
            pstmt.setInt(1, productId); // SQL 쿼리의 첫 번째 인자 값으로 productId 설정
            try (ResultSet rs = pstmt.executeQuery()) { // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장
                if (rs.next()) { // ResultSet 객체에 다음 행이 있으면
                    Product product = new Product(); // Product 객체 생성
                    // 필요한 필드들을 가져와서 product에 설정
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
                    return product; // Product 객체 반환
                }
            }
        }
        return null; // productId에 해당하는 상품이 없으면 null 반환
    }

    // Product를 업데이트하는 메서드
    public static void updateProduct(Product product, int quantity) throws SQLException { // Product 객체와 수량을 받아 상품 정보를 업데이트하는 메소드
        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE products SET remainingCount = remainingCount - ?, productStatus = CASE WHEN remainingCount - ? <= 0 THEN '품절' ELSE productStatus END WHERE id = ?")) { // 상품 재고를 감소시키고, 재고가 0 이하가 되면 상품 상태를 '품절'로 변경하는 SQL 쿼리 준비
            pstmt.setInt(1, quantity); // SQL 쿼리의 첫 번째 및 두 번째 인자 값으로 quantity 설정
            pstmt.setInt(2, quantity);
            pstmt.setInt(3, product.getId()); // SQL 쿼리의 세 번째 인자 값으로 product의 id 설정
            pstmt.executeUpdate(); // SQL 쿼리 실행
        }
    }

    // 사용자의 장바구니에 담긴 상품 목록을 가져오는 메서드
    public static List<Product> getProductsInCart(String username) throws SQLException { // 사용자 이름을 받아 그 사용자의 장바구니에 담긴 상품 목록을 가져오는 메소드
        List<Product> products = new ArrayList<>(); // 상품 목록을 저장할 ArrayList 객체 생성
        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT p.* FROM products p JOIN cart c ON p.id = c.product_id JOIN users u ON u.id = c.user_id WHERE u.username = ?")) { // username에 해당하는 사용자의 장바구니에 담긴 상품 목록을 조회하는 SQL 쿼리 준비
            pstmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
            try (ResultSet rs = pstmt.executeQuery()) { // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장
                while (rs.next()) { // ResultSet 객체에 다음 행이 있으면
                    Product product = new Product(); // Product 객체 생성
                    // 필요한 필드들을 가져와서 product에 설정
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
                    products.add(product); // ArrayList에 Product 객체 추가
                }
            }
        }
        return products; // 상품 목록 반환
    }
}
