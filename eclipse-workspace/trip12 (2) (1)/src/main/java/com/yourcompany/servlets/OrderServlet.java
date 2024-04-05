package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class OrderServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 OrderServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        HttpSession session = request.getSession(); // 세션을 가져옴
        String username = (String) session.getAttribute("username"); // 세션에서 사용자 이름을 가져옴

        if (username == null) { // 로그인이 되어 있지 않으면
            response.sendRedirect("Login.jsp"); // 로그인 페이지로 리다이렉트
            return;
        }

        try {
            // Cart 테이블에서 주문 정보 가져오기
            List<CartItem> cartItems = CartDAO.getCartItems(username); // 사용자의 장바구니 정보를 가져옴
            int totalPrice = 0; // 총 가격을 저장할 변수

            // 주문 테이블에 추가
            int orderId = OrderDAO.createOrder(username, totalPrice); // 주문을 생성하고 주문 아이디를 가져옴

            for (CartItem cartItem : cartItems) { // 장바구니의 각 항목에 대하여
                Product product = cartItem.getProduct(); // 상품 정보를 가져옴
                int quantity = cartItem.getQuantity(); // 수량을 가져옴
                int price = product.getPrice(); // 가격을 가져옴

                // OrderItem 테이블에 추가
                OrderDAO.addOrderItem(orderId, product.getId(), quantity, price); // 주문 항목을 추가

                // 장바구니에서 해당 상품 삭제
                CartDAO.removeFromCart(username, product.getId()); // 장바구니에서 해당 상품을 삭제

                // 주문 총액 누적
                totalPrice += quantity * price; // 총 가격을 계산
            }

            // 주문 테이블에 총액 업데이트
            OrderDAO.updateTotalPrice(orderId, totalPrice); // 주문의 총 가격을 업데이트
        } catch (SQLException e) { // SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            response.sendRedirect("error.jsp"); // 에러 페이지로 리다이렉트
        }

        response.sendRedirect("MyPage.jsp"); // 마이페이지로 리다이렉트
    }
}
