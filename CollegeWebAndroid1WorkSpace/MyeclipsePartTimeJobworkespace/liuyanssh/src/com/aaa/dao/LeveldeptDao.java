package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.entity.LevelDept;
import com.aaa.util.PageEntity;


public interface LeveldeptDao {
	
		//�޸�
		void update(LevelDept ct);
		//ɾ��
		void del(LevelDept ct);
		
		void delByDeptId(Integer id);
}
