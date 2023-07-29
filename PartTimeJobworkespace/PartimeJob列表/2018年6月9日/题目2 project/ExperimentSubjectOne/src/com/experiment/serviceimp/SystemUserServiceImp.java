package com.experiment.serviceimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.experiment.bean.SystemUserBean;
import com.experiment.common.DBconnection;
import com.experiment.service.SystemUserServiceI;

public class SystemUserServiceImp implements SystemUserServiceI{

	@Override
	public boolean userregister(SystemUserBean bean) {
		Connection conn=DBconnection.getconnection();
		String sql="insert into system_user(userName,userPassword) values(?,?);";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1,bean.getUserName());
			prst.setString(2, bean.getUserPassword());
			int i=prst.executeUpdate();
			prst.close();
			conn.close();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int checkuser(SystemUserBean user) {
		int userid = 0;
		Connection conn=DBconnection.getconnection();
		String sql="select userId from system_user where userName=? and userPassword=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, user.getUserName());
			prst.setString(2, user.getUserPassword());
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				userid = rs.getInt("userId");
				rs.close();
				prst.close();
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userid;
	}

	@Override
	public List<SystemUserBean> seluserlist() {
		List<SystemUserBean> list=new ArrayList<SystemUserBean>();
		Connection conn=DBconnection.getconnection();
		String sql="select * from system_user";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			ResultSet rs=prst.executeQuery();
			while(rs.next()){
				SystemUserBean sysuser=new SystemUserBean();
				sysuser.setUserId(rs.getInt("userId"));
				sysuser.setUserName(rs.getString("userName"));
				sysuser.setUserPassword(rs.getString("userPassword"));
				list.add(sysuser);
			}
			rs.close();
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updatesystemuser(SystemUserBean user) {
		Connection conn=DBconnection.getconnection();
		String sql="update system_user set userName = ?,userPassword =? where userId = ?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setString(1, user.getUserName());
			prst.setString(2, user.getUserPassword());
			prst.setInt(3,user.getUserId());
			prst.executeUpdate();
			
			prst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean deletesystemuser(int userid) {
		Connection conn=DBconnection.getconnection();
		String sql="delete from system_user where userId=?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1,userid);
			int i=prst.executeUpdate();
			prst.close();
			conn.close();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public SystemUserBean getOneSystemUser(int userid) {
		SystemUserBean user = new SystemUserBean();
		Connection conn=DBconnection.getconnection();
		String sql="select * from system_user where userId = ?";
		try {
			PreparedStatement prst=conn.prepareStatement(sql);
			prst.setInt(1, userid);
			ResultSet rs=prst.executeQuery();
			if(rs.next()){
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				rs.close();
				prst.close();
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
