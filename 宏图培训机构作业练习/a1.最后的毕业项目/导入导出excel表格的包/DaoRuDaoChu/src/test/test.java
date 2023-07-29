package test;
package com.ht.action;


import java.sql.Connection;
import java.sql.SQLException;

import com.ht.common.BaseAction;
import com.ht.service.IDatasService;
import com.ht.service.IStuService;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class test extends BaseAction{
	public void s(){
		IStuService ss=(IStuService)getService("sService");
	}
	public static void main(String[] args) {
		new test().s();
	}
}
