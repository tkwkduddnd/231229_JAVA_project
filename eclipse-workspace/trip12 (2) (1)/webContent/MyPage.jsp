<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
    <title>여행사 마이페이지</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- 구글 폰트 '나눔고딕' 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="Common.css"> <!-- 공통 CSS 스타일시트 링크 -->
    <link rel="stylesheet" type="text/css" href="MyPage.css?after"> <!-- 마이페이지 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> <!-- jQuery 3.6.4 버전 스크립트 링크 -->
</head> <!-- head 태그 끝 -->
<body> <!-- body 태그 시작 -->
    <jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->

    <section> <!-- section 태그 시작 -->
        <div class="section-nav"> <!-- section-nav 클래스 div 시작 -->
            <ul> <!-- 순서 없는 목록(ul) 태그 시작 -->
                <li class="menu-item"><a href="javascript:void(0);" data-page="PasswordChange.jsp">비밀번호 변경</a></li> <!-- 목록 항목(li), '비밀번호 변경' 페이지로 이동하는 링크 -->
                <li class="menu-item"><a href="javascript:void(0);" data-page="Order.jsp">주문 정보</a></li> <!-- 목록 항목(li), '주문 정보' 페이지로 이동하는 링크 -->
                <li class="menu-item"><a href="javascript:void(0);" data-page="Review.jsp">나의 후기</a></li> <!-- 목록 항목(li), '나의 후기' 페이지로 이동하는 링크 -->
                <li class="menu-item"><a href="javascript:void(0);" data-page="enquiry.jsp">문의 내역</a></li> <!-- 목록 항목(li), '문의 내역' 페이지로 이동하는 링크 -->
                <li class="menu-item"><a href="javascript:void(0);" data-page="deleteAccount.jsp">계정 탈퇴</a></li> <!-- 목록 항목(li), '계정 탈퇴' 페이지로 이동하는 링크 -->
            </ul> <!-- 순서 없는 목록(ul) 태그 끝 -->
        </div> <!-- section-nav 클래스 div 끝 -->

        <div class="right-content"></div> <!-- right-content 클래스 div 시작 -->
        <script> <!-- script 태그 시작 -->
        $(document).ready(function() { // 문서가 준비되면 함수 실행
            $(".section-nav ul li a").click(function(e) { // .section-nav ul li a 요소 클릭 시 함수 실행
                e.preventDefault(); // 기본 이벤트 막음

                var pageUrl = $(this).data("page"); // 클릭한 요소의 data-page 속성 값을 pageUrl 변수에 저장

                $.ajax({ // ajax 요청 시작
                    type : "GET", // GET 방식
                    url : pageUrl, // 요청 URL은 pageUrl
                    success : function(data) { // 요청 성공 시 함수 실행
                        $(".right-content").html(data); // .right-content 요소의 내용을 응답 데이터로 변경
                    },
                    error : function() { // 요청 실패 시 함수 실행
                        alert("페이지 로드에 실패했습니다."); // 경고창 표시
                    }
                });
            });
        });

        </script> <!-- script 태그 끝 -->
    </section> <!-- section 태그 끝 -->

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->
</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
