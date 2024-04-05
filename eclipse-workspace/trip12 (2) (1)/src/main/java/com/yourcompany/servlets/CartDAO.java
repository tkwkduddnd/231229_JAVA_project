// 패키지 정의
package com.yourcompany.servlets;

// 필요한 라이브러리 임포트
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 장바구니 관련 데이터베이스 작업을 수행하는 클래스
public class CartDAO {

	// 장바구니에 상품 추가 메소드
	public static void addToCart(String username, int productId, int quantity) throws SQLException {
		try (Connection conn = DBUtil.openConnection()) {
			// 해당 사용자의 장바구니에 이미 같은 상품이 있는지 확인
			if (isProductInCart(conn, username, productId)) {
				// 이미 장바구니에 있는 경우 수량을 업데이트
				updateCartQuantity(conn, username, productId, quantity);
			} else {
				// 장바구니에 없는 경우 신규로 추가
				try (PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO Cart (user_id, product_id, quantity) VALUES ((SELECT id FROM users WHERE username = ?), ?, ?)")) {
					pstmt.setString(1, username);
					pstmt.setInt(2, productId);
					pstmt.setInt(3, quantity);
					pstmt.executeUpdate();
				}
			}
		}
	}

	// 해당 사용자의 장바구니에 이미 같은 상품이 있는지 확인하는 메소드
	private static boolean isProductInCart(Connection conn, String username, int productId) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"SELECT COUNT(*) FROM Cart WHERE user_id = (SELECT id FROM users WHERE username = ?) AND product_id = ?")) {
			pstmt.setString(1, username);
			pstmt.setInt(2, productId);
			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next() && rs.getInt(1) > 0;
			}
		}
	}

	// 장바구니에 이미 있는 경우 수량을 업데이트하는 메소드
	private static void updateCartQuantity(Connection conn, String username, int productId, int quantity)
			throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE Cart SET quantity = quantity + ? WHERE user_id = (SELECT id FROM users WHERE username = ?) AND product_id = ?")) {
			pstmt.setInt(1, quantity);
			pstmt.setString(2, username);
			pstmt.setInt(3, productId);
			pstmt.executeUpdate();
		}
	}

	// 장바구니에서 상품 삭제 메소드
	public static void removeFromCart(String username, int productId) throws SQLException {
		try (Connection conn = DBUtil.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"DELETE FROM Cart WHERE user_id = (SELECT id FROM users WHERE username = ?) AND product_id = ?")) {
			pstmt.setString(1, username);
			pstmt.setInt(2, productId);
			pstmt.executeUpdate();
		}
	}

	// 장바구니에서 상품 목록과 수량 가져오는 메소드
	public static List<CartItem> getCartItems(String username) throws SQLException {
		List<CartItem> cartItems = new ArrayList<>();

		try (Connection conn = DBUtil.openConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"SELECT p.*, c.quantity FROM products p JOIN cart c ON p.id = c.product_id JOIN users u ON u.id = c.user_id WHERE u.username = ?")) {
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery()) {
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

					int quantity = rs.getInt("quantity");

					cartItems.add(new CartItem(product, quantity));
				}
			}
		}

		return cartItems;
	}
}
