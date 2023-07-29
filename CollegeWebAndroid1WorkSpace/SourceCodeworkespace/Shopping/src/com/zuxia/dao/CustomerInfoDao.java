package com.zuxia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zuxia.model.CustomerDetailInfo;
import com.zuxia.model.CustomerInfo;
import com.zuxia.model.UserInfo;
import com.zuxia.util.DBConn;
import com.zuxia.util.DateTimeUtil;
import com.zuxia.util.PageModel;

/**
 * 客户信息数据访问类
 */
public class CustomerInfoDao {

	/**
	 * 查询出所有的客户户信息（分页）
	 * 
	 * @param pageSize 页面显示数据条数
	 * @param pageNo 页码
	 * @return 包含客户信息数据分页对象
	 */
	public PageModel<CustomerInfo> getAllCustomers(int pageSize, int pageNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerInfo> cusList = new ArrayList<CustomerInfo>();
		PageModel<CustomerInfo> pm = null;
		String sql = "select top "
				+ pageSize
				+ " a.*,b.name,b.telphone,b.movePhone,b.address from CustomerInfo a left join CustomerDetailInfo b on a.id=b.customerId where a.id not in (select top "
				+ ((pageNo - 1) * pageSize)
				+ " id from CustomerInfo order by id desc) order by a.id desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			CustomerInfo customer = null;
			CustomerDetailInfo detail = null;
			while (rs.next()) {
				customer = new CustomerInfo();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPwd(rs.getString("pwd"));
				customer.setRegisterTime(DateTimeUtil.convertDate(rs
						.getString("registerTime")));
				detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				detail.setAddress(rs.getString("address"));
				customer.setDetailInfo(detail);

				cusList.add(customer);
			}

			pm = new PageModel<CustomerInfo>();
			pm.setData(cusList);
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
		String sql = "select count(*) from CustomerInfo";
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
	 * 搜索客户信息（分页）
	 * 
	 * @param pageSize 页面显示数据条数
	 * @param pageNo 页码
	 * @param keywords 客户名关键词
	 * @return 包含客户信息数据分页对象
	 */
	public PageModel<CustomerInfo> getAllCustomers(int pageSize, int pageNo,
			String keywords) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerInfo> cusList = new ArrayList<CustomerInfo>();
		PageModel<CustomerInfo> pm = null;
		String sql = "select top "
				+ pageSize
				+ " a.*,b.name,b.telphone,b.movePhone,b.address from CustomerInfo a left join CustomerDetailInfo b on a.id=b.customerId where b.name like '%"
				+ keywords + "%' or a.email like '%"+keywords+"%' and a.id not in (select top "
				+ ((pageNo - 1) * pageSize)
				+ " id from CustomerInfo order by id desc) order by a.id desc";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);

			// 执行查询
			rs = pstmt.executeQuery();
			CustomerInfo customer = null;
			CustomerDetailInfo detail = null;
			while (rs.next()) {
				customer = new CustomerInfo();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPwd(rs.getString("pwd"));
				customer.setRegisterTime(DateTimeUtil.convertDate(rs
						.getString("registerTime")));
				detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				detail.setAddress(rs.getString("address"));
				customer.setDetailInfo(detail);

				cusList.add(customer);
			}

