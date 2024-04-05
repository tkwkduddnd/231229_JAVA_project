<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 페이지의 언어를 자바로 설정하고, 콘텐츠 타입과 페이지 인코딩을 UTF-8로 설정합니다. -->
<%@ page import="java.util.List"%> <!-- java.util 패키지의 List 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.Product"%> <!-- com.yourcompany.servlets 패키지의 Product 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.ProductDAO"%> <!-- com.yourcompany.servlets 패키지의 ProductDAO 클래스를 임포트합니다. -->
<%@ page import="java.util.Map"%> <!-- java.util 패키지의 Map 인터페이스를 임포트합니다. -->
<%@ page import="java.util.HashMap"%> <!-- java.util 패키지의 HashMap 클래스를 임포트합니다. -->
<%@ page import="java.sql.SQLException"%> <!-- java.sql 패키지의 SQLException 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.CartItem"%> <!-- com.yourcompany.servlets 패키지의 CartItem 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.CartDAO"%> <!-- com.yourcompany.servlets 패키지의 CartDAO 클래스를 임포트합니다. -->

<!DOCTYPE html> <!-- HTML5 문서 형식을 선언합니다. -->
<html lang="en"> <!-- lang 속성으로 문서의 기본 언어를 영어로 설정합니다. -->
<head> <!-- 웹 페이지의 메타 정보를 담는 head 태그를 시작합니다. -->
    <meta charset="UTF-8"> <!-- 문자 인코딩을 UTF-8로 설정합니다. -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 뷰포트의 너비를 디바이스의 너비로, 초기 확대 비율을 1.0으로 설정합니다. -->
    <title>장바구니</title> <!-- 웹 페이지의 제목을 "장바구니"로 설정합니다. -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 제공하는 '나눔고딕' 폰트 스타일시트를 링크합니다. -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트를 링크합니다. -->
    <link rel="stylesheet" type="text/css" href="Cart.css?after"> <!-- Cart.css 스타일시트를 링크하고, 캐시 방지를 위해 쿼리 파라미터를 추가합니다. -->
