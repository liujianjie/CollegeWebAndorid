package com.goods.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.goods.bean.User;
import com.goods.util.JDBCUtils;


public class UsersDao {
	// ����û��Ĳ���
	public boolean insert(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		// ������ݵ�����
		conn = JDBCUtils.getConnection();
		// ���Statement����
		 String sql = "INSERT INTO users(name,password,email,birthday,sex,role) "+
					"VALUES(?,?,?,?,?,?)";
         stmt=conn.prepareStatement(sql);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		
         stmt.setString(1, user.getName());
		 stmt.setString(2, user.getPassword());
		 stmt.setString(3, user.getEmail());
		 stmt.setString(4, sdf.format(user.getBirthday()));
		 stmt.setString(5, user.getSex());
		 stmt.setInt(6, user.getRole());
		
		// ����SQL���
		
	
			int num = stmt.executeUpdate();
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	// ��ѯ���е�User����
	public ArrayList<User> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM users";
			rs = stmt.executeQuery(sql);
			// ��������
			
			while (rs.next()) {
				
				User user = new User();	
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setSex(rs.getString("sex"));
				user.setRole(rs.getInt("role"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	// ����id����ָ����user
	public User find(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			conn = JDBCUtils.getConnection();
			// ���Statement����
			stmt = conn.createStatement();
			// ����SQL���
			String sql = "SELECT * FROM users WHERE id=" + id;
			rs = stmt.executeQuery(sql);
			// ��������
			while (rs.next()) {
				User user = new User();	
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setSex(rs.getString("sex"));
				user.setRole(rs.getInt("role"));
				return user;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return null;
		}
	// �����û�������ָ����user
		public boolean find(String name) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				stmt = conn.createStatement();
				// ����SQL���
				String sql = "SELECT * FROM users WHERE name='" + name+"'";
				System.out.println(name);
				rs = stmt.executeQuery(sql);
				// ��������
			    if(rs.next()) return false;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtils.release(rs, stmt, conn);
				}
				return true;
			}
	
	
		// ɾ���û�
		public boolean delete(int id) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				stmt = conn.createStatement();
				// ����SQL���
				String sql = "DELETE FROM users WHERE id=" + id;
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}
		// �޸��û�
		public boolean update(User user) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				stmt = conn.createStatement();
				// ����SQL���
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String birthday = sdf.format(user.getBirthday());
				String sql = "UPDATE users set name='" + user.getName()
						+ "',password='" + user.getPassword() + "',email='"
						+ user.getEmail() + "',registTime='" + birthday
						+ "' WHERE id=" + user.getId();
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}
		//��¼��֤
		public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
				
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				// ������ݵ�����
				conn = JDBCUtils.getConnection();
				// ���Statement����
				String sql = "select * from users where name=?  and password=?";
				 stmt = conn.prepareStatement(sql);
				// ����SQL���
				stmt.setString(1, username);
				stmt.setString(2, password);
				
				rs = stmt.executeQuery();
				// ��������
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setBirthday(rs.getDate("birthday"));
					user.setSex(rs.getString("sex"));
					user.setRole(rs.getInt("role"));
					return user;
					}
					return null;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtils.release(rs, stmt, conn);
				}
				return null;
		}
		
		// �޸��û�����
				public boolean updatePassword(User user) {
					Connection conn = null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					try {
						// ������ݵ�����
						conn = JDBCUtils.getConnection();
						// ���Statement����
						String sql = "update users set password=? where id=?";
						 stmt = conn.prepareStatement(sql);
						 stmt.setString(1, user.getPassword());
							stmt.setInt(2, user.getId());
							
					
						int num = stmt.executeUpdate();
						if (num > 0) {
							return true;
						}
						return false;
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						JDBCUtils.release(rs, stmt, conn);
					}
					return false;
				}
	}
