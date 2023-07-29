package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.LevelDept;
import com.aaa.entity.Staff;
import com.aaa.entity.StaffDept;
import com.aaa.util.PageEntity;


public interface StaffDeptBiz {
	
		//�޸�
		void update(StaffDept ct);
		//ɾ��
		void del(StaffDept ct);
		
		void delByDeptId(Integer id);
		StaffDept selByStaffId(Integer id);//one
		void delStaffDeptsByDeptId(Integer DeptId);//list
}
