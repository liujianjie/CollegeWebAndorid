package com.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.goods.bean.Book;
import com.goods.utils.JDBCUtils;

// ʹ��jdbc�������ݿ��goods��ͼ�����������������ɾ�Ĳ�
public class BookDao {
	// ��ѯ���е�Book����
	public List<Book> findAllBook() {
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
				book.setIntro(rs.getString("intro"));
				book.setCatalog(rs.getString("catalog"));
				list.add(book);// ���list�У���Ϊ�ж��ͼ��
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();// �׳��쳣
		} finally {
			JDBCUtils.release(rs, preStmt, con);// �ͷ��ڴ�
		}
		return null;
	}

	// ����id����ָ����һ��ͼ���¼
	public Book findOneBook(int id) {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			// ������ݵ�����
			con = JDBCUtils.getCon();
			// SQL���
			String sql = "select * from goods where id=" + id;
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
				book.setIntro(rs.getString("intro"));
				book.setCatalog(rs.getString("catalog"));
				return book;// ֻ��Ҫһ������һ���ͷ���book����
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);// �ͷ��ڴ�
		}
		return null;
	}

	// ����idɾ��goods��ָ��ͼ��
	public boolean deleteById(int id) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// SQL���
			String sql = "delete from goods where id = " + id;
			// ���Statement����
			preStmt = con.prepareStatement(sql);
			// ִ���޸�ɾ������
			int num = preStmt.executeUpdate();
			// �������0������ɹ�
			if (num > 0) {
				return true;
			}
			// ����ʧ��
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return false;
	}

	// ���µ�book��������ȥ�޸�goods���ͼ��
	public boolean updateBook(Book book) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// ��ȡ���Ӷ���ķ���
			con = JDBCUtils.getCon();
			// SQL���
			String sql = "update goods set name=?,price=? where id=?";
			// ���Statement����
			preStmt = con.prepareStatement(sql);
			// ����վλ������ֵ
			preStmt.setString(1, book.getName());
			preStmt.setDouble(2, book.getPrice());
			preStmt.setInt(3, book.getId());
			// ִ���޸�ɾ������
			int num = preStmt.executeUpdate();
			// �������0������ɹ�
			if (num > 0) {
				return true;
			}
			// ����ʧ��
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);
		}
		return false;
	}
}
