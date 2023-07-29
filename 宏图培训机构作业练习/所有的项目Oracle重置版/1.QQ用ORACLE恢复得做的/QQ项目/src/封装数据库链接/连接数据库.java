package 封装数据库链接;

import java.sql.*;

public class 连接数据库 {
	private static String url="jdbc:oracle:thin:@localhost:1521:orcls";//路径
	private static String driver="oracle.jdbc.driver.OracleDriver";//驱动
	private static String username="review";
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
	public static Connection shujuku(){
		
		try {
			if(conn==null||conn.isClosed()){
				conn=DriverManager.getConnection(url,username,pwd);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(连接数据库.shujuku());
		
	}
}
