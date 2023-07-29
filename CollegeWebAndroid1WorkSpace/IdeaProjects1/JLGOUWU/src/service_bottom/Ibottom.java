package service_bottom;

import java.util.List;

import bean.BottomBean;


public interface Ibottom {
	public List selbottom();
	
	public List selMold();
	
	public boolean addbottom(BottomBean bot);
	
	public boolean delbottom(int id);
	
	public BottomBean selhang(int id);
	
	public boolean alerthang(BottomBean emp);
	
	//按照类型id查找分类
	public List selfenlei(int mold_id);
	
	//根据类型id查询第一个bottom_id的值 以便查出商品
	public int selonnbottom_id(int mold_id);
	
	//查询分类名
	public String selbottomname(int bottomid);
	
	//查询类型名
	public String selMold(int moldid);
	
	// 根据一级分类id查找一个二级分类
	public BottomBean seloneBottomByMoldId(int moldId);
}
