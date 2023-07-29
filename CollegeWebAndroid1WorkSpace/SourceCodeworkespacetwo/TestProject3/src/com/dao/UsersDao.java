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
 * ��ɶ����ݿ��crud
 */
public class UsersDao {
	
	//��¼��֤
	public User findUserByNameAndPassword(String username, String password)
	throws SQLException{
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���
			con = JDBCUtils.getCon();
			// ��ȡִ��sql���Ķ���
			String sql = "select * from users where username=? and password=?";
			// ����ִ��sql����PreparedStatement����
			preStmt = con.prepareStatement(sql);
			// ����sql���
			preStmt.setString(1, username.trim());
			preStmt.setString(2, password);
			System.out.println(username + "," + password);
			rs = preStmt.executeQuery();
			while (rs.next()) {
			// һ�����ݶ�Ӧһ�����󣬻�ȡÿһ�е����ݣ������ø�һ��user����
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setSex(rs.getString("sex"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			user.setRole(rs.getInt("role"));
			// �Ѷ�����ӵ�����
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
	
	
	//�����û��ķ���
	public boolean insert(User user) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement preStmt = null;
		try {
			// ��ȡ���Ӷ���
			con = JDBCUtils.getCon();
			// ��ȡִ��sql���Ķ���,ִ��sql
//			 Date birthday = user.getBirthday();
			// String sqlBirthday = String.format("%tF", birthday);
			
//			Date birthday = sdf.format(user.getBirthday());
			String sql = "insert into users(username,sex,password,email,birthday,role)" 
						+ "values(?,?,?,?,?,?)";
			// ����ִ��sql����PreparedStatement����
			preStmt = con.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			// λsql����еĲ�����ֵ
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getSex());
			preStmt.setString(3, user.getPassword());
			preStmt.setString(4, user.getEmail());
			preStmt.setString(5, sdf.format(user.getBirthday()));
//			preStmt.setDate(5, user.getBirthday());
			preStmt.setInt(6, user.getRole());
			// ִ��sql
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

	// �ṩ��ѯ���еķ���
	public List<User> findAllUser() {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// ��ȡִ��sql���Ķ���
			String sql = "select * from users ";
			// ����ִ��sql����PreparedStatement����
			preStmt = con.prepareStatement(sql);
			rs = preStmt.executeQuery();
			// ����rs
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				// һ�����ݶ�Ӧһ�����󣬻�ȡÿһ�е����ݣ������ø�һ��user����
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setSex(rs.getString("sex"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setRole(rs.getInt("role"));
				// �Ѷ�����ӵ�����
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
	}

	// ����id��ָ����user
	public User find(int id) {
//			Statement stmt = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// ��ȡStatement�Ķ���

			String sql = "select * from users where id = " + id;
			preStmt = con.prepareStatement(sql);
			rs = preStmt.executeQuery();
			// ������
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
	// �����û�����ָ����user
		public boolean find(String username) {
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				// ��ȡ���Ӷ���ķ���
				con = JDBCUtils.getCon();
				// ��ȡStatement�Ķ���

				String sql = "select * from users where username='" + username + "' ";
				System.out.println(username);
				preStmt = con.prepareStatement(sql);
				
				rs = preStmt.executeQuery();
				// ������
				if (rs.next()) return false;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtils.release(rs, preStmt, con);
				}
			return true;
		}

	// ɾ���û�
	public boolean delete(int id) {
//			Statement stmt = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// ��ȡStatement�Ķ���
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

	// �޸��û�
	public boolean update(User user) {
		PreparedStatement preStmt = null;
//			ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// ��ȡStatement�Ķ���
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

	// �޸��û�����
	public boolean updatePassword(User user) {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			con = JDBCUtils.getCon();
			// ���Statement����
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