			pm = new PageModel<CustomerInfo>();
			pm.setData(cusList);
			pm.setPageNo(pageNo);
			pm.setPageSize(pageSize);
			pm.setTotalRecords(getTotalRecordsByKeywords(conn, pstmt, rs, keywords));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return pm;
	}
	
	//获取总记录条数
	private int getTotalRecordsByKeywords(Connection conn, PreparedStatement pstmt,
			ResultSet rs,String keywords) {
		String sql = "select count(1) from CustomerInfo a left join CustomerDetailInfo b on a.id=b.customerId where b.name like '%"
				+ keywords + "%'";
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
	 * 获取客户信息
	 * @param customerId 客户编号
	 * @return 客户信息
	 */
	public CustomerInfo getCustomerInfo(int customerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerInfo customer = null;
		String sql = "select a.*,b.name,b.telphone,b.movePhone,b.address from CustomerInfo a left join CustomerDetailInfo b on a.id=b.customerId where a.id = ? ";

		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customerId);

			// 执行查询
			rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new CustomerInfo();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPwd(rs.getString("pwd"));
				customer.setRegisterTime(DateTimeUtil.convertDate(rs
						.getString("registerTime")));
				CustomerDetailInfo detail = new CustomerDetailInfo();
				detail.setName(rs.getString("name"));
				detail.setTelphone(rs.getString("telphone"));
				detail.setMovePhone(rs.getString("movePhone"));
				detail.setAddress(rs.getString("address"));
				customer.setDetailInfo(detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}

		return customer;
	}
	
	/**
	 * 删除
	 * @param id 编号
	 * @return
	 */
	public boolean removeCustomer(int id) {
		String sql = "delete from CustomerDetailInfo where customerId=? ";
		String sql1 = "delete from CustomerInfo where id=?";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql+sql1);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
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
	 * 删除多个客户信息
	 * @param ids 客户编号
	 * @return 若删除成功返回true，删除失败返回false
	 */
	public boolean removeCustomers(String ids) {
		ids = ids.substring(0, ids.length() - 1);
		StringBuilder sb = new StringBuilder(
				"delete from CustomerDetailInfo where customerId in (");
		sb.append(ids);
		sb.append(") delete from CustomerInfo where id in (");
		sb.append(ids);
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
	 * 修改
	 * @param customer  客户信息
	 * @return 修改成功(true)或修改失败(false)
	 */
	public boolean updateCustomer(CustomerInfo customer){
		String sql = "update CustomerInfo set email=? where id=? ";
		String sql2 = "update CustomerDetailInfo set name=?,telphone=?,movePhone=?,address=? where customerId=?";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql+sql2);
			//设置参数
			pstmt.setString(1, customer.getEmail());
			pstmt.setInt(2, customer.getId());
			
			CustomerDetailInfo detail = customer.getDetailInfo();
			pstmt.setString(3, detail.getName());
			pstmt.setString(4, detail.getTelphone());
			pstmt.setString(5, detail.getMovePhone());
			pstmt.setString(6, detail.getAddress());
			pstmt.setInt(7, customer.getId());
			
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
	 * 新增客户详细信息
	 * @param detail 详细信息
	 * @return 新增结果（成功或失败）
	 */
	public boolean addCustomerDetailInfo(CustomerDetailInfo detail){
		String sql = "insert into CustomerDetailInfo values (?,?,?,?,?)";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, detail.getCustomerInfo().getId());
			pstmt.setString(2, detail.getName());
			pstmt.setString(3, detail.getTelphone());
			pstmt.setString(4, detail.getMovePhone());
			pstmt.setString(5, detail.getAddress());
			
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
	 * 新增客户信息
	 * @param customer 客户信息实体
	 * @return 添加成功(true)或添加失败(false)
	 */
	public boolean addCustomer(CustomerInfo customer){
		String sql = "insert into CustomerInfo values (?,?,getdate()) ";
		String sql2 = "insert into CustomerDetailInfo values (@@identity,?,?,?,?)";
		
		Connection conn = DBConn.getConn();
		PreparedStatement pstmt = null;

		try {
				CustomerDetailInfo detail = customer.getDetailInfo();
			if(detail==null){
				pstmt = conn.prepareStatement(sql);
			}else{
				pstmt = conn.prepareStatement(sql+sql2);
				pstmt.setString(3, detail.getName());
				pstmt.setString(4, detail.getTelphone());
				pstmt.setString(5, detail.getMovePhone());
				pstmt.setString(6, detail.getAddress());
			}
			//设置参数
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPwd());
			
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
	 * 客户登陆
	 * @param name 客户账户名
	 * @param pwd 客户密码
	 * @return 客户信息
	 */
	public CustomerInfo validateLogin(String name,String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerInfo customer = null;
		String sql = "select a.*,b.name,b.telphone,b.movePhone,b.address from CustomerInfo a left join CustomerDetailInfo b on a.id=b.customerId where a.email=? and a.pwd=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
	
			// 执行查询
			rs = pstmt.executeQuery();
	
			if (rs.next()) {
				customer = new CustomerInfo();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPwd(rs.getString("pwd"));
				customer.setRegisterTime(DateTimeUtil.convertDate(rs
						.getString("registerTime")));
				CustomerDetailInfo detail = null;
				String cusName = rs.getString("name");
				if(cusName != null && !"".equals(cusName.trim())){
					detail= new CustomerDetailInfo();
					detail.setName(cusName);
					detail.setTelphone(rs.getString("telphone"));
					detail.setMovePhone(rs.getString("movePhone"));
					detail.setAddress(rs.getString("address"));
					
				}
				customer.setDetailInfo(detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		
		return customer;
	}
	
	/**
	 * 验证某Email是否已经存在
	 * @param email
	 * @return 存在(true)，不存在（false）
	 */
	public boolean isExists(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerInfo customer = null;
		String sql = "select 1 from CustomerInfo where email=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
	
			// 执行查询
			rs = pstmt.executeQuery();
	
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		
		return false;
	}
}
