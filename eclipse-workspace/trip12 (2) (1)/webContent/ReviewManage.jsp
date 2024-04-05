<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<%@ page import="java.util.List" %> <!-- List 클래스를 import -->
<%@ page import="java.util.ArrayList" %> <!-- ArrayList 클래스를 import -->
<%@ page import="java.sql.*" %> <!-- java.sql 패키지의 모든 클래스를 import -->
<%@ page import="java.util.Date" %> <!-- Date 클래스를 import -->

<%@ include file="AdminNav.jsp" %> <!-- AdminNav.jsp 파일을 include -->

<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>여행사 홈페이지 - 여행후기 관리</title> <!-- 웹페이지 제목 설정 -->
    <link rel="stylesheet" href="OneToOne.css"> <!-- OneToOne.css 스타일시트 연결 -->
    <link rel="stylesheet" href="Common.css?after"> <!-- Common.css 스타일시트 연결 -->
    <script> <!-- 스크립트 시작 -->
        function deletePost(id) { // 게시글 삭제 함수
            var confirmDelete = confirm("이 게시글을 삭제하시겠습니까?"); // 삭제 확인 메시지 출력
            if (confirmDelete) { // 삭제 확인 시
                var xhr = new XMLHttpRequest(); // XMLHttpRequest 객체 생성
                xhr.onreadystatechange = function() { // 상태 변화 시 함수 정의
                    if (xhr.readyState === 4) { // 통신 완료 시
                        if (xhr.status === 200) { // 통신 성공 시
                            alert("게시글이 정상적으로 삭제되었습니다."); // 성공 메시지 출력
                            location.reload(); // 페이지 새로고침
                        } else { // 통신 실패 시
                            alert("게시글 삭제에 실패했습니다."); // 실패 메시지 출력
                        }
                    }
                };
                xhr.open("POST", "DeleteServlet", true); // DeleteServlet에 POST 요청 설정
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // 헤더 설정
                xhr.send("id=" + id); // 요청 전송
            }
        }
    </script> <!-- 스크립트 끝 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <section id="tableSection"> <!-- section 태그 시작 -->
        <h2>여행후기 관리</h2> <!-- 제목 설정 -->
        <table> <!-- 테이블 시작 -->
            <tr> <!-- 테이블 row 시작 -->
                <th>번호</th> <!-- 테이블 header -->
                <th>제목</th> <!-- 테이블 header -->
                <th>작성자</th> <!-- 테이블 header -->
                <th>날짜</th> <!-- 테이블 header -->
                <th>조회수</th> <!-- 테이블 header -->
                <th></th> <!-- 테이블 header -->
            </tr>
        
            <% // Java 코드 시작
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // DB 연결

                    String query = "SELECT * FROM board ORDER BY id DESC"; // SQL 쿼리, id를 기준으로 내림차순 정렬
                    PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 생성
                    ResultSet rs = pst.executeQuery(); // 쿼리 실행

                    List<Object[]> resultList = new ArrayList<>(); // Object 배열을 사용하는 List 생성

                    while (rs.next()) { // 결과셋에서 행을 하나씩 가져옴
                        Object[] rowData = {rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDate("date"), rs.getInt("viewCount")}; // 결과셋에서 데이터를 가져와 Object 배열에 저장
                        resultList.add(rowData); // List에 Object 배열 추가
                    }

                    for (int i = 0; i < resultList.size(); i++) { // List의 크기만큼 반복
                        Object[] rowData = resultList.get(i); // List에서 Object 배열 가져옴

                        out.println("<tr>"); // 테이블 row 시작
                        out.println("<td>" + (i+1) + "</td>"); // 번호 출력
                        out.println("<td><a href='view.jsp?id=" + rowData[0] + "'>" + rowData[1] + "</a></td>"); // 제목 출력, 제목을 클릭하면 해당 게시글로 이동
                        out.println("<td>" + rowData[2] + "</td>"); // 작성자 출력
                        out.println("<td>" + rowData[3] + "</td>"); // 날짜 출력
                        out.println("<td>" + rowData[4] + "</td>"); // 조회수 출력
                        out.println("<td><button onclick=\"deletePost(" + rowData[0] + ")\" style=\"font-size: smaller;\">삭제</button></td>"); // 삭제 버튼 출력
                        out.println("</tr>"); // 테이블 row 끝
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // 예외 처리
                }
            %> <!-- Java 코드 끝 -->
        </table> <!-- 테이블 끝 -->
    </section> <!-- section 태그 끝 -->
</body> <!-- body 태그 끝 -->

</html> <!-- HTML 끝 -->
