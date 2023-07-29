package com.jlgouwu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jlgouwu.dao.GoodsDao;
import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Goods;
import com.jlgouwu.pojo.Mold;
import com.jlgouwu.service.GoodsService;
@Service
public class GoodsImp implements GoodsService{
	
	@Resource
	GoodsDao goodsDao;
	public List selGoods(int id) {
		return goodsDao.selGoods(id);
	}
	

	public boolean addGoods(Goods god) {
		return goodsDao.addGoods(god) > 0 ? true : false;
	}

	public boolean delGoods(int id) {
		return goodsDao.delGoods(id) > 0 ? true : false;
	}
	public boolean delGoodsByBid(int id) {
		return goodsDao.delGoodsByBid(id);
	}
	
	public List selBottom() {
		return goodsDao.selBottom();
	}
	
	public Goods selhang(int id) {
		return goodsDao.selhang(id);
	}
	
	public boolean alerthang(Goods god) {
		return goodsDao.alerthang(god) > 0 ? true : false;
	}


	public List selxsgoods(String name) {
		return goodsDao.selxsgoods(name);
	}


	public Bottom selbottom(int bottom_id) {
		 return goodsDao.selbottom(bottom_id);
	}


	public Mold selmold(int mold_id) {
		return goodsDao.selmold(mold_id);
	}

	//通过销量的多少对比来后去一开始商品 分页。。。
	public List selfyGoods(int pagecount, int currpage) {
		int zero = (currpage - 1) * pagecount;
		int first = pagecount;
		return goodsDao.selfyGoods(zero, first);
	}


	public int selgoodscount() {
		return goodsDao.selgoodscount();
	}


	public List selthreeGoods(int id, int pagecount) {
		return goodsDao.selthreeGoods(id, pagecount);
	}

	//前台
	public List sellistgoods(int pagecount, int currpage, int id) {
		int zero = (currpage - 1) * pagecount;
		int first = pagecount;
		int second = id;
		return goodsDao.sellistgoods(zero, first, second);
	}


	public int selbottomgoodscount(int bottomid) {
		return goodsDao.selbottomgoodscount(bottomid);
	}

	
	public Goods seldangegoods(int bottom_id) {

		return goodsDao.seldangegoods(bottom_id);
	}

	//这是后台的数据
	public List selhtGoods(int pagecount, int currpage) {
		int zero = (currpage - 1) * pagecount;
		int first = pagecount;
		return goodsDao.selhtGoods(zero, first);
	}
	
}
