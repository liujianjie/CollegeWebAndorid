package com.aaa.biz;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aaa.dao.StaffDao;
import com.aaa.dao.StaffDeptDao;
import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.Dept;
import com.aaa.entity.LevelDept;
import com.aaa.entity.StaffDept;
import com.aaa.entity.StaffDept;
import com.aaa.util.PageEntity;
import com.aaa.util.PageUtil;

@Service
public class StaffDeptBizimpl implements StaffDeptBiz {
	@Autowired
	private StaffDeptDao staffdao;
	
	
	public void update(StaffDept ct){
		staffdao.update(ct);
		
	}
	//ɾ��
	public void del(StaffDept ct){
		staffdao.del(ct);
		
	}
	public void delByDeptId(Integer id){
		staffdao.delByDeptId(id);
	}
	
	public StaffDept selByStaffId(Integer id){
		return staffdao.selByStaffId(id);
	}
	public void delStaffDeptsByDeptId(Integer DeptId){
		staffdao.delStaffDeptsByDeptId(DeptId);
	}
}
