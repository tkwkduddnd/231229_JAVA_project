package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserManagementServlet") // 서블릿 매핑을 어노테이션을 통해 정의
public class UserManagementServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 UserManagementServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정

        String searchKeyword = request.getParameter("search"); // 요청 파라미터 중 "search" 값을 가져와 searchKeyword 변수에 저장

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            String query; // SQL 쿼리문을 저장할 query 변수 선언
            if (searchKeyword != null && !searchKeyword.isEmpty()) { // searchKeyword가 null이 아니고 비어있지 않은 경우
                query = "SELECT * FROM users WHERE fullName LIKE ?"; // fullName이 searchKeyword를 포함하는 사용자를 검색하는 쿼리문 작성
            } else {
                query = "SELECT * FROM users"; // 모든 사용자를 검색하는 쿼리문 작성
            }

            PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성

            if (searchKeyword != null && !searchKeyword.isEmpty()) { // searchKeyword가 null이 아니고 비어있지 않은 경우
                pst.setString(1, "%" + searchKeyword + "%"); // 첫번째 인자에 searchKeyword를 포함하는 문자열을 설정
            }

            ResultSet rs = pst.executeQuery(); // SQL 쿼리 실행하고 결과를 ResultSet 객체에 저장

            List<User> userList = new ArrayList<>(); // User 객체를 저장할 userList 생성
            while (rs.next()) { // ResultSet 객체에 다음 행이 있을 때까지 반복
                User user = new User(); // User 객체 생성
                user.setId(rs.getInt("id")); // id 값을 가져와 user 객체에 설정
                user.setUsername(rs.getString("username")); // username 값을 가져와 user 객체에 설정
                user.setFullName(rs.getString("fullName")); // fullName 값을 가져와 user 객체에 설정
                user.setGender(rs.getString("gender")); // gender 값을 가져와 user 객체에 설정
                user.setBirthday(rs.getDate("birthday").toString()); // birthday 값을 가져와 user 객체에 설정

                userList.add(user); // userList에 user 객체 추가
            }

            request.setAttribute("userList", userList); // request 객체에 userList 속성 추가

            rs.close(); // ResultSet 객체 닫기
            pst.close(); // PreparedStatement 객체 닫기
            con.close(); // Connection 객체 닫기

            if (userList.isEmpty() && searchKeyword != null && !searchKeyword.isEmpty()) { // userList가 비어있고 searchKeyword가 null이 아니고 비어있지 않은 경우
                request.setAttribute("searchNotFound", true); // request 객체에 "searchNotFound" 속성 추가
            }
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        request.getRequestDispatcher("UserManagement.jsp").forward(request, response); // UserManagement.jsp 페이지로 포워드
    }
}
