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
<link rel="stylesheet" type="text/css" href="ThemeProduct.css?after"> <!-- 테마 상품 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->

	<jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

	<section> <!-- section 태그 시작 -->
		<div class="user-content"> <!-- user-content 클래스 div 시작 -->
			<h2>일본 여행</h2> <!-- 섹션 제목 설정 -->

			<form action="JapanServlet" method="post"> <!-- JapanServlet로 POST 방식으로 form 데이터 전송 -->
				<label for="theme"></label> <!-- 테마 라벨, 표시되는 텍스트 없음 -->
				<select name="theme"> <!-- 테마 선택 select 박스 -->
					<option value="일본" selected>일본</option> <!-- 기본 선택된 테마 옵션 -->
				</select> 
				<label for="keyword"></label> <!-- 검색어 라벨, 표시되는 텍스트 없음 -->
				<input type="text" name="keyword"> <!-- 검색어 입력 필드 -->
				<input type="submit" value="조회"> <!-- form 데이터 전송 버튼, 버튼 텍스트는 '조회' -->
			</form>

			<div class="product-container row"> <!-- product-container row 클래스 div 시작 -->
				<%
				List<Product> productList = (List<Product>) request.getAttribute("productList"); // request 객체에서 productList 속성 값을 가져와서 productList 변수에 저장
				String keyword = (String) session.getAttribute("keyword"); // 세션에서 keyword 속성 값을 가져와서 keyword 변수에 저장
				if (productList != null && !productList.isEmpty()) { // productList가 null이 아니고 비어있지 않다면 아래 코드 실행
					int productCount = productList.size(); // productList의 크기를 productCount 변수에 저장
					for (int i = 0; i < productCount; i++) { // productList의 크기만큼 반복
						Product product = productList.get(i); // productList에서 i번째 Product 객체를 가져와서 product 변수에 저장
				%>
				<div class="col-md-4 product-item"> <!-- col-md-4 product-item 클래스 div 시작 -->
					<img src="<%=product.getProductImage()%>" alt="상품 이미지"> <!-- 상품 이미지 -->

					<p> <!-- p 태그 시작 -->
						상품명 :
						<%=product.getProductName()%> <!-- 상품명 -->
					</p> <!-- p 태그 끝 -->
					<p> <!-- p 태그 시작 -->
						상세정보 :
						<%=product.getDetails()%> <!-- 상세정보 -->
					</p> <!-- p 태그 끝 -->
					<p> <!-- p 태그 시작 -->
						가격 :
						<%=product.getPrice()%> <!-- 가격 -->
					</p> <!-- p 태그 끝 -->
					<button type="button" class="details-button" onclick="window.location.href='ProductDetailServlet?id=<%=product.getId()%>'">상세 정보</button> <!-- 상세 정보 버튼, 클릭 시 'ProductDetailServlet?id=상품 ID'로 이동 -->
				</div> <!-- col-md-4 product-item 클래스 div 끝 -->
				<%
				// 한 줄에 5개씩 출력하도록 추가된 부분
				if ((i + 1) % 5 == 0 && (i + 1) < productCount) { // i가 5의 배수이고, i가 productList의 크기보다 작다면 아래 코드 실행
				%>
			</div> <!-- product-container row 클래스 div 끝 -->
			<div class="product-container row"> <!-- product-container row 클래스 div 시작 -->
				<%
				}
				}
				} else { // productList가 null이거나 비어있다면 아래 코드 실행
				    if (keyword == null || keyword.isEmpty()) { // keyword가 null이거나 비어있다면 아래 코드 실행
				%>
				<div class="center-text">검색어를 입력해주세요.</div> <!-- 검색어를 입력해달라는 메시지 표시 -->
				<%
				    } else { // keyword가 null이 아니고 비어있지 않다면 아래 코드 실행
				%>
				<div class="center-text">일치하는 상품이 없습니다.</div> <!-- 일치하는 상품 없음 메시지 표시 -->
				<%
				    }
				}
				%>
			</div> <!-- product-container row 클래스 div 끝 -->
		</div> <!-- user-content 클래스 div 끝 -->
	</section> <!-- section 태그 끝 -->
	
	<jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
