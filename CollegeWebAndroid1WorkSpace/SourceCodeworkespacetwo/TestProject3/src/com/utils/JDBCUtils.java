package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��װ�ĵõ�����mysql���ݿ�Ķ���
 * */
public class JDBCUtils {
	public static void main(String[] args) throws Exception {
		System.out.println(getCon());
	}
	//��ȡ���Ӷ���ķ���
	public static Connection getCon() throws Exception {
		// 1. ע�����ݿ������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.ͨ��DriverManager��ȡConnection���ݿ�����
		//����Ӧ�ó��������ݿ����ӵ�Connection����
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mybook?useUnicode=true&characterEncoding=utf-8",
				"root", "tiger");
		return con;
	}
	//�ر����ӣ��ͷ���Դ
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
