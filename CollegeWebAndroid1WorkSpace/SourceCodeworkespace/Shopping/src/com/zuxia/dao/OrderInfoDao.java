package com.zuxia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zuxia.model.CustomerDetailInfo;
import com.zuxia.model.CustomerInfo;
import com.zuxia.model.GoodsInfo;
import com.zuxia.model.GoodsType;
import com.zuxia.model.OrderGoodsInfo;
import com.zuxia.model.OrderInfo;
import com.zuxia.util.DBConn;
import com.zuxia.util.DateTimeUtil;
import com.zuxia.util.PageModel;

/**
 * 订单信息类
 */
public class OrderInfoDao {
	/**
	 * 分页查询订单信息
	 * 
	 * @param pageSize 页面显示记录的条数
	 * @param pageNo 页码
	 * @return 包含订单数据的分页对象
	 */
	public PageModel<OrderInfo> getAllOrdersInfo(int pageSize, int pageNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<OrderInfo> pm = null;
		ArrayList<OrderInfo> orders = new ArrayList<OrderInfo>();
		String sql = "select top "
				+ pageSize
				+ " a.orderId,a.customerId,a.status,a.orderTime,b.email,c.name,c.telphone,c.movePhone from OrderInfo a inner join CustomerInfo b on a.customerId=b.id left join CustomerDetailInfo c on c.customerId=b.id where a.orderId not in (select top "
				+ ((pageNo - 1) * pageSize) + " orderId from OrderInfo)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			OrderInfo order = null;
			CustomerInfo customer = null;
			CustomerDetailInfo detail = null;
			while (rs.next()) {
				order = new OrderInfo();
				order.setOrderId(rs.getInt("orderId"));
				order.setStatus(rs.getInt("status"));
				order.setOrderTime(DateTimeUtil.convertDate(rs
						.getString("orderTime")));
				customer = new CustomerInfo();
				customer.setId(rs.getInt("customerId"));
				customer.setEmail(rs.getString("email"));

				detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				customer.setDetailInfo(detail);

				order.setCustomerInfo(customer);

				orders.add(order);
			}

			// 设置分页属性
			pm = new PageModel<OrderInfo>();
			pm.setData(orders);
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

	// 获取总记录条数
	private int getTotalRecords(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		String sql = "select count(1) from OrderInfo";
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
	 * 根据关键字查询订单
	 * 
	 * @param pageSize 页面显示数据的条数
	 * @param pageNo 页码
	 * @param keywords 关键词
	 * @return 包含订单数据的分页对象
	 */
	public PageModel<OrderInfo> getAllOrdersInfo(int pageSize, int pageNo,
			String keywords) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<OrderInfo> pm = null;
		ArrayList<OrderInfo> orders = new ArrayList<OrderInfo>();
		String sql = "select top "
				+ pageSize
				+ " a.orderId,a.customerId,a.status,a.orderTime,b.email,c.name,c.telphone,c.movePhone from OrderInfo a inner join CustomerInfo b on a.customerId=b.id left join CustomerDetailInfo c on c.customerId=b.id where a.orderId like '%"
				+ keywords + "%' or b.email like '%" + keywords
				+ "%' and a.orderId not in (select top "
				+ ((pageNo - 1) * pageSize) + " a.orderId from OrderInfo)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			OrderInfo order = null;
			CustomerInfo customer = null;
			CustomerDetailInfo detail = null;
			while (rs.next()) {
				order = new OrderInfo();
				order.setOrderId(rs.getInt("orderId"));
				order.setStatus(rs.getInt("status"));
				order.setOrderTime(DateTimeUtil.convertDate(rs
						.getString("orderTime")));
				customer = new CustomerInfo();
				customer.setId(rs.getInt("customerId"));
				customer.setEmail(rs.getString("email"));

				detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				customer.setDetailInfo(detail);

				order.setCustomerInfo(customer);

				orders.add(order);
			}

			// 设置分页属性
			pm = new PageModel<OrderInfo>();
			pm.setData(orders);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecords(conn, pstmt, rs, keywords));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return pm;
	}

	// 获取总记录条数（关键字搜索时）
	private int getTotalRecords(Connection conn, PreparedStatement pstmt,
			ResultSet rs, String keywords) {
		String sql = "select count(1) from OrderInfo a inner join CustomerInfo b on a.customerId=b.id where a.orderId like '%"
			+ keywords + "%' or b.email like '%" + keywords
			+ "%'";
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
	 * 分页查询某种状态（未确认/已确认）的订单
	 * @param pageSize 页码
	 * @param pageNo 页码大小
	 * @param status 订单状态
	 * @return 包含订单数据的分页对象
	 */
	public PageModel<OrderInfo> getAllOrdersInfo(int pageSize, int pageNo,
			int status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PageModel<OrderInfo> pm = null;
		ArrayList<OrderInfo> orders = new ArrayList<OrderInfo>();
		String sql = "select top "
				+ pageSize
				+ " a.orderId,a.customerId,a.status,a.orderTime,b.email,c.name,c.telphone,c.movePhone from OrderInfo a inner join CustomerInfo b on a.customerId=b.id left join CustomerDetailInfo c on c.customerId=b.id where a.status="
				+ status+" and a.orderId not in (select top "
				+ ((pageNo - 1) * pageSize) + " a.orderId from OrderInfo)";
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			OrderInfo order = null;
			CustomerInfo customer = null;
			CustomerDetailInfo detail = null;
			while (rs.next()) {
				order = new OrderInfo();
				order.setOrderId(rs.getInt("orderId"));
				order.setStatus(rs.getInt("status"));
				order.setOrderTime(DateTimeUtil.convertDate(rs
						.getString("orderTime")));
				customer = new CustomerInfo();
				customer.setId(rs.getInt("customerId"));
				customer.setEmail(rs.getString("email"));

				detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				customer.setDetailInfo(detail);

				order.setCustomerInfo(customer);

				orders.add(order);
			}

			// 设置分页属性
			pm = new PageModel<OrderInfo>();
			pm.setData(orders);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecords(conn, pstmt, rs, status));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return pm;
	}

