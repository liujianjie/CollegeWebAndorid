package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.DepartmentDao;
import com.aaa.dao.UserDao;
import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.User;
import com.aaa.util.PageEntity;
@Service
public class DepartmentBizimpl implements DepartmentBiz {
	@Autowired
	private DepartmentDao deptDao;
	public List getDepartmentList(){
		List list= deptDao.getDepartmentList();
		 //ֻ��ȷ��list�������ݲ���ʹ��get
		 if(list.size()>0){
			 return list;
		 }else{
			 return null;
		 }
		
	}
	public void update(Department ct) {
		// TODO Auto-generated method stub
		deptDao.update(ct);
	}
	public void del(Department ct) {
		// TODO Auto-generated method stub
		deptDao.del(ct);
	}
	public void addBysql(Department ct) {
		// TODO Auto-generated method stub
		deptDao.addBysql(ct);
	}
	public List getct() {
		// TODO Auto-generated method stub
		return null;
	}
	public PageEntity getAllDepartment(PageEntity page) {
		return  deptDao.getAllDepartment(page);
	}
	public Department getDepartmentOne(Integer Id){
		return  deptDao.getDepartmentOne(Id);
	}
	public void delDepart(Integer Id){
		deptDao.delDepart(Id);
	}
	public void updateBySql(Department ct) {
		// TODO Auto-generated method stub
		deptDao.updateBySql(ct);
	}
}
