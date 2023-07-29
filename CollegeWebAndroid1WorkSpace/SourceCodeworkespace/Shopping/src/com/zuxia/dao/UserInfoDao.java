package com.zuxia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zuxia.model.UserInfo;
import com.zuxia.util.DBConn;

/**
 * 用户信息数据访问类
 */
public class UserInfoDao {
	
	/**
	 * 获取用户信息
	 * @param userId 用户编号
	 * @return 用户信息
	 */
	public UserInfo getUserInfo(int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo user = null;
		String sql = "select * from UserInfo where id=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
	
			// 执行查询
			rs = pstmt.executeQuery();
	
			if (rs.next()) {
				user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		
		return user;
	}
	
	/**
	 * 验证管理员用户登录
	 * @param name 用户名
	 * @param pwd 用户密码
	 * @return 登录成功返回用户信息，登录失败返回null
	 */
	public UserInfo validateLogin(UserInfo loginUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo user = null;
		String sql = "select id from UserInfo where userName=? and userPwd=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginUser.getUserName());
			pstmt.setString(2, loginUser.getUserPwd());
	
			// 执行查询
			rs = pstmt.executeQuery();
	
			if (rs.next()) {
				user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setUserName(loginUser.getUserName());
				user.setUserPwd(loginUser.getUserPwd());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(rs, pstmt, conn);
		}
		
		return user;
	}
	
	/**
	 * 修改用户信息
	 * @param user 用户
	 * @param oldPwd 旧密码
	 * @return 修改成功(true) 或 修改失败(false)
	 */
	public boolean update(UserInfo user,String oldPwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update UserInfo set userName=?,userPwd=? where id=? and userPwd=?";
		
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setInt(3, user.getId());
			pstmt.setString(4, oldPwd);
	
			// 执行更新
			int rowCount = pstmt.executeUpdate();
			if (rowCount>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeDB(null, pstmt, conn);
		}
		
		return false;
	}
	
	/**
	 * 修改
	 * @param user
	 * @param oldPwd
	 * @return
	 */
	public boolean update(UserInfo user) {
		return this.update(user, user.getUserPwd());
	}
}
