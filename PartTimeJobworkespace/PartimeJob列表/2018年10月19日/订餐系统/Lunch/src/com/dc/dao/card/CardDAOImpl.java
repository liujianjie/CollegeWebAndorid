package com.dc.dao.card;

import java.util.*;

import com.dc.entity.OrderdEntity;
import com.dc.util.BaseDAO;


public class CardDAOImpl implements CardDAO{
	/*
	 * 根据顾客id，判断card表中是否已有商品
	 */
	public List find(String meal,String price,String customerid) throws Exception{
		String sql="select * from card where meal=? and price=? and customer_id=?";
		Object[]obj={meal,price, customerid};
		BaseDAO b=new BaseDAO();
		return b.selectInfo(sql, obj);
	}
	/*
	 * 如果表中没有，则新增
	 */
	public void insert(String meal,String price,String customerid){
		String sql="insert into card (meal,price,count,customer_id) values(?,?,1,?) ";
		Object[]obj={meal,price,customerid};
		BaseDAO b=new BaseDAO();
		try {
			b.insertSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 如果表中已有，则叠加
	 */
	public void update(String meal,String customerid){
		String sql="update card set count=1+count where meal=? and customer_id=?";
		Object[]obj={meal,customerid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 根据顾客id，将商品查询到购物车
	 */
	public List select(String customerid) throws Exception{
		String sql="select * from card where customer_id=?";
		Object[]obj={customerid};
		BaseDAO b=new BaseDAO();
		List list=b.selectInfo(sql, obj);
		return list;
	}
	/*
	 * 将购物车商品批量增加到订单详情表
	 */
	public void insertorderd(List<OrderdEntity> list,String orderid){
		String mealid = null;
		String mealtype=null;
		String rank=null;
		int n=0;
		BaseDAO b=new BaseDAO();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				OrderdEntity order=list.get(i);
				String sql1="select * from meal where meal_name=?";
				try {
					List<HashMap> list1=b.selectInfo(sql1, new Object[]{order.getMeal()});
					System.out.println(list1);
					Map map=list1.get(0);
					 mealid=map.get("meal_id").toString();
					 mealtype=map.get("meal_type").toString();
					 String sql2="INSERT into order_detail (order_id,meal_id,price,count,customer_id,state,rank)VALUES(?,?,?,?,?,?,?)";
					 if(mealtype.equals("热菜")){ 
						 n=n+1;
						 rank=String.valueOf(n);
					 }else{
						 rank=null;
					 }
					 int orderdetailid=b.insertSql(sql2, new Object[]{orderid,mealid,order.getPrice(),order.getCount(),order.getCustomerid(),0,rank});
					 if(mealtype.equals("热菜")){
						 this.insertcook(orderdetailid,order.getCount(), orderid, mealid, order.getCustomerid(), rank);
					 }
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	/*
	 * 订单商品加入cook表
	 */
	public void insertcook(int orderdetailid,String count,String orderid,String mealid,String customerid,String rank){
		int count1=Integer.parseInt(count);
		for(int i=0;i<count1;i++){
			String sql="INSERT into cook (order_detail_id,order_id,meal_id,count,customer_id,state,rank)VALUES(?,?,?,?,?,?,?)";
			Object[]obj={orderdetailid,orderid,mealid,1,customerid,0,rank};
			BaseDAO b=new BaseDAO();
			try {
				b.insertSql(sql, obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * 将购物车信息加入订单表
	 */
	public int insertorder(String cus,String orderdate,String money,String content){
		String sql="insert into orders(customer_id,order_date,money,state,order_content) VALUES(?,?,?,0,?)";
		Object[]obj={cus,orderdate,money,content};
		BaseDAO b=new BaseDAO();
		try {
			int i=b.insertSql(sql, obj);
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/*
	 * 清空购物车
	 */
	public void clear(String customerid){
		String sql="delete from card where customer_id=? ";
		Object[]obj={customerid};
		BaseDAO b=new BaseDAO();
		try {
			int i=b.updateSql(sql, obj);
			System.out.println(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 将购物车商品单个删除
	 */
	public void delete(String cardid){
		String sql="delete from card where card_id=? ";
		Object[]obj={cardid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 用户查询所有订单
	 */
	public List findMyOrder(String customerid){
		String sql="select * from orders where customer_id=? and room_id is null ORDER BY order_date DESC ";
		Object[]obj={customerid};
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
	 * 完成订单
	 */
	public void finishOrder(String orderid){
		String sql="update orders set state=4 where order_id=? ";
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
	 * 查询顾客信息
	 */
	public List findcustomerById(String customerid){
		String sql="select * from customer where customer_id=? ";
		Object[]obj={customerid};
		BaseDAO b=new BaseDAO();
		List list;
		try {
			list = b.selectInfo(sql, obj);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	/*
	 * 修改用户配送信息
	 */
	public void updateinfo(String customerid,String add,String phone,String province,String city,String district){
		String sql=" update customer set customer_add=?,customer_phone=?,customer_province=?,customer_city=?,customer_district=? where customer_id=? ";
		Object[]obj={add,phone,province,city,district,customerid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 修改购物车数量
	 */
	
	public void updatecard(List list ){
		String sql=" update card set count=? where meal=? and price=? and customer_id=? ";
		for(int i=0;i<list.size();i++){
			Map map=(Map) list.get(i);
			System.out.println(map);
			String count=(String) map.get("count");
			String meal=(String) map.get("meal");
			String price=(String) map.get("price");
			String customerid=(String) map.get("customerid");
			
			Object[]obj={count,meal,price,customerid};
			BaseDAO b=new BaseDAO();
			try {
				b.updateSql(sql, obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}
