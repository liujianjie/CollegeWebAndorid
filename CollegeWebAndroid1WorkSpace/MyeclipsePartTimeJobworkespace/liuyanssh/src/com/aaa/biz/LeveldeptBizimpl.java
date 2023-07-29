package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.CommentDao;
import com.aaa.dao.LeveldeptDao;
import com.aaa.entity.Comment;
import com.aaa.entity.LevelDept;
import com.aaa.util.PageEntity;
@Service
public class LeveldeptBizimpl implements LeveldeptBiz {
	@Autowired
	private LeveldeptDao  leveldeptDao;

	public void update(LevelDept ct) {
		// TODO Auto-generated method stub
		leveldeptDao.update(ct);
	}

	public void del(LevelDept ct) {
		// TODO Auto-generated method stub
		leveldeptDao.del(ct);
	}

	public void delByDeptId(Integer id){
		leveldeptDao.delByDeptId(id);
	}

}
