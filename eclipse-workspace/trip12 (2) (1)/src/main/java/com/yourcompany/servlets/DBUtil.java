// 패키지 정의
package com.yourcompany.servlets;

// 필요한 라이브러리 임포트
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 데이터베이스 유틸리티 클래스
public class DBUtil {

    // MySQL 서버의 JDBC URL, 사용자 이름, 비밀번호 상수 정의
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/webtrip";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    // 연결, 닫기 및 관리를 위한 JDBC 변수
    private static Connection connection;

    // 연결을 열기 위한 메소드
    public static Connection openConnection() throws SQLException {
        // 연결이 없거나 닫혀있는 경우 새로 연결을 시도
        if (connection == null || connection.isClosed()) {
            try {
                // 데이터베이스 연결을 위한 드라이버 로드
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 데이터베이스 연결
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            } catch (ClassNotFoundException e) {
                // 예외 발생 시, 스택 트레이스 출력
                e.printStackTrace();
            }
        }
        // 연결 객체 반환
        return connection;
    }

    // 연결을 닫기 위한 메소드
    public static void closeConnection() throws SQLException {
        // 연결이 존재하고 열려 있는 경우 연결을 닫음
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
