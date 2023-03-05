package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DbConnection.getDB());
	}
	public static Connection getDB() {
		String url = "jdbc:mysql://localhost:3306/gjunex";
		String user = "root";
		String password = "1234";
		Connection con = null; //?
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
				return con; //?
	}
}
