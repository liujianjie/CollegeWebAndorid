package com.aaa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//链接mysql数据库  普通的jdbc
public class DBconnection {
	private static String url = "jdbc:mysql://localhost:3306/menu?serverTimezone=UTC";//serverTimezone=UTC解决mysql时差问题
	private static String driver = "com.mysql.jdbc.Driver";//驱动器
	private static String user = "root";//mysql登录用户
	private static String pwd = "tiger";//mysql登录密码
	private static Connection conn = null;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	//单例模式，可以重复使用
	public static Connection getconnection(){
		try {
			if(conn==null||conn.isClosed()){
				conn=DriverManager.getConnection(url,user,pwd);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void main(String[] args) throws SQLException {
		//测试是否连接数据库成功
		System.out.println(DBconnection.getconnection());
		System.out.println("555");
	}
}
