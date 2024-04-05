<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<%@ page import="java.util.List"%> <!-- java.util.List 패키지 임포트 -->
<%@ page import="com.yourcompany.servlets.Product"%> <!-- com.yourcompany.servlets.Product 패키지 임포트 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
    <title>여행사 홈페이지</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- 공통 CSS 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="ThemeProduct.css?after"> <!-- 주제별 상품 페이지 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="user-content"> <!-- user-content 클래스 div 시작 -->
            <h2>유럽 여행</h2> <!-- 섹션 제목 설정 -->

            <form action="EuropeServlet" method="post"> <!-- post 방식으로 EuropeServlet에 데이터 전송하는 form 시작 -->
                <!-- 테마 선택 및 검색어 입력 필드 설정 -->
                <label for="theme"></label> 
                <select name="theme">
                    <option value="유럽" selected>유럽</option>
                </select> 
                <label for="keyword"></label> 
                <input type="text" name="keyword">
                <input type="submit" value="조회">
            </form> <!-- form 끝 -->

            <div class="product-container row"> <!-- product-container 클래스 div 시작 -->
                <%
                List<Product> productList = (List<Product>) request.getAttribute("productList"); // request 객체에서 productList를 가져옴
                String keyword = (String) session.getAttribute("keyword"); // 세션에서 검색어를 가져옴
                if (productList != null && !productList.isEmpty()) { // productList가 null이 아니고 비어있지 않으면
                    int productCount = productList.size(); // productList의 크기를 productCount에 저장
                    for (int i = 0; i < productCount; i++) { // productList의 크기만큼 반복
                        Product product = productList.get(i); // productList에서 product를 하나씩 가져옴
                %>
                <div class="col-md-4 product-item"> <!-- product-item 클래스 div 시작 -->
                    <!-- 상품 이미지, 상품명, 상세정보, 가격 출력 -->
                    <img src="<%=product.getProductImage()%>" alt="상품 이미지">
                    <p>상품명 : <%=product.getProductName()%></p>
                    <p>상세정보 : <%=product.getDetails()%></p>
                    <p>가격 : <%=product.getPrice()%></p>
                    <!-- 상세 정보 보기 버튼 -->
                    <button type="button" class="details-button" onclick="window.location.href='ProductDetailServlet?id=<%=product.getId()%>'">상세 정보</button>
                </div> <!-- product-item 클래스 div 끝 -->
                <%
                // 한 줄에 5개씩 출력하도록 추가된 부분
                if ((i + 1) % 5 == 0 && (i + 1) < productCount) {
                %>
            </div>
            <div class="product-container row">
                <%
                }
                }
                } else {
                    if (keyword == null || keyword.isEmpty()) { // 검색어가 없을 경우
                %>
                <div class="center-text">검색어를 입력해주세요.</div> <!-- 검색어 입력 요청 메시지 출력 -->
                <%
                    } else { // 검색어가 있지만 일치하는 상품이 없을 경우
                %>
                <div class="center-text">일치하는 상품이 없습니다.</div> <!-- 일치하는 상품 없음 메시지 출력 -->
                <%
                    }
                }
                %>
            </div> <!-- product-container 클래스 div 끝 -->
        </div> <!-- user-content 클래스 div 끝 -->
    </section> <!-- section 태그 끝 -->
    
    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
