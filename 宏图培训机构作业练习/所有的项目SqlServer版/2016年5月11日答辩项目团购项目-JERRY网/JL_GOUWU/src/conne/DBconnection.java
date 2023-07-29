package conne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.MoldBean;

public class DBconnection {
	private static String url="jdbc:oracle:thin:@localhost:1521:orcls";
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String sa="review";
	private static String pwd="liujianjie";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static Connection getconnection(){
			try {
				if(conn==null||conn.isClosed()){
					conn=DriverManager.getConnection(url,sa,pwd);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return conn;
	}
	
	public static void main(String[] args) {
//		List list=new ArrayList();
//		Connection conn=DBconnection.getconnection();
//		System.out.println(conn);
//		String sql="select * from mold";
//		try {
//			PreparedStatement prst=conn.prepareStatement(sql);
//			ResultSet rs=prst.executeQuery();
//			while(rs.next()){
//				MoldBean mod=new MoldBean();
//				mod.setMold_id(rs.getInt(1));
//				mod.setMold(rs.getString(2));
//				list.add(mod);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(list.size());
		System.out.println(new Date().toLocaleString());
	}
}
