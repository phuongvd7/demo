package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConn() {
		//mysql server account
		final String username = "root";
		final String password = "1234";
		
		final String url = "jdbc:mysql://localhost:3306/hello";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url , username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//ham cua exception de in ra loi
			System.out.println("Loi ket noi db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		getConn();
	}
}
