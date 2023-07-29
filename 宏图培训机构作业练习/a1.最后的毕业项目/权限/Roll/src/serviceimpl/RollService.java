package serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;

public class RollService {
	public List   queryrollbyuid(int uid){
		List list =new ArrayList();
		String sql="select msid from rolles where usid="+uid;
		Connection conn=DBConnection.getConnection();
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			ResultSet rs= prst.executeQuery();
			while(rs.next()){
				list.add(rs.getString("msid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
	
	public void delrollbyuid(int uid){
		String sql="delete from rolles where usid="+uid;
		Connection conn=DBConnection.getConnection();
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			 prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saverollbyuid(int uid,int mid){
		String sql="insert into rolles values(seq_orcl.NEXTVAL,"+uid+","+mid+")";
		Connection conn=DBConnection.getConnection();
		try {
			PreparedStatement prst = conn.prepareStatement(sql);
			 prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