</head> <!-- head 태그를 닫습니다. -->
<body> <!-- 본문을 나타내는 body 태그를 시작합니다. -->

    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 페이지를 현재 페이지에 포함시킵니다. -->

    <section> <!-- 섹션을 나타내는 section 태그를 시작합니다. -->
        <h2>장바구니</h2> <!-- 섹션의 제목을 "장바구니"로 설정합니다. -->
        <div> <!-- div 태그를 시작합니다. -->
            <%
            String username = (String) session.getAttribute("username"); // 세션에서 "username" 속성의 값을 가져와 username 변수에 저장합니다.
            if (username != null) { // username이 null이 아닌 경우에만 아래 코드를 실행합니다.
                try {
                    List<CartItem> cartItems = CartDAO.getCartItems(username); // CartDAO의 getCartItems 메소드를 사용해 username에 해당하는 장바구니 아이템 리스트를 가져옵니다.
                    if (cartItems != null && !cartItems.isEmpty()) { // cartItems가 null이 아니고 비어있지 않은 경우에만 아래 코드를 실행합니다.
                Map<Integer, Integer> productQuantityMap = new HashMap<>(); // 상품의 수량을 저장할 Map 객체를 생성합니다. 키는 상품의 ID, 값은 상품의 수량입니다.
                int totalPrice = 0; // 장바구니에 담긴 모든 상품의 총 가격을 저장할 변수를 생성하고 0으로 초기화합니다.
            %>
            <table class="cart-table"> <!-- 장바구니 상품을 나타낼 테이블을 생성하고, CSS 클래스로 "cart-table"을 지정합니다. -->
                <thead> <!-- 테이블의 헤더를 나타내는 thead 태그를 시작합니다. -->
                    <tr> <!-- 헤더의 행을 나타내는 tr 태그를 시작합니다. -->
                        <th>이미지</th> <!-- 헤더의 열을 나타내는 th 태그를 사용해 "이미지"라는 제목을 추가합니다. -->
                        <th>상품명</th> <!-- "상품명"이라는 제목을 추가합니다. -->
                        <th>가격</th> <!-- "가격"이라는 제목을 추가합니다. -->
                        <th>출발 시간</th> <!-- "출발 시간"이라는 제목을 추가합니다. -->
                        <th>도착 시간</th> <!-- "도착 시간"이라는 제목을 추가합니다. -->
                        <th>수량</th> <!-- "수량"이라는 제목을 추가합니다. -->
                        <th>삭제</th> <!-- "삭제"라는 제목을 추가합니다. -->
                    </tr> <!-- 헤더의 행을 나타내는 tr 태그를 닫습니다. -->
                </thead> <!-- 테이블의 헤더를 나타내는 thead 태그를 닫습니다. -->
                <tbody> <!-- 테이블의 본문을 나타내는 tbody 태그를 시작합니다. -->
                    <%
                    for (CartItem cartItem : cartItems) { // cartItems 리스트의 각 CartItem에 대해 아래 코드를 실행합니다.
                        Product product = cartItem.getProduct(); // CartItem에서 Product 객체를 가져와 product 변수에 저장합니다.
                        int quantityInCart = cartItem.getQuantity(); // CartItem에서 상품의 수량을 가져와 quantityInCart 변수에 저장합니다.
                        boolean inCart = quantityInCart > 0; // 수량이 0보다 큰지 확인하여 inCart 변수에 저장합니다.

                        if (productQuantityMap.containsKey(product.getId())) { // productQuantityMap에 이미 product의 ID가 키로 존재하는 경우, 아래 코드를 실행합니다.
                            int existingQuantity = productQuantityMap.get(product.getId()); // productQuantityMap에서 해당 상품 ID의 값을 가져와 existingQuantity 변수에 저장합니다.
                            productQuantityMap.put(product.getId(), existingQuantity + quantityInCart); // existingQuantity와 quantityInCart를 더한 값을 productQuantityMap에 업데이트합니다.
                        } else { // productQuantityMap에 product의 ID가 키로 존재하지 않는 경우, 아래 코드를 실행합니다.
                            productQuantityMap.put(product.getId(), quantityInCart); // productQuantityMap에 product의 ID와 quantityInCart를 키와 값으로 추가합니다.
                        }
                        totalPrice += product.getPrice() * quantityInCart; // 상품의 가격과 수량을 곱한 값을 totalPrice에 더합니다.
                    %>
                    <tr> <!-- 테이블의 행을 나타내는 tr 태그를 시작합니다. -->
                        <td><img src="<%=product.getProductImage()%>" alt="상품 이미지"></td> <!-- 상품의 이미지를 img 태그를 사용해 출력합니다. -->
                        <td><%=product.getProductName()%></td> <!-- 상품의 이름을 출력합니다. -->
                        <td><%=product.getPrice()%>원</td> <!-- 상품의 가격을 출력합니다. -->
                                                <td><%=product.getDepartureTime()%></td> <!-- 상품의 출발 시간을 출력합니다. -->
                        <td><%=product.getArrivalTime()%></td> <!-- 상품의 도착 시간을 출력합니다. -->
                        <td><%=quantityInCart%>개</td> <!-- 상품의 수량을 출력합니다. -->
                        <td> <!-- 상품을 장바구니에서 삭제하는 버튼을 생성하는 폼을 시작합니다. -->
                            <form action="RemoveFromCartServlet" method="post"> <!-- form 태그를 이용해 RemoveFromCartServlet으로 post 요청을 보내는 폼을 생성합니다. -->
                                <input type="hidden" name="productId" value="<%=product.getId()%>"> <!-- 상품의 id를 보내기 위해 hidden 타입의 input 태그를 사용합니다. -->
                                <input type="submit" value="삭제"> <!-- 삭제 버튼을 생성합니다. -->
                            </form> <!-- 폼을 닫습니다. -->
                        </td> 
                    </tr> <!-- 테이블의 행을 나타내는 tr 태그를 닫습니다. -->
                    <%
                    }
                    %>
                </tbody> <!-- 테이블의 본문을 나타내는 tbody 태그를 닫습니다. -->
            </table> <!-- 테이블을 닫습니다. -->
            <div class="order-section"> <!-- 주문 정보 섹션을 시작합니다. -->
                <div class="cart-total"> <!-- 총 가격 정보를 감싸는 div 태그를 시작합니다. -->
                    <p> <!-- p 태그를 시작합니다. -->
                        결제 금액: <!-- "결제 금액:" 텍스트를 출력합니다. -->
                        <%=totalPrice%>원 <!-- 총 가격을 출력합니다. -->
                    </p> <!-- p 태그를 닫습니다. -->
                </div> <!-- 총 가격 정보를 감싸는 div 태그를 닫습니다. -->
                <div class="order-button"> <!-- 주문 버튼을 감싸는 div 태그를 시작합니다. -->
                    <form action="OrderServlet" method="post"> <!-- form 태그를 이용해 OrderServlet으로 post 요청을 보내는 폼을 생성합니다. -->
                        <input type="hidden" name="totalPrice" value="<%=totalPrice%>"> <!-- 총 가격을 보내기 위해 hidden 타입의 input 태그를 사용합니다. -->
                        <input type="submit" value="주문"> <!-- 주문 버튼을 생성합니다. -->
                    </form> <!-- 폼을 닫습니다. -->
                </div> <!-- 주문 버튼을 감싸는 div 태그를 닫습니다. -->
            </div> <!-- 주문 정보 섹션을 닫습니다. -->
            <%
            } else {
            %>
            <p>장바구니가 비어 있습니다.</p> <!-- 장바구니가 비어 있는 경우, "장바구니가 비어 있습니다." 텍스트를 출력합니다. -->
            <%
            }
            } catch (SQLException e) {
            %>
            <p>장바구니 정보를 가져오는 동안 오류가 발생했습니다.</p> <!-- SQL 예외가 발생한 경우, "장바구니 정보를 가져오는 동안 오류가 발생했습니다." 텍스트를 출력합니다. -->
            <%
            }
            } else {
            %>
            <p>로그인이 필요한 서비스입니다.</p> <!-- username이 null인 경우, 즉 로그인이 되어있지 않은 경우, "로그인이 필요한 서비스입니다." 텍스트를 출력합니다. -->
            <%
            }
            %>
        </div> <!-- div 태그를 닫습니다. -->
    </section> <!-- 섹션을 나타내는 section 태그를 닫습니다. -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 페이지를 현재 페이지에 포함시킵니다. -->

</body> <!-- 본문을 나타내는 body 태그를 닫습니다. -->
</html> <!-- html 태그를 닫습니다. -->
                        