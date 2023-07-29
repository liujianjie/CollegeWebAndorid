package com.zuxia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zuxia.model.GoodsInfo;
import com.zuxia.model.GoodsType;
import com.zuxia.util.DBConn;
import com.zuxia.util.PageModel;

/**
 * 商品类型数据访问类
 */
public class GoodsTypeDao {
	
	/**
	 * 获取所有的商品类型(分页)
	 * @return 商品类型列表
	 */
	public PageModel<GoodsType> getAllGoodsTypes(int pageSize,int pageNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<GoodsType> pm = null;
		ArrayList<GoodsType> types = new ArrayList<GoodsType>();
		String sql = "select top "+pageSize+" * from GoodsType where typeId not in (select top "+((pageNo-1)*pageSize)+" typeId from GoodsType)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsType type = null;
			while (rs.next()) {
				type = new GoodsType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				
				types.add(type);
			}
			
			pm = new PageModel<GoodsType>();
			pm.setData(types);
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
		String sql = "select count(*) from GoodsType";
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
	 * 商品类型关键词查询（分页）
	 */
	public PageModel<GoodsType> getAllGoodsTypes(int pageSize,int pageNo,String keywords) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<GoodsType> pm = null;
		ArrayList<GoodsType> types = new ArrayList<GoodsType>();
		String sql = "select top "+pageSize+" * from GoodsType where typeName like '%"+keywords+"%' and typeId not in (select top "+((pageNo-1)*pageSize)+" typeId from GoodsType)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsType type = null;
			while (rs.next()) {
				type = new GoodsType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				
				types.add(type);
			}
			
			pm = new PageModel<GoodsType>();
			pm.setData(types);
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
		String sql = "select count(*) from GoodsType where typeName like '%"+keywords+"%'";
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
	 * 获取所有的商品类型（未分页）
	 * @return 所有的商品类型列表结合
	 */
	public ArrayList<GoodsType> getAllGoodsTypes() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsType> types = new ArrayList<GoodsType>();
		String sql = "select * from GoodsType";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsType type = null;
			while (rs.next()) {
				type = new GoodsType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				
				types.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return types;
	}
	
	/**
	 * 获取所有商品类型及该类型下的最新五条商品
	 * @return
	 */
	public ArrayList<GoodsType> getAllGoodsTypesAndGoods() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsType> types = new ArrayList<GoodsType>();
		String sql = "select * from GoodsType";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsType type = null;
			while (rs.next()) {
				type = new GoodsType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				setGoodsList(conn, type);
				
				types.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return types;
	}
	
	public void setGoodsList(Connection conn,GoodsType type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select top 5 goodsId,goodsName from GoodsInfo where typeId="+type.getTypeId()+" order by goodsId desc";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			
			ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
			GoodsInfo goods = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				
				goodsList.add(goods);
			}
			type.setItems(goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取商品类型信息
	 * @param typeId 商品类型编号
	 * @return 包含商品类型信息的类型对象
	 */
	public GoodsType getGoodsType(int typeId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsType type = null;
		String sql = "select * from GoodsType where typeId=?";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);

			// 执行查询
			rs = pstmt.executeQuery();
			if(rs.next()) {
				type = new GoodsType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return type;
	}
	
	/**
	 * 删除
	 * @param id 编号
	 * @return
	 */
	public boolean removeGoodsType(int id) {
		String sql = "delete from GoodsType where typeId=? ";
		
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
	 * 删除多个商品类型
	 * @param ids 类型编号
	 * @return 若删除成功返回true，删除失败返回false
	 */
	public boolean removeGoodsType(String ids) {
		ids = ids.substring(0, ids.length() - 1);
		StringBuilder sb = new StringBuilder(
				"delete from GoodsType where typeId in (");
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
	 * @param type 商品类型
	 * @return 修改成功(true)或修改失败(false)
	 */
	public boolean updateGoodsType(GoodsType type){
		String sql = "update GoodsType set typeName=? where typeId=? ";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, type.getTypeName());
			pstmt.setInt(2,type.getTypeId());
			
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
	 * 新增商品类型
	 * @param type 商品类型
	 * @return 添加成功(true)或添加失败(false)
	 */
	public boolean addType(GoodsType type){
		String sql = "insert into GoodsType values (?) ";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setString(1, type.getTypeName());
			
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
	
}
