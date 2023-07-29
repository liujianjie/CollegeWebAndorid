package com.dc.dao.mealTotal;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class TotalDAOImpl implements TotalDAO{
    //根据菜品表和订单表和订单详情表进行菜品销量统计
	@Override
	public List Select(Map map,PageEntity page) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select * from (");
		sql.append(" SELECT a.meal_name,a.xiadan,a.ymoney,a.wancheng,a.smoney,a.tuidan,a.yuji,b.pl FROM ");
		sql.append(" (select a.meal_name,a.xiadan,a.ymoney,b.wancheng,b.smoney,c.tuidan,b.yuji from");
		sql.append(" (select b.meal_name,下单数 as xiadan,应收金额 as ymoney from");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 下单数,sum(b.count)*a.meal_price as 应收金额 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state!=5");
		/*if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
		}*/
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date >='"+map.get("dateA")+"' AND c.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  c.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a ");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) a");
		sql.append(" join");
		sql.append(" (select b.meal_name,完成数 as wancheng,实收金额 as smoney,预计收入 as yuji from");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 完成数,sum(b.count)*a.meal_price as 实收金额,sum(b.count)*(a.meal_price-a.meal_budget) as 预计收入 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state=4");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and c.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date >='"+map.get("dateA")+"' AND c.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  c.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) b on a.meal_name=b.meal_name");
		sql.append(" join ");
		sql.append(" (select b.meal_name,退单数 as tuidan from ");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 退单数 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and c.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date >='"+map.get("dateA")+"' AND c.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  c.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) c on b.meal_name=c.meal_name) a");
		sql.append(" join");
		sql.append(" (SELECT b.name2,CONCAT(FORMAT((a.som1/b.som2)*100,2),'%') as pl from (");
		sql.append(" SELECT a.meal_name as name1,count(b.comment_id) as som1 from meal a LEFT JOIN ");
		sql.append(" comments b on a.meal_id=b.meal_id");
		sql.append(" where b.comment_grade >=3");
		sql.append(" GROUP BY a.meal_name) a ");
		sql.append(" RIGHT JOIN (");
		sql.append(" SELECT a.meal_name as name2,count(b.comment_id) as som2 from meal a LEFT JOIN ");
		sql.append(" comments b on a.meal_id=b.meal_id");
		sql.append(" GROUP BY a.meal_name) b on a.name1=b.name2) b on a.meal_name=b.name2)a");
		PageUtil pageutil=new PageUtil();
	    pageutil.setpageinfo(sql, page);
		return page.getPagelist();
	}
    /****
     * 总计
     */
	@Override
	public Map SelectAll(Map map2) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select * from (");
		sql.append(" SELECT a.meal_name as mealname,sum(a.xiadan) as xiadan,sum(a.ymoney) as ymoney,sum(a.wancheng) as wancheng,sum(a.smoney) as smoney,sum(a.tuidan)as tuidan,sum(a.yuji) as yuji FROM");
		//sql.append(" SELECT a.meal_name,a.xiadan,a.ymoney,a.wancheng,a.smoney,a.tuidan,a.yuji,b.pl FROM ");
		sql.append(" (select a.meal_name,a.xiadan,a.ymoney,b.wancheng,b.smoney,c.tuidan,b.yuji from");
		sql.append(" (select b.meal_name,下单数 as xiadan,应收金额 as ymoney from");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 下单数,sum(b.count)*a.meal_price as 应收金额 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state!=5");
//		if(StringUtil.checkNotNull(map2.get("dateA"))&&StringUtil.checkNotNull(map2.get("dateB"))){
//			sql.append(" and c.order_date between '"+map2.get("dateA")+"' and '"+map2.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map2.get("dateA"))&&StringUtil.checkNotNull(map2.get("dateB"))){
			sql.append(" and c.order_date >='"+map2.get("dateA")+"' AND c.order_date <= '"+map2.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map2.get("dateA"))){
				sql.append(" and  c.order_date >='"+map2.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map2.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map2.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a ");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) a");
		sql.append(" join");
		sql.append(" (select b.meal_name,完成数 as wancheng,实收金额 as smoney,预计收入 as yuji from");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 完成数,sum(b.count)*a.meal_price as 实收金额,sum(b.count)*(a.meal_price-a.meal_budget) as 预计收入 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state=4");
//		if(StringUtil.checkNotNull(map2.get("dateA"))&&StringUtil.checkNotNull(map2.get("dateB"))){
//			sql.append(" and c.order_date between '"+map2.get("dateA")+"' and '"+map2.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map2.get("dateA"))&&StringUtil.checkNotNull(map2.get("dateB"))){
			sql.append(" and c.order_date >='"+map2.get("dateA")+"' AND c.order_date <= '"+map2.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map2.get("dateA"))){
				sql.append(" and  c.order_date >='"+map2.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map2.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map2.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) b on a.meal_name=b.meal_name");
		sql.append(" join ");
		sql.append(" (select b.meal_name,退单数 as tuidan from ");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 退单数 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state=5");
		if(StringUtil.checkNotNull(map2.get("dateA"))&&StringUtil.checkNotNull(map2.get("dateB"))){
			sql.append(" and c.order_date between '"+map2.get("dateA")+"' and '"+map2.get("dateB")+"'  ");
		}
		sql.append(" GROUP BY a.meal_name) a");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) c on b.meal_name=c.meal_name) a");
		sql.append(" join");
		sql.append(" (SELECT b.name2,CONCAT(FORMAT((a.som1/b.som2)*100,2),'%') as pl from (");
		sql.append(" SELECT a.meal_name as name1,count(b.comment_id) as som1 from meal a LEFT JOIN ");
		sql.append(" comments b on a.meal_id=b.meal_id");
		sql.append(" where b.comment_grade >=3");
		sql.append(" GROUP BY a.meal_name) a ");
		sql.append(" RIGHT JOIN (");
		sql.append(" SELECT a.meal_name as name2,count(b.comment_id) as som2 from meal a LEFT JOIN ");
		sql.append(" comments b on a.meal_id=b.meal_id");
		sql.append(" GROUP BY a.meal_name) b on a.name1=b.name2) b on a.meal_name=b.name2)a");
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql.toString(),null);
			if(list!=null&&!list.isEmpty()){
				Map map=(Map) list.get(0);
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 下单图表统计
	 */
	public List mealTu(Map map){
		StringBuffer sql=new StringBuffer();
		sql.append("select * from (");
		sql.append(" SELECT a.meal_name,a.xiadan,a.ymoney,a.wancheng,a.smoney,a.tuidan,a.yuji,b.pl FROM ");
		sql.append(" (select a.meal_name,a.xiadan,a.ymoney,b.wancheng,b.smoney,c.tuidan,b.yuji from");
		sql.append(" (select b.meal_name,下单数 as xiadan,应收金额 as ymoney from");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 下单数,sum(b.count)*a.meal_price as 应收金额 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state!=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and c.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date >='"+map.get("dateA")+"' AND c.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  c.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a ");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) a");
		sql.append(" join");
		sql.append(" (select b.meal_name,完成数 as wancheng,实收金额 as smoney,预计收入 as yuji from");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 完成数,sum(b.count)*a.meal_price as 实收金额,sum(b.count)*(a.meal_price-a.meal_budget) as 预计收入 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state=4");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and c.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date >='"+map.get("dateA")+"' AND c.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  c.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) b on a.meal_name=b.meal_name");
		sql.append(" join ");
		sql.append(" (select b.meal_name,退单数 as tuidan from ");
		sql.append(" (select a.meal_id,a.meal_name,sum(b.count) as 退单数 from meal a ");
		sql.append(" LEFT JOIN order_detail b on a.meal_id=b.meal_id");
		sql.append(" JOIN orders c on b.order_id=c.order_id");
		sql.append(" where c.state=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and c.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and c.order_date >='"+map.get("dateA")+"' AND c.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  c.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  c.order_date <= '"+map.get("dateB")+"' ");
			}
		}
		sql.append(" GROUP BY a.meal_name) a");
		sql.append(" RIGHT JOIN meal b on a.meal_id=b.meal_id) c on b.meal_name=c.meal_name) a");
		sql.append(" join");
		sql.append(" (SELECT b.name2,CONCAT(FORMAT((a.som1/b.som2)*100,2),'%') as pl from (");
		sql.append(" SELECT a.meal_name as name1,count(b.comment_id) as som1 from meal a LEFT JOIN ");
		sql.append(" comments b on a.meal_id=b.meal_id");
		sql.append(" where b.comment_grade >=3");
		sql.append(" GROUP BY a.meal_name) a ");
		sql.append(" RIGHT JOIN (");
		sql.append(" SELECT a.meal_name as name2,count(b.comment_id) as som2 from meal a LEFT JOIN ");
		sql.append(" comments b on a.meal_id=b.meal_id");
		sql.append(" GROUP BY a.meal_name) b on a.name1=b.name2) b on a.meal_name=b.name2)a");
		sql.append(" ORDER BY a.xiadan DESC LIMIT 0,10");
		BaseDAO base=new BaseDAO();
		try {
			List list = base.selectInfo(sql.toString(), null);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
