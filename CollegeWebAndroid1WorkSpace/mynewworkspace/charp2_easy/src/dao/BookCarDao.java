package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import goods.entity.Book;
import goods.entity.BookCar;
import goods.entity.User;
import utils.JDBCUtils;


public class BookCarDao {

    public static final String INSERT_BOOK_CAR = "insert into book_car(price,pic,num,name,number) values(?,?,?,?,?)";
    public static final String SELECT_ALL_BOOK_CAR = "select * from book_car";


    public boolean insert(BookCar bookCar) {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement preStmt = null;
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(INSERT_BOOK_CAR);
            preStmt.setString(1, Double.toString(bookCar.getPrice()));
            preStmt.setString(2, bookCar.getPic());
            preStmt.setString(3, Integer.toString(bookCar.getNum()));
            preStmt.setString(4, bookCar.getName());
            preStmt.setString(5, bookCar.getNumber());
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

    public List<BookCar> findAll() {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(SELECT_ALL_BOOK_CAR);
            rs = preStmt.executeQuery();
            List<BookCar> list = new ArrayList<BookCar>();
            while (rs.next()) {
                BookCar bookCar = new BookCar();
                bookCar.setId(rs.getInt("id"));
                bookCar.setNum(rs.getInt("num"));
                bookCar.setName(rs.getString("name"));
                bookCar.setPic(rs.getString("pic"));
                bookCar.setPrice(rs.getDouble("price"));
                bookCar.setNumber(rs.getString("number"));
                list.add(bookCar);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(rs, preStmt, con);
        }
    }
}
