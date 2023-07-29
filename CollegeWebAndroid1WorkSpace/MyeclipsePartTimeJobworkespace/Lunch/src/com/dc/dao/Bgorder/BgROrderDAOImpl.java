package com.dc.dao.Bgorder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class BgROrderDAOImpl implements BgROrderDAO{
/**
 * 查询所有房间订单
 */
	@Override
	public List SelectAllRO(Map map, PageEntity page0) {
		StringBuffer sql=new StringBuffer("");
		sql.append(" select b.room_number,b.room_type,a.*,c.emp_name from room b");
		sql.append("  JOIN orders a  on a.room_id=b.room_id");
		sql.append("  left join emp c ON a.emp_id=c.emp_id");
		sql.append(" where 1=1 ");
		//如果查询条件为空，则查询所有（此条件不过滤）
		if(StringUtil.checkNotNull(map.get("roomnumber"))){
			String roomnumber=map.get("roomnumber").toString();
			sql.append("and b.room_number like '%"+roomnumber+"%'");
		}
		if(StringUtil.checkNotNull(map.get("state"))){
			String state=map.get("state").toString();
			sql.append("and a.state like '%"+state+"%'");
		}
		sql.append(" order by a.order_date desc");
		PageUtil pageutil=new PageUtil();
		 pageutil.setpageinfo(sql, page0);
		 return page0.getPagelist();	
	}
/**
 * 改变订单状态
 */
@Override
public int changeOrState(String orderid,String empid) {
	BaseDAO base =new BaseDAO();
	String sql="update orders SET state=4,emp_id=?,date=now() where order_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{empid,orderid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
}
/**
 * 查询所有酒水订单
 */
@Override
public List SelectAllDrink() {
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer("");
	sql.append("select a.*,b.meal_name,b.meal_price,b.meal_type,"); 
	sql.append(" c.order_date,d.*,e.* from order_detail a");
	sql.append(" LEFT JOIN meal b on a.meal_id=b.meal_id");
	sql.append(" left join orders c on a.order_id=c.order_id");
	sql.append(" left join customer d on a.customer_id=d.customer_id");
	sql.append(" left join room e on c.room_id=e.room_id");
	sql.append(" where b.meal_type='酒水' and c.state=1");
	try {
		List list=base.selectInfo(sql.toString(), null);
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * 修改酒品详情状态
 */

public int changeDrinkState(String detailid) {
	BaseDAO base=new BaseDAO();
	String sql="update order_detail set state=1 where order_detail_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{detailid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 查询显示条件统计房间订单
 */
public Map checkOrshowTotal(Map map, PageEntity page0) {
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer("");
	sql.append("select a.*,b.roommoneys,b.roomorders,c.roommoneyx,c.roomorderx,b.ordercounts,c.ordercountx from (");
	sql.append(" select b.*,count(a.order_id)as ordercount from orders a");
	sql.append(" right join room b on a.room_id=b.room_id");
	sql.append(" GROUP BY b.room_id)a");
	sql.append(" LEFT JOIN (");
	sql.append(" select *,SUM(b.money)as roommoneys,SUM(b.mealcount)as roomorders,count(order_id) as ordercounts   ");
	sql.append(" from (");
	sql.append(" select a.*,SUM(b.count)as mealcount from orders a");
	sql.append(" join order_detail b on b.order_id=a.order_id where 1=1 AND a.state=4");
	if(StringUtil.checkNotNull(map.get("begintime"))){
		String begintime=map.get("begintime").toString();
		sql.append(" and a.order_date>'"+begintime+"'");
	}
	if(StringUtil.checkNotNull(map.get("endtime"))){
		String endtime=map.get("endtime").toString();
		sql.append(" and a.order_date<'"+endtime+"'");
	}
	sql.append(" and SUBSTR(a.order_date FROM 12 FOR 8)<='12:00:00'and SUBSTR(a.order_date FROM 12 FOR 8)>='08:00:00'");
	sql.append(" GROUP BY a.order_id");
	sql.append(" )b ");
	sql.append(" GROUP BY b.room_id");
	sql.append(" ) b on a.room_id=b.room_id");
	sql.append(" left join (");
	sql.append(" select *,SUM(b.money)as roommoneyx,SUM(b.mealcount)as roomorderx,count(order_id) as ordercountx  ");
	sql.append(" from (");
	sql.append(" select a.*,SUM(b.count)as mealcount from orders a");
	sql.append(" join order_detail b on b.order_id=a.order_id");
	sql.append(" where 1=1  AND a.state=4");
	
	if(StringUtil.checkNotNull(map.get("begintime"))){
		String begintime=map.get("begintime").toString();
		sql.append(" and a.order_date>'"+begintime+"'");
	}
	if(StringUtil.checkNotNull(map.get("endtime"))){
		String endtime=map.get("endtime").toString();
		sql.append(" and a.order_date<'"+endtime+"'");
	}
	sql.append(" and SUBSTR(a.order_date FROM 12 FOR 8)<='24:00:00'and SUBSTR(a.order_date FROM 12 FOR 8)>='12:00:00'");
	sql.append(" GROUP BY a.order_id");
	sql.append(" )b ");
	sql.append(" GROUP BY b.room_id");
	sql.append(" )c ON b.room_id=c.room_id where 1=1 ");
	//sql.append(" and  a.room_type like '包厢' and a.room_number like '%A%'");
	//如果查询条件为空，则查询所有（此条件不过滤）
	if(StringUtil.checkNotNull(map.get("roomnumber"))){
		String roomnumber=map.get("roomnumber").toString();
		sql.append("and a.room_number like '%"+roomnumber+"%'");
	}
	if(StringUtil.checkNotNull(map.get("roomtype"))){
		String roomtype=map.get("roomtype").toString();
		sql.append("and a.room_type like '%"+roomtype+"%'");
	}
	PageUtil pageutil=new PageUtil();
	 pageutil.setpageinfo(sql, page0);
	 Map map1=CountAllTosum(sql, page0.getPagelist());
	 return map1;	
}
/**
 * 计算统计查询结果时所有结果并统计
 * @param sql
 * @param list
 * @return
 */
public Map CountAllTosum(StringBuffer sql,List list){
	StringBuffer sqla=new StringBuffer();
	sqla.append("select * from (");
	sqla.append(" select sum(roommoneys) as allmoneys,SUM(roommoneyx) as allmoneyx,");
	sqla.append(" sum(roomorders) as allordedetails,sum(roomorderx) as allordedetailx,");
	sqla.append(" sum(ordercounts) as ordercounts,sum(ordercountx) as ordercountx");
	sqla.append(" from ( ");
	sqla.append(sql);
	sqla.append(" )f");
	sqla.append(" )e");
	BaseDAO base=new BaseDAO();
	try {
		List sons=base.selectInfo(sqla.toString(), null);
		if(list!=null&&list.size()>0){
		Map map=new HashMap();
		map.put("Total", sons);
		map.put("Detail", list);
		return map;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
