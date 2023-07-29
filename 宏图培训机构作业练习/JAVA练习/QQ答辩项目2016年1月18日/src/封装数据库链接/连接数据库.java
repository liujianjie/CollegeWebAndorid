package 封装数据库链接;

import java.sql.*;

public class 连接数据库 {
	private static String url="jdbc:sqlserver://127.0.0.1:1433;databasename=QQ数据库";//路径
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动
	private static String username="sa";
	private static String pwd="123456";
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
	
}
