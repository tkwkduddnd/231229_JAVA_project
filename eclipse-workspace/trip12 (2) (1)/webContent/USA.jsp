<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.yourcompany.servlets.Product"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행사 홈페이지</title>
    <!-- Google 폰트 및 스타일시트 연결 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <!-- 공통 스타일시트 및 ThemeProduct.css 연결 -->
    <link rel="stylesheet" type="text/css" href="Common.css">
    <link rel="stylesheet" type="text/css" href="ThemeProduct.css?after">
</head>
<body>

    <!-- 네비게이션을 포함한 페이지 상단 부분 -->
    <jsp:include page="Nav.jsp" />

    <!-- 사용자 콘텐츠 섹션 -->
    <section>
        <!-- 사용자 콘텐츠 영역 -->
        <div class="user-content">
            <h2>미국 여행</h2>

            <!-- 상품 검색 폼 -->
            <form action="USAServlet" method="post">
                <label for="theme"></label> 
                <!-- 여행 테마 선택 드롭다운 -->
                <select name="theme">
                    <option value="미국" selected>미국</option>
                </select> 
                <label for="keyword"></label> 
                <!-- 키워드 검색 입력 필드 -->
                <input type="text" name="keyword">
                <input type="submit" value="조회">
            </form>

            <!-- 상품 목록 표시 -->
            <div class="product-container row">
                <% 
                // Servlet에서 전달받은 상품 목록과 세션에서 검색어를 가져옴
                List<Product> productList = (List<Product>) request.getAttribute("productList");
                String keyword = (String) session.getAttribute("keyword");
                if (productList != null && !productList.isEmpty()) {
                    int productCount = productList.size();
                    for (int i = 0; i < productCount; i++) {
                        Product product = productList.get(i);
                %>
                        <!-- 상품 아이템 표시 -->
                        <div class="col-md-4 product-item">
                            <!-- 상품 이미지 -->
                            <img src="<%=product.getProductImage()%>" alt="상품 이미지">
                            <!-- 상품 정보 -->
                            <p>상품명 : <%=product.getProductName()%></p>
                            <p>상세정보 : <%=product.getDetails()%></p>
                            <p>가격 : <%=product.getPrice()%></p>
                            <!-- 상세 정보 버튼 -->
                            <button type="button" class="details-button" onclick="window.location.href='ProductDetailServlet?id=<%=product.getId()%>'">상세 정보</button>
                        </div>
                <%
                    // 한 줄에 5개씩 출력하도록 추가된 부분
                    if ((i + 1) % 5 == 0 && (i + 1) < productCount) {
                %>
            </div>
            <!-- 다음 줄에 상품 목록 표시 -->
            <div class="product-container row">
                <%
                    }
                    }
                } else {
                    // 검색 결과가 없는 경우에 대한 메시지 표시
                    if (keyword == null || keyword.isEmpty()) {
                %>
                        <div class="center-text">검색어를 입력해주세요.</div>
                <%
                    } else {
                %>
                        <div class="center-text">일치하는 상품이 없습니다.</div>
                <%
                    }
                }
                %>
            </div>
        </div>
    </section>
    
    <!-- 푸터 영역 포함 -->
    <jsp:include page="footer.jsp" />
    
</body>
</html>
