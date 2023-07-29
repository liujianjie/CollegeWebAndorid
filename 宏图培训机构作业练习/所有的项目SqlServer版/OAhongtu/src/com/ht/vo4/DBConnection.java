package com.ht.vo4;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String uname="scott";
	private static String pwd="tiger";
	private static Connection conn;
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
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, uname, pwd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());
	}
}
