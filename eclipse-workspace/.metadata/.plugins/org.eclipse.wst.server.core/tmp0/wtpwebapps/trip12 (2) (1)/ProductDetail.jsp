<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<%@ page import="java.util.List"%> <!-- java.util.List 클래스 임포트 -->
<%@ page import="com.yourcompany.servlets.Product"%> <!-- Product 클래스 임포트 -->

<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>여행사 홈페이지</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 가져옴 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트 연결 -->
    <link rel="stylesheet" type="text/css" href="ProductDetail.css?after"> <!-- ProductDetail.css 스타일시트 연결 -->
    <link rel="stylesheet" type="text/css" href="ThemeProduct.css?after"> <!-- ThemeProduct.css 스타일시트 연결 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->

    <header> <!-- header 태그 시작 -->
        <h1>NH 여행</h1> <!-- 제목 설정 -->
    </header> <!-- header 태그 끝 -->

    <nav> <!-- nav 태그 시작 -->
        <div class="left-nav"> <!-- left-nav 클래스 div 시작 -->
            <a href="Home.jsp">홈</a> <!-- 홈 링크 -->
            <a href="Europe.jsp">유 럽</a> <!-- 유럽 링크 -->
            <a href="SoutheastAsia.jsp">동남아</a> <!-- 동남아 링크 -->
            <a href="Japan.jsp">일 본</a> <!-- 일본 링크 -->
            <a href="China.jsp">중 국</a> <!-- 중국 링크 -->
            <a href="USA.jsp">미 국</a> <!-- 미국 링크 -->
            <a href="Honeymoon.jsp">허니문</a> <!-- 허니문 링크 -->
            <a href="CompanyIntroduction.jsp">회사 소개</a> <!-- 회사 소개 링크 -->
        </div> <!-- left-nav 클래스 div 끝 -->

        <div class="right-nav"> <!-- right-nav 클래스 div 시작 -->
            <%
            // 세션에서 username과 role을 가져옴
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            // 로그인 상태가 아니면
            if (username == null) {
            %>
            <a href="Login.jsp">로그인</a> <!-- 로그인 링크 -->
            <a href="Register.jsp">회원가입</a> <!-- 회원가입 링크 -->
            <a href="tripreview.jsp">여행후기</a> <!-- 여행후기 링크 -->
            <a href="OneToOne.jsp">1:1문의</a> <!-- 1:1문의 링크 -->
            <% } else { %> <!-- 로그인 상태면 -->
            <a href="<%= "admin".equals(role) ? "Admin.jsp" : "MyPage.jsp" %>"> <!-- 관리자면 Admin.jsp로, 아니면 MyPage.jsp로 이동하는 링크 -->
                <%= username %>님의 마이페이지
            </a>
            <a href="<%= "admin".equals(role) ? "Admin.jsp" : "Cart.jsp" %>"> <!-- 관리자면 Admin.jsp로, 아니면 Cart.jsp로 이동하는 링크 -->
                장바구니
            </a>
            <a href="tripreview.jsp">여행후기</a> <!-- 여행후기 링크 -->
            <a href="OneToOne.jsp">1:1문의</a> <!-- 1:1문의 링크 -->
            <a href="LogoutServlet">로그아웃</a> <!-- 로그아웃 링크 -->
            <% } %>
        </div> <!-- right-nav 클래스 div 끝 -->

    </nav> <!-- nav 태그 끝 -->

    <section> <!-- section 태그 시작 -->
        <h2>상세 정보</h2> <!-- 제목 설정 -->
        <div> <!-- div 시작 -->
            <%
            // request의 product 속성을 가져와 product 변수에 저장
            Product product = (Product) request.getAttribute("product");
            // product가 null이 아니면
            if (product != null) {
            %>
            <img src="<%=product.getProductImage()%>" alt="상품 이미지"> <!-- 상품 이미지 출력 -->
            <div> <!-- div 시작 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    상품명 : <!-- 상품명 라벨 -->
                    <%=product.getProductName()%> <!-- 상품명 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    출발 시간 : <!-- 출발 시간 라벨 -->
                    <%=product.getDepartureTime()%> <!-- 출발 시간 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    도착 시간 : <!-- 도착 시간 라벨 -->
                    <%=product.getArrivalTime()%> <!-- 도착 시간 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    남은 수량 : <!-- 남은 수량 라벨 -->
                    <%=product.getRemainingCount()%> <!-- 남은 수량 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    상품 상태 : <!-- 상품 상태 라벨 -->
                    <%=product.getProductStatus()%> <!-- 상품 상태 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    가격 : <!-- 가격 라벨 -->
                    <%=product.getPrice()%> <!-- 가격 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
                <p class="product-info"> <!-- product-info 클래스 p 시작 -->
                    상세 정보 : <!-- 상세 정보 라벨 -->
                    <%=product.getDetails()%> <!-- 상세 정보 출력 -->
                </p> <!-- product-info 클래스 p 끝 -->
<form action="CartServlet" method="post" onsubmit="return checkOrderQuantity()"> <!-- 폼 시작, 제출 시 CartServlet으로 POST 요청 보냄, 제출 전 checkOrderQuantity 함수 실행 -->
    <input type="hidden" name="productId" value="<%=product.getId()%>"> <!-- 상품 ID 입력 필드, 표시되지 않음 -->
    <label for="quantity">주문 수량 :</label> <!-- 주문 수량 라벨 -->
    <input type="text" id="quantity" name="quantity" min="1" max="<%=product.getRemainingCount()%>"> <!-- 주문 수량 입력 필드, 최소값은 1, 최대값은 상품 잔여 수량 -->
    <%-- 상품 잔여 수량이 0인 경우 버튼 비활성화 처리 --%>
    <%
    // 상품 잔여 수량이 0인 경우
    if (product.getRemainingCount() == 0) {
    %>
    <input type="submit" value="상품담기" disabled> <!-- 제출 버튼, 라벨은 '상품담기', 비활성화 상태 -->
    <%
    } else {
    %>
    <input type="submit" value="상품담기"> <!-- 제출 버튼, 라벨은 '상품담기' -->
    <%
    }
    %>
</form> <!-- 폼 끝 -->
</div> <!-- div 끝 -->
<%
// product가 null인 경우
} else {
%>
<p>상품 정보를 찾을 수 없습니다.</p> <!-- 상품 정보를 찾을 수 없다는 메시지 출력 -->
<%
}
%>
</div> <!-- div 끝 -->
</section> <!-- section 태그 끝 -->


