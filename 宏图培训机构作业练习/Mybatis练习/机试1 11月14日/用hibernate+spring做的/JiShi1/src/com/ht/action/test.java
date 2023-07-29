package com.ht.action;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ht.common.BaseAction;


public class test extends BaseAction{
	public void s(){
		DataSource date=(DataSource) getService("dSource");
		try {
			Connection con=date.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new test().s();
	}
}
