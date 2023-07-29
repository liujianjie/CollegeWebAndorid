package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false";
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
	// �ر�����
	public void closeConnection() throws SQLException{
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}
	// ��ѯ
	public ResultSet query(String sql) throws Exception{
		getConnection();
		ResultSet rs = null;
		Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stat.executeQuery(sql);
		return rs;
	}
	// �޸�\����
	public int udpate(String sql) throws Exception{
		getConnection();
		Statement stat = conn.createStatement();
		try{
			return stat.executeUpdate(sql);// ����ִ�гɹ�������sql���
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}
