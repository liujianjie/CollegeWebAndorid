package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	public static Connection getCon() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/book_store?useUnicode=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true&failOverReadOnly=false",
				"root", "tiger");
		return con;
	}
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
