
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBconnection {
	private static String url="jdbc:mysql://localhost:3306/c2c?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8";
	private static String driver="com.mysql.jdbc.Driver";
	private static String sa="root";
	private static String pwd="tiger";
	private static Connection conn=null;
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public static Connection getconnection(){
			try {
				if(conn==null||conn.isClosed()){
					conn=DriverManager.getConnection(url,sa,pwd);
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			return conn;
	}
	
	public static void main(String[] args) {
		Connection conn=DBconnection.getconnection();
		System.out.println(conn);
	}
}
