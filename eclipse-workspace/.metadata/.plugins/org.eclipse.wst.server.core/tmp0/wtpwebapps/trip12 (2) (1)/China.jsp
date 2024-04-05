<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<%@ page import="java.util.List"%> <!-- java.util.List 패키지 임포트 -->
<%@ page import="com.yourcompany.servlets.Product"%> <!-- com.yourcompany.servlets.Product 클래스 임포트 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어 -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 viewport 설정 -->
    <title>여행사 홈페이지</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 링크 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="ThemeProduct.css?after"> <!-- ThemeProduct.css 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="user-content"> <!-- user-content 클래스 div 시작 -->
            <h2>중국 여행</h2> <!-- 섹션 제목 설정 -->

            <form action="ChinaServlet" method="post"> <!-- post 방식으로 ChinaServlet에 요청을 보내는 form 태그 시작 -->
                <label for="theme"></label> <!-- theme에 대한 label 태그, 실제 텍스트는 없음 -->
                <select name="theme"> <!-- theme 선택 select 태그 시작 -->
                    <option value="중국" selected>중국</option> <!-- 기본 선택된 중국 option 태그 -->
                </select> <!-- select 태그 끝 -->
                <label for="keyword"></label> <!-- keyword에 대한 label 태그, 실제 텍스트는 없음 -->
                <input type="text" name="keyword"> <!-- keyword 입력 input 태그 -->
                <input type="submit" value="조회"> <!-- 조회 버튼 -->
            </form> <!-- form 태그 끝 -->

            <div class="product-container row"> <!-- product-container와 row 클래스 div 시작 -->
                <%
                List<Product> productList = (List<Product>) request.getAttribute("productList"); // request 객체에서 productList 가져오기
                String keyword = (String) session.getAttribute("keyword");  // session 객체에서 keyword 가져오기
                if (productList != null && !productList.isEmpty()) { // productList가 null이 아니고 비어있지 않을 경우
                    int productCount = productList.size(); // productList의 크기를 productCount에 저장
                    for (int i = 0; i < productCount; i++) { // productList의 크기만큼 반복
                        Product product = productList.get(i); // productList에서 i번째 Product를 가져와 product에 저장
                %>
                <div class="col-md-4 product-item"> <!-- col-md-4와 product-item 클래스 div 시작 -->
                    <img src="<%=product.getProductImage()%>" alt="상품 이미지"> <!-- 상품 이미지 출력 -->

                    <p> <!-- 상품명 출력 -->
                        상품명 :
                        <%=product.getProductName()%></p>
                    <p> <!-- 상세정보 출력 -->
                        상세정보 :
                        <%=product.getDetails()%></p>
                    <p> <!-- 가격 출력 -->
                        가격 :
                        <%=product.getPrice()%></p>
                    <button type="button" class="details-button" onclick="window.location.href='ProductDetailServlet?id=<%=product.getId()%>'">상세 정보</button> <!-- 상세 정보 버튼, 클릭 시 ProductDetailServlet에 product id를 파라미터로 요청 -->
                </div> <!-- div 태그 끝 -->
                <%

                if ((i + 1) % 5 == 0 && (i + 1) < productCount) { // i + 1이 5의 배수이고 i + 1이 productCount보다 작을 경우
                %>
            </div> <!-- product-container와 row 클래스 div 끝 -->
            <div class="product-container row"> <!-- 새로운 product-container와 row 클래스 div 시작 -->
                <%
                }
                }
                } else { // productList가 null이거나 비어있을 경우
                    if (keyword == null || keyword.isEmpty()) { // keyword가 null이거나 비어있을 경우
                %>
                <div class="center-text">검색어를 입력해주세요.</div> <!-- 검색어를 입력해주세요 출력 -->
                <%
                    } else { // keyword가 null이 아니고 비어있지 않을 경우
                %>
                <div class="center-text">일치하는 상품이 없습니다.</div> <!-- 일치하는 상품이 없습니다 출력 -->
                <%
                    }
                }
                %>
            </div> <!-- product-container와 row 클래스 div 끝 -->
        </div> <!-- user-content 클래스 div 끝 -->
    </section> <!-- section 태그 끝 -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
