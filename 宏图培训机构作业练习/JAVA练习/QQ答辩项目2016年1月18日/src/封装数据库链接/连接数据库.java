package ��װ���ݿ�����;

import java.sql.*;

public class �������ݿ� {
	private static String url="jdbc:sqlserver://127.0.0.1:1433;databasename=QQ���ݿ�";//·��
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//����
	private static String username="sa";
	private static String pwd="123456";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	public static Connection shujuku(){
		
		try {
			if(conn==null||conn.isClosed()){
				conn=DriverManager.getConnection(url,username,pwd);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	
}
