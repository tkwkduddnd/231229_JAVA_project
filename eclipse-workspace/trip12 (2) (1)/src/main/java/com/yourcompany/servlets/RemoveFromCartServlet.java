package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RemoveFromCartServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class RemoveFromCartServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 RemoveFromCartServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        HttpSession session = request.getSession(); // HttpSession 객체 생성
        String username = (String) session.getAttribute("username"); // 세션에서 "username"이라는 이름의 속성 값을 가져와 username 변수에 저장

        if (username == null) { // username이 null인 경우 (로그인하지 않은 사용자인 경우)
            response.sendRedirect("Login.jsp"); // "Login.jsp" 페이지로 리다이렉트
            return;
        }

        int productId = Integer.parseInt(request.getParameter("productId")); // 요청 파라미터 중 "productId" 값을 가져와 정수로 변환하여 productId 변수에 저장

        try {
            // 데이터베이스에서 장바구니에서 상품 삭제
            CartDAO.removeFromCart(username, productId); // CartDAO의 removeFromCart 메소드를 호출하여 장바구니에서 상품 삭제
        } catch (SQLException e) { // SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            response.sendRedirect("error.jsp"); // "error.jsp" 페이지로 리다이렉트
            return;
        }

        // 장바구니 페이지로 리다이렉트
        response.sendRedirect("Cart.jsp"); // "Cart.jsp" 페이지로 리다이렉트
    }
}
