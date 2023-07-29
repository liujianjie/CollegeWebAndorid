package ����ʵ�ֽӿ�;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.imageio.spi.RegisterableService;

import QQ���ݿ���Ϣ.QQgame;
import QQ���ݿ���Ϣ.QQuser;
import QQ���ݿ���Ϣ.QQhistory;
import ��װ���ݿ�����.�������ݿ�;
import �ӿ�.QQuserInterface;

public class QQuserimp implements QQuserInterface{
	public boolean add(QQuser s) {
		Connection conn=�������ݿ�.shujuku();
		String sql="insert into QQ values(seq_review_qq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean QQID(String qqnum) {
			Connection conn=�������ݿ�.shujuku();
			String sql="select * from QQ where qqnum=?";
			try {
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1,qqnum);
				ResultSet rs=pre.executeQuery();//��ѯ
				if(rs.next()){
					//������ھ���
					return true;
				}
				rs.close();
				pre.close();
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			return false;
	}
	
	public QQuser chkuser(QQuser quer) {
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from QQ where qqnum=? and pwd=?";
		PreparedStatement pre;
		try { 
			pre = conn.prepareStatement(sql);
			pre.setString(1, quer.getQqnum());//qq��
			pre.setString(2, quer.getPwd());//����
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������� �����Լ�����Ϣ ���ԸողŻ�û�� �ǳ�
				quer.setId(rs.getInt("id"));
				quer.setQqname(rs.getString("qqname"));
				quer.setPwd(rs.getString("pwd"));
				quer.setNames(rs.getString("names"));
				quer.setAge(rs.getInt("age"));
				quer.setSex(rs.getString("sex"));
				quer.setDate(rs.getString("dateremix"));
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean updstate(String qqnum, int state) {//�޸�����״̬
		Connection conn=�������ݿ�.shujuku();
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		return false;

	}
	public boolean addhistory(QQhistory qqh){
		//orcale �������ϵ�ֻ�ܷ��ڹ������
		Connection conn=�������ݿ�.shujuku();
		String sql = "DECLARE BEGIN ";
			sql+="delete from history where qqnum='"+qqh.getQqnum()+"';";
			sql+="insert into history values(seq_review_qq.nextval,'"+qqh.getQqnum()+"','"
							+qqh.getQqpwd()+"','"+qqh.getQqface()+"');";
			sql+="commit;END;";//ע���ʽ �ֺ�
//			System.out.println(sql);
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			int i=pre.executeUpdate();
			if(i>0){
				return true;//�ɹ�
				
			}
			pre.close();
			conn.close();
		} catch(Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		return false;
	}

	public List selhi() {
		List list=new ArrayList();
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from history";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				QQhistory qqh=new QQhistory();
				qqh.setId(rs.getInt("id"));
				qqh.setQqnum(rs.getString("qqnum"));
				qqh.setQqpwd(rs.getString("qqpwd"));
				qqh.setQqface(rs.getString("qqface"));
				list.add(qqh);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return list;
	}

	public Vector<QQuser> selectusergroupname(String myqq, String groupname) {
		Vector<QQuser> vec=new Vector<QQuser>();
		Connection conn=�������ݿ�.shujuku();
		//���Һ��ѵ���Ϣ ����
		String sql="select * from QQ where qqnum in(select friqq from qqfrid where myqq=? and groupname=?) order by status";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, myqq);//qq��
			pre.setString(2, groupname);//����
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//������� ���غ��ѵ���Ϣ
				QQuser hy=new QQuser();
				hy.setId(rs.getInt("id"));
				hy.setQqname(rs.getString("qqname"));
				hy.setQqnum(rs.getString("qqnum"));//QQ��
				hy.setPwd(rs.getString("pwd"));
				hy.setNames(rs.getString("names"));
				hy.setAge(rs.getInt("age"));
				hy.setSex(rs.getString("sex"));
				hy.setDate(rs.getString("dateremix"));
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return vec;//���غ�����Ϣ
	}
	@Override
	public Vector<Vector> selusers(QQuser user) {
		Vector vec=new Vector();
		Connection conn=�������ݿ�.shujuku();
		//���Һ��ѵ���Ϣ ����
		String sql="select * from QQ where 1=1 ";
		if(!user.getQqnum().equals("")){//��Ϊ��
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
			while(rs.next()){//������� ���غ��ѵ���Ϣ
				Vector hy=new Vector();
				//˳��һ�����Ǹ�find��vector���ŵ�
				hy.add(rs.getString("qqnum"));//QQ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return vec;//���غ�����Ϣ
	}
	@Override
	public QQuser chkqqnum(QQuser quer) {
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from QQ where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, quer.getQqnum());//qq��
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������� �����Լ�����Ϣ ���ԸողŻ�û�� �ǳ�
				quer.setId(rs.getInt("id"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public QQuser chkqqziliao(QQuser quer) {
		Connection conn=�������ݿ�.shujuku();
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
			if(rs.next()){//������� �����Լ�����Ϣ 
				quer.setId(rs.getInt("id"));
				quer.setPwd(rs.getString("pwd"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public void addscore(String qqnum, int score) {//��Ϸ
		Connection conn=�������ݿ�.shujuku();
		String sql="update game set shescore=? where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, score);
			pre.setString(2, qqnum);//ֻ��ִ�� û����ֵ
			pre.executeUpdate();
		pre.close();
		conn.close();
		
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	@Override
	public boolean addQqgame(QQgame g) {
		Connection conn=�������ݿ�.shujuku();
		String sql="insert into game values(seq_review_qq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int i=1;
			pre.setString(i++,g.getQqnum());
			pre.setString(i++,g.getQqname());
			pre.setString(i++,g.getVip());
			pre.setInt(i++,g.getShescore());
			pre.setInt(i++,g.getShenode());
			pre.setInt(i++,g.getTxzgk());
			pre.setInt(i++,g.getShetoux0());
			pre.setInt(i++,g.getShetouy0());
			pre.setInt(i++,g.getShetoux1());
			pre.setInt(i++,g.getShetouy1());
			pre.setInt(i++,g.getFoodx());
			pre.setInt(i++,g.getFoody());
			pre.setInt(i++,g.getDirection());
			int ii=pre.executeUpdate();
			if(ii>0){
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean chekhui(String qqnum) {
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from game where qqnum=? and vip='��'";
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,qqnum);
			ResultSet rs=pre.executeQuery();//��ѯ
			if(rs.next()){
				//������ھ���
				return true;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public QQgame shenode(String qqnum) {
		QQgame game=new QQgame();
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from game where qqnum=?";//����������Ϣ���е��ң�Ӧ�÷ֿ���
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,qqnum);
			ResultSet rs=pre.executeQuery();//��ѯ
			if(rs.next()){//�����
				//������ھͷ����߽� ���ü��ϸ������� �ű��հ� //������ǲ����е����ݰ�
				game.setQqnum(rs.getString("qqnum"));
				game.setQqname(rs.getString("qqname"));
				game.setTxzgk(rs.getInt("txzgk"));
				game.setVip(rs.getString("vip"));
				game.setShenode(rs.getInt("shenode"));
				game.setShetoux0(rs.getInt("shetoux0"));
				game.setShetouy0(rs.getInt("shetouy0"));
				game.setShetoux1(rs.getInt("shetoux1"));
				game.setShetouy1(rs.getInt("shetouy1"));
				game.setFoodx(rs.getInt("foodx"));
				game.setFoody(rs.getInt("foody"));
				game.setDirection(rs.getInt("direction"));
				return game;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updshenode(String qqnum,int node,int shetoux0,int shetouy0,int shetoux1,int shetouy1,int foodx,int foody,int direction) {
		Connection conn=�������ݿ�.shujuku();
		String sql="update game set shenode=?,shetoux0=?,shetouy0=?,shetoux1=?,shetouy1=?,foodx=?,foody=?,direction=? where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, node);
			pre.setInt(2, shetoux0);
			pre.setInt(3, shetouy0);
			pre.setInt(4, shetoux1);
			pre.setInt(5, shetouy1);
			pre.setInt(6, foodx);
			pre.setInt(7, foody);
			pre.setInt(8, direction);
			pre.setString(9, qqnum);
			int i=pre.executeUpdate();
			if(i>0){
				
				return true;
			}
		pre.close();
		conn.close();
		
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return false;
	}
	//�����Ƿ���ڵ��б���
	public boolean selhy(String myq, String fyq) {
		Connection conn=�������ݿ�.shujuku();
		//���Һ��ѵ���Ϣ ����
		String sql="select * from qqfrid where myqq=? and friqq=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, myq);//qq��
			pre.setString(2, fyq);//����
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������� ������
				return true;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public QQuser selQQuserbyfind(String qqnum) {
		QQuser quer=new QQuser();
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from QQ where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq��
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������� �����Լ�����Ϣ ���ԸողŻ�û�� �ǳ�
				quer.setId(rs.getInt("id"));
				quer.setQqname(rs.getString("qqname"));
				quer.setQqnum(rs.getString("qqnum"));
				quer.setPwd(rs.getString("pwd"));
				quer.setNames(rs.getString("names"));
				quer.setAge(rs.getInt("age"));
				quer.setSex(rs.getString("sex"));
				quer.setDate(rs.getString("dateremix"));
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	@Override//�����б������������
	public void addfrid(String myqnum, String fyqnum, String groupname) {
		Connection conn=�������ݿ�.shujuku();
		String sql = "DECLARE BEGIN ";
		sql+="insert into qqfrid values(seq_review_qq.nextval,'"+myqnum+"','"+fyqnum+"','"+groupname+"');";
		sql+="insert into qqfrid values(seq_review_qq.nextval,'"+fyqnum+"','"+myqnum+"','"+groupname+"');";
		sql+="commit;END;";//ע���ʽ �ֺ�
		System.out.println(sql);
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int ii=pre.executeUpdate();
			if(ii>0){
				System.out.println("��Ӻ��ѳɹ�");
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	@Override
	public String mimanull(String myqnum) {
		QQuser quer=new QQuser();
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from history where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, myqnum);//qq��
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������ڷ�������
				quer.setPwd(rs.getString("qqpwd"));
				return quer.getPwd();
				
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	//ɾ������
	public boolean upfrid(String myqq, String hyqq) {
		Connection conn=�������ݿ�.shujuku();
		String sql = "DECLARE BEGIN ";
		sql+="delete from qqfrid where myqq='"+myqq+"' and friqq='"+hyqq+"';";
		sql+="delete from qqfrid where myqq='"+hyqq+"' and friqq='"+myqq+"';";
		sql+="commit;END;";//ע���ʽ �ֺ�
//		System.out.println(sql);
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			int ii=pre.executeUpdate();
			if(ii>0){
//				System.out.println("ɾ�����ѳɹ�");
				return true;
			}
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean movegroup(String myqnum, String fyqnum, String groupname) {
		Connection conn=�������ݿ�.shujuku();
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean upduser(QQuser quser) {
		Connection conn=�������ݿ�.shujuku();
		String sql="update QQ set qqname=?,pwd=?,face=?,sex=?,dateremix=?,years=?,months=?,days=?,"
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	@Override
	//�޸���Ϸ����ǳ�
	public boolean upgameuser(QQgame quser) {
		Connection conn=�������ݿ�.shujuku();
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	@Override
	//��ѯ���ڵ�״̬
	public QQuser selzt(String qqnum) {
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from QQ where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq��
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������� �����Լ�����Ϣ
				QQuser quer=new QQuser();
				quer.setStatus(rs.getInt("status"));
				return quer;
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int seltxzgk(String qqnum) {
		Connection conn=�������ݿ�.shujuku();
		String sql="select * from game where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq��
			ResultSet rs=pre.executeQuery();
			if(rs.next()){//������� �����Լ�����Ϣ
				QQgame quer=new QQgame();
				quer.setTxzgk(rs.getInt("txzgk"));
				return quer.getTxzgk();
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return 0;
	}
	@Override
	public boolean savetxzgk(String qqnum,int level) {
		Connection conn=�������ݿ�.shujuku();
		String sql="update game set txzgk=? where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, level);//�ȼ�
			pre.setString(2, qqnum);//qq��
			int rs=pre.executeUpdate();
			if(rs>0){//������� �����Լ�����Ϣ
				
				return true;
			}
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public Vector<Vector> selscore() {
		Vector<Vector> vec=new Vector<Vector>();
		Connection conn=�������ݿ�.shujuku();
		//���Һ��ѵ���Ϣ ����
		String sql="select qqname,shescore from game order by shescore desc";//ȱ�� �����û� û��ֻ������
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){//������� ���غ��ѵ���Ϣ
				Vector zy=new Vector();
				zy.add(rs.getString("qqname"));
				zy.add(rs.getInt("shescore"));
				vec.add(zy);
			}
			rs.close();
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return vec;//���غ�����Ϣ
	}
	@Override
	public boolean vipzhuce(String qqnum) {
		Connection conn=�������ݿ�.shujuku();
		String sql="update game set vip='��' where qqnum=?";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, qqnum);//qq��
			int rs=pre.executeUpdate();
			if(rs>0){//������� �����Լ�����Ϣ
				return true;
			}
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void TestAddHistory() {
		Connection conn=�������ݿ�.shujuku();
		String sql="insert into history values(seq_review_qq.nextval,?,?,?)";
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, "1219277604");
			pre.setString(2, "1219277604");
			pre.setString(3, "1219277604");
			int rs=pre.executeUpdate();
			System.out.println(rs);
			pre.close();
			conn.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
}
