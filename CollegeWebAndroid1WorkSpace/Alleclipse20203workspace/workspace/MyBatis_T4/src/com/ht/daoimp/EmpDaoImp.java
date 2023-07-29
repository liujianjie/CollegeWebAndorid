package com.ht.daoimp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import com.ht.bean.Dept;
import com.ht.bean.Emp;
import com.ht.bean.EmpAndDept;
import com.ht.dao.EmpDao;
import com.ht.util.MybatisUtil;

public class EmpDaoImp implements EmpDao{
	@Override
	public List<EmpAndDept> selEmpAndDept() {
		return MybatisUtil.opensession().selectList("com.ht.dao.EmpDao.selEmpAndDept");
	}
	public static void main(String[] args) {
		EmpDao emp = new EmpDaoImp();
		List<EmpAndDept> list =  emp.selEmpAndDept();
		for(EmpAndDept ed : list){
			System.out.println(ed.getDname()+"\t"+ed.getDname()+"\t"+ed.getLoc());
		}
	}
}
