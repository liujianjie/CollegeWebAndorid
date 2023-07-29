package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String uname="scott";
	private static String pwd="tiger";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			if(conn==null||conn.isClosed()){
				try {
					conn=DriverManager.getConnection(url, uname, pwd);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());
	}
}
