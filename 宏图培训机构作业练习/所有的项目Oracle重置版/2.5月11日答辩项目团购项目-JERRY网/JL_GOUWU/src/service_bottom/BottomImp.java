package service_bottom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BottomBean;
import bean.MoldBean;

import conne.DBconnection;

public class BottomImp implements Ibottom{

	public List selbottom() {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from bottom b left join mold m on b.mold_id=m.mold_id order by b.bottom_id";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				BottomBean bot=new BottomBean();
				bot.setMold_id(rs.getInt("mold_id"));
				bot.setBottom_id(rs.getInt("bottom_id"));
				bot.setBottom(rs.getString("bottom"));
				bot.setMold(rs.getString("mold"));
				list.add(bot);
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}
		
		return list;
	}

	public boolean addbottom(BottomBean bot) {
		Connection conn=DBconnection.getconnection();
		String sql="insert into bottom values(SEQ_REVIEW_JERRY.nextval,?,?)";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1,bot.getBottom());
			prst.setInt(2, bot.getMold_id());
			int i=prst.executeUpdate();
			prst.close();
			conn.close();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean alerthang(BottomBean bot) {
		Connection conn=DBconnection.getconnection();
		String sql="update bottom set bottom=?,mold_id=? where bottom_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1,bot.getBottom());
			prst.setInt(2, bot.getMold_id());
			prst.setInt(3, bot.getBottom_id());
			int i=prst.executeUpdate();
			prst.close();
			conn.close();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delbottom(int id) {
		Connection conn=DBconnection.getconnection();
		String sql="delete from bottom where bottom_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, id);
			int rs=prst.executeUpdate();
			prst.close();
			conn.close();
			if(rs>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public BottomBean selhang(int id) {
		BottomBean bot=new BottomBean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from bottom where bottom_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				bot.setBottom_id(id);
				bot.setBottom(rs.getString("bottom"));
				bot.setMold_id(rs.getInt("mold_id"));
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bot;
	}

	public List selMold() {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from mold";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				MoldBean mod=new MoldBean();
				mod.setMold_id(rs.getInt(1));
				mod.setMold(rs.getString(2));
				list.add(mod);
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

	public List selfenlei(int mold_id) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from bottom b left join mold m on b.mold_id=m.mold_id where b.mold_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, mold_id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				BottomBean bot=new BottomBean();
				bot.setBottom_id(rs.getInt("bottom_id"));
				bot.setBottom(rs.getString("bottom"));
				bot.setMold_id(rs.getInt("mold_id"));
				bot.setMold(rs.getString("mold"));
				list.add(bot);
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

	public int selonnbottom_id(int mold_id) {
		int b_id=1;
		Connection conn=DBconnection.getconnection();
//		String sql="select top 1 bottom_id from bottom where mold_id=?";
		String sql="select * from(select bottom_id from bottom where mold_id=?)where rownum<=1 ";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, mold_id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				b_id=rs.getInt("bottom_id");
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b_id;
	}

	public String selbottomname(int bottom_id) {
		String bottom="";
		Connection conn=DBconnection.getconnection();
		String sql="select bottom from bottom where bottom_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, bottom_id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				bottom=rs.getString("bottom");
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bottom;
	}

	public String selMold(int moldid) {
		String mold="";
		Connection conn=DBconnection.getconnection();
		String sql="select mold from mold where mold_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, moldid);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				mold=rs.getString("mold");
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mold;
	}

}
