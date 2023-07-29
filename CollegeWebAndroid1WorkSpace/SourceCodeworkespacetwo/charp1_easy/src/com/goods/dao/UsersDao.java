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
 * ʹ��jdbc�������ݿ��users���û�����������������ɾ�Ĳ�
 */
public class UsersDao {

	// ��¼��֤������Ϊ�û���������
	public User findUserByNameAndPassword(String username, String password) throws SQLException {
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
			// ����ռλ����ֵ
			preStmt.setString(1, username.trim());
			preStmt.setString(2, password);
			// ִ�в�ѯ����
			rs = preStmt.executeQuery();
			while (rs.next()) {
				// user����洢users���е��û���Ϣ
				User user = new User();
				user.setId(rs.getInt("id"));// ��ȡid
				user.setUsername(rs.getString("username"));// ��ȡ�û���
				user.setSex(rs.getString("sex"));// ��ȡ�Ա�
				user.setPassword(rs.getString("password"));// ��ȡ����
				user.setEmail(rs.getString("email"));// ��ȡemail
				user.setBirthday(rs.getDate("birthday"));// ��ȡ����
				user.setRole(rs.getInt("role"));// ��ɫ
				return user;// ֻҪһ����ֱ�ӷ���
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

	// �����û��ķ���
	public boolean insert(User user) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement preStmt = null;
		try {
			// ��ȡ���Ӷ���
			con = JDBCUtils.getCon();
			// ��ȡִ��sql���Ķ���,ִ��sql
			String sql = "insert into users(username,sex,password,email,birthday,role)" + "values(?,?,?,?,?,?)";
			// ����ִ��sql����PreparedStatement����
			preStmt = con.prepareStatement(sql);
			// ��ʽ������
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// ����ռλ����ֵ
			preStmt.setString(1, user.getUsername());// �û���
			preStmt.setString(2, user.getSex());// �Ա�
			preStmt.setString(3, user.getPassword());// ����
			preStmt.setString(4, user.getEmail());// email
			preStmt.setString(5, sdf.format(user.getBirthday()));//���գ�sdf.format������������ת��Ϊ�ַ�������
			// preStmt.setDate(5, user.getBirthday());
			preStmt.setInt(6, user.getRole());// ��ɫ
			// ִ��sql
			int row = preStmt.executeUpdate();
			// ����ɹ�����Ӱ�������������0����ɹ�
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

	// �ṩ��ѯ�����û��ķ���
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
		// Statement stmt = null;
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
			// �õ�PreparedStatement����
			preStmt = con.prepareStatement(sql);
			// ִ���޸�ɾ��
			rs = preStmt.executeQuery();
			// ������
			if (rs.next())
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return true;
	}

	// ɾ���û�
	public boolean delete(int id) {
		// Statement stmt = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// ��ȡStatement�Ķ���
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

	// �޸��û�
	public boolean update(User user) {
		PreparedStatement preStmt = null;
		// ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// ��ȡStatement�Ķ���
			String sql = "update users set username=?,sex=?,password=? where id = ?";
			preStmt = con.prepareStatement(sql);
			// ����ռλ��
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getSex());
			preStmt.setString(3, user.getPassword());
			preStmt.setInt(4, user.getId());
			// ִ���޸�ɾ������
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

	// �޸��û����룬�����û�id��������û�����
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
			// ����ռλ��
			preStmt.setString(1, user.getPassword());// ������
			preStmt.setInt(2, user.getId());//�û���id
			// ִ���޸�ɾ������
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
