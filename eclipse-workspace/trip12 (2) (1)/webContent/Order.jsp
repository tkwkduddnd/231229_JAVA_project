<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 페이지의 언어를 자바로 설정하고, 콘텐츠 타입과 페이지 인코딩을 UTF-8로 설정합니다. -->
<%@ page import="java.util.List" %> <!-- java.util 패키지의 List 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.OrderDAO" %> <!-- com.yourcompany.servlets 패키지의 OrderDAO 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.OrderItem" %> <!-- com.yourcompany.servlets 패키지의 OrderItem 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.Product" %> <!-- com.yourcompany.servlets 패키지의 Product 클래스를 임포트합니다. -->
<%@ page import="com.yourcompany.servlets.ProductDAO" %> <!-- com.yourcompany.servlets 패키지의 ProductDAO 클래스를 임포트합니다. -->

<!DOCTYPE html> <!-- HTML5 문서 형식을 선언합니다. -->
<html lang="en"> <!-- lang 속성으로 문서의 기본 언어를 영어로 설정합니다. -->
<head> <!-- 웹 페이지의 메타 정보를 담는 head 태그를 시작합니다. -->
    <meta charset="UTF-8"> <!-- 문자 인코딩을 UTF-8로 설정합니다. -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 뷰포트의 너비를 디바이스의 너비로, 초기 확대 비율을 1.0으로 설정합니다. -->
    <title>주문 내역</title> <!-- 웹 페이지의 제목을 "주문 내역"로 설정합니다. -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 제공하는 '나눔고딕' 폰트 스타일시트를 링크합니다. -->
    <link rel="stylesheet" type="text/css" href="Review.css?after"> <!-- Review.css 스타일시트를 링크하고, 캐시 방지를 위해 쿼리 파라미터를 추가합니다. -->
</head> <!-- head 태그를 닫습니다. -->
<body> <!-- 본문을 나타내는 body 태그를 시작합니다. -->

    <section> <!-- 섹션을 나타내는 section 태그를 시작합니다. -->
        <div class="right-content"> <!-- CSS 클래스 "right-content"를 가진 div 태그를 시작합니다. -->
            <h2>주문 내역</h2> <!-- 섹션의 제목을 "주문 내역"로 설정합니다. -->
            <%
            String username = (String) session.getAttribute("username"); // 세션에서 "username" 속성의 값을 가져와 username 변수에 저장합니다.
            if (username != null) { // username이 null이 아닌 경우에만 아래 코드를 실행합니다.
                try {
                    // 사용자의 주문 내역 가져오기
                    List<OrderItem> orderItems = OrderDAO.getOrderItems(username); // OrderDAO의 getOrderItems 메소드를 사용해 username에 해당하는 주문 아이템 리스트를 가져옵니다.

                    if (orderItems != null && !orderItems.isEmpty()) { // orderItems가 null이 아니고 비어있지 않은 경우에만 아래 코드를 실행합니다.
            %>
            <table border="1"> <!-- 주문 내역을 나타낼 테이블을 생성하고, 테이블 테두리의 너비를 1로 설정합니다. -->
                <thead> <!-- 테이블의 헤더를 나타내는 thead 태그를 시작합니다. -->
                    <tr> <!-- 헤더의 행을 나타내는 tr 태그를 시작합니다. -->
                        <th class="round-top-left">주문번호</th> <!-- 헤더의 열을 나타내는 th 태그를 사용해 "주문번호"라는 제목을 추가하고, CSS 클래스로 "round-top-left"를 지정합니다. -->
                        <th>상품명</th> <!-- "상품명"이라는 제목을 추가합니다. -->
                        <th>가격</th> <!-- "가격"이라는 제목을 추가합니다. -->
                        <th>수량</th> <!-- "수량"이라는 제목을 추가합니다. -->
                        <th class="round-top-right">총 금액</th> <!-- "총 금액"이라는 제목을 추가하고, CSS 클래스로 "round-top-right"를 지정합니다. -->
                    </tr> <!-- 헤더의 행을 나타내는 tr 태그를 닫습니다. -->
                </thead> <!-- 테이블의 헤더를 나타내는 thead 태그를 닫습니다. -->
                <tbody> <!-- 테이블의 본문을 나타내는 tbody 태그를 시작합니다. -->
                    <%
                    for (OrderItem orderItem : orderItems) { // orderItems 리스트의 각 OrderItem에 대해 아래 코드를 실행합니다.
                        Product product = ProductDAO.getProductById(orderItem.getProductId()); // ProductDAO의 getProductById 메소드를 사용해 orderItem의 productId에 해당하는 상품 정보를 가져옵니다.
                    %>
                    <tr> <!-- 테이블의 행을 나타내는 tr 태그를 시작합니다. -->
                        <td class="round-bottom-left"><%=orderItem.getOrderId()%></td> <!-- 주문 번호를 출력하고, CSS 클래스로 "round-bottom-left"를 지정합니다. -->
                        <td><%=product.getProductName()%></td> <!-- 상품 이름을 출력합니다. -->
                        <td><%=orderItem.getPrice()%>원</td> <!-- 주문 아이템의 가격을 출력합니다. -->
                        <td><%=orderItem.getQuantity()%>개</td> <!-- 주문 아이템의 수량을 출력합니다. -->
                        <td class="round-bottom-right"><%=orderItem.getTotalPrice()%>원</td> <!-- 주문 아이템의 총 가격을 출력하고, CSS 클래스로 "round-bottom-right"를 지정합니다. -->
                    </tr> <!-- 테이블의 행을 나타내는 tr 태그를 닫습니다. -->
                    <%
                    }
                    %>
                </tbody> <!-- 테이블의 본문을 나타내는 tbody 태그를 닫습니다. -->
            </table> <!-- 테이블을 닫습니다. -->
            </div>
            <%
            } else {
            %>
            <p>주문 내역이 없습니다.</p> <!-- orderItems가 null이거나 비어 있는 경우, "주문 내역이 없습니다." 텍스트를 출력합니다. -->
            <%
            }
            } catch (Exception e) {
            %>
            <p>주문 내역을 가져오는 동안 오류가 발생했습니다. 에러 메시지: <%= e.getMessage() %></p> <!-- 예외가 발생한 경우, "주문 내역을 가져오는 동안 오류가 발생했습니다. 에러 메시지: "와 함께 예외 메시지를 출력합니다. -->
            <%
            }
            } else {
            %>
            <p>로그인이 필요한 서비스입니다.</p> <!-- username이 null인 경우, 즉 로그인이 되어있지 않은 경우, "로그인이 필요한 서비스입니다." 텍스트를 출력합니다. -->
            <%
            }
            %>
        </div>
    </section> <!-- 섹션을 나타내는 section 태그를 닫습니다. -->

</body> <!-- 본문을 나타내는 body 태그를 닫습니다. -->
</html> <!-- html 태그를 닫습니다. -->
