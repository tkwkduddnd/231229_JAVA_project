<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<%@ page import="com.yourcompany.servlets.Product" %> <!-- Product 클래스 임포트 -->
<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>상품 수정</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 가져옴 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트 연결 -->
    <link rel="stylesheet" type="text/css" href="ProductRegistration.css"> <!-- ProductRegistration.css 스타일시트 연결 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->

    <jsp:include page="AdminNav.jsp" /> <!-- AdminNav.jsp 파일을 include -->

    <section> <!-- section 태그 시작 -->
        <div class="admin-content"> <!-- admin-content 클래스 div 시작 -->
            <h2>상품 수정</h2> <!-- 제목 설정 -->

            <%-- 추가된 코드: 메시지가 있을 경우에만 alert 메시지 출력 --%>
            <% String message = (String)request.getAttribute("message"); %> <!-- message 변수에 request의 "message" 속성을 가져와 저장 -->
            <% if (message != null) { %> <!-- message가 null이 아니면 -->
                <script>
                    alert('<%= message %>'); <!-- alert 메시지로 message를 출력 -->
                </script>
            <% } %>

            <form action="ProductUpdateProcessServlet" method="post" enctype="multipart/form-data" onsubmit="return confirm('상품을 수정하시겠습니까?');"> <!-- 폼 시작, 제출 시 ProductUpdateProcessServlet으로 POST 요청 보냄 -->
                <% Product product = (Product)request.getAttribute("product"); %> <!-- product 변수에 request의 "product" 속성을 가져와 저장 -->
                <input type="hidden" name="productCode" value="<%= product.getProductCode() %>"> <!-- 상품 코드를 hidden 필드에 저장 -->

                <label for="theme">테마:</label> <!-- 라벨 설정 -->
                <select name="theme"> <!-- 테마 선택 -->
                    <option value="유럽" <%= "유럽".equals(product.getTheme()) ? "selected" : "" %>>유럽</option> <!-- 유럽 테마 옵션 설정 -->
                    <option value="동남아" <%= "동남아".equals(product.getTheme()) ? "selected" : "" %>>동남아</option> <!-- 동남아 테마 옵션 설정 -->
                    <option value="일본" <%= "일본".equals(product.getTheme()) ? "selected" : "" %>>일본</option> <!-- 일본 테마 옵션 설정 -->
                    <option value="중국" <%= "중국".equals(product.getTheme()) ? "selected" : "" %>>중국</option> <!-- 중국 테마 옵션 설정 -->
                    <option value="미국" <%= "미국".equals(product.getTheme()) ? "selected" : "" %>>미국</option> <!-- 미국 테마 옵션 설정 -->
                    <option value="허니문" <%= "허니문".equals(product.getTheme()) ? "selected" : "" %>>허니문</option> <!-- 허니문 테마 옵션 설정 -->
                </select><br> <!-- 테마 선택 끝 -->

                <label for="productImage">상품 이미지:</label> <!-- 라벨 설정 -->
                <input type="file" name="productImageFile"><br> <!-- 파일 입력 필드 -->

                <label for="productName">상품 이름:</label> <!-- 라벨 설정 -->
                <input type="text" name="productName" value="<%= product.getProductName() %>"><br> <!-- 상품 이름 입력 필드 -->

                <label for="departureTime">출발일시:</label> <!-- 라벨 설정 -->
                <input type="datetime-local" name="departureTime" value="<%= product.getDepartureTime() %>"><br> <!-- 출발일시 입력 필드 -->

                <label for="arrivalTime">도착일시:</label> <!-- 라벨 설정 -->
                <input type="datetime-local" name="arrivalTime" value="<%= product.getArrivalTime() %>"><br> <!-- 도착일시 입력 필드 -->

                <label for="remainingCount">남은 갯수:</label> <!-- 라벨 설정 -->
                <input type="number" name="remainingCount" value="<%= product.getRemainingCount() %>"><br> <!-- 남은 갯수 입력 필드 -->

                <label for="productStatus">상품 상태:</label> <!-- 라벨 설정 -->
                <select name="productStatus"> <!-- 상품 상태 선택 -->
                    <option value="판매중" <%= "판매중".equals(product.getProductStatus()) ? "selected" : "" %>>판매중</option> <!-- 판매중 옵션 설정 -->
                    <option value="품절" <%= "품절".equals(product.getProductStatus()) ? "selected" : "" %>>품절</option> <!-- 품절 옵션 설정 -->
                </select><br> <!-- 상품 상태 선택 끝 -->

                <label for="price">가격:</label> <!-- 라벨 설정 -->
                <input type="number" name="price" value="<%= product.getPrice() %>"><br> <!-- 가격 입력 필드 -->

                <label for="details">상세 정보:</label> <!-- 라벨 설정 -->
                <textarea name="details"><%= product.getDetails() %></textarea><br> <!-- 상세 정보 입력 필드 -->

                <input type="submit" value="수정"> <!-- 제출 버튼 -->
                <input type="button" value="취소" onclick="location.href='ProductList.jsp'"> <!-- 취소 버튼, 클릭 시 ProductList.jsp로 이동 -->
                <br>
            </form> <!-- 폼 끝 -->
        </div> <!-- admin-content 클래스 div 끝 -->
    </section> <!-- section 태그 끝 -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일을 include -->

</body> <!-- body 태그 끝 -->

</html> <!-- HTML 끝 -->
