package com.jlgouwu.dao;

import java.util.List;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Mold;



public interface BottomDao {
	public List<Bottom> selbottom();
	
	public List<Mold> selMold();
	
	public int addbottom(Bottom bot);
	
	public int delbottom(int id);
	
	public Bottom selhang(int id);
	
	public int alerthang(Bottom emp);
	
	//按照类型id查找分类
	public List<Bottom> selfenlei(int mold_id);
	
	//根据类型id查询第一个bottom_id的值 以便查出商品
	public int selonnbottom_id(int mold_id);
	
	//查询分类名
	public String selbottomname(int bottomid);
	
	//查询类型名
	public String selMold2(int moldid);
	
	// 根据一级分类id查找一个二级分类
	public Bottom seloneBottomByMoldId(int moldId);
}
