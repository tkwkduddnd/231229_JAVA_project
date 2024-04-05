<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<%@ page import="java.sql.*" %> <!-- java.sql 패키지 임포트 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html> <!-- html 태그 시작 -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <title>게시글 수정</title> <!-- 웹페이지 제목 설정 -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet"> <!-- Google Fonts에서 나눔고딕 폰트 링크 -->
    <link rel="stylesheet" type="text/css" href="edit.css?after"> <!-- edit.css 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
	<jsp:include page="Nav.jsp" /> <!-- Nav.jsp 파일 포함 -->
	<section> <!-- section 태그 시작 -->
    <div class="container mt-5"> <!-- container 클래스 div 시작 -->
        <h2 class="mb-4">게시글 수정</h2> <!-- 섹션 제목 설정 -->
        <% 
            String id = request.getParameter("id"); // id 파라미터 값 가져오기
            String title = ""; // title 초기화
            String content = ""; // content 초기화
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

                String query = "SELECT * FROM onetooneboard WHERE id=?"; // id에 해당하는 게시글 가져오는 쿼리
                PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
                pst.setInt(1, Integer.parseInt(id)); // 첫 번째 매개변수에 id 설정
                ResultSet rs = pst.executeQuery(); // 쿼리 실행

                if (rs.next()) { // 결과 집합에 다음 행이 있으면
                    title = rs.getString("title"); // title에 해당하는 값을 가져와 title에 저장
                    content = rs.getString("content"); // content에 해당하는 값을 가져와 content에 저장
                }
                con.close(); // 연결 종료
            } catch (Exception e) {
                e.printStackTrace(); // 예외 발생 시 스택 추적 출력
            }
        %>
        <form action="UpdateOneToOneServlet" method="post" accept-charset="UTF-8"> <!-- 게시글 수정을 위한 form 태그 시작, post 방식, 문자 인코딩은 UTF-8 -->
            <input type="hidden" name="id" id="id" value="<%=id%>" /> <!-- id를 hidden input으로 저장 -->
            <div class="form-group"> <!-- form-group 클래스 div 시작 -->
                <label for="title">제목</label> <!-- label 태그를 사용하여 input에 라벨 지정 -->
                <input type="text" id="title" name="title" value="<%=title%>" class="form-control"> <!-- title 값을 가지는 text input -->
            </div> <!-- form-group 클래스 div 끝 -->
            <div class="form-group"> <!-- form-group 클래스 div 시작 -->
                <label for="content">내용</label> <!-- label 태그를 사용하여 textarea에 라벨 지정 -->
                <textarea id="content" name="content" rows="4" class="form-control"><%=content%></textarea> <!-- content 값을 가지는 textarea -->
            </div> <!-- form-group 클래스 div 끝 -->
            <input type="submit" value="수정하기" class="btn btn-primary" onclick="alert('수정이 완료되었습니다.')"> <!-- 제출 버튼, 클릭 시 '수정이 완료되었습니다.' 알림창 표시 -->
        </form>  <!-- form 태그 끝 -->
    </div> <!-- container 클래스 div 끝 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> <!-- jQuery slim 버전 링크 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> <!-- Bootstrap JS 링크 -->
    </section> <!-- section 태그 끝 -->
    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->
</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
