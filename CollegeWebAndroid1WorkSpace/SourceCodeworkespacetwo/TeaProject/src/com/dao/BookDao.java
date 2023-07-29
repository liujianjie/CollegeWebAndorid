package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Book;
import com.utils.JDBCUtils;

// Dao使用jdbc操作数据库表goods（图书表），对这个表进行增删改查
public class BookDao {
	// 查询所有的Book对象
	public List<Book> findAll() {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// 获得数据的连接
			con = JDBCUtils.getCon();
			// 发送SQL语句
			String sql = "select * from goods";
			// 获得Statement对象
			preStmt = con.prepareStatement(sql);
			// 执行查询操作
			rs = preStmt.executeQuery();
			// 处理结果集
			while (rs.next()) {
				// 实例化一个book对象来存储从数据库读取的信息
				Book book = new Book();
				book.setId(rs.getInt("id"));// 设置从数据库读取的id
				book.setName(rs.getString("name"));// 设置从数据库读取的名称
				book.setPrice(rs.getDouble("price"));
				book.setPic(rs.getString("pic"));
				book.setCatalog(rs.getString("catalog"));
				list.add(book);// 添加list中，因为有多个图书
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, preStmt, con);// 释放内存
		}
		return null;
	}

	// 根据id查找指定的book
	public Book find(int id) {
		Connection con = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			con = JDBCUtils.getCon();

			// 发送SQL语句
			String sql = "SELECT * FROM goods WHERE id=" + id;
			// 获得Statement对象
			preStmt = con.prepareStatement(sql);
			rs = preStmt.executeQuery();
			// 处理结果集
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

	// 删除指定商品
	public boolean delete(int id) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
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

	// 修改图书
	public boolean update(Book book) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			// 获取连接对象的方法
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
