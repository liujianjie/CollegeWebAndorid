package com.zuxia.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	
	private static final String CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static final String CONN_STRING = "jdbc:sqlserver://localhost:1433;databaseName=qlzx";
	private static final String USER = "sa";
	private static final String PASS = "tiger";
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(CONN_STRING,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeDB(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(new DBConn().getConn());
	}
}
