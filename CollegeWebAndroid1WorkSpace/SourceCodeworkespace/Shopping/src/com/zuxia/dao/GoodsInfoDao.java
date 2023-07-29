package com.zuxia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zuxia.model.GoodsInfo;
import com.zuxia.model.GoodsType;
import com.zuxia.model.SalesGoods;
import com.zuxia.util.DBConn;
import com.zuxia.util.PageModel;

/**
 * 商品信息数据访问类
 */
public class GoodsInfoDao {
	/**
	 * 查询所有商品信息 
	 * @param pageSize 页面显示数据条数
	 * @param pageNo 页面编号
	 * @return 包含所有商品数据的分页对象
	 */
	public PageModel<GoodsInfo> getAllGoods(int pageSize, int pageNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		PageModel<GoodsInfo> pm = null;
		String sql = "select top "
				+ pageSize
				+ " a.*,b.typeName from GoodsInfo a inner join GoodsType b on a.typeId = b.typeId where a.goodsId not in (select top "
				+ ((pageNo - 1) * pageSize)
				+ " goodsId from GoodsInfo order by goodsId desc) order by goodsId desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsInfo goods = null;
			GoodsType type = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				type = new GoodsType(rs.getInt("typeId"), rs
						.getString("typeName"));
				goods.setGoodsType(type);
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setIsNew(rs.getInt("isNew"));
				goods.setIsRecommend(rs.getInt("isRecommend"));
				goods.setStatus(rs.getInt("status"));
				goods.setPhoto(rs.getString("photo"));
				goods.setRemark(rs.getString("remark"));

				goodsList.add(goods);
			}

			pm = new PageModel<GoodsInfo>();
			pm.setData(goodsList);
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
	
	/**
	 * 获得总记录数
	 */
	private int getTotalRecords(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		String sql = "select count(*) from GoodsInfo";
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
	 * 查询所有商品信息
	 * @param pageSize 页面显示数据条数
	 * @param pageNo 页面编号
	 * @return 包含所有商品数据的分页对象
	 */
	public PageModel<GoodsInfo> getAllGoods(int pageSize, int pageNo,
			String keywords) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		PageModel<GoodsInfo> pm = null;
		String sql = "select top "
				+ pageSize
				+ " a.*,b.typeName from GoodsInfo a inner join GoodsType b on a.typeId = b.typeId where a.goodsName like '%"
				+ keywords
				+ "%' and a.goodsId not in (select top "
				+ ((pageNo - 1) * pageSize)
				+ " goodsId from GoodsInfo order by goodsId desc) order by goodsId desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsInfo goods = null;
			GoodsType type = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				type = new GoodsType(rs.getInt("typeId"), rs
						.getString("typeName"));
				goods.setGoodsType(type);
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setIsNew(rs.getInt("isNew"));
				goods.setIsRecommend(rs.getInt("isRecommend"));
				goods.setStatus(rs.getInt("status"));
				goods.setPhoto(rs.getString("photo"));
				goods.setRemark(rs.getString("remark"));

				goodsList.add(goods);
			}

