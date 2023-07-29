package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconntion {
	private static String url="jdbc:oracle:thin:@localhost:1521:orcls";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String sa="review";
	private static String pwd="liujianjie";
	private static Connection conn=null;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static Connection getconnection(){
		try {
			if(conn==null||conn.isClosed()){
				conn=DriverManager.getConnection(url,sa,pwd);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void main(String[] args) {
		System.out.println(DBconntion.getconnection());
	}
}
