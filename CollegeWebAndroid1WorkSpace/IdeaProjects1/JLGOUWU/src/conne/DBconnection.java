package conne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static String url="jdbc:mysql://localhost:3306/jlgouwu?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String sa="root";
	private static String pwd="tiger";
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
		Connection conn=DBconnection.getconnection();
		System.out.println(conn);
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
//		System.out.println(new Date().toLocaleString());
	}
}
