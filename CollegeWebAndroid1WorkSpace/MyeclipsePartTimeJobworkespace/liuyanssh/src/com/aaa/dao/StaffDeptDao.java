package com.aaa.dao;

import com.aaa.entity.StaffDept;

public interface StaffDeptDao {
	
	//�޸�
	void update(StaffDept ct);
	//ɾ��
	void del(StaffDept ct);
	
	void delByDeptId(Integer id);
	StaffDept selByStaffId(Integer id);
	void delStaffDeptsByDeptId(Integer DeptId);
}
