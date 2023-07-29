package com.ht.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.ht.bean.EmpAndDept;
import com.ht.dao.DeptDao;
import com.ht.dao.EmpDao;
import com.ht.util.MybatisUtil;

public class MapJunits {
	private SqlSession sqlsession;
	
	@Before
	public void before(){
		sqlsession = MybatisUtil.opensession();
	}
	
	@Test
	public void tests() {
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		List<EmpAndDept> list = dao.selEmpAndDept();
		for(EmpAndDept ed : list){
			System.out.println(ed.getDname()+"\t"+ed.getJob()+"\t"+ed.getLoc());
		}
	}

}