	// 获取总记录条数（关键字搜索时）
	private int getTotalRecords(Connection conn, PreparedStatement pstmt,
			ResultSet rs, int status) {
		String sql = "select count(1) from OrderInfo where status="+ status;
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
	 * 获取订单信息
	 * @param orderId 订单编号
	 * @return 包含此订单全部数据的订单信息
	 */
	public OrderInfo getOrderInfo(int orderId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderInfo order = null;
		
		
		//String sql = "select a.customerId,a.status,a.orderTime,b.goodsId,b.quantity,c.goodsName,c.price,c.discount,d.typeName,f.email,f.registerTime,g.name,g.telphone,g.movePhone,g.address from OrderInfo a left join OrderGoodsInfo b on a.orderId=b.orderId inner join GoodsInfo c on c.goodsId=b.goodsId inner join GoodsType d on d.typeId=c.typeId inner join CustomerInfo f on a.customerId=f.id left join CustomerDetailInfo g on g.customerId=f.id  where a.orderId=?";
		String sql="select a.customerId,a.status,a.orderTime,b.email,b.registerTime,c.name,c.telphone,c.movePhone,c.address from OrderInfo a inner join CustomerInfo b on a.customerId=b.id left join CustomerDetailInfo c on c.customerId=b.id  where a.orderId="+orderId;
		String sql2="select a.goodsId,a.quantity,b.typeId,b.goodsName,b.price,b.discount,c.typeName from OrderGoodsInfo a inner join GoodsInfo b on a.goodsId=b.goodsId inner join GoodsType c on c.typeId=b.typeId where a.orderId="+orderId;

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				order = new OrderInfo();
				//订单信息
				order.setOrderId(orderId);
				order.setStatus(rs.getInt("status"));
				order.setOrderTime(DateTimeUtil.convertDate(rs.getString("orderTime")));
				
				//客户信息
				CustomerInfo customer = new CustomerInfo();
				customer.setId(rs.getInt("customerId"));
				customer.setEmail(rs.getString("email"));
				customer.setRegisterTime(DateTimeUtil.convertDate(rs.getString("registerTime")));
				
				//客户详细信息
				CustomerDetailInfo detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				detail.setAddress(rs.getString("address"));
				customer.setDetailInfo(detail);
				
				order.setCustomerInfo(customer);
				
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				
				OrderGoodsInfo orderGoods = null;
				GoodsInfo goodsInfo = null;
				ArrayList<OrderGoodsInfo> orderGoodsList = new ArrayList<OrderGoodsInfo>();
				while(rs.next()){
					//订单详细信息
					orderGoods = new OrderGoodsInfo();
					orderGoods.setQuantity(rs.getInt("quantity"));
					//商品信息
					goodsInfo = new GoodsInfo();
					goodsInfo.setGoodsId(rs.getInt("goodsId"));
					goodsInfo.setGoodsName(rs.getString("goodsName"));
					goodsInfo.setPrice(rs.getDouble("price"));
					goodsInfo.setDiscount(rs.getFloat("discount"));
					goodsInfo.setGoodsType(new GoodsType(rs.getInt("typeId"),rs.getString("typeName")));
					orderGoods.setGoodsInfo(goodsInfo);
					orderGoodsList.add(orderGoods);
				}
				//将订单详细信息存入订单对象中
				order.setOrderDetails(orderGoodsList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		return order;
	}
	
	/**
	 * 改变订单状态
	 * @param orderId 订单编号
	 * @param status 订单状态
	 * @return 订单状态改变成功(true)或订单状态改变失败（false）
	 */
	public boolean changeOrderStatus(int orderId,int status){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update OrderInfo set status=? where orderId=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, orderId);
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			DBConn.closeDB(null, pstmt, conn);
		}
	}
	
	//删除订单
	public boolean removeOrder(int orderId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from OrderGoodsInfo where orderId=? delete from OrderInfo where orderId=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, orderId);
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			DBConn.closeDB(null, pstmt, conn);
		}
	}
	
	//删除订单
	public boolean removeOrder(String orderIds){
		orderIds = orderIds.substring(0, orderIds.length() - 1);
		StringBuilder sb = new StringBuilder(
				"delete from OrderGoodsInfo where orderId in (");
		sb.append(orderIds);
		sb.append(") delete from OrderInfo where orderId in (");
		sb.append(orderIds);
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
	
	//添加订单
	public boolean addOrder(OrderInfo order){
		StringBuilder sb = new StringBuilder();
		//第一部分SQL语句
		sb.append("insert into OrderInfo values (")
			.append(order.getCustomerInfo().getId())
			.append(",")
			.append(order.getStatus())
			.append(",getdate()) ");
		
		
		//第二部分SQL语句
		sb.append("declare @orderId int ")
			.append("select @orderId=@@identity ");
		
		ArrayList<OrderGoodsInfo> goodsList = order.getOrderDetails();
		for(OrderGoodsInfo goodsDetail : goodsList){
			sb.append("insert into OrderGoodsInfo values (@orderId,")
				.append(goodsDetail.getGoodsInfo().getGoodsId())
				.append(",")
				.append(goodsDetail.getQuantity())
				.append(") ");
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sb.toString());
			
			conn.setAutoCommit(false);
			pstmt.executeUpdate();
			conn.commit(); //提交事务
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try{
				conn.rollback(); //回滚
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally{
			DBConn.closeDB(null, pstmt, conn);
		}
		return false;
	}
}