			pm = new PageModel<GoodsInfo>();
			pm.setData(goodsList);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecordsByKeyWords(conn, pstmt, rs,keywords));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return pm;
	}

	/**
	 * 获得总记录数
	 */
	private int getTotalRecordsByKeyWords(Connection conn, PreparedStatement pstmt,
			ResultSet rs,String keyWords) {
		String sql = "select count(*) from GoodsInfo where goodsName like '%"+keyWords+"%'";
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
	 * 根据商品编号获得商品信息
	 * @param id 商品编号
	 * @return 商品信息
	 */
	public GoodsInfo getGoodsInfo(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsInfo goods = null;
		String sql = "select a.*,b.typeName from GoodsInfo a inner join GoodsType b on a.typeId = b.typeId where a.goodsId=?";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsType type = null;
			if (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				type = new GoodsType(rs.getInt("typeId"), rs
						.getString("typeName"));
				goods.setGoodsType(type);
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setIsNew(rs.getInt("isNew"));
				goods.setIsRecommend(rs.getInt("isRecommend"));
				goods.setStatus(rs.getInt("status"));
				goods.setPhoto(rs.getString("photo"));
				goods.setRemark(rs.getString("remark"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return goods;
	}
	
	/**
	 * 删除
	 * @param id 编号
	 * @return
	 */
	public boolean removeGoods(int id) {
		String sql = "delete from GoodsInfo where goodsId=?";
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
	 * 删除多个商品
	 * @param ids 商品编号
	 * @return 若删除成功返回true，删除失败返回false
	 */
	public boolean removeGoods(String ids) {
		StringBuilder sb = new StringBuilder(
				"delete from GoodsInfo where goodsId in (");
		sb.append(ids.substring(0, ids.length() - 1));
		sb.append(")");
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			// pstmt.setInt(1, id);
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
	 * 修改商品信息
	 * @param goods 商品信息
	 * @return 修改成功(true)或修改失败(false)
	 */
	public boolean updateGoods(GoodsInfo goods){
		String sql = "update GoodsInfo set typeId=?,goodsName=?,price=?,discount=?,isNew=?,isRecommend=?,status=?,photo=?,remark=? where goodsId = ?";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGoodsType().getTypeId());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setDouble(3, goods.getPrice());
			pstmt.setFloat(4, goods.getDiscount());
			pstmt.setInt(5, goods.getIsNew());
			pstmt.setInt(6, goods.getIsRecommend());
			pstmt.setInt(7, goods.getStatus());
			pstmt.setString(8, goods.getPhoto());
			pstmt.setString(9, goods.getRemark());
			pstmt.setInt(10, goods.getGoodsId());
			
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
	 * 新增商品
	 * @param goods 商品信息实体
	 * @return 添加成功(true)或添加失败(false)
	 */
	public boolean addGoods(GoodsInfo goods){
		String sql = "insert into GoodsInfo values (?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGoodsType().getTypeId());
			pstmt.setString(2, goods.getGoodsName());
			pstmt.setDouble(3, goods.getPrice());
			pstmt.setFloat(4, goods.getDiscount());
			pstmt.setInt(5, goods.getIsNew());
			pstmt.setInt(6, goods.getIsRecommend());
			pstmt.setInt(7, goods.getStatus());
			pstmt.setString(8, goods.getPhoto());
			pstmt.setString(9, goods.getRemark());
			
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
	 * 查询新商品
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public ArrayList<GoodsInfo> getNewGoods() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		String sql = "select top 9 goodsId,goodsName,price,discount,photo from GoodsInfo where isNew=0 and status=0 order by goodsId desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsInfo goods = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setPhoto(rs.getString("photo"));

				goodsList.add(goods);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return goodsList;
	}
	
	/**
	 * 查询推荐商品
	 * @return
	 */
	public ArrayList<GoodsInfo> getRecommendGoods() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		String sql = "select top 9 goodsId,goodsName,price,discount,photo from GoodsInfo where isRecommend=0 and status=0 order by goodsId desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsInfo goods = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setPhoto(rs.getString("photo"));

				goodsList.add(goods);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return goodsList;
	}
	
	/**
	 * 查询特价商品
	 * @return
	 */
	public ArrayList<GoodsInfo> getDiscountGoods() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		String sql = "select top 9 goodsId,goodsName,price,discount,photo from GoodsInfo where discount<>10 and status=0 order by discount";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsInfo goods = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setPhoto(rs.getString("photo"));

				goodsList.add(goods);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return goodsList;
	}
	
	/**
	 * 查询热卖商品
	 * @return
	 */
	public ArrayList<SalesGoods> getSalesGoods(int typeId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SalesGoods> goodsList = new ArrayList<SalesGoods>();
		String sql = "select top 10 sum(a.quantity) as quantity,b.goodsId,b.goodsName from OrderGoodsInfo a inner join GoodsInfo b on a.goodsId=b.goodsId inner join OrderInfo c on c.orderId=a.orderId where b.typeId=? and b.status=0 and c.status=1 group by b.goodsId,b.goodsName order by sum(a.quantity) desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);

			// 执行查询
			rs = pstmt.executeQuery();
			SalesGoods goods = null;
			while (rs.next()) {
				goods = new SalesGoods();
				goods.setQuantity(rs.getInt("quantity"));
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goodsList.add(goods);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return goodsList;
	}
	
	/**
	 * 根据类型编号查询该类型下的所有商品信息，且商品都是上架的
	 * @param pageSize
	 * @param pageNo
	 * @param typeId
	 * @return
	 */
	public PageModel<GoodsInfo> getAllGoodsByTypeId(int pageSize, int pageNo,int typeId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
		PageModel<GoodsInfo> pm = null;
		String sql = "select top "
				+ pageSize
				+ " a.*,b.typeName from GoodsInfo a inner join GoodsType b on a.typeId = b.typeId where a.typeId="+typeId+" and a.status=0 and a.goodsId not in (select top "
				+ ((pageNo - 1) * pageSize)
				+ " goodsId from GoodsInfo where typeId="+typeId+" and a.status=0 order by goodsId desc) order by goodsId desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			GoodsInfo goods = null;
			GoodsType type = null;
			while (rs.next()) {
				goods = new GoodsInfo();
				goods.setGoodsId(rs.getInt("goodsId"));
				type = new GoodsType(rs.getInt("typeId"), rs
						.getString("typeName"));
				goods.setGoodsType(type);
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setPrice(rs.getDouble("price"));
				goods.setDiscount(rs.getFloat("discount"));
				goods.setIsNew(rs.getInt("isNew"));
				goods.setIsRecommend(rs.getInt("isRecommend"));
				goods.setStatus(rs.getInt("status"));
				goods.setPhoto(rs.getString("photo"));
				goods.setRemark(rs.getString("remark"));

				goodsList.add(goods);
			}

			pm = new PageModel<GoodsInfo>();
			pm.setData(goodsList);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecordsByTypeId(conn, pstmt, rs,typeId));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return pm;
	}
	
	/**
	 * 获得总记录数
	 */
	private int getTotalRecordsByTypeId(Connection conn, PreparedStatement pstmt,
			ResultSet rs,int typeId) {
		String sql = "select count(*) from GoodsInfo where status=0 and typeId="+typeId;
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
}
