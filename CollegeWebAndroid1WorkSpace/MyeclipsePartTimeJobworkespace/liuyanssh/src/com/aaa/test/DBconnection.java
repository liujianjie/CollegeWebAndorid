package com.aaa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//����mysql���ݿ�  ��ͨ��jdbc
public class DBconnection {
	private static String url = "jdbc:mysql://localhost:3306/menu?serverTimezone=UTC";//serverTimezone=UTC���mysqlʱ������
	private static String driver = "com.mysql.jdbc.Driver";//������
	private static String user = "root";//mysql��¼�û�
	private static String pwd = "tiger";//mysql��¼����
	private static Connection conn = null;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	//����ģʽ�������ظ�ʹ��
	public static Connection getconnection(){
		try {
			if(conn==null||conn.isClosed()){
				conn=DriverManager.getConnection(url,user,pwd);
				
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void main(String[] args) throws SQLException {
		//�����Ƿ��������ݿ�ɹ�
		System.out.println(DBconnection.getconnection());
		System.out.println("555");
	}
}
