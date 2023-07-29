package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装的得到链接mysql数据库的对象
 * */
public class JDBCUtils {
	public static void main(String[] args) throws Exception {
		System.out.println(getCon());
	}
	//获取连接对象的方法
	public static Connection getCon() throws Exception {
		// 1. 注册数据库的驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.通过DriverManager获取Connection数据库连接
		//创建应用程序与数据库连接的Connection对象
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mybook?useUnicode=true&characterEncoding=utf-8",
				"root", "tiger");
		return con;
	}
	//关闭连接，释放资源
	public static void release(ResultSet rs, PreparedStatement preStmt, Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(preStmt!=null) {
			try {
				preStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			preStmt = null;
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	}
}
