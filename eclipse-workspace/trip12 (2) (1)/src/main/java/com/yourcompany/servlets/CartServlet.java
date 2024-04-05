// 패키지 정의
package com.yourcompany.servlets;

// 필요한 라이브러리 임포트
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 웹 서블릿 어노테이션으로 이 클래스가 서블릿임을 정의
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	// 직렬화에 사용되는 버전 ID
	private static final long serialVersionUID = 1L;

	// 클라이언트의 POST 요청을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션 객체를 가져옴
		HttpSession session = request.getSession();
		// 세션에서 username 속성을 가져옴
		String username = (String) session.getAttribute("username");

		// 로그인을 하지 않은 경우 로그인 페이지로 리다이렉트
		if (username == null) {
			response.sendRedirect("Login.jsp");
			return;
		}

		// 요청에서 상품 ID와 수량을 가져옴
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		try {
			// 상품 ID로 상품을 가져옴
			Product product = ProductDAO.getProductById(productId);

			if (product != null) {
				// 데이터베이스에 장바구니 정보를 저장
				CartDAO.addToCart(username, product.getId(), quantity);

				// 상품의 재고와 상태를 업데이트
				ProductDAO.updateProduct(product, quantity);
			}
		} catch (SQLException e) {
			// 예외 발생 시, 스택 트레이스 출력 후 에러 페이지로 리다이렉트
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

		// 장바구니 페이지로 리다이렉트
		response.sendRedirect("Cart.jsp");
	}
}
