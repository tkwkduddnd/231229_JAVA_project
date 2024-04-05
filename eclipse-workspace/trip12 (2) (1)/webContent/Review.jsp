<%@ page language="java" contentType="text/html; charset=UTF-8"%> <!-- JSP 페이지 설정, 언어는 자바, 인코딩은 UTF-8 -->
<%@ page import="java.sql.*" %> <!-- java.sql 패키지의 모든 클래스를 import -->

<!DOCTYPE html> <!-- HTML5 선언 -->
<html lang="en"> <!-- HTML 시작, 언어는 영어 -->

<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹사이트 설정 -->
    <title>후기 관리</title> <!-- 웹페이지 제목 설정 -->
    <link rel="stylesheet" type="text/css" href="Review.css"> <!-- Review.css 스타일시트 연결 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
    <section> <!-- section 태그 시작 -->
        <div class="right-content"> <!-- right-content 클래스 div 시작 -->
            <h2>나의 후기</h2> <!-- 제목 설정 -->
            <table border="1"> <!-- 테이블 시작 -->
                <thead> <!-- 테이블 헤더 시작 -->
                    <tr> <!-- 테이블 row 시작 -->
                        <th>번호</th> <!-- 테이블 header -->
                        <th>제목</th> <!-- 테이블 header -->
                        <th>작성자</th> <!-- 테이블 header -->
                        <th>내용</th> <!-- 테이블 header -->
                        <th>날짜</th> <!-- 테이블 header -->
                        <th>조회수</th> <!-- 테이블 header -->
                    </tr>
                </thead> <!-- 테이블 헤더 끝 -->
                <tbody> <!-- 테이블 바디 시작 -->
                    <% // Java 코드 시작
                        Connection con = null;
                        PreparedStatement pst = null;
                        ResultSet rs = null;

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // DB 연결

                            String username = (String) session.getAttribute("username"); // 세션에서 username 가져옴

                            String query = "SELECT * FROM board WHERE author = ? ORDER BY id ASC"; // SQL 쿼리, 작성자가 username인 게시글을 id를 기준으로 오름차순 정렬
                            pst = con.prepareStatement(query); // PreparedStatement 생성
                            pst.setString(1, username); // 첫 번째 파라미터에 username 설정
                            rs = pst.executeQuery(); // 쿼리 실행

                            while (rs.next()) { // 결과셋에서 행을 하나씩 가져옴
                    %>
                        <tr> <!-- 테이블 row 시작 -->
                            <td><%= rs.getInt("id") %></td> <!-- 번호 출력 -->
                            <td><%= rs.getString("title") %></td> <!-- 제목 출력 -->
                            <td><%= rs.getString("author") %></td> <!-- 작성자 출력 -->
                            <td><%= rs.getString("content") %></td> <!-- 내용 출력 -->
                            <td><%= rs.getTimestamp("date") %></td> <!-- 날짜 출력 -->
                            <td><%= rs.getInt("viewCount") %></td> <!-- 조회수 출력 -->
                        </tr> <!-- 테이블 row 끝 -->
                    <%
                            }
                        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
                            e.printStackTrace(); // 예외 처리
                        } finally { // finally 블록
                            try {
                                if (rs != null) rs.close(); // ResultSet이 null이 아니면 닫음
                                if (pst != null) pst.close(); // PreparedStatement가 null이 아니면 닫음
                                if (con != null) con.close(); // Connection이 null이 아니면 닫음
                            } catch (SQLException e) { // SQLException 발생 시
                                e.printStackTrace(); // 예외 처리
                            }
                        }
                    %> <!-- Java 코드 끝 -->
                </tbody> <!-- 테이블 바디 끝 -->
            </table> <!-- 테이블 끝 -->
        </div> <!-- right-content 클래스 div 끝 -->
    </section> <!-- section 태그 끝 -->
    <jsp:include page="footer.jsp" /> <!-- footer.jsp 파일을 include -->
</body> <!-- body 태그 끝 -->

</html> <!-- HTML 끝 -->
