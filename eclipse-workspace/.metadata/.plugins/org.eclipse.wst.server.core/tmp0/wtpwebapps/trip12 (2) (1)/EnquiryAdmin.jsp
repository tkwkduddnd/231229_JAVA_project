<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<%@ page import="java.util.List" %> <!-- java.util.List 패키지 임포트 -->
<%@ page import="java.util.ArrayList" %> <!-- java.util.ArrayList 패키지 임포트 -->
<%@ page import="java.sql.*" %> <!-- java.sql 패키지 임포트 -->
<%@ page import="java.util.Date" %> <!-- java.util.Date 패키지 임포트 -->

<%@ include file="AdminNav.jsp" %> <!-- AdminNav.jsp 파일 포함 -->

<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
    <title>여행사 홈페이지 - 문의 관리</title> <!-- 웹페이지 제목 설정 -->
    <link rel="stylesheet" href="OneToOne.css"> <!-- OneToOne.css 스타일시트 링크 -->
    <link rel="stylesheet" href="Common.css?after"> <!-- 공통 CSS 스타일시트 링크, 캐시를 피하기 위해 쿼리 문자열 추가 -->
    <script>
        function deleteOneToOne(id) { <!-- 게시글 삭제 함수 -->
            if (confirm("이 게시글을 삭제하시겠습니까?")) { <!-- 삭제 확인 알림창 -->
                // AJAX를 사용하여 서블릿에 비동기 요청을 보냄
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        // 삭제 성공 메시지를 보여주고 페이지를 다시 로드
                        alert("삭제가 정상적으로 완료되었습니다."); // 추가된 부분
                        location.reload();
                    }
                };
                xhr.open("POST", "DeleteOneToOneServlet", true);
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhr.send("id=" + id);
            }
        }
    </script> <!-- 게시글 삭제를 위한 자바스크립트 함수 선언 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <section id="tableSection"> <!-- tableSection id 섹션 시작 -->
        <h2>1:1 문의 관리</h2> <!-- 섹션 제목 설정 -->
        <table> <!-- 테이블 시작 -->
            <!-- 테이블 헤더 설정 -->
            <tr> 
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>조회수</th>
                <th></th>
            </tr>
        
            <% 
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

                    String query = "SELECT * FROM onetooneboard ORDER BY id DESC"; // 내림차순 정렬 쿼리
                    PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
                    ResultSet rs = pst.executeQuery(); // 쿼리 실행

                    List<Object[]> resultList = new ArrayList<>(); // Object 배열을 사용하는 List 생성

                    while (rs.next()) { // 결과 집합에 다음 행이 있을 때까지 반복
                        Object[] rowData = {rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDate("date"), rs.getInt("viewCount")}; // 각 행의 데이터를 Object 배열에 저장
                        resultList.add(rowData); // List에 rowData 추가
                    }

                    for (int i = 0; i < resultList.size(); i++) { // resultList의 크기만큼 반복
                        Object[] rowData = resultList.get(i); // resultList에서 rowData를 하나씩 가져옴

                        out.println("<tr>");
                        out.println("<td>" + (i+1) + "</td>");
                        out.println("<td><a href='viewOneToOne.jsp?id=" + rowData[0] + "'>" + rowData[1] + "</a></td>");
                        out.println("<td>" + rowData[2] + "</td>");
                        out.println("<td>" + rowData[3] + "</td>");
                        out.println("<td>" + rowData[4] + "</td>");
                        out.println("<td><button onclick=\"deleteOneToOne(" + rowData[0] + ")\" style=\"font-size: smaller;\">삭제</button></td>"); // 삭제 버튼 추가
                        out.println("</tr>");
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // 예외 발생 시 스택 추적 출력
                }
            %> <!-- JSP 스크립트릿 끝 -->
        </table> <!-- 테이블 끝 -->
    </section> <!-- tableSection id 섹션 끝 -->
    

    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
