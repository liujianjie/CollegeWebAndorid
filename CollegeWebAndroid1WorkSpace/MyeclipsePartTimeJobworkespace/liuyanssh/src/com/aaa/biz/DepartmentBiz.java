package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.util.PageEntity;

public interface DepartmentBiz {
	List getDepartmentList();

	// �޸�
	void update(Department ct);

	// ɾ��
	void del(Department ct);

	// ���
	void addBysql(Department ct);

	PageEntity getAllDepartment(PageEntity page);
	
	public Department getDepartmentOne(Integer Id);
	
	void delDepart(Integer Id);
	
	void updateBySql(Department ct);
}
