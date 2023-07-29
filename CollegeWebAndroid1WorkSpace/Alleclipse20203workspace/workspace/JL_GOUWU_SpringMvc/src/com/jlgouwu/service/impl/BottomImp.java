package com.jlgouwu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jlgouwu.dao.BottomDao;
import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.service.BottomService;

@Service
public class BottomImp implements BottomService{
	
	@Resource
	BottomDao bottomDao;
	
	public List selbottom() {
		return bottomDao.selbottom();
	}

	public boolean addbottom(Bottom bot) {
		return bottomDao.addbottom(bot) > 0 ? true : false;
	}

	public boolean alerthang(Bottom bot) {
		return bottomDao.alerthang(bot) > 0 ? true : false;
	}

	public boolean delbottom(int id) {
		return bottomDao.delbottom(id) > 0 ? true : false;
	}

	public Bottom selhang(int id) {
		return bottomDao.selhang(id);
	}

	public List selMold() {
		return bottomDao.selMold();
	}

	public List selfenlei(int mold_id) {
		return bottomDao.selfenlei(mold_id);
	}
	public int selonnbottom_id(int mold_id) {
		return bottomDao.selonnbottom_id(mold_id);
	}
	@Override
	public String selbottomname(int bottomid) {
		return bottomDao.selbottomname(bottomid);
	}
	public String selMold2(int moldid) {
		return bottomDao.selMold2(moldid);
	}
	public Bottom seloneBottomByMoldId(int mold_id) {
		return bottomDao.seloneBottomByMoldId(mold_id);
	}

	
}
