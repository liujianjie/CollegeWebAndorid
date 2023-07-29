package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.LevelDept;
import com.aaa.util.PageEntity;

public interface LeveldeptBiz {

	// �޸�
	void update(LevelDept ct);

	// ɾ��
	void del(LevelDept ct);
	
	void delByDeptId(Integer id);

	// ���
//	void addBysql(Department ct);

//	void delDepart(Integer Id);
	
}
