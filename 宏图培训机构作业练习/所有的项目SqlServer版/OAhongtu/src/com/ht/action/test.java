package com.ht.action;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.ht.common.BaseAction;
import com.ht.service.ICaiwuService;
import com.ht.service.IDatasService;
import com.ht.service.IEmpService;
import com.ht.service.IStuService;
import com.ht.vo5.Student;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class test extends BaseAction{
	public void s(){
		ICaiwuService ie=(ICaiwuService)getService("cService");
		DataSource date=(DataSource) getService("dSource");
		try {
			Connection con=date.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Date date=new Date();
//		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//		String datea=df.format(date);
//		String dateas="2016-8-14";  
//		Date date2=new Date();
//		System.out.println();
	}
	public static void main(String[] args) {
		new test().s();
	}
}
