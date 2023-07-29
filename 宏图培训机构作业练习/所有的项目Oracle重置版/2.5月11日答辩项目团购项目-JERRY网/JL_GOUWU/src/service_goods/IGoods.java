package service_goods;

import java.util.List;

import bean.BottomBean;
import bean.Goodsbean;
import bean.MoldBean;

public interface IGoods {
	//按照分类id查找商品 
	public List selGoods(int id);

	//后台查询商品分页
	public List selhtGoods(int pagecount,int currpage);
	
	public List selBottom();
	
	public boolean addGoods(Goodsbean god);
	
	public boolean delGoods(int id);
	
	public Goodsbean selhang(int id);
	
	public boolean alerthang(Goodsbean god);
	
	//查询3个商品 按照分类 bottomid
	public List selthreeGoods(int id,int pageCount);
	
	//查询相似商品
	public List selxsgoods(String name);
	
	//属于的分类
	public BottomBean selbottom(int bottom_id);
	
	//属于的类型
	public MoldBean selmold(int mold_id);
	
	//通过销量的多少对比来后去商品 分页。。。
	public List selfyGoods(int pagecount,int currpage);
	
	//查看行数的总数
	public int selgoodscount();
	
	//通过bottomid来查看商品 跳转 goodslist页面 分页
	public List sellistgoods(int pagecount,int currpage,int id);
	
	//查看这个分类下的所有商品
	public int selbottomgoodscount(int bottom_id);
	
	//按照一个分类bottom_id查找销量最多的商品
	public Goodsbean seldangegoods(int bottom_id);
}
