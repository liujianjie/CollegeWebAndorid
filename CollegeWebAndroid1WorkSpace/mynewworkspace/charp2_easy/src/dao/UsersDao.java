package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import goods.entity.User;
import utils.JDBCUtils;

public class UsersDao {


    // 根据用户名 和密码查询用户信息
    public static final String SELECT_USERS = "select * from users where username=? and password=?";
    // 查询所有的用户信息
    public static final String SELECT_ALL_USERS = "select * from users";
    //根据 id 查找书籍信息
    public static final String INSERT_USERS = "insert into users(username,sex,password,email,birthday,role) values(?,?,?,?,?,?)";
    // 根据 id查询用户信息
    public static final String SELECT_USERS_BY_ID = "select * from users where id =";
    // 根据 username 查询用户信息
    public static final String SELECT_USERS_BY_USERNAME = "select * from users where username=";
    //根据 id 修改用户信息
    public static final String UPDATE_USERS_BY_ID = "update users set username=?,sex=?,password=? where id = ?";
    //根据 id 修改用户密码
    public static final String UPDATE_PWD_BY_ID = "update users set password=? where id=?";
    //根据 id 删除用户信息
    public static final String DELETE_USERS_BY_ID = "delete from users where id = ";


    public User findUserByNameAndPassword(String username, String password) throws SQLException {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(SELECT_USERS);
            // 设置参数
            preStmt.setString(1, username.trim());
            preStmt.setString(2, password);
            System.out.println(username + "," + password);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                // 查询用户
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                user.setRole(rs.getInt("role"));
                // 得到用户信息
                return user;
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


    // 插入用户信息
    public boolean insert(User user) {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement preStmt = null;
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(INSERT_USERS);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            preStmt.setString(1, user.getUsername());
            preStmt.setString(2, user.getSex());
            preStmt.setString(3, user.getPassword());
            preStmt.setString(4, user.getEmail());
            preStmt.setString(5, sdf.format(user.getBirthday()));
            preStmt.setInt(6, user.getRole());
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

    public List<User> findAllUser() {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(SELECT_ALL_USERS);
            rs = preStmt.executeQuery();
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                user.setRole(rs.getInt("role"));
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
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(SELECT_USERS_BY_ID + id);
            rs = preStmt.executeQuery();
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

    // 根据用户名查找用户
    public boolean find(String username) {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            // 执行sql
            System.out.println(SELECT_USERS_BY_USERNAME + username);
            preStmt = con.prepareStatement(SELECT_USERS_BY_USERNAME + username);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, preStmt, con);
        }
        return true;
    }

    public boolean delete(int id) {
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(DELETE_USERS_BY_ID + id);
            int num = preStmt.executeUpdate(DELETE_USERS_BY_ID + id);
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

    // 更新用户信息
    public boolean update(User user) {
        PreparedStatement preStmt = null;
        Connection con = null;
        try {
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(UPDATE_USERS_BY_ID);
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

    // 修改密码
    public boolean updatePassword(User user) {
        Connection con = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 打开连接
            con = JDBCUtils.getCon();
            preStmt = con.prepareStatement(UPDATE_PWD_BY_ID);
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
