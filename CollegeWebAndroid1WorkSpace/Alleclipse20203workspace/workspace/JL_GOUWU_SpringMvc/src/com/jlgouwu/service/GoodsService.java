package com.jlgouwu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Goods;
import com.jlgouwu.pojo.Mold;


public interface GoodsService {
	//按照分类id查找商品 
	public List<Goods> selGoods(int id);

	//后台查询商品分页
	public List<Goods> selhtGoods(int pagecount,int currpage);
	
	public List<Bottom> selBottom();
	
	public boolean addGoods(Goods god);
	
	public boolean delGoods(int id);
	
	public Goods selhang(int id);
	
	public boolean alerthang(Goods god);
	
	//查询3个商品 按照分类 bottomid
	public List<Goods> selthreeGoods(int id,int pageCount);
	
	//查询相似商品
	public List<Goods> selxsgoods(String name);
	
	//属于的分类
	public Bottom selbottom(int bottom_id);
	
	//属于的类型
	public Mold selmold(int mold_id);
	
	//通过销量的多少对比来后去商品 分页。。。
	public List<Goods> selfyGoods(int pagecount,int currpage);
	
	//查看行数的总数
	public int selgoodscount();
	
	//通过bottomid来查看商品 跳转 goodslist页面 分页
	public List<Goods> sellistgoods(int pagecount,int currpage,int id);
	
	//查看这个分类下的所有商品
	public int selbottomgoodscount(int bottom_id);
	
	//按照一个分类bottom_id查找销量最多的商品
	public Goods seldangegoods(int bottom_id);
	
	// 按照分类删除
	public boolean delGoodsByBid(int bottom_id);
}
