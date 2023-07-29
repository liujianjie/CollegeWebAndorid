package com.dc.dao.order;

import java.util.List;

import com.dc.util.BaseDAO;
import com.dc.util.StringUtil;
/*
 * ¶©µ¥Í³¼Æ
 */
public class CountDAOImpl implements CountDAO{
	
	public List count1(String date1,String date2){
		StringBuffer sql=new StringBuffer();
		sql.append("  select d.date,a.s1,a.s2,a.s3,b.s4,c.s5 ,e.s6 ,money from ");
		sql.append("  (select SUBSTRING(order_date ,1,10) date,COUNT(order_id) from orders a  ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10))d ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) date,COUNT(room_id) as s2 ,COUNT(order_id) as s3,(COUNT(order_id)-COUNT(room_id)) s1,sum(money) money from orders a ");  
		sql.append("   where state=4 GROUP BY SUBSTRING(order_date ,1,10))a on a.date=d.date ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) as date,count(order_id) s4 from orders where state=5 ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10)) b on d.date=b.date ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) as date,count(order_id) s5 from orders where state!=4 and state!=5 and room_id is null ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10) ) c on d.date=c.date ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) as date,count(order_id) s6 from orders where state!=4 and state!=5 and room_id is not null ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10) ) e on d.date=e.date ");
		sql.append("  where 1=1 ");
		BaseDAO b =new BaseDAO();
		if(StringUtil.checkNotNull(date1)&&StringUtil.checkNotNull(date2)){
			sql.append(" and d.date >='"+date1+"' AND d.date <= '"+date2+"' ");
		}else{
			if(StringUtil.checkNotNull(date1)){
				sql.append(" and  d.date >='"+date1+"' ");
			}
			if(StringUtil.checkNotNull(date2)){
				sql.append("  and  d.date <= '"+date2+"' ");
			}
		}
			
			try {
				List list=b.selectInfo(sql.toString(), null);
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;	
	}
	public List count2(String date1,String date2){
		StringBuffer sql=new StringBuffer();
		sql.append("  select sum(s1) s1,sum(s2) s2,sum(s3) s3,sum(s4) s4,sum(s5) s5,sum(s6) s6,sum(money) money from(  ");
		sql.append("  select d.date,a.s1,a.s2,a.s3,b.s4,c.s5 ,e.s6 ,money from ");
		sql.append("  (select SUBSTRING(order_date ,1,10) date,COUNT(order_id) from orders a  ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10))d ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) date,COUNT(room_id) as s2 ,COUNT(order_id) as s3,(COUNT(order_id)-COUNT(room_id)) s1,sum(money) money from orders a ");  
		sql.append("   where state=4 GROUP BY SUBSTRING(order_date ,1,10))a on a.date=d.date ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) as date,count(order_id) s4 from orders where state=5 ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10)) b on d.date=b.date ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) as date,count(order_id) s5 from orders where state!=4 and state!=5 and room_id is null ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10) ) c on d.date=c.date ");
		sql.append("  left join ");
		sql.append("  (select SUBSTRING(order_date ,1,10) as date,count(order_id) s6 from orders where state!=4 and state!=5 and room_id is not null ");
		sql.append("  GROUP BY SUBSTRING(order_date ,1,10) ) e on d.date=e.date ");
		sql.append("  where 1=1 ");
		BaseDAO b =new BaseDAO();
		if(StringUtil.checkNotNull(date1)&&StringUtil.checkNotNull(date2)){
			sql.append(" and d.date >='"+date1+"' AND d.date <= '"+date2+"' ");
		}else{
			if(StringUtil.checkNotNull(date1)){
				sql.append(" and  d.date >='"+date1+"' ");
			}
			if(StringUtil.checkNotNull(date2)){
				sql.append("  and  d.date <= '"+date2+"' ");
			}
		}
		sql.append(" )a ");
		
			try {
				List list=b.selectInfo(sql.toString(), null);
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;	
	}
	
}	