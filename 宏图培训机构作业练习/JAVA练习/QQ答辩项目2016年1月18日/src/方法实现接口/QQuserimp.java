package 方法实现接口;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.spi.RegisterableService;

import QQLGO.qqhistory;
import QQ数据库信息.QQGAME;
import QQ数据库信息.QQuser;
import 封装数据库链接.连接数据库;
import 接口.QQuserInterface;

public class QQuserimp implements QQuserInterface{
	public boolean add(QQuser s) {
		Connection conn=连接数据库.shujuku();
		String sql="insert into QQ values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int i=1;
			pre.setString(i++,s.getQqnum());
			pre.setString(i++,s.getQqname());
			pre.setString(i++,s.getPwd());
			pre.setString(i++,s.getFace());
			pre.setString(i++,s.getNames());
			pre.setInt(i++,s.getAge());
			pre.setString(i++,s.getSex());
			pre.setString(i++,s.getDate());
			pre.setString(i++,s.getYears());
			pre.setString(i++,s.getMonths());
			pre.setString(i++,s.getDprivate());
			pre.setString(i++,s.getCountry());
			pre.setString(i++,s.getProvince());
			pre.setString(i++,s.getCity());
			pre.setString(i++,s.getMark());
			pre.setString(i++,s.getNation());
			pre.setInt(i++,s.getLevels());
			pre.setString(i++,s.getStar());
			pre.setInt(i++,s.getStatus());
			pre.setString(i++, s.getIpadd());
			pre.setInt(i++, s.getPort());
			int ii=pre.executeUpdate();
			if(ii>0){
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean QQID(String qqnum) {
			Connection conn=连接数据库.shujuku();
			String sql="select * from QQ where qqnum=?";
			try {
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1,qqnum);
				ResultSet rs=pre.executeQuery();//查询
				if(rs.next()){
					//如果存在就真
					return true;
				}
				rs.close();
				pre.close();
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return false;
	}
	
	public QQuser chkuser(QQuser quer) {
		Connection conn=连接数据库.shujuku();
		String sql="select * from QQ where qqnum=? and pwd=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, quer.getQqnum());//qq号
			pre.setString(2, quer.getPwd());//密码
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回自己的信息 所以刚刚才会没有 昵称
				quer.setId(rs.getInt("id"));
				quer.setQqname(rs.getString("qqname"));
				quer.setPwd(rs.getString("pwd"));
				quer.setNames(rs.getString("names"));
				quer.setAge(rs.getInt("age"));
				quer.setSex(rs.getString("sex"));
				quer.setDate(rs.getString("Date"));
				quer.setYears(rs.getString("years"));
				quer.setMonths(rs.getString("months"));
				quer.setDprivate(rs.getString("days"));
				quer.setCountry(rs.getString("country"));
				quer.setProvince(rs.getString("province"));
				quer.setCity(rs.getString("city"));
				quer.setMark(rs.getString("mark"));
				quer.setNation(rs.getString("nation"));
				quer.setLevels(rs.getInt("levels"));
				quer.setStar(rs.getString("star"));
				quer.setStatus(rs.getInt("status"));
				quer.setFace(rs.getString("face"));
				quer.setIpadd(rs.getString("ipadd"));
				quer.setPort(rs.getInt("port"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean updstate(String qqnum, int state) {//修改在线状态
		Connection conn=连接数据库.shujuku();
		String sql="update QQ set status=? where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, state);
			pre.setString(2, qqnum);
			int i=pre.executeUpdate();
			if(i>0){
				
				return true;
			}
		pre.close();
		conn.close();
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return false;

	}
	public boolean addhistory(qqhistory qqh){
		Connection conn=连接数据库.shujuku();
		String sql="delete from history where qqnum='"+qqh.getQqnum()+"';";
			sql+="insert into history values('"+qqh.getQqnum()+"','"
							+qqh.getQqpwd()+"','"+qqh.getQqface()+"')";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			int i=pre.executeUpdate();
			if(i>0){
				return true;//成功
				
			}
			pre.close();
			conn.close();
		} catch(Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return false;
	}

	public List selhi() {
		List list=new ArrayList();
		Connection conn=连接数据库.shujuku();
		String sql="select * from history";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				qqhistory qqh=new qqhistory();
				qqh.setId(rs.getInt("id"));
				qqh.setQqnum(rs.getString("qqnum"));
				qqh.setQqpwd(rs.getString("qqpwd"));
				qqh.setQqface(rs.getString("qqface"));
				list.add(qqh);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return list;
	}

	public Vector<QQuser> selectusergroupname(String myqq, String groupname) {
		Vector<QQuser> vec=new Vector<QQuser>();
		Connection conn=连接数据库.shujuku();
		//查找好友的信息 返回
		String sql="select * from QQ where qqnum in(select friqq from qqfrid where myqq=? and groupname=?) order by status";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, myqq);//qq号
			pre.setString(2, groupname);//分组
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//如果存在 返回好友的信息
				QQuser hy=new QQuser();
				hy.setId(rs.getInt("id"));
				hy.setQqname(rs.getString("qqname"));
				hy.setQqnum(rs.getString("qqnum"));//QQ号
				hy.setPwd(rs.getString("pwd"));
				hy.setNames(rs.getString("names"));
				hy.setAge(rs.getInt("age"));
				hy.setSex(rs.getString("sex"));
				hy.setDate(rs.getString("Date"));
				hy.setYears(rs.getString("years"));
				hy.setMonths(rs.getString("months"));
				hy.setDprivate(rs.getString("days"));
				hy.setCountry(rs.getString("country"));
				hy.setProvince(rs.getString("province"));
				hy.setCity(rs.getString("city"));
				hy.setMark(rs.getString("mark"));
				hy.setNation(rs.getString("nation"));
				hy.setLevels(rs.getInt("levels"));
				hy.setStar(rs.getString("star"));
				hy.setStatus(rs.getInt("status"));
				hy.setFace(rs.getString("face"));
				hy.setIpadd(rs.getString("ipadd"));
				hy.setPort(rs.getInt("port"));
				vec.add(hy);
				
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return vec;//返回好友信息
	}
	@Override
	public Vector<Vector> selusers(QQuser user) {
		Vector vec=new Vector();
		Connection conn=连接数据库.shujuku();
		//查找好友的信息 返回
		String sql="select * from QQ where 1=1 ";
		if(!user.getQqnum().equals("")){//不为空
			sql+=" and qqnum like '%"+user.getQqnum()+"%'";
		}
		if(!user.getQqname().equals("")){
			sql+=" and qqname like '%"+user.getQqname()+"%'";
		}
		if(user.getAge()!=0){
			sql+=" and age="+user.getAge();
		}
		if(!user.getSex().equals("")){
			sql+=" and sex='"+user.getSex()+"'";
		}
//		System.out.println(sql);
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//如果存在 返回好友的信息
				Vector hy=new Vector();
				//顺序一定是那个find里vector的排的
				hy.add(rs.getString("qqnum"));//QQ号
				hy.add(rs.getString("qqname"));
				hy.add(rs.getInt("age"));
				hy.add(rs.getString("sex"));
				hy.add(rs.getString("nation"));
				hy.add(rs.getInt("levels"));;
				hy.add(rs.getString("mark"));
				vec.add(hy);
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return vec;//返回好友信息
	}
	@Override
	public QQuser chkqqnum(QQuser quer) {
		Connection conn=连接数据库.shujuku();
		String sql="select * from QQ where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, quer.getQqnum());//qq号
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回自己的信息 所以刚刚才会没有 昵称
				quer.setId(rs.getInt("id"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public QQuser chkqqziliao(QQuser quer) {
		Connection conn=连接数据库.shujuku();
		String sql="select * from QQ where years=? and months=? and days=? and country=? and province=? and city=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, quer.getYears());
			pre.setString(2, quer.getMonths());
			pre.setString(3, quer.getDprivate());
			pre.setString(4, quer.getCountry());
			pre.setString(5, quer.getProvince());
			pre.setString(6, quer.getCity());
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回自己的信息 
				quer.setId(rs.getInt("id"));
				quer.setPwd(rs.getString("pwd"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public void addscore(String qqname, int score) {//游戏
		Connection conn=连接数据库.shujuku();
		String sql="update game set shescore=? where qqname=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, score);
			pre.setString(2, qqname);//只是执行 没返回值
			pre.executeUpdate();
		pre.close();
		conn.close();
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Override
	public boolean add(QQGAME g) {
		Connection conn=连接数据库.shujuku();
		String sql="insert into game values(?,?,?,?,?,?)";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int i=1;
			pre.setString(i++,g.getQqnum());
			pre.setString(i++,g.getQqname());
			pre.setString(i++,g.getVip());
			pre.setInt(i++,g.getShescore());
			pre.setInt(i++,g.getShenode());
			pre.setInt(i++,g.getTxzgk());
			int ii=pre.executeUpdate();
			if(ii>0){
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean chekhui(String qqnum) {
		Connection conn=连接数据库.shujuku();
		String sql="select * from game where qqnum=? and vip='是'";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,qqnum);
			ResultSet rs=pre.executeQuery();//查询
			if(rs.next()){
				//如果存在就真
				return true;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public QQGAME shenode(String qqname,QQGAME game) {
		Connection conn=连接数据库.shujuku();
		String sql="select shenode from game where qqname=?";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,qqname);
			ResultSet rs=pre.executeQuery();//查询
			if(rs.next()){//结果集
				//如果存在就返回蛇节
				game.setShenode(rs.getInt("shenode"));
				return game;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updshenode(String qqnum, int node) {
		Connection conn=连接数据库.shujuku();
		String sql="update game set shenode=? where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, node);
			pre.setString(2, qqnum);
			int i=pre.executeUpdate();
			if(i>0){
				
				return true;
			}
		pre.close();
		conn.close();
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return false;
	}
	//好友是否存在的列表中
	public boolean selhy(String myq, String fyq) {
		Connection conn=连接数据库.shujuku();
		//查找好友的信息 返回
		String sql="select * from qqfrid where myqq=? and friqq=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, myq);//qq号
			pre.setString(2, fyq);//分组
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回真
				return true;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public QQuser selQQuserbyfind(String qqnum) {
		QQuser quer=new QQuser();
		Connection conn=连接数据库.shujuku();
		String sql="select * from QQ where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq号
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回自己的信息 所以刚刚才会没有 昵称
				quer.setId(rs.getInt("id"));
				quer.setQqname(rs.getString("qqname"));
				quer.setQqnum(rs.getString("qqnum"));
				quer.setPwd(rs.getString("pwd"));
				quer.setNames(rs.getString("names"));
				quer.setAge(rs.getInt("age"));
				quer.setSex(rs.getString("sex"));
				quer.setDate(rs.getString("Date"));
				quer.setYears(rs.getString("years"));
				quer.setMonths(rs.getString("months"));
				quer.setDprivate(rs.getString("days"));
				quer.setCountry(rs.getString("country"));
				quer.setProvince(rs.getString("province"));
				quer.setCity(rs.getString("city"));
				quer.setMark(rs.getString("mark"));
				quer.setNation(rs.getString("nation"));
				quer.setLevels(rs.getInt("levels"));
				quer.setStar(rs.getString("star"));
				quer.setStatus(rs.getInt("status"));
				quer.setFace(rs.getString("face"));
				quer.setIpadd(rs.getString("ipadd"));
				quer.setPort(rs.getInt("port"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	@Override//好友列表添加两条数据
	public void addfrid(String myqnum, String fyqnum, String groupname) {
		Connection conn=连接数据库.shujuku();
		String sql="insert into qqfrid values('"+myqnum+"','"+fyqnum+"','"+groupname+"')";
		sql+="insert into qqfrid values('"+fyqnum+"','"+myqnum+"','"+groupname+"')";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int ii=pre.executeUpdate();
			if(ii>0){
				System.out.println("添加好友成功");
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Override
	public String mimanull(String myqnum) {
		QQuser quer=new QQuser();
		Connection conn=连接数据库.shujuku();
		String sql="select * from history where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, myqnum);//qq号
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在返回密码
				quer.setPwd(rs.getString("qqpwd"));
				return quer.getPwd();
				
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	//删除好友
	public boolean upfrid(String myqq, String hyqq) {
		Connection conn=连接数据库.shujuku();
		String sql="delete from qqfrid where myqq='"+myqq+"' and friqq='"+hyqq+"'";
				sql+="delete from qqfrid where myqq='"+hyqq+"' and friqq='"+myqq+"'";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int ii=pre.executeUpdate();
			if(ii>0){
//				System.out.println("删除好友成功");
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean movegroup(String myqnum, String fyqnum, String groupname) {
		Connection conn=连接数据库.shujuku();
		String sql="update qqfrid set groupname='"+groupname+"' where myqq='"+myqnum+"' and friqq='"+fyqnum+"'";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int ii=pre.executeUpdate();
			if(ii>0){
				
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean upduser(QQuser quser) {
		Connection conn=连接数据库.shujuku();
		String sql="update QQ set qqname=?,pwd=?,face=?,sex=?,Date=?,years=?,months=?,days=?,"
				+ "country=?,province=?,city=?,mark=?,nation=?,star=? where qqnum=?";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1, quser.getQqname());
				pre.setString(2, quser.getPwd());
				pre.setString(3, quser.getFace());
				pre.setString(4, quser.getSex());
				pre.setString(5, quser.getDate());
				pre.setString(6, quser.getYears());
				pre.setString(7, quser.getMonths());
				pre.setString(8, quser.getDprivate());
				pre.setString(9, quser.getCountry());
				pre.setString(10, quser.getProvince());
				pre.setString(11, quser.getCity());
				pre.setString(12, quser.getMark());
				pre.setString(13, quser.getNation());
				pre.setString(14, quser.getStar());
				pre.setString(15, quser.getQqnum());
			int ii=pre.executeUpdate();
				if(ii>0){
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	@Override
	//修改游戏表的昵称
	public boolean upgameuser(QQGAME quser) {
		Connection conn=连接数据库.shujuku();
		String sql="update game set qqname=? where qqnum=?";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1, quser.getQqname());
				pre.setString(2, quser.getQqnum());
			int ii=pre.executeUpdate();
				if(ii>0){
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	@Override
	//查询现在的状态
	public QQuser selzt(String qqnum) {
		Connection conn=连接数据库.shujuku();
		String sql="select * from QQ where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq号
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回自己的信息
				QQuser quer=new QQuser();
				quer.setStatus(rs.getInt("status"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int seltxzgk(String qqnum) {
		Connection conn=连接数据库.shujuku();
		String sql="select * from game where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq号
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//如果存在 返回自己的信息
				QQGAME quer=new QQGAME();
				quer.setTxzgk(rs.getInt("txzgk"));
				return quer.getTxzgk();
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public boolean savetxzgk(String qqnum,int level) {
		Connection conn=连接数据库.shujuku();
		String sql="update game set txzgk=? where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, level);//等级
			pre.setString(2, qqnum);//qq号
			int rs=pre.executeUpdate();
			if(rs>0){//如果存在 返回自己的信息
				
				return true;
			}
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public Vector<Vector> selscore() {
		Vector<Vector> vec=new Vector<Vector>();
		Connection conn=连接数据库.shujuku();
		//查找好友的信息 返回
		String sql="select qqname,shescore from game order by shescore desc";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//如果存在 返回好友的信息
				Vector zy=new Vector();
				zy.add(rs.getString("qqname"));
				zy.add(rs.getInt("shescore"));
				vec.add(zy);
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return vec;//返回好友信息
	}
	@Override
	public boolean vipzhuce(String qqnum) {
		Connection conn=连接数据库.shujuku();
		String sql="update game set vip='是' where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq号
			int rs=pre.executeUpdate();
			if(rs>0){//如果存在 返回自己的信息
				return true;
			}
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
}
