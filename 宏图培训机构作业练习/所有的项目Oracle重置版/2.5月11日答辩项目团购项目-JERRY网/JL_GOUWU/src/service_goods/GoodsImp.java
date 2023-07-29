package service_goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conne.DBconnection;

import bean.BottomBean;
import bean.Goodsbean;
import bean.MoldBean;

public class GoodsImp implements IGoods{

	public List selGoods(int id) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from goods g left join bottom b on b.bottom_id=g.bottom_id where 1=1";
		if(id>0){
			sql+="and g.bottom_id="+id;
		}
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				Goodsbean god=new Goodsbean();
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
				list.add(god);
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
	

	public boolean addGoods(Goodsbean god) {
		Connection conn=DBconnection.getconnection();
		String sql="insert into goods values(SEQ_REVIEW_JERRY.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1,god.getBottom_id());
			prst.setString(2, god.getG_name());
			prst.setString(3,god.getG_dress());
			prst.setString(4, god.getG_dec());
			prst.setString(5,god.getG_img());
			prst.setFloat(6, god.getG_price());
			prst.setFloat(7, god.getG_scj());
			prst.setInt(8,god.getG_count());
			prst.setInt(9, god.getG_sale());
			prst.setInt(10, god.getG_statu());
			prst.setInt(11,1);//加入购物车商品的数量
			prst.setString(12, god.getG_descrip());
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

	public boolean delGoods(int id) {
		Connection conn=DBconnection.getconnection();
		String sql="delete from goods where g_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1,id);
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
	
	
	public List selBottom() {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from bottom";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				BottomBean bot=new BottomBean();
				bot.setBottom_id(rs.getInt("bottom_id"));
				bot.setBottom(rs.getString("bottom"));
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
	
	public Goodsbean selhang(int id) {
		Goodsbean god=new Goodsbean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from goods g left join bottom b on b.bottom_id=g.bottom_id where 1=1";
		if(id>0){
			sql+="and g.g_id="+id;
		}
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setGwccount(rs.getInt("gwccount"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return god;
	}
	
	public boolean alerthang(Goodsbean god) {
		Connection conn=DBconnection.getconnection();
		String sql="update goods set bottom_id=?,g_name=?,g_dress=?,g_dec=?,g_img=?,g_price=?,g_scj=?,g_count=?,g_sale=?,g_statu=?,gwccount=?,g_descrip=? where g_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1,god.getBottom_id());
			prst.setString(2, god.getG_name());
			prst.setString(3,god.getG_dress());
			prst.setString(4, god.getG_dec());
			prst.setString(5,god.getG_img());
			prst.setFloat(6, god.getG_price());
			prst.setFloat(7, god.getG_scj());
			prst.setInt(8,god.getG_count());
			prst.setInt(9, god.getG_sale());
			prst.setInt(10, god.getG_statu());
			prst.setInt(11,1);
			prst.setString(12, god.getG_descrip());
			prst.setInt(13, god.getG_id());
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


	public List selxsgoods(String name) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
		String sql="select * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_name like '%"+name+"%'";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				Goodsbean god=new Goodsbean();
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
				list.add(god);
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


	public BottomBean selbottom(int bottom_id) {
		BottomBean bot=new BottomBean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from goods g left join bottom b on b.bottom_id=g.bottom_id where g.bottom_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, bottom_id);
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				bot.setMold_id(rs.getInt("mold_id"));
				bot.setBottom(rs.getString("bottom"));
				bot.setBottom_id(rs.getInt("bottom_id"));
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


	public MoldBean selmold(int mold_id) {
		MoldBean mod=new MoldBean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from bottom b left join mold m on b.mold_id=m.mold_id where b.mold_id=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, mold_id);
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				mod.setMold(rs.getString("mold"));
				mod.setMold_id(rs.getInt("mold_id"));
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mod;
	}

	//通过销量的多少对比来后去一开始商品 分页。。。
	public List selfyGoods(int pagecount, int currpage) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
//		String sql="select top "+pagecount+" * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_id not in (select top "+(currpage-1)*pagecount+" g_id from goods) order by g_sale desc";
		String sql="select * from(select row_number()over(order by g_sale desc) r,g.*,b.bottom from goods g left join bottom b on b.bottom_id=g.bottom_id)where r <= ("+pagecount+"*"+currpage+") and r > ("+currpage+"-1)*"+pagecount+"";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				Goodsbean god=new Goodsbean();
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
				list.add(god);
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


	public int selgoodscount() {
		Connection conn=DBconnection.getconnection();
		String sql="select count(*) from goods";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){//不能关闭，不然 rs获取不了，prst不能关闭 不知道conn能不能关闭。。 也不能关闭
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	public List selthreeGoods(int id, int pagecount) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
//		String sql="select top "+pageCount+" * from goods g left join bottom b on b.bottom_id=g.bottom_id where g.bottom_id="+id+" order by g_sale desc";
		String sql="select * from(select g.*,b.mold_id,b.bottom from goods g left join bottom b on b.bottom_id=g.bottom_id where g.bottom_id="+id+" order by g_sale desc)where rownum<="+pagecount+" order by rownum";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				Goodsbean god=new Goodsbean();
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
				list.add(god);
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

	//前台么？
	public List sellistgoods(int pagecount, int currpage, int id) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
//		String sql="select top "+pagecount+" * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_id not in (select top "+(currpage-1)*pagecount+" g_id from goods) and g.bottom_id="+id+"";
		String sql="select * from(select row_number()over(order by g_id) r,g.*,b.bottom,b.mold_id from goods g left join bottom b on b.bottom_id=g.bottom_id where g.bottom_id="+id+")where r <= ("+pagecount+"*"+currpage+") and r > ("+currpage+"-1)*"+pagecount+"";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				Goodsbean god=new Goodsbean();
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
				list.add(god);
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


	public int selbottomgoodscount(int bottomid) {
		Connection conn=DBconnection.getconnection();
		String sql="select count(*) from goods where bottom_id="+bottomid+"";
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

	
	public Goodsbean seldangegoods(int bottom_id) {
		Goodsbean god=new Goodsbean();
		Connection conn=DBconnection.getconnection();
//		String sql="select top 1 * from goods g left join bottom b on b.bottom_id=g.bottom_id where b.bottom_id="+bottom_id+" order by g_sale desc";
		String sql="select * from(select g.*,b.mold_id,b.bottom from goods g left join bottom b on b.bottom_id=g.bottom_id where b.bottom_id="+bottom_id+" order by g_sale desc)where rownum<=1 order by rownum";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return god;
	}

	//这是后台的数据吧
	public List selhtGoods(int pagecount, int currpage) {
		List list=new ArrayList();
		Connection conn=DBconnection.getconnection();
//		String sql="select top "+pagecount+" * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_id not in (select top "+(currpage-1)*pagecount+" g_id from goods)";
		String sql="select * from(select row_number()over(order by g_id) r,g.*,b.bottom,b.mold_id from goods g left join bottom b on b.bottom_id=g.bottom_id)where r <= ("+pagecount+"*"+currpage+") and r > ("+currpage+"-1)*"+pagecount+"";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				Goodsbean god=new Goodsbean();
				god.setG_id(rs.getInt("g_id"));
				god.setBottom_id(rs.getInt("bottom_id"));
				god.setG_name(rs.getString("g_name"));
				god.setG_dress(rs.getString("g_dress"));
				god.setG_dec(rs.getString("g_dec"));
				god.setG_img(rs.getString("g_img"));
				god.setG_price(rs.getFloat("g_price"));
				god.setG_scj(rs.getFloat("g_scj"));
				god.setG_count(rs.getInt("g_count"));
				god.setG_sale(rs.getInt("g_sale"));
				god.setG_statu(rs.getInt("g_statu"));
				god.setG_descrip(rs.getString("g_descrip"));
				god.setBottom(rs.getString("bottom"));
				list.add(god);
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
