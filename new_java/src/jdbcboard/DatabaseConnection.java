package jdbcboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
	
	private DatabaseConnection() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "javaUser","skduddn99!");
		}
		catch(ClassNotFoundException e) {
		System.out.println("드라이버를 찾을 수 없습니다.");
		e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
	}
	public static DatabaseConnection getInstance() {
		return dbc;
	}
	public Connection getConnection() {
		return conn;
	}
}
