package com.dc.dao.order;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class OrderDAOImpl implements OrderDAO {
	/*
	 * 订单查询
	 */
	public List findorder(Map map,PageEntity page){
		
		StringBuffer sql=new StringBuffer("");
		sql.append(" select a.order_id,a.money,a.order_date,a.state ,b.*,c.emp_name from orders a  ");
		sql.append(" LEFT JOIN customer b on a.customer_id=b.customer_id");
		sql.append(" LEFT JOIN emp c on a.emp_id=c.emp_id");
		sql.append(" where room_id is null and 1=1 ");
		//如果查询条件为空，则查询所有（此条件不过滤）
		if(StringUtil.checkNotNull(map.get("customername"))){
			String customername=map.get("customername").toString();
			sql.append(" and b.customer_name like '%"+customername+"%'");
		}
		String state=(String) map.get("state");
		if(StringUtil.checkNotNull(state)){
			sql.append(" and a.state like '%"+state+"%'");
			if(state.equals("4")&&!state.equals("5")){
				sql.append(" ORDER BY a.order_date DESC");
			}
		}else{
			sql.append(" ORDER BY a.order_date DESC");
		}
		
		
		PageUtil pageutil=new PageUtil();
		 pageutil.setpageinfo(sql, page);
		 return page.getPagelist();	
	}
	/*
	 * 查询一个订单
	 */
	public List findById(String orderid){
		StringBuffer sql=new StringBuffer("");
		sql.append(" select a.order_id,a.emp_id,a.money,a.order_date,a.state,a.order_content,b.*,c.emp_name,c.phone from orders a  ");
		sql.append(" LEFT JOIN customer b on a.customer_id=b.customer_id ");
		sql.append(" LEFT JOIN emp c on c.emp_id=a.emp_id where a.order_id=?");
		Object[] obj={orderid};
		BaseDAO b=new BaseDAO();
		try {
			List list=b.selectInfo(sql.toString(), obj);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 订单详情查询
	 */
	public List findDetail(String orderid){
		StringBuffer sql=new StringBuffer("");
		sql.append(" select a.*,b.meal_name,b.meal_desc,b.meal_image from order_detail a  ");
		sql.append(" LEFT JOIN meal b on b.meal_id=a.meal_id where order_id=?");
		Object[] obj={orderid};
		BaseDAO b=new BaseDAO();
		try {
			List list=b.selectInfo(sql.toString(), obj);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 员工查询
	 */
	public List findemp(){
		String sql="select * from emp where duty_id=21 ";		
		BaseDAO b=new BaseDAO();
		try {
			List list =b.selectInfo(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	/*
	 * 安排员工配送
	 */
	public void updateByName(String empname,String orderid ) {
		// TODO Auto-generated method stub
		String sql="select emp_id FROM emp where emp_name=?";
		Object[]obj={empname};
		BaseDAO b=new BaseDAO();
		try {
			List list = (List) b.selectInfo(sql, obj);
			Map map=(Map) list.get(0);
			String empid=map.get("emp_id").toString();
			String sql1="update orders SET emp_id=?,state=3 where order_id=?";
			Object[]obj1={empid,orderid};
			int i=b.updateSql(sql1, obj1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * 接单
	 */
	public void updatestate(String orderid){
		String sql="update orders SET state=1 where order_id=?";
		Object[]obj={orderid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 取消订单
	 */
	public void qxdd(String orderid){
		String sql="update orders set state=5 where order_id=?";
		Object[]obj={orderid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 查看可否打包
	 */
	public List findpack(String orderid){
		String sql="select * from order_detail where order_id=? and state=0 ";
		Object[]obj={orderid}; 
		BaseDAO b=new BaseDAO();
		try {
			List list=b.selectInfo(sql, obj);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 打包
	 */
	public void pack(String orderid){
		String sql="UPDATE orders SET state=2 where order_id=? ";
		Object[]obj={orderid}; 
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
