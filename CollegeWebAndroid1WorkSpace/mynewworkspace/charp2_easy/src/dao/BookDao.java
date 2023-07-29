package dao;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import goods.entity.Book;


public class BookDao {

    // 查询所有的书籍信息
    public static final String SELECT_ALL_BOOK = "SELECT * FROM goods";
    //根据 id 查找书籍信息
    public static final String SELECT_BOOK_BY_ID = "SELECT * FROM goods WHERE id=";
    //根据 id 修改书籍信息
    public static final String UPDATE_BOOK_BY_ID = "update goods set name=?,price=? where id=?";
    //根据 id 删除书籍信息
    public static final String DELETE_BOOK_BY_ID = "delete from goods where id = ";


    /**
     * 查询所有书籍信息
     *
     * @return
     */
    public List<Book> findAll() {
        Connection con = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<Book>();
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(SELECT_ALL_BOOK);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setPic(rs.getString("pic"));
                book.setIntro(rs.getString("intro"));
                book.setCatalog(rs.getString("catalog"));
                list.add(book);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, preStmt, con);
        }
        return null;
    }

    /**
     * 根据 id 查找书籍信息
     *
     * @param id
     * @return
     */
    public Book find(int id) {
        Connection con = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(SELECT_BOOK_BY_ID+id);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setPic(rs.getString("pic"));
                book.setIntro(rs.getString("intro"));
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

    /**
     * 根据 id 删除书籍信息
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(DELETE_BOOK_BY_ID+id);
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

    /**
     * 更新书籍信息
     *
     * @param book
     * @return
     */
    public boolean update(Book book) {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(UPDATE_BOOK_BY_ID);
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
