<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<%@ page import="java.util.List" %> <!-- java.util.List 클래스 임포트 -->
<%@ page import="com.yourcompany.servlets.Product" %> <!-- Product 클래스 임포트 -->
<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>상품 목록</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 가져옴 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- Common.css 스타일시트 연결 -->
    <link rel="stylesheet" type="text/css" href="ProductList.css?after"> <!-- ProductList.css 스타일시트 연결 -->
    <script>
        function confirmAndAlert(confirmationMessage, message) { <!-- confirmAndAlert 함수 정의 -->
            if (confirm(confirmationMessage)) { <!-- 사용자가 확인 메시지를 확인하면 -->
                alert(message); <!-- alert 메시지로 message를 출력 -->
                return true; // 폼 제출
            }
            return false; // 폼 제출 취소
        }
    </script>
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->

    <jsp:include page="AdminNav.jsp" /> <!-- AdminNav.jsp 파일을 include -->

    <section> <!-- section 태그 시작 -->
        <div class="admin-content"> <!-- admin-content 클래스 div 시작 -->
            <h2>상품 목록</h2> <!-- 제목 설정 -->

            <form action="ProductListServlet" method="post"> <!-- 폼 시작, 제출 시 ProductListServlet으로 POST 요청 보냄 -->
                <label for="theme">테마:</label> <!-- 라벨 설정 -->
                <select name="theme"> <!-- 테마 선택 -->
                    <option value="선택" <% if ("선택".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>선택</option> <!-- 선택 옵션 설정 -->
                    <option value="all" <% if ("all".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>전체</option> <!-- 전체 옵션 설정 -->
                    <option value="유럽" <% if ("유럽".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>유럽</option> <!-- 유럽 테마 옵션 설정 -->
                    <option value="동남아" <% if ("동남아".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>동남아</option> <!-- 동남아 테마 옵션 설정 -->
                    <option value="일본" <% if ("일본".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>일본</option> <!-- 일본 테마 옵션 설정 -->
                    <option value="중국" <% if ("중국".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>중국</option> <!-- 중국 테마 옵션 설정 -->
                    <option value="미국" <% if ("미국".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>미국</option> <!-- 미국 테마 옵션 설정 -->
                    <option value="허니문" <% if ("허니문".equals(request.getAttribute("selectedTheme"))) { %>selected<% } %>>허니문</option> <!-- 허니문 테마 옵션 설정 -->
                </select>
                <input type="submit" value="검색"> <!-- 제출 버튼 -->
            </form> <!-- 폼 끝 -->
<table border="1"> <!-- 테이블 시작, 테이블 테두리 설정 -->
    <tr> <!-- 테이블 행 시작 -->
        <th>이미지</th> <!-- 테이블 헤더 설정 -->
        <th>테마</th> <!-- 테이블 헤더 설정 -->
        <th>상품 코드</th> <!-- 테이블 헤더 설정 -->
        <th>상품 이름</th> <!-- 테이블 헤더 설정 -->
        <th>출발일시</th> <!-- 테이블 헤더 설정 -->
        <th>도착일시</th> <!-- 테이블 헤더 설정 -->
        <th>남은 갯수</th> <!-- 테이블 헤더 설정 -->
        <th>상품 상태</th> <!-- 테이블 헤더 설정 -->
        <th>가격</th> <!-- 테이블 헤더 설정 -->
        <th>상세 정보</th> <!-- 테이블 헤더 설정 -->
        <th>수정</th> <!-- 테이블 헤더 설정 -->
        <th>삭제</th> <!-- 테이블 헤더 설정 -->
    </tr> <!-- 테이블 행 끝 -->

    <% 
    // productList 변수에 request의 "productList" 속성을 가져와 저장
    List<Product> productList = (List<Product>)request.getAttribute("productList"); 
    // productList가 null이 아니고, 비어있지 않으면
    if (productList != null && !productList.isEmpty()) { 
        // productList의 각 product에 대해서
        for (Product product : productList) { 
%>

                <tr> <!-- 테이블 행 시작 -->
                    <td><img src="<%= product.getProductImage() %>" alt="상품 이미지"></td> <!-- 상품 이미지 출력 -->
                    <td><%= product.getTheme() %></td> <!-- 테마 출력 -->
                    <td><%= product.getProductCode() %></td> <!-- 상품 코드 출력 -->
                    <td><%= product.getProductName() %></td> <!-- 상품 이름 출력 -->
                    <td><%= product.getDepartureTime() %></td> <!-- 출발일시 출력 -->
                    <td><%= product.getArrivalTime() %></td> <!-- 도착일시 출력 -->
                    <td><%= product.getRemainingCount() %></td> <!-- 남은 갯수 출력 -->
                    <td><%= product.getProductStatus() %></td> <!-- 상품 상태 출력 -->
                    <td><%= product.getPrice() %></td> <!-- 가격 출력 -->
                    <td><%= product.getDetails() %></td> <!-- 상세 정보 출력 -->
                    <td> <!-- 수정 버튼 셀 시작 -->
                        <form action="ProductUpdateServlet" method="post"> <!-- 폼 시작, 제출 시 ProductUpdateServlet으로 POST 요청 보냄 -->
                            <input type="hidden" name="productCode" value="<%= product.getProductCode() %>"> <!-- 상품 코드 입력 필드, 표시되지 않음 -->
                            <input type="submit" value="수정"> <!-- 제출 버튼, 라벨은 '수정' -->
                        </form> <!-- 폼 끝 -->
                    </td> <!-- 수정 버튼 셀 끝 -->
                    <td> <!-- 삭제 버튼 셀 시작 -->
                        <form action="DeleteProductServlet" method="post" onsubmit="return confirmAndAlert('정말로 삭제하시겠습니까?', '삭제 완료하였습니다.');"> <!-- 폼 시작, 제출 시 DeleteProductServlet으로 POST 요청 보냄, 제출 전 confirmAndAlert 함수 실행 -->
                            <input type="hidden" name="productCode" value="<%= product.getProductCode() %>"> <!-- 상품 코드 입력 필드, 표시되지 않음 -->
                            <input type="submit" value="삭제"> <!-- 제출 버튼, 라벨은 '삭제' -->
                        </form> <!-- 폼 끝 -->
                    </td> <!-- 삭제 버튼 셀 끝 -->
                </tr> <!-- 테이블 행 끝 -->
    <%
            }
        }
    %>
</table> <!-- 테이블 끝 -->
</div> <!-- admin-content 클래스 div 끝 -->
</section> <!-- section 태그 끝 -->

<jsp:include page="footer.jsp" /> <!-- footer.jsp 파일을 include -->

</body> <!-- body 태그 끝 -->

</html> <!-- HTML 끝 -->
