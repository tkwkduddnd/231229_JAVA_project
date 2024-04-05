<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- 페이지의 언어를 자바로 설정하고, 인코딩을 UTF-8로 설정 -->
<%@ page import="java.util.List"%> <!-- java.util 패키지의 List 클래스를 임포트 -->
<%@ page import="com.yourcompany.servlets.Product"%> <!-- com.yourcompany.servlets 패키지의 Product 클래스를 임포트 -->
<!DOCTYPE html>
<html lang="en"> <!-- HTML 문서의 언어를 영어로 설정 -->
<head>
<meta charset="UTF-8"> <!-- 문자 인코딩을 UTF-8로 설정 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
<title>여행사 홈페이지</title> <!-- 웹페이지의 제목 설정 -->
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트에서 나눔고딕 폰트를 가져옴 -->
<link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트를 연결 -->
<link rel="stylesheet" type="text/css" href="ThemeProduct.css?after"> <!-- ThemeProduct.css 스타일시트를 연결 -->
</head>
<body>
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp를 현재 페이지에 삽입 -->

    <section>
        <div class="user-content">
            <h2>동남아 여행</h2>

            <form action="SoutheastAsiaServlet" method="post"> <!-- 동남아 여행 상품을 조회하는 폼 -->
                <label for="theme"></label> <select name="theme">
                    <option value="동남아" selected>동남아</option>
                </select> <label for="keyword"></label> <input type="text" name="keyword">
                <input type="submit" value="조회">
            </form>

            <div class="product-container row">
                <% // JSP 스크립틀릿 시작
                List<Product> productList = (List<Product>) request.getAttribute("productList"); // 상품 목록을 가져옴
                String keyword = (String) session.getAttribute("keyword"); // 세션에서 검색어를 가져옴
                if (productList != null && !productList.isEmpty()) { // 상품 목록이 비어있지 않은 경우
                    int productCount = productList.size(); // 상품 개수를 가져옴
                    for (int i = 0; i < productCount; i++) {
                        Product product = productList.get(i); // 상품 정보를 가져옴
                %>
                <div class="col-md-4 product-item">
                    <img src="<%=product.getProductImage()%>" alt="상품 이미지"> <!-- 상품 이미지 출력 -->

                    <p>상품명 : <%=product.getProductName()%></p> <!-- 상품명 출력 -->
                    <p>상세정보 : <%=product.getDetails()%></p> <!-- 상세정보 출력 -->
                    <p>가격 : <%=product.getPrice()%></p> <!-- 가격 출력 -->
                    <button type="button" class="details-button" onclick="window.location.href='ProductDetailServlet?id=<%=product.getId()%>'">상세 정보</button> <!-- 상세 정보 버튼 -->
                </div>
                <% // 한 줄에 5개씩 출력하도록 추가된 부분
                if ((i + 1) % 5 == 0 && (i + 1) < productCount) {
                %>
            </div>
            <div class="product-container row">
                <%
                }
                }
                } else { // 상품 목록이 비어있거나 검색어가 없는 경우
                    if (keyword == null || keyword.isEmpty()) { // 검색어가 없는 경우
                %>
                <div class="center-text">검색어를 입력해주세요.</div> <!-- 검색어를 입력하라는 메시지 출력 -->
                <%
                    } else { // 검색 결과가 없는 경우
                %>
                <div class="center-text">일치하는 상품이 없습니다.</div> <!-- 검색 결과가 없다는 메시지 출력 -->
                <%
                    }
                }
                %>
            </div>
        </div>
    </section>
    <jsp:include page="footer.jsp" /> <!-- footer.jsp를 현재 페이지에 삽입 -->
</body>
</html>
