package com.yourcompany.servlets; // 패키지 선언

import java.io.IOException; // 필요한 클래스들을 임포트
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ProductRegistrationServlet") // 서블릿 매핑을 어노테이션을 통해 정의
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 파일 크기가 이 값 이상이면 파일을 임시 저장 위치에 저장
                 maxFileSize = 1024 * 1024 * 10,      // 파일 하나당 최대 크기
                 maxRequestSize = 1024 * 1024 * 50)   // 요청 전체에 대한 최대 크기
public class ProductRegistrationServlet extends HttpServlet { // HttpServlet 클래스를 상속받는 ProductRegistrationServlet 클래스 선언
    private static final long serialVersionUID = 1L; // 직렬화에 사용될 serialVersionUID 정의

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // HTTP POST 요청을 처리하는 메소드
        request.setCharacterEncoding("UTF-8"); // 요청 인코딩을 UTF-8로 설정
        response.setCharacterEncoding("UTF-8"); // 응답 인코딩을 UTF-8로 설정
        response.setContentType("text/html;charset=UTF-8"); // 응답 컨텐츠 타입을 "text/html; charset=UTF-8"로 설정

        // 요청 파라미터 값을 가져와 변수에 저장
        String theme = request.getParameter("theme");
        String productCode = request.getParameter("productCode");
        String productName = request.getParameter("productName");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        int remainingCount = Integer.parseInt(request.getParameter("remainingCount")); // 정수로 변환하여 저장
        String productStatus = request.getParameter("productStatus");
        int price = Integer.parseInt(request.getParameter("price")); // 정수로 변환하여 저장
        String details = request.getParameter("details");
        try {
            // 데이터베이스 연결
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로딩
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtrip", "root", "1234"); // 데이터베이스 연결

            // 파일 업로드 처리
            Part filePart = request.getPart("productImageFile"); // 요청 파라미터 중 "productImageFile" 값을 Part 객체로 가져옴
            String fileName = getFileName(filePart); // 파일 이름 가져오기

            // 파일 업로드 처리
            if (fileName != null && !fileName.isEmpty()) { // 파일 이름이 null이 아니고 비어 있지 않은 경우
                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads"; // 업로드 경로 설정

                File uploadDir = new File(uploadPath); // 업로드 디렉토리 File 객체 생성
                if (!uploadDir.exists()) { // 업로드 디렉토리가 존재하지 않는 경우
                    uploadDir.mkdir(); // 업로드 디렉토리 생성
                }

                // 파일 경로를 상대경로로 변경
                String relativeFilePath = "images/products/" + fileName;

                // 상대경로를 절대경로로 변환
                String absoluteFilePath = getServletContext().getRealPath("") + File.separator + relativeFilePath;

                filePart.write(absoluteFilePath); // 파일 업로드

                // 데이터베이스에 상품 정보 삽입
                String query = "INSERT INTO products (theme, productImage, productCode, productName, departureTime, "
                        + "arrivalTime, remainingCount, productStatus, price, details) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // 상품 정보를 삽입하는 SQL 쿼리문
                PreparedStatement pst = con.prepareStatement(query); // PreparedStatement 객체 생성
                // SQL 쿼리에 인자 값 설정
                pst.setString(1, theme);
                pst.setString(2, relativeFilePath); // 상대 경로로 저장
                pst.setString(3, productCode);
                pst.setString(4, productName);
                pst.setString(5, departureTime);
                pst.setString(6, arrivalTime);
                pst.setInt(7, remainingCount);
                pst.setString(8, productStatus);
                pst.setInt(9, price);
                pst.setString(10, details);

                int rowsAffected = pst.executeUpdate(); // SQL 쿼리 실행하고 영향받은 행의 수를 rowsAffected 변수에 저장
                if (rowsAffected > 0) { // SQL 쿼리 실행 결과 영향받은 행의 수가 0보다 큰 경우 (상품 등록 성공)
                    // 상품 등록 성공
                    request.setAttribute("message", "상품등록이 완료되었습니다!"); // "message"이라는 이름으로 성공 메시지를 request에 저장
                } else { // SQL 쿼리 실행 결과 영향받은 행의 수가 0인 경우 (상품 등록 실패)
                    // 상품 등록 실패
                    request.setAttribute("message", "상품등록에 실패했습니다. 다시 시도해주세요."); // "message"이라는 이름으로 실패 메시지를 request에 저장
                }

                pst.close(); // PreparedStatement 객체 닫기
            }

            con.close(); // Connection 객체 닫기
        } catch (ClassNotFoundException | SQLException e) { // ClassNotFoundException 또는 SQLException 발생 시
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        }

        // JSP 페이지로 포워딩
        request.getRequestDispatcher("ProductRegistration.jsp").forward(request, response); // "ProductRegistration.jsp" 페이지로 포워딩
    }

    private String getFileName(final Part part) { // 파일 이름을 가져오는 메소드
        final String partHeader = part.getHeader("content-disposition"); // "content-disposition" 헤더 값을 가져와 partHeader 변수에 저장
        for (String content : part.getHeader("content-disposition").split(";")) { // "content-disposition" 헤더 값을 ";"로 분리하여 반복
            if (content.trim().startsWith("filename")) { // 분리된 값이 "filename"으로 시작하는 경우
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", ""); // "filename" 다음의 값을 반환
            }
        }
        return null; // "filename"으로 시작하는 값이 없는 경우 null 반환
    }
}
