package com.dc.dao.pinlun;

import java.util.List;
import java.util.Map;

import com.dc.util.BaseDAO;

public class QTPinlunDAOImpl implements QTPinlunDAO{
 
	@Override
	/**
	 * 根据商品id查询相关评论
	 */
	public List SelPinlun(String mealid) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,c.customer_name,m.meal_name");
		sql.append(" from comments a,customer c ,meal m");
		sql.append(" where a.customer_id=c.customer_id");
		sql.append(" and a.meal_id=m.meal_id");
		sql.append(" and m.meal_id=?");
		sql.append(" ORDER BY comment_date DESC limit 6");
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{mealid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
	/**
	 * 根据订单id查询相关菜品详情
	 * @Override
	 */
	public List FindOrder(String orderid) {
		// TODO Auto-generated method stub
		String sql="select * from order_detail a,meal b where a.meal_id=b.meal_id and a.order_id=?";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql, new Object[]{orderid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    /**
     *根据orderID查询相关菜品评论
     * @Override
     */
	public List FindPinlun(String orderid) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,d.* from meal a");
		sql.append(" join order_detail b on a.meal_id=b.meal_id");
		sql.append(" join orders c on b.order_id=c.order_id");
		sql.append(" join customer d on d.customer_id=b.customer_id");
		sql.append(" where c.order_id=?");
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{orderid});
			if(list!=null&&!list.isEmpty()){
					for(int i=0;i<list.size();i++){
						Map map=(Map) list.get(i);
						String mealid=map.get("meal_id").toString();
						String sql2="select a.*,b.customer_name from comments a join customer b on a.customer_id=b.customer_id where meal_id=? order by a.comment_date desc limit 6";
						List commlist=base.selectInfo(sql2, new Object[]{mealid});
						map.put("comments", commlist);
					}
			}
				return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * 新增顾客评论
	 */
	public boolean InsertPL(String orderid, String commentcontent,String commentgrade, String mealid) {
		// TODO Auto-generated method stub
		String sql="select c.customer_id from customer c ,orders o WHERE c.customer_id=o.customer_id and o.order_id=?";
		BaseDAO base=new BaseDAO();
		String customerid;
		try {
			List list=base.selectInfo(sql, new Object[]{orderid});
	        if(list!=null&&list.size()>0){
	        	Map map=(Map) list.get(0);
	        	customerid=map.get("customer_id").toString();
	            String sql2="insert into comments(customer_id,comment_date,comment_content,comment_grade,meal_id) VAlUES(?,now(),?,?,? )";
	            BaseDAO base1=new BaseDAO();
	            int a=base1.insertSql(sql2, new Object[]{customerid,commentcontent,commentgrade,mealid});
	            if(a>0){
	            	return true;
	            }
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
    //查询菜品详情
	public Map findmeal(String mealid){
		String sql="select * from meal where meal_id=?";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql,new Object[]{mealid});
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
}
