package webpro;


import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
	private static String url = "jdbc:mysql://localhost:3306/quentech";
	private static String userName = "root";
	private static String password = "16820";
	private static Connection con;

	public  Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is not success!!!");
		}
		
		return con;
	}
	

}
