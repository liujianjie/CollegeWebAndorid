package ��װ���ݿ�����;

import java.sql.*;

public class �������ݿ� {
	private static String url="jdbc:oracle:thin:@localhost:1521:orcls";//·��
	private static String driver="oracle.jdbc.driver.OracleDriver";//����
	private static String username="review";
	private static String pwd="liujianjie";
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
	public static void main(String[] args) {
		System.out.println(�������ݿ�.shujuku());
		
	}
}
