package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.Dept;
import com.aaa.entity.User;
import com.aaa.util.PageEntity;
public interface DeptDao {
	PageEntity getDeptList(PageEntity page);
	
	public List getct();
	//�޸�
	void update(Dept ct);
	//ɾ��
	void del(Dept ct);
	//���
	void add(Dept ct);
	
	void updateBySql(Dept ct);
	
	Dept getDeptOne(Integer id);
	
	void addDept(Dept ct) ;
	
	void delDepByDepartId(Integer id);
	
	//给赋值
	void setLevelAndDept(Integer leid,Integer deptid);
	
	List getLevelIdList(Integer deptid);
	
	List getDeptListBydeparid(Integer Id);
}
