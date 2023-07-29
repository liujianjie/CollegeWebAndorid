package com.zuxia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zuxia.model.BulletinInfo;
import com.zuxia.model.UserInfo;
import com.zuxia.util.DBConn;
import com.zuxia.util.DateTimeUtil;
import com.zuxia.util.PageModel;

/**
 * 公告信息数据访问类
 */
public class BulletinDao {
	/**
	 * 获取所有的公告信息(分页)
	 * @return 公告信息列表
	 */
	public PageModel<BulletinInfo> getAllBulletinInfo(int pageSize,int pageNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<BulletinInfo> pm = null;
		ArrayList<BulletinInfo> items = new ArrayList<BulletinInfo>();
		String sql = "select top "+pageSize+" a.*,b.userName from Bulletin a inner join UserInfo b on a.userId=b.id where a.id not in (select top "+((pageNo-1)*pageSize)+" id from Bulletin)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			BulletinInfo item = null;
			UserInfo user=null;
			while (rs.next()) {
				item = new BulletinInfo();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setContent(rs.getString("content"));
				
				user = new UserInfo();
				user.setId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				
				item.setUser(user);
				item.setCreateTime(DateTimeUtil.convertDate(rs.getString("createTime")));
				
				items.add(item);
			}
			
			pm = new PageModel<BulletinInfo>();
			pm.setData(items);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecords(conn, pstmt, rs));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return pm;
	}
	
	//获取总记录条数
	private int getTotalRecords(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		String sql = "select count(1) from Bulletin";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
	
	/*
	 * 公告信息关键词查询（分页）
	 */
	public PageModel<BulletinInfo> getAllBulletinInfo(int pageSize,int pageNo,String keywords) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<BulletinInfo> pm = null;
		ArrayList<BulletinInfo> items = new ArrayList<BulletinInfo>();
		String sql = "select top "+pageSize+" a.*,b.userName from Bulletin a inner join UserInfo b on a.userId=b.id where a.title like '%"+keywords+"%' and a.id not in (select top "+((pageNo-1)*pageSize)+" id from Bulletin)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			BulletinInfo item = null;
			UserInfo user = null;
			while (rs.next()) {
				item = new BulletinInfo();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setContent(rs.getString("content"));
				user = new UserInfo();
				user.setId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				
				item.setUser(user);
				item.setCreateTime(DateTimeUtil.convertDate(rs.getString("createTime")));
				
				items.add(item);
			}
			
			pm = new PageModel<BulletinInfo>();
			pm.setData(items);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecords(conn, pstmt, rs,keywords));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return pm;
	}
	
	//获取总记录条数
	private int getTotalRecords(Connection conn, PreparedStatement pstmt,
			ResultSet rs,String keywords) {
		String sql = "select count(1) from Bulletin where title like '%"+keywords+"%'";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
	
	/**
	 * 获取公告信息信息
	 * @param id 公告信息编号
	 * @return 包含公告信息信息的类型对象
	 */
	public BulletinInfo getBulletinInfo(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BulletinInfo item = null;
		String sql = "select a.*,b.userName from Bulletin a inner join UserInfo b on a.userId=b.id where a.id=?";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			// 执行查询
			rs = pstmt.executeQuery();
			if(rs.next()) {
				item = new BulletinInfo();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setContent(rs.getString("content"));
				UserInfo user = new UserInfo();
				user.setId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				item.setUser(user);
				item.setCreateTime(DateTimeUtil.convertDate(rs.getString("createTime")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return item;
	}
	
	/**
	 * 删除
	 * @param id 编号
	 * @return 删除失败（false）或删除成功（true）
	 */
	public boolean removeBulletin(int id) {
		String sql = "delete from Bulletin where id=? ";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowCount = 0;
			rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(null, pstmt, conn);
		}

		return false;
	}

	/**
	 * 删除多个公告信息
	 * @param ids 编号
	 * @return 若删除成功返回true，删除失败返回false
	 */
	public boolean removeBulletin(String ids) {
		ids = ids.substring(0, ids.length() - 1);
		StringBuilder sb = new StringBuilder(
				"delete from Bulletin where id in (");
		sb.append(ids);
		sb.append(")");
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			int rowCount = 0;
			rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(null, pstmt, conn);
		}

		return false;
	}
	
	/**
	 * 修改
	 * @param id 编号
	 * @return 修改成功(true)或修改失败(false)
	 */
	public boolean updateBulletin(BulletinInfo item){
		String sql = "update Bulletin set title=?,content=?,userId=?,createTime=? where id=?";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, item.getTitle());
			pstmt.setString(2, item.getContent());
			pstmt.setInt(3, item.getUser().getId());
			pstmt.setString(4, DateTimeUtil.convertDate(item.getCreateTime()));
			pstmt.setInt(5, item.getId());
			
			int rowCount = 0;
			rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(null, pstmt, conn);
		}
		
		return false;
	}
	
	/**
	 * 新增公告信息
	 * @param item 公告信息
	 * @return 添加成功(true)或添加失败(false)
	 */
	public boolean addBulletin(BulletinInfo item){
		String sql = "insert into Bulletin values (?,?,?,?)";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, item.getTitle());
			pstmt.setString(2, item.getContent());
			pstmt.setInt(3, item.getUser().getId());
			pstmt.setString(4,DateTimeUtil.convertDate(item.getCreateTime()));
			
			int rowCount = 0;
			
			rowCount = pstmt.executeUpdate();
			if (rowCount > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(null, pstmt, conn);
		}
		
		return false;
	}
	
	/**
	 * 获取前五条公告信息
	 */
	public ArrayList<BulletinInfo> getTopFiveBulletinInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BulletinInfo> items = new ArrayList<BulletinInfo>();
		String sql = "select top 5 id,title,createTime from Bulletin order by createTime desc";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			BulletinInfo item = null;
			while(rs.next()) {
				item = new BulletinInfo();
				item.setId(rs.getInt("id"));
				item.setTitle(rs.getString("title"));
				item.setCreateTime(DateTimeUtil.convertDate(rs.getString("createTime")));
				
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return items;
	}
	
}
