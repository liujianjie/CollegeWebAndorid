package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.utils.JDBCUtils;

// Daoʹ��jdbc�������ݿ��goods��ͼ�����������������ɾ�Ĳ�
public class BookDao {
	// ��ѯ���е�Book����
	public List<Book> findAll() {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// ������ݵ�����
			con = JDBCUtils.getCon();
			// ����SQL���
			String sql = "select * from goods";
			// ���Statement����
			preStmt = con.prepareStatement(sql);
			// ִ�в�ѯ����
			rs = preStmt.executeQuery();
			// ��������
			while (rs.next()) {
				// ʵ����һ��book�������洢�����ݿ��ȡ����Ϣ
				Book book = new Book();
				book.setId(rs.getInt("id"));// ���ô����ݿ��ȡ��id
				book.setName(rs.getString("name"));// ���ô����ݿ��ȡ������
				book.setPrice(rs.getDouble("price"));
				book.setPic(rs.getString("pic"));
				book.setCatalog(rs.getString("catalog"));
				list.add(book);// ���list�У���Ϊ�ж��ͼ��
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);// �ͷ��ڴ�
		}
		return null;
	}

	// ����id����ָ����book
	public Book find(int id) {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			con = JDBCUtils.getCon();

			// ����SQL���
			String sql = "SELECT * FROM goods WHERE id=" + id;
			// ���Statement����
			preStmt = con.prepareStatement(sql);
			rs = preStmt.executeQuery();
			// ��������
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setPic(rs.getString("pic"));
				book.setCatalog(rs.getString("catalog"));
				return book;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return null;
	}

	// ɾ��ָ����Ʒ
	public boolean delete(int id) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			String sql = "delete from goods where id = " + id;
			preStmt = con.prepareStatement(sql);
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

	// �޸�ͼ��
	public boolean update(Book book) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();

			String sql = "update goods set name=?,price=? where id=?";
			preStmt = con.prepareStatement(sql);

			preStmt.setString(1, book.getName());
			preStmt.setDouble(2, book.getPrice());
			preStmt.setInt(3, book.getId());

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
