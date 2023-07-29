package service_mold;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MoldBean;

import conne.DBconnection;

public class MoldImp implements Imold{

	public List selmold() {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from mold";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			System.out.println(rs==null);
			while(rs.next()){
				MoldBean mold=new MoldBean();
				mold.setMold_id(rs.getInt("mold_id"));
				mold.setMold(rs.getString("mold"));
				list.add(mold);
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
