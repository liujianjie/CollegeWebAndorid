package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class DBconnection {
	private String url = "jdbc:mysql://localhost:3306/myworkdata?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private String driverName="com.mysql.jdbc.Driver";
	private String user = "root";
	private String userpwd = "tiger";
	Connection conn;
	
	private void getConnection() throws ClassNotFoundException, SQLException{
		if(conn == null || conn.isClosed()){
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, userpwd);
		}
	}
	// 关闭连接
	public void closeConnection() throws SQLException{
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}
	// 查询
	public ResultSet query(String sql) throws Exception{
		getConnection();
		ResultSet rs = null;
		Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stat.executeQuery(sql);
		return rs;
	}
	// 修改
	public void udpate(String sql) throws Exception{
		getConnection();
		Statement stat = conn.createStatement();
		stat.execute(sql);
	}
}
