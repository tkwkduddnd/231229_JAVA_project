<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- JSP 페이지 설정, 내용 유형은 HTML, 문자 인코딩은 UTF-8 -->
<%@ page import="java.sql.*" %> <!-- java.sql 패키지 임포트 -->
<%@ page import="javax.servlet.http.HttpSession" %> <!-- javax.servlet.http.HttpSession 패키지 임포트 -->
<!DOCTYPE html> <!-- HTML5 DOCTYPE 선언 -->
<html lang="en"> <!-- html 태그 시작, 언어는 영어(en) -->
<head> <!-- head 태그 시작 -->
    <meta charset="UTF-8"> <!-- 문자 인코딩 선언, UTF-8 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- 반응형 웹 디자인을 위한 뷰포트 설정 -->
    <title>문의 내역</title> <!-- 웹페이지 제목 설정 -->
    <link rel="stylesheet" type="text/css" href="Review.css"> <!-- Review.css 스타일시트 링크 -->
    <style>
        .컨테이너 {
            overflow-x: auto;
        }
    </style> <!-- 컨테이너 클래스 스타일 설정 -->
</head> <!-- head 태그 끝 -->

<body> <!-- body 태그 시작 -->
<section> <!-- section 태그 시작 -->
    <div class="컨테이너"> <!-- 컨테이너 클래스 div 시작 -->
        <h2>문의 내역</h2> <!-- 섹션 제목 설정 -->
        <!-- 여기에 문의 내역을 나열하는 테이블 또는 리스트를 만듭니다. -->
        <table border="1" class="right-content-table"> <!-- right-content-table 클래스 테이블 시작 -->
            <thead> <!-- 테이블 헤더 시작 -->
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
            </thead> <!-- 테이블 헤더 끝 -->
            <tbody> <!-- 테이블 바디 시작 -->
                <% 
                    Connection con = null;
                    PreparedStatement pst = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

                        // 사용자 정보 가져오기
                        HttpSession sessionObj = request.getSession(false);

                        // 세션이 null이거나 유효하지 않은 경우 예외 처리
                        if (sessionObj != null && sessionObj.getAttribute("username") != null) {
                            String username = (String) sessionObj.getAttribute("username");

                            String query = "SELECT * FROM onetooneboard WHERE author = ? ORDER BY id ASC"; // 오름차순 정렬 쿼리
                            pst = con.prepareStatement(query); // PreparedStatement 객체 생성
                            pst.setString(1, username); // 첫 번째 매개변수에 username 설정
                            rs = pst.executeQuery(); // 쿼리 실행

                            while (rs.next()) { // 결과 집합에 다음 행이 있을 때까지 반복
                %>
                                <tr>
                                    <td><%= rs.getInt("id") %></td>
                                    <td><%= rs.getString("title") %></td>
                                    <td><%= rs.getString("author") %></td>
                                    <td><%= rs.getString("content") %></td>
                                    <td><%= rs.getTimestamp("date") %></td>
                                    <td><%= rs.getInt("viewCount") %></td>
                                </tr> <!-- 각 행의 데이터를 테이블에 추가 -->
                <%
                            }
                        } else {
                %>
                            <tr>
                                <td colspan="6">세션이 null이거나 로그인이 필요합니다.</td> <!-- 세션이 null이거나 유효하지 않은 경우 메시지 출력 -->
                            </tr>
                <%
                        }
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace(); // 예외 발생 시 스택 추적 출력
                    } finally {
                        // Connection, PreparedStatement, ResultSet을 닫아주는 것이 좋습니다.
                        try {
                            if (rs != null) rs.close();
                            if (pst != null) pst.close();
                            if (con != null) con.close();
                        } catch (SQLException e) {
                            e.printStackTrace(); // 예외 발생 시 스택 추적 출력
                        }
                    }
                %> <!-- JSP 스크립트릿 끝 -->
            </tbody> <!-- 테이블 바디 끝 -->
        </table> <!-- 테이블 끝 -->
    </div> <!-- 컨테이너 클래스 div 끝 -->
</section> <!-- section 태그 끝 -->

<jsp:include page="footer.jsp" /> <!-- footer.jsp 파일 포함 -->

</body> <!-- body 태그 끝 -->
</html> <!-- html 태그 끝 -->
