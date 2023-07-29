package com.goods.util;


import java.sql.*;
public class JDBCUtils {
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
   public static Connection getConnection() throws Exception{
	// 1. 注册数据库的驱动
	   Class.forName("com.mysql.jdbc.Driver");
		// 2.通过DriverManager获取数据库连接
		String url = "jdbc:mysql://localhost:3306/tbook?useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String password = "tiger";
		Connection conn = DriverManager.getConnection (url, username, 
	     			password);   

       return conn;		
   }
   
   public static void release(ResultSet rs, Statement stmt, Connection conn){
	   if(rs!=null){
		 try{
			   rs.close();
	     }catch(SQLException e){
		   e.printStackTrace();
		   }
		 rs=null;
	   }
	   
	   if(stmt!=null){
			 try{
				   stmt.close();
		     }catch(SQLException e){
			   e.printStackTrace();
			   }
			 stmt=null;
	   }
	   
	   if(conn!=null){
			 try{
				   conn.close();
		     }catch(SQLException e){
			   e.printStackTrace();
			   }
			 conn=null;
	   }
	   
   }
}
