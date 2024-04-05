package com.yourcompany.servlets; // 패키지 선언

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO { // 주문 정보를 처리하는 DAO 클래스

    public static int createOrder(String username, int totalPrice) throws SQLException { // 주문을 생성하는 메소드
        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO orders (user_id, total_price) VALUES ((SELECT id FROM users WHERE username = ?), ?)",
                     Statement.RETURN_GENERATED_KEYS)) { // 주문을 생성하는 SQL 쿼리 준비
            pstmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정
            pstmt.setInt(2, totalPrice); // SQL 쿼리의 두 번째 인자 값으로 totalPrice 설정
            pstmt.executeUpdate(); // SQL 쿼리 실행

            // 생성된 주문 ID를 가져오기
            try (ResultSet rs = pstmt.getGeneratedKeys()) { // 생성된 키를 가져옴
                if (rs.next()) {
                    return rs.getInt(1); // 생성된 키가 있으면 반환
                }
            }
        }
        return -1; // 실패 시 -1 반환
    }

    public static void addOrderItem(int orderId, int productId, int quantity, int price) throws SQLException { // 주문 항목을 추가하는 메소드
        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)")) { // 주문 항목을 추가하는 SQL 쿼리 준비
            pstmt.setInt(1, orderId); // SQL 쿼리의 첫 번째 인자 값으로 orderId 설정
            pstmt.setInt(2, productId); // SQL 쿼리의 두 번째 인자 값으로 productId 설정
            pstmt.setInt(3, quantity); // SQL 쿼리의 세 번째 인자 값으로 quantity 설정
            pstmt.setInt(4, price); // SQL 쿼리의 네 번째 인자 값으로 price 설정
            pstmt.executeUpdate(); // SQL 쿼리 실행
        }
    }

    public static void updateTotalPrice(int orderId, int totalPrice) throws SQLException { // 주문의 총 가격을 업데이트하는 메소드
        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE orders SET total_price = ? WHERE order_id = ?")) { // 주문의 총 가격을 업데이트하는 SQL 쿼리 준비
            pstmt.setInt(1, totalPrice); // SQL 쿼리의 첫 번째 인자 값으로 totalPrice 설정
            pstmt.setInt(2, orderId); // SQL 쿼리의 두 번째 인자 값으로 orderId 설정
            pstmt.executeUpdate(); // SQL 쿼리 실행
        }
    }

    public static List<OrderItem> getOrderItems(String username) throws SQLException { // 주문 항목을 가져오는 메소드
        List<OrderItem> orderItems = new ArrayList<>(); // 주문 항목을 저장할 ArrayList 객체 생성

        try (Connection conn = DBUtil.openConnection(); // 데이터베이스 연결
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM order_items WHERE order_id IN (SELECT order_id FROM orders WHERE user_id = (SELECT id FROM users WHERE username = ?))")) { // 주문 항목을 조회하는 SQL 쿼리 준비
            pstmt.setString(1, username); // SQL 쿼리의 첫 번째 인자 값으로 username 설정

            try (ResultSet rs = pstmt.executeQuery()) { // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장
                while (rs.next()) { // ResultSet 객체에 다음 행이 있으면
                    int orderId = rs.getInt("order_id");
                    int productId = rs.getInt("product_id");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");

                    OrderItem orderItem = new OrderItem(orderId, productId, quantity, price); // OrderItem 객체 생성
                    orderItems.add(orderItem); // ArrayList에 OrderItem 객체 추가
                }
            }
        } catch (SQLException e) {
            // Catch the exception and rethrow it
            throw e; // 예외를 다시 던짐
        }

        return orderItems; // 주문 항목 반환
    }
}
