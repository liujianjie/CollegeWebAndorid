package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.Dept;
import com.aaa.util.PageEntity;

public interface DeptBiz {
	PageEntity getDeptList(PageEntity page);
	public List getct();
	//�޸�
	void update(Dept  ct);
	//ɾ��
	void del(Dept  ct);
	//���
	void add(Dept  ct);
	
	void updateBySql(Dept ct);
	
	public Dept getDeptOne(Integer id);
	
	public void addDept(Dept ct) ;
	

	void delDepByDepartId(Integer id);
	
	void setLevelAndDept(Integer leid,Integer deptid);
	
	List getLevelIdList(Integer deptid);
	
	List getDeptListBydeparid(Integer Id);
	
	List getDepLevtListBydept(Integer Id);
}
