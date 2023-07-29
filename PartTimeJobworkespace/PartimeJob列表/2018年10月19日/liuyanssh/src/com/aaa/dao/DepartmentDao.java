package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.User;
import com.aaa.util.PageEntity;

public interface DepartmentDao {
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
