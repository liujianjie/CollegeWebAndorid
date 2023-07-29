package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.utils.JDBCUtils;

/*
 * 完成对数据库的crud
 */
public class UsersDao {
	
	//登录验证
	public User findUserByNameAndPassword(String username, String password)
	throws SQLException{
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象
			con = JDBCUtils.getCon();
			// 获取执行sql语句的对象
			String sql = "select * from users where username=? and password=?";
			// 创建执行sql语句的PreparedStatement对象
			preStmt = con.prepareStatement(sql);
			// 发送sql语句
			preStmt.setString(1, username.trim());
			preStmt.setString(2, password);
			System.out.println(username + "," + password);
			rs = preStmt.executeQuery();
			while (rs.next()) {
			// 一行数据对应一个对象，获取每一行的数据，就设置给一个user对象
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setSex(rs.getString("sex"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			user.setRole(rs.getInt("role"));
			// 把对象添加到集合
			return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			JDBCUtils.release(rs, preStmt, con);
			}
		return null;
	}
	
	
	//插入用户的方法
	public boolean insert(User user) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement preStmt = null;
		try {
			// 获取连接对象
			con = JDBCUtils.getCon();
			// 获取执行sql语句的对象,执行sql
//			 Date birthday = user.getBirthday();
			// String sqlBirthday = String.format("%tF", birthday);
			
//			Date birthday = sdf.format(user.getBirthday());
			String sql = "insert into users(username,sex,password,email,birthday,role)" 
						+ "values(?,?,?,?,?,?)";
			// 创建执行sql语句的PreparedStatement对象
			preStmt = con.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			// 位sql语句中的参数赋值
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getSex());
			preStmt.setString(3, user.getPassword());
			preStmt.setString(4, user.getEmail());
			preStmt.setString(5, sdf.format(user.getBirthday()));
//			preStmt.setDate(5, user.getBirthday());
			preStmt.setInt(6, user.getRole());
			// 执行sql
			int row = preStmt.executeUpdate();
			if (row > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return false;
	}

	// 提供查询所有的方法
	public List<User> findAllUser() {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
			con = JDBCUtils.getCon();
			// 获取执行sql语句的对象
			String sql = "select * from users ";
			// 创建执行sql语句的PreparedStatement对象
			preStmt = con.prepareStatement(sql);
			rs = preStmt.executeQuery();
			// 遍历rs
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				// 一行数据对应一个对象，获取每一行的数据，就设置给一个user对象
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setRole(rs.getInt("role"));
				// 把对象添加到集合
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
	}

	// 根据id查指定的user
	public User find(int id) {
//			Statement stmt = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
			con = JDBCUtils.getCon();
			// 获取Statement的对象

			String sql = "select * from users where id = " + id;
			preStmt = con.prepareStatement(sql);
			rs = preStmt.executeQuery();
			// 处理结果
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				java.sql.Date birthday = rs.getDate("birthday");
				user.setRole(rs.getInt("role"));
				return user;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
	}
	// 根据用户名查指定的user
		public boolean find(String username) {
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				// 获取连接对象的方法
				con = JDBCUtils.getCon();
				// 获取Statement的对象

				String sql = "select * from users where username='" + username + "' ";
				System.out.println(username);
				preStmt = con.prepareStatement(sql);
				
				rs = preStmt.executeQuery();
				// 处理结果
				if (rs.next()) return false;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtils.release(rs, preStmt, con);
				}
			return true;
		}

	// 删除用户
	public boolean delete(int id) {
//			Statement stmt = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
			con = JDBCUtils.getCon();
			// 获取Statement的对象
//				preStmt = con.createStatement();

			String sql = "delete from users where id = " + id;
			preStmt = con.prepareStatement(sql);

			int num = preStmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
	}

	// 修改用户
	public boolean update(User user) {
		PreparedStatement preStmt = null;
//			ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
			con = JDBCUtils.getCon();
			// 获取Statement的对象
			String sql = "update users set username=?,sex=?,password=? where id = ?";
			preStmt = con.prepareStatement(sql);

			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getSex());
			preStmt.setString(3, user.getPassword());
			preStmt.setInt(4, user.getId());

			int num = preStmt.executeUpdate();
			if (num > 0) {
				return true;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.release(null, preStmt, con);
		}
		return false;
	}

	// 修改用户密码
	public boolean updatePassword(User user) {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			con = JDBCUtils.getCon();
			// 获得Statement对象
			String sql = "update users set password=? where id=?";
			preStmt = con.prepareStatement(sql);
			preStmt.setString(1, user.getPassword());
			preStmt.setInt(2, user.getId());
				
		
			int num = preStmt.executeUpdate();
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return false;
	}
	
}
