package com.dc.dao.orders;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;
import com.sun.xml.internal.ws.api.model.MEP;

public class OrdersDaoImpl implements OrdersDao{
	/**
	 * 查询统计订单
	 * */
	public List findAllOrders(Map map,PageEntity page){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select b.emp_name,c.customer_name,d.room_number,");
		sql.append(" a.order_date,a.order_content,a.order_count,");
		sql.append(" e.meal_price,(a.order_count*e.meal_price)as price");
		sql.append(" from  orders a left join emp b on a.emp_id=b.emp_id");
		sql.append(" join customer c on a.customer_id=c.customer_id");
		sql.append(" join room d on a.order_id=d.room_id ");
		sql.append(" join meal e on a.order_content=e.meal_name");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("customername"))){
			String customername=map.get("customername").toString();
			sql.append(" and customer_name like '%"+customername+"%'");
		}
		PageUtil pageUtil=new PageUtil();
		pageUtil.setpageinfo(sql, page);
		return page.getPagelist();
	}
}
