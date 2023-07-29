package service_userorders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CommentBean;
import bean.JRuserBean;
import bean.OrdersBean;
import conne.DBconnection;

public class UserOrdersImp implements IUserOrders{

	public boolean zhuce(JRuserBean jr) {
		Connection conn=DBconnection.getconnection();
//		String sql="insert into jruser values(?,?,?,?,?,?,?)";
		String sql="insert into jruser(uname,pwd,jr_img,jointime,birthday,moneys,phone) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, jr.getUname());
			prst.setString(2, jr.getPwd());
			prst.setString(3, jr.getJr_img());
			prst.setString(4, jr.getJointime());
			prst.setString(5, jr.getBirthday());
			prst.setFloat(6, jr.getMoneys());
			prst.setString(7, jr.getPhone());
			int i=prst.executeUpdate();
			if(i>0){
				prst.close();
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean denglu(String uname, String pwd) {
		Connection conn=DBconnection.getconnection();
		String sql="select * from jruser where uname=? and pwd=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, uname);
			prst.setString(2, pwd);
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				rs.close();
				prst.close();
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public JRuserBean seljruser(String uname) {
		JRuserBean jr=new JRuserBean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from jruser where uname=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, uname);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				
				jr.setUname(uname);
				jr.setJruser_id(rs.getInt("jruser_id"));
				jr.setPwd(rs.getString("pwd"));
				jr.setJr_img(rs.getString("jr_img"));
				jr.setJointime(rs.getString("jointime"));
				jr.setBirthday(rs.getString("birthday"));
				jr.setMoneys(rs.getFloat("moneys"));
				jr.setPhone(rs.getString("phone"));
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jr;
	}

	public boolean addorders(OrdersBean order) {
		Connection conn=DBconnection.getconnection();
//		String sql="insert into orders values(?,?,?,?,?,?,?,?,?,?,?)";
		String sql="insert into orders(jruser_id,xfm,statu,gtime,g_id,gname,gdec,gprice,gwccount,total,gimg) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, order.getJruser_id());
			prst.setString(2, order.getXfm());
			prst.setInt(3, order.getStatu());
			prst.setString(4,order.getGtime());
			prst.setInt(5, order.getG_id());
			prst.setString(6,order.getGname());
			prst.setString(7, order.getGdec());
			prst.setFloat(8, order.getGprice());
			prst.setInt(9, order.getGwccount());
			prst.setFloat(10, order.getTotal());
			prst.setString(11,order.getGimg());

			int i=prst.executeUpdate();
			if(i>0){
				prst.close();
				conn.close();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List selorders(int pageCount,int currPage,int jruser_id) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from orders where jruser_id=? limit "+(currPage - 1) * pageCount+","+pageCount;
//		String sql="select top "+pageCount+" * from orders where orders_id not in(select top "+(currPage-1)*pageCount+" orders_id from orders) and jruser_id=?";
//		String sql="select * from(select row_number()over(order by orders_id) r,o.* from orders o where jruser_id=?)where r <= ("+pageCount+"*"+currPage+") and r > ("+currPage+"-1)*"+pageCount+"";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, jruser_id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				OrdersBean or=new OrdersBean();
				or.setOrders_id(rs.getInt("orders_id"));
				or.setJruser_id(jruser_id);
				or.setXfm(rs.getString("xfm"));
				or.setStatu(rs.getInt("statu"));
				or.setGtime(rs.getString("gtime"));
				or.setG_id(rs.getInt("g_id"));
				or.setGname(rs.getString("gname"));
				or.setGdec(rs.getString("gdec"));
				or.setGprice(rs.getFloat("gprice"));
				or.setGwccount(rs.getInt("gwccount"));
				or.setTotal(rs.getFloat("total"));
				or.setGimg(rs.getString("gimg"));
				list.add(or);
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

	public void alertsale(int g_id, int gwccount) {
		Connection conn=DBconnection.getconnection();
		String sql="update goods set g_sale=g_sale+? where g_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, gwccount);
			prst.setInt(2, g_id);
			prst.executeUpdate();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public OrdersBean xfyz(String xfm) {
		Connection conn=DBconnection.getconnection();
		String sql="select * from orders where xfm=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, xfm);

			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				OrdersBean or=new OrdersBean();
				or.setOrders_id(rs.getInt("orders_id"));
				or.setStatu(rs.getInt("statu"));
				rs.close();
				prst.close();
				conn.close();
				return or;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean alertstatu(int orders_id) {
		Connection conn=DBconnection.getconnection();
		String sql="update orders set statu=2 where orders_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, orders_id);

			int i=prst.executeUpdate();
			if(i>0){
				prst.close();
				conn.close();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean addcomment(CommentBean co) {
		Connection conn=DBconnection.getconnection();
//		String sql="insert into comments values(?,?,?,?)";
		String sql="insert into comments(jruser_id,g_id,c_comment,c_time) values(?,?,?,?)";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, co.getJruser_id());
			prst.setInt(2, co.getG_id());
			prst.setString(3, co.getC_comment());
			prst.setString(4, co.getC_time());
			int i=prst.executeUpdate();
			if(i>0){
				prst.close();
				conn.close();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List selcomment(int pageCount,int currPage,int gid) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from comments c left join jruser j on c.jruser_id=j.jruser_id where g_id=? limit "+(currPage - 1) * pageCount+","+pageCount;
//		String sql="select top "+pageCount+" * from comments c left join jruser j on c.jruser_id=j.jruser_id where c_id not in (select top "+(currPage-1)*pageCount+" c_id from comments) and g_id=?";
//		String sql="select * from(select row_number()over(order by g_id) r,c.c_id,c.g_id,c.c_comment,c.c_time,j.* from comments c left join jruser j on c.jruser_id=j.jruser_id where g_id=?)where r <= ("+pageCount+"*"+currPage+") and r > ("+currPage+"-1)*"+pageCount+"";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, gid);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				CommentBean co=new CommentBean();
				co.setC_id(rs.getInt("c_id"));
				co.setJruser_id(rs.getInt("jruser_id"));
				co.setC_comment(rs.getString("c_comment"));
				co.setC_time(rs.getString("c_time"));
				co.setUname(rs.getString("uname"));
				co.setJr_img(rs.getString("jr_img"));
				list.add(co);
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

	public int selcommentcount(int gid) {
		Connection conn=DBconnection.getconnection();
		String sql="select count(*) from comments where g_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, gid);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){//²»ÄÜ¹Ø±Õ°É prst 
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public JRuserBean seljruserpinglun(int jruser_id) {
		JRuserBean jr=new JRuserBean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from jruser where jruser_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, jruser_id);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				jr.setUname(rs.getString("uname"));
				jr.setJruser_id(rs.getInt("jruser_id"));
				jr.setPwd(rs.getString("pwd"));
				jr.setJr_img(rs.getString("jr_img"));
				jr.setJointime(rs.getString("jointime"));
				jr.setBirthday(rs.getString("birthday"));
				jr.setMoneys(rs.getFloat("moneys"));
				jr.setPhone(rs.getString("phone"));
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jr;
	}

	public boolean cunzaiuname(String uname) {
		Connection conn=DBconnection.getconnection();
		String sql="select * from jruser where uname=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, uname);
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				rs.close();
				prst.close();
				conn.close();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean shifougm(int jruser_id, int g_id) {
		Connection conn=DBconnection.getconnection();
		String sql="select * from orders where g_id=? and jruser_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, g_id);
			prst.setInt(2, jruser_id);
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				rs.close();
				prst.close();
				conn.close();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int selcountorders(int jruser_id) {
		Connection conn=DBconnection.getconnection();
		String sql="select count(*) from orders where jruser_id="+jruser_id+"";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
