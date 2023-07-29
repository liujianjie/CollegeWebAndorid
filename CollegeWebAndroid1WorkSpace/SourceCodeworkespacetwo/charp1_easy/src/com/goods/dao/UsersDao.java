package com.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.goods.bean.User;
import com.goods.utils.JDBCUtils;

/*
 * 使用jdbc操作数据库表users（用户表），对这个表进行增删改查
 */
public class UsersDao {

	// 登录验证，参数为用户名和密码
	public User findUserByNameAndPassword(String username, String password) throws SQLException {
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
			// 设置占位符的值
			preStmt.setString(1, username.trim());
			preStmt.setString(2, password);
			// 执行查询操作
			rs = preStmt.executeQuery();
			while (rs.next()) {
				// user对象存储users表中的用户信息
				User user = new User();
				user.setId(rs.getInt("id"));// 获取id
				user.setUsername(rs.getString("username"));// 获取用户名
				user.setSex(rs.getString("sex"));// 获取性别
				user.setPassword(rs.getString("password"));// 获取密码
				user.setEmail(rs.getString("email"));// 获取email
				user.setBirthday(rs.getDate("birthday"));// 获取生日
				user.setRole(rs.getInt("role"));// 角色
				return user;// 只要一个，直接返回
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			;
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return null;
	}

	// 插入用户的方法
	public boolean insert(User user) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement preStmt = null;
		try {
			// 获取连接对象
			con = JDBCUtils.getCon();
			// 获取执行sql语句的对象,执行sql
			String sql = "insert into users(username,sex,password,email,birthday,role)" + "values(?,?,?,?,?,?)";
			// 创建执行sql语句的PreparedStatement对象
			preStmt = con.prepareStatement(sql);
			// 格式化对象
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 设置占位符的值
			preStmt.setString(1, user.getUsername());// 用户名
			preStmt.setString(2, user.getSex());// 性别
			preStmt.setString(3, user.getPassword());// 密码
			preStmt.setString(4, user.getEmail());// email
			preStmt.setString(5, sdf.format(user.getBirthday()));//生日，sdf.format：将日期类型转换为字符串类型
			// preStmt.setDate(5, user.getBirthday());
			preStmt.setInt(6, user.getRole());// 角色
			// 执行sql
			int row = preStmt.executeUpdate();
			// 插入成功返回影响的行数，大于0代表成功
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

	// 提供查询所有用户的方法
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
		// Statement stmt = null;
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
//				java.sql.Date birthday = rs.getDate("birthday");
				user.setBirthday(rs.getDate("birthday"));
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
			// 得到PreparedStatement对象
			preStmt = con.prepareStatement(sql);
			// 执行修改删除
			rs = preStmt.executeQuery();
			// 处理结果
			if (rs.next())
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return true;
	}

	// 删除用户
	public boolean delete(int id) {
		// Statement stmt = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
			con = JDBCUtils.getCon();
			// 获取Statement的对象
			// preStmt = con.createStatement();

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
		// ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
			con = JDBCUtils.getCon();
			// 获取Statement的对象
			String sql = "update users set username=?,sex=?,password=? where id = ?";
			preStmt = con.prepareStatement(sql);
			// 设置占位符
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getSex());
			preStmt.setString(3, user.getPassword());
			preStmt.setInt(4, user.getId());
			// 执行修改删除操作
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

	// 修改用户密码，根据用户id设置这个用户密码
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
			// 设置占位符
			preStmt.setString(1, user.getPassword());// 新密码
			preStmt.setInt(2, user.getId());//用户的id
			// 执行修改删除操作
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
