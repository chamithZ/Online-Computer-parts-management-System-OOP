package webpro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CusDBUtil {
	private static boolean ifSuccess;
	private static Connection con=null;
	private static Statement st=null;
	private static ResultSet rst=null;
	
	public static boolean validate(String username,String password) {

		try {
			dbConnect connect=new dbConnect();
			con=connect.getConnection();
			st = con.createStatement();
			String sql = "select * from user where email='"+username+"' and password='"+password+"'";
			rst = st.executeQuery(sql);
			
			if (rst.next()) {
				ifSuccess = true;
			} else {
				ifSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ifSuccess;
	}
	
	
	/*
	 * public static List<Customer> validate(String username,String password){
	 * 
	 * ArrayList<Customer> cus=new ArrayList<>();
	 * 
	 * //create db connection
	 * 
	 * 
	 * try { dbConnect connect=new dbConnect(); con=connect.getConnection();
	 * 
	 * Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * String
	 * sql="select * from customer where username='"+username+"' and password='"
	 * +password+"'"; rst= st.executeQuery(sql);
	 * 
	 * if(rst.next()) { String id=rst.getString(1); int firstname=rst.getInt(2);
	 * String lastname=rst.getString(3); String address=rst.getString(4); String
	 * email=rst.getString(5); String phone=rst.getString(6); String
	 * state=rst.getString(7); String country=rst.getString(8); String
	 * psw=rst.getString(9);
	 * 
	 * Customer c=new
	 * Customer(id,firstname,lastname,address,email,phone,state,country,psw);
	 * //Customer c=new Customer(id,firstname,lastname,address,email,phone,state);
	 * cus.add(c); }
	 * 
	 * } catch(Exception e) { e.printStackTrace(); } return cus;
	 * 
	 * 
	 * }
	 */

	public static boolean insertcustomer(String name,String email,String phone,String username,String password) {
		boolean isSuccess=false;
		
		//create db connection
		String url="jdbc:mysql://localhost:3306/pcmart";
		String user="root";	
		String pass="16820";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection  con =DriverManager.getConnection(url,user,pass);
			Statement stmt = con.createStatement();
			String sql="insert into user values( '"+name+"',0,'"+email+"','"+phone+"','"+username+"','"+password+"')";
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			} else {
				isSuccess=false;
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("sql error"+e.getMessage());
		}
		
		return isSuccess;
		
	}

}
