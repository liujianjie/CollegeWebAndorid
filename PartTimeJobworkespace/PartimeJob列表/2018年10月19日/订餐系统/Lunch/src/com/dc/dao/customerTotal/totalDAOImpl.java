package com.dc.dao.customerTotal;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class totalDAOImpl implements totalDAO{

	@Override
	//根据顾客表的订单表订单详情表还有食物表进行相关查询和统计
	public List select(Map map,PageEntity page) {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * from (");
		sql.append(" SELECT m.name1 as aname,m.coun as acoun ,m.sum as asum,m.money as amoney ,");
		sql.append(" n.coun as bcoun,n.sum as bsum,n.money as  bmoney from (");
		sql.append(" SELECT a.customer_name as name1,a.coun as coun ,b.sum  as sum ,a.money as money from (");
		sql.append(" select a.customer_name,count(b.order_id) as coun,sum(b.money) as  money from customer a");
		sql.append(" LEFT JOIN orders b on a.customer_id=b.customer_id");
		sql.append(" WHERE b.state=4");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and b.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and b.order_date >='"+map.get("dateA")+"' AND b.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  b.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  b.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_name )a LEFT JOIN (");
		sql.append(" SELECT b.customer_name,a.sum from (");
		sql.append(" SELECT a.customer_id, sum(b.count) as sum from orders a");
		sql.append(" RIGHT JOIN order_detail b on a.order_id=b.order_id");
		sql.append(" where a.state=4");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and a.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and a.order_date >='"+map.get("dateA")+"' AND a.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  a.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  a.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_id)a ");
		sql.append(" LEFT JOIN customer b on a.customer_id=b.customer_id");
		sql.append(" GROUP BY b.customer_name)b on a.customer_name=b.customer_name)m");
		sql.append(" LEFT JOIN(");
		sql.append(" SELECT a.customer_name as name1,a.coun as coun ,b.sum  as sum ,a.money as money from (");
		sql.append(" select a.customer_name,count(b.order_id) as coun,sum(b.money) as  money from customer a");
		sql.append(" LEFT JOIN orders b on a.customer_id=b.customer_id");
		sql.append(" WHERE b.state=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and b.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and b.order_date >='"+map.get("dateA")+"' AND b.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  b.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  b.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_name )a LEFT JOIN (");
		sql.append(" SELECT b.customer_name,a.sum from (");
		sql.append(" SELECT a.customer_id, sum(b.count) as sum from orders a");
		sql.append(" RIGHT JOIN order_detail b on a.order_id=b.order_id");
		sql.append(" where a.state=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and a.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and a.order_date >='"+map.get("dateA")+"' AND a.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  a.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  a.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_id)a");
		sql.append(" LEFT JOIN customer b on a.customer_id=b.customer_id");
		sql.append(" GROUP BY b.customer_name)b on a.customer_name=b.customer_name)n");
		sql.append(" on m.name1=n.name1)a");
		PageUtil pageutil=new PageUtil();
	    pageutil.setpageinfo(sql, page);
		return page.getPagelist();
	}
	//求总和
	public Map find(Map map) {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * from (");
		sql.append(" SELECT sum(m.coun) as acoun ,sum(m.sum) as asum,sum(m.money) as amoney ,");
		sql.append(" sum(n.coun) as bcoun,sum(n.sum) as bsum,sum(n.money) as  bmoney from (");
		sql.append(" SELECT a.customer_name as name1,a.coun as coun ,b.sum  as sum ,a.money as money from (");
		sql.append(" select a.customer_name,count(b.order_id) as coun,sum(b.money) as  money from customer a");
		sql.append(" LEFT JOIN orders b on a.customer_id=b.customer_id");
		sql.append(" WHERE b.state=4");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and b.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and b.order_date >='"+map.get("dateA")+"' AND b.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  b.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  b.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_name )a LEFT JOIN (");
		sql.append(" SELECT b.customer_name,a.sum from (");
		sql.append(" SELECT a.customer_id, sum(b.count) as sum from orders a");
		sql.append(" RIGHT JOIN order_detail b on a.order_id=b.order_id");
		sql.append(" where a.state=4");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and a.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and a.order_date >='"+map.get("dateA")+"' AND a.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  a.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  a.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_id)a ");
		sql.append(" LEFT JOIN customer b on a.customer_id=b.customer_id");
		sql.append(" GROUP BY b.customer_name)b on a.customer_name=b.customer_name)m");
		sql.append(" LEFT JOIN(");
		sql.append(" SELECT a.customer_name as name1,a.coun as coun ,b.sum  as sum ,a.money as money from (");
		sql.append(" select a.customer_name,count(b.order_id) as coun,sum(b.money) as  money from customer a");
		sql.append(" LEFT JOIN orders b on a.customer_id=b.customer_id");
		sql.append(" WHERE b.state=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and b.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and b.order_date >='"+map.get("dateA")+"' AND b.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  b.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  b.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_name )a LEFT JOIN (");
		sql.append(" SELECT b.customer_name,a.sum from (");
		sql.append(" SELECT a.customer_id, sum(b.count) as sum from orders a");
		sql.append(" RIGHT JOIN order_detail b on a.order_id=b.order_id");
		sql.append(" where a.state=5");
//		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
//			sql.append(" and a.order_date between '"+map.get("dateA")+"' and '"+map.get("dateB")+"'  ");
//		}
		if(StringUtil.checkNotNull(map.get("dateA"))&&StringUtil.checkNotNull(map.get("dateB"))){
			sql.append(" and a.order_date >='"+map.get("dateA")+"' AND a.order_date <= '"+map.get("dateB")+"' ");
		}else{
			if(StringUtil.checkNotNull(map.get("dateA"))){
				sql.append(" and  a.order_date >='"+map.get("dateA")+"' ");
			}
			if(StringUtil.checkNotNull(map.get("dateB"))){
				sql.append(" and  a.order_date <= '"+map.get("dateB")+"' ");
			}
		
		}
		sql.append(" GROUP BY a.customer_id)a");
		sql.append(" LEFT JOIN customer b on a.customer_id=b.customer_id");
		sql.append(" GROUP BY b.customer_name)b on a.customer_name=b.customer_name)n");
		sql.append(" on m.name1=n.name1)a");
		try {
			List list=base.selectInfo(sql.toString(),null);
			if(list!=null&&!list.isEmpty()){
				Map map1=(Map) list.get(0);
				return map1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      
}
