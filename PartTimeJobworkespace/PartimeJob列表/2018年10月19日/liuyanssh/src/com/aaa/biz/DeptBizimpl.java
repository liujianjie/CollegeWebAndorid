package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.DepartmentDao;
import com.aaa.dao.DeptDao;
import com.aaa.dao.UserDao;
import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.Dept;
import com.aaa.entity.User;
import com.aaa.util.PageEntity;
@Service
public class DeptBizimpl implements DeptBiz {
	@Autowired
	private DeptDao deptDao;
	public PageEntity getDeptList(PageEntity page){
		// TODO Auto-generated method stub
		return  deptDao.getDeptList(page);
		
	}
	public List getct() {
		// TODO Auto-generated method stub
		return deptDao.getct();
	}
	public void update(Dept ct) {
		deptDao.update(ct);
	}
	public void del(Dept ct) {
		// TODO Auto-generated method stub
		deptDao.del(ct);
	}
	public void add(Dept ct) {
		// TODO Auto-generated method stub
		deptDao.add(ct);
	}
	public Dept getDeptOne(Integer id){
		return deptDao.getDeptOne(id);
	} 
	public void updateBySql(Dept ct){
		deptDao.updateBySql(ct);
	}
	
	public void addDept(Dept ct) {
		// TODO Auto-generated method stub
		deptDao.addDept(ct);
	}
	public void delDepByDepartId(Integer id){
		deptDao.delDepByDepartId(id);
	}
	public void setLevelAndDept(Integer leid, Integer deptid) {
		// TODO Auto-generated method stub
		deptDao.setLevelAndDept(leid, deptid);
	}
	public List getLevelIdList(Integer deptid){
		
		return deptDao.getLevelIdList(deptid);
	}
	public List getDeptListBydeparid(Integer Id) {
		return deptDao.getDeptListBydeparid(Id);
	}
}
