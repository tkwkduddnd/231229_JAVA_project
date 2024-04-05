// LogoutServlet.java
package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 입출력 예외 처리를 위한 라이브러리

import javax.servlet.ServletException; // 서블릿 예외 처리를 위한 라이브러리
import javax.servlet.annotation.WebServlet; // 서블릿 연결을 위한 어노테이션 라이브러리
import javax.servlet.http.HttpServlet; // HttpServlet 클래스를 위한 라이브러리
import javax.servlet.http.HttpServletRequest; // HTTP 요청을 처리하기 위한 라이브러리
import javax.servlet.http.HttpServletResponse; // HTTP 응답을 처리하기 위한 라이브러리
import javax.servlet.http.HttpSession; // 세션 관리를 위한 라이브러리

@WebServlet("/LogoutServlet") // 서블릿 매핑을 위한 어노테이션, 클라이언트가 "/LogoutServlet" 요청을 하면 이 서블릿이 처리
public class LogoutServlet extends HttpServlet { // HttpServlet을 상속받는 LogoutServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용되는 고유 버전 ID

    protected void doGet(HttpServletRequest request, HttpServletResponse response) // HTTP GET 요청을 처리하는 메소드
            throws ServletException, IOException { // ServletException과 IOException 예외를 처리
        HttpSession session = request.getSession(); // 현재 세션을 가져옴
        session.invalidate(); // 현재 세션을 무효화 (로그아웃 처리)
        response.sendRedirect("Home.jsp"); // 로그아웃 후 홈페이지로 리다이렉트
    }
}