<jsp:include page="footer.jsp" /> <!-- footer.jsp 파일을 include -->

<script> <!-- 스크립트 시작 -->
function checkOrderQuantity() { <!-- checkOrderQuantity 함수 시작 -->
    var quantityInput = document.getElementById('quantity').value; <!-- quantity ID를 가진 요소의 값을 가져와 quantityInput 변수에 저장 -->
    var isLoggedIn =
<%=username != null%>
; // 사용자가 로그인한 상태인지 확인

    // 로그인 상태가 아니면
    if (!isLoggedIn) {
        alert('로그인이 필요한 서비스입니다.'); <!-- '로그인이 필요한 서비스입니다.'라는 경고창 띄움 -->
        window.location.href = 'Login.jsp'; <!-- Login.jsp로 이동 -->
        return false;
    }

    // 입력값이 숫자인지 확인
    if (!/^[0-9]+$/.test(quantityInput)) {
        alert('주문 수량은 숫자만 입력 가능합니다.'); <!-- '주문 수량은 숫자만 입력 가능합니다.'라는 경고창 띄움 -->
        return false;
    }

    // 주문 수량이 음수인 경우
    if (parseInt(quantityInput) < 0) {
        alert('주문 수량은 0 이상이어야 합니다.'); <!-- '주문 수량은 0 이상이어야 합니다.'라는 경고창 띄움 -->
        return false;
    }

    // 주문 수량이 0 또는 재고 수량을 초과하는 경우
    var maxQuantity =
<%=product.getRemainingCount()%>
; // 상품 잔여 수량을 가져와 maxQuantity 변수에 저장
    if (parseInt(quantityInput) === 0
            || parseInt(quantityInput) > maxQuantity) {
        alert('주문 수량을 재고 수량 이내로 입력해주세요.'); <!-- '주문 수량을 재고 수량 이내로 입력해주세요.'라는 경고창 띄움 -->
        return false;
    }

    return true;
}
</script> <!-- 스크립트 끝 -->
</body> <!-- body 태그 끝 -->
</html> <!-- HTML 끝 -->
