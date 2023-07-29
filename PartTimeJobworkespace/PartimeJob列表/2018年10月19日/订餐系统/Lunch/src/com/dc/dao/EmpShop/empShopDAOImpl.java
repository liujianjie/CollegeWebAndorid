package com.dc.dao.EmpShop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.util.BaseDAO;
import com.dc.util.StringUtil;

public class empShopDAOImpl implements empShopDAO{
/**
 * 现场开桌，顾客通过桌位进行点餐
 */
	@Override
	public Map selectShopinfo(String mealid) {
		BaseDAO base=new BaseDAO();
		String sql="select * from meal a  where a.meal_id=?  ;";
		try {
			List<HashMap> list=base.selectInfo(sql,new Object[]{mealid});
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 员工登录，分配房间，房间开桌
 */
	@Override
	public List selectAllRoominfo() {
		BaseDAO base =new BaseDAO();
		String sql="select * from room";
		try {
			List list=base.selectInfo(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

/**
 * 开桌查询状态
 */
@Override
public String selectroomState(String roomid) {
	BaseDAO base=new BaseDAO();
	String sql="select room_state FROM room where room_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{roomid});
		if(list!=null&&list.size()>0){
			Map map=(Map) list.get(0);
			String state=map.get("room_state").toString();
			return state;
		}
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 *订单详情表插入返回订单id，热菜进行输入顺序,同时插入cook表
 */
public int insertShopcar(String money, String roomid, List list) {
	BaseDAO base=new BaseDAO();
	int orderdetailid=0;
	int orderid;
	try {
		if(list!=null&&list.size()>0){
			String sqlorder="insert into orders(room_id,order_date,order_count,money,state,pushfoodcount) values(?,now(),1,?,1,0);";
				orderid = base.insertSql(sqlorder, new Object[]{roomid,money});
				int j=1;
			for(int i=0;i<list.size();i++){
				Map map=(Map) list.get(i);
				String mealcount=map.get("mealcount").toString();
				String mealid=map.get("mealid").toString();
				String mealtype=map.get("mealtype").toString();
				String sql="insert into order_detail(order_id,meal_id,count,state) values(?,?,?,0);";
				orderdetailid=base.insertSql(sql, new Object[]{orderid,mealid,mealcount});
				if(mealtype.equals("热菜")){
					String sql2="update order_detail set rank=? where order_detail_id=?";
					base.updateSql(sql2, new Object[]{j,orderdetailid});
					StringBuffer cooksql=new StringBuffer();
					cooksql.append("insert into cook(order_id,meal_id,count,state,rank,order_detail_id)");
					//cooksql.append(" select a.order_id,a.meal_id,1,a.price,a.customer_id,a.state,a.rank from order_detail a");
					cooksql.append(" values(?,?,1,?,?,?)");
				for(int k=0;k<Integer.parseInt(mealcount);k++){	
						base.updateSql(cooksql.toString(), new Object[]{orderid,mealid,0,j,orderdetailid});
				}
					j++;
				}
			}
			
			return orderid;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 详情展示未上桌
 */
public List selectThisdtail(String orderid) {
	// TODO Auto-generated method stub
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("select a.*,b.* from order_detail a ");
	sql.append(" left join meal b ON a.meal_id=b.meal_id ");
	sql.append(" left join orders c on a.order_id=c.order_id");
	sql.append(" WHERE a.order_id=? and c.state=1 and a.state<3 ");
	//String sql="select* from order_detail a left join meal b ON a.meal_id=b.meal_id WHERE order_id=? and a.state=0";
	try {
		List list=base.selectInfo(sql.toString(), new Object[]{orderid});
		if(list!=null&&list.size()>0){
			return list;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * 详情展示已上桌
 */
public List noselectThisdtail(String orderid) {
	// TODO Auto-generated method stub
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("select a.*,b.* from order_detail a ");
	sql.append(" left join meal b ON a.meal_id=b.meal_id ");
	sql.append(" left join orders c on a.order_id=c.order_id");
	sql.append(" WHERE a.order_id=?  and a.state=3");
	//String sql="select* from order_detail a left join meal b ON a.meal_id=b.meal_id WHERE order_id=? and a.state=1";
	try {
		List list=base.selectInfo(sql.toString(), new Object[]{orderid});
		if(list!=null&&list.size()>0){
			return list;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
/**
 * 获取订餐详情个数
 */
@Override
public String getDetailcount(String orderid) {
	BaseDAO base=new BaseDAO();
	String sql="select * from (select count(*)as count  from order_detail where order_id=?)a";
	try {
		List list=base.selectInfo(sql, new Object[]{orderid});
		if(list!=null&&list.size()>0){
			Map map=(Map) list.get(0);
			String count=map.get("count").toString();
			return count;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}
/**
 * orderid查详情
 */
public List orderdetailinfo(String orderid) {
	BaseDAO base=new BaseDAO();
/*	StringBuffer sql=new StringBuffer();
	sql.append("select a.*,b.* from order_detail a ");
	sql.append(" left join meal b ON a.meal_id=b.meal_id ");
	sql.append(" left join orders c on a.order_id=c.order_id");
	sql.append(" WHERE a.order_id=? and c.state=1");*/
	String sql="select a.*,b.meal_name,b.meal_price,b.meal_type from order_detail a LEFT JOIN meal b on a.meal_id=b.meal_id where a.order_id=?";
	try {
		List list=base.selectInfo(sql.toString(), new Object[]{orderid});
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * orderid查订单,更改总钱
 */

public List orderRoominfo(String orderid) {
	BaseDAO base=new BaseDAO();
	StringBuffer sqlb=new StringBuffer();
	sqlb.append("select countmoney FROM(select sum(a.count*b.meal_price)as countmoney");
	sqlb.append(" from order_detail a ");
	sqlb.append(" LEFT JOIN meal b on a.meal_id=b.meal_id ");
	sqlb.append(" where a.order_id=?)a");
	try {
		List list1=base.selectInfo(sqlb.toString(), new Object[]{orderid});
		Map map=new HashMap();
		if(list1!=null&&list1.size()>0){
			 map=(Map) list1.get(0);
		}
		if(map.get("countmoney")!=null){
			String countmoney=map.get("countmoney").toString();
			String sql2="UPDATE orders SET money=? WHERE order_id=?";
			int j=base.updateSql(sql2, new Object[]{countmoney,orderid});
		}
		String sql="select b.room_number,b.room_type,a.*,b.peo_count,c.emp_name from room b"+
				" JOIN orders a on a.room_id=b.room_id"+
				" left join emp c ON a.emp_id=c.emp_id"+
				" where a.order_id=?";
			List list=base.selectInfo(sql, new Object[]{orderid});
			return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}
@Override
/**
 * 查询id房间信息
 */
public List selectroominfo(String roomid) {
	// TODO Auto-generated method stub
	BaseDAO base=new BaseDAO();
	String sql="select * from room where room_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{roomid});
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * 菜详情改为3
 */
public int changeOrDeS3(String orderdetailid) {
	// TODO Auto-generated method stub
	BaseDAO base=new BaseDAO();
	String sql="UPDATE order_detail SET state=3 WHERE order_detail_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{orderdetailid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 退菜
 */
public int reOneTableDe(String orderdetailid) {
	// TODO Auto-generated method stub
	BaseDAO base=new BaseDAO();
	String sql="DELETE FROM order_detail WHERE order_detail_id=?";
	String sql2="DELETE FROM cook WHERE order_detail_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{orderdetailid});
		int j=base.updateSql(sql2, new Object[]{orderdetailid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 通过房间找订单id
 */

public String FindRoomOrid(String roomid) {
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("select b.room_number,b.room_type,a.*,b.peo_count from room b");
	sql.append(" JOIN orders a on a.room_id=b.room_id");
	sql.append(" where b.room_id=? and a.state <4");
	sql.append(" ORDER BY a.order_date DESC");
	try {
		List list=base.selectInfo(sql.toString(), new Object[]{roomid});
		if(list!=null&&list.size()>0){
			Map map=(Map) list.get(0);
			String orderid=map.get("order_id").toString();
			return orderid;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
}
@Override
/**
 * 判断订单是否全部上桌
 */
public boolean countOrder(String orderid) {
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("select * from (SELECT count(*) as sum from order_detail a ");
	sql.append(" where a.order_id=?)a");
	sql.append(" where a.sum");
	sql.append(" in (SELECT count(*) as countstate from order_detail a ");
	sql.append(" where a.order_id=? and state=3)");
	try {
		List list=base.selectInfo(sql.toString(), new Object[]{orderid,orderid});
		if(list!=null&&list.size()>0){	
			Map map=(Map) list.get(0);
			if(StringUtil.checkNotNull(map)&&StringUtil.checkNotNull(map.get("sum"))){
				return true;
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
@Override
/**
 * 加菜，返回详情id
 */
public int AddMeal(String money, String roomid, List list,String addorderid) {
	BaseDAO base=new BaseDAO();
	int orderdetailid=0;
	try {
		if(list!=null&&list.size()>0){
			String sqlorder="UPDATE orders SET money=money+? WHERE order_id=?;";
				 int f=base.updateSql(sqlorder, new Object[]{money,addorderid});
				int j=1;
			for(int i=0;i<list.size();i++){
				Map map=(Map) list.get(i);
				String mealcount=map.get("mealcount").toString();
				String mealid=map.get("mealid").toString();
				String mealtype=map.get("mealtype").toString();
				String sql="insert into order_detail(order_id,meal_id,count,state) values(?,?,?,0);";
				orderdetailid=base.insertSql(sql, new Object[]{addorderid,mealid,mealcount});
				if(mealtype.equals("热菜")){
					String sql2="update order_detail set rank=? where order_detail_id=?";
					base.updateSql(sql2, new Object[]{j,orderdetailid});
					StringBuffer cooksql=new StringBuffer();
					cooksql.append("insert into cook(order_id,meal_id,count,state,rank,order_detail_id)");
					//cooksql.append(" select a.order_id,a.meal_id,1,a.price,a.customer_id,a.state,a.rank from order_detail a");
					cooksql.append(" values(?,?,1,?,?,?)");
				for(int k=0;k<Integer.parseInt(mealcount);k++){	
						base.updateSql(cooksql.toString(), new Object[]{addorderid,mealid,0,j,orderdetailid});
				}
					j++;
				}
			}
			
			return orderdetailid;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
public int puchMealcount(String orderid) {
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("UPDATE orders SET pushfoodcount=pushfoodcount+1 WHERE order_id=? and pushfoodcount<3");
	try {
		base.updateSql(sql.toString(), new Object[]{orderid});
		return 1;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 联合cook表删除菜显示
 */
public List showremovecookde(String orderid) {
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("select d.*,e.meal_price,e.meal_type,e.meal_name ");
	sql.append(" from (select 'cook',a.* from order_detail a");
	sql.append(" left join meal c on c.meal_id=a.meal_id");
	sql.append(" where a.count=1 and a.order_id =? and c.meal_type!='热菜'");
	sql.append(" UNION select * from cook b");
	sql.append(" where b.order_id =?)d ");
	sql.append(" LEFT JOIN meal e ON e.meal_id=d.meal_id");
	try {
		List list=base.selectInfo(sql.toString(), new Object[]{orderid,orderid});
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * 只退热菜，凉菜全退 
 */
public int removecookde(String orderid, String orderdetailid) {
	BaseDAO base=new BaseDAO();
	String sql="DELETE  from cook where order_detail_id=? limit 1";
	String sql2="UPDATE order_detail SET count=count-1 WHERE order_detail_id=?";
	String sql3="DELETE FROM order_detail WHERE order_detail_id=? and order_detail.count<1";
	try {
		base.updateSql(sql, new Object[]{orderdetailid});
		base.updateSql(sql2, new Object[]{orderdetailid});
		base.updateSql(sql3, new Object[]{orderdetailid});
		return 1;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 添加到后台empshop表,已经有的则增加
 */
public int InsertTBEmpshop(String mealid, String mealcount, String roomid,
		String addorderid) {
	BaseDAO base=new BaseDAO();
	int i=0;
	int mealCount=Integer.parseInt(mealcount);
	String sql0="select * from meal where meal_id=?";
	try {
		List list0=base.selectInfo(sql0, new Object[]{mealid});
		if(list0!=null&&list0.size()>0){
			Map map=(Map) list0.get(0);
			String mealprice1=map.get("meal_price").toString();
			double mealprice=Double.parseDouble(mealprice1);
			String mealname=map.get("meal_name").toString();
				String sql1="select * from empshop where room_id=? and meal_id=?";
				List list1=base.selectInfo(sql1, new Object[]{roomid,mealid});
				if(list1.size()>0&&list1!=null){
					Map map1=(Map) list1.get(0);
					String price1=map1.get("price").toString();
					double  price=Double.parseDouble(price1);
					String count1=map1.get("count").toString();
					int count=Integer.parseInt(count1);
					String sqlupdate="UPDATE EmpShop SET price=?,count=? WHERE room_id=? AND meal_id=?";
					i=base.updateSql(sqlupdate, new Object[]{(price+mealprice),(count+mealCount),roomid,mealid});
				}else{
							if(!StringUtil.checkNotNull(addorderid)){
								addorderid=null;
							}
							String sql="INSERT INTO EmpShop (room_id, meal_id, count, price,meal_price, meal_name, order_id) VALUES (?, ?,?, ?, ?, ?, ?)";
							 i=base.updateSql(sql, new Object[]{roomid,mealid,mealcount,mealprice,mealprice1,mealname,addorderid});
						}
		}
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 查询员工房间购物车
 */
public List selectTbEmpshop(String roomid) {
	BaseDAO base=new BaseDAO();
	String sql="SELECT * FROM EmpShop where room_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{roomid});
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * 后台删除empshop表
 */
public void deleteTbEmpshop(String mealid, String roomid) {
	BaseDAO base=new BaseDAO();
	String sql="DELETE FROM EmpShop WHERE room_id=? AND meal_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{roomid,mealid});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
/**
 * 修改购物车empshopbiao数量
 */
@Override
public int updateTbempshop(String mealid, String roomid, String mealcount) {
	BaseDAO base=new BaseDAO();
	String sql="UPDATE EmpShop SET count=? WHERE room_id=? AND meal_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{mealcount,roomid,mealid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 添加到empshop表，先查询empshop表内容
 */
public List selectAllTbempshop(String roomid) {
	BaseDAO base=new BaseDAO();
	String sql="select * from empshop where room_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{roomid});
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
@Override
/**
 * 删除empshop表
 */
public int deleteAllTbempshop(String roomid) {
	BaseDAO base=new BaseDAO();
	String sql="delete from empshop where room_id=?";
	int i;
	try {
		i = base.updateSql(sql, new Object[]{roomid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * empshop菜入订单
 */
public int EmpshopAddMeal(String roomid, List empshoplist) {
	BaseDAO base=new BaseDAO();
	int orderdetailid=0;
	String money=getempshopmoney(roomid);
	int orderid=0;
	try {
		if(empshoplist!=null&&empshoplist.size()>0){
			String sqlorder="insert into orders(room_id,order_date,order_count,money,state,pushfoodcount) values(?,now(),1,?,1,0);";
			orderid = base.insertSql(sqlorder, new Object[]{roomid,money});
				int j=1;
			for(int i=0;i<empshoplist.size();i++){
				Map map=(Map) empshoplist.get(i);
				String mealcount=map.get("count").toString();
				String mealid=map.get("meal_id").toString();
				String sql="insert into order_detail(order_id,meal_id,count,state) values(?,?,?,0);";
				orderdetailid=base.insertSql(sql, new Object[]{orderid,mealid,mealcount});
				if(checkhotmeal(mealid)){
					String sql2="update order_detail set rank=? where order_detail_id=?";
					base.updateSql(sql2, new Object[]{j,orderdetailid});
					StringBuffer cooksql=new StringBuffer();
					cooksql.append("insert into cook(order_id,meal_id,count,state,rank,order_detail_id)");
					//cooksql.append(" select a.order_id,a.meal_id,1,a.price,a.customer_id,a.state,a.rank from order_detail a");
					cooksql.append(" values(?,?,1,?,?,?)");
				for(int k=0;k<Integer.parseInt(mealcount);k++){	
						base.updateSql(cooksql.toString(), new Object[]{orderid,mealid,0,j,orderdetailid});
				}
					j++;
				}
			}
			
			return orderid;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return 0;
}
/**
 * 查菜状态热菜凉菜
 */
public boolean checkhotmeal(String mealid){
	BaseDAO base=new BaseDAO();
	String sql="select * from meal where meal_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{mealid});
		if(list!=null&&list.size()>0){
			Map map=(Map) list.get(0);
			String type=map.get("meal_type").toString();
			if(type.equals("热菜")){
				return true;
			}else {
				return false;
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}
public String getempshopmoney(String roomid){
	BaseDAO base=new BaseDAO();
	String sql="select * from(select sum(price)as money from empshop where room_id=?)a";
	try {
		List list=base.selectInfo(sql, new Object[]{roomid});
		if(list!=null&&list.size()>0){
			Map map=(Map) list.get(0);
			String money=map.get("money").toString();
			return money;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
@Override
/**
 * empshop表进行加菜
 */
public int EmpshopAddMeal2(String roomid, String addorderid, List empshoplist) {
	
	BaseDAO base=new BaseDAO();
	int orderdetailid=0;
	String money=getempshopmoney(roomid);
	try {
		if(empshoplist!=null&&empshoplist.size()>0){
			String sqlorder="UPDATE orders SET money=money+? WHERE order_id=?;";
			 int f=base.updateSql(sqlorder, new Object[]{money,addorderid});
				int j=1;
			for(int i=0;i<empshoplist.size();i++){
				Map map=(Map) empshoplist.get(i);
				String mealcount=map.get("count").toString();
				String mealid=map.get("meal_id").toString();
				String sql="insert into order_detail(order_id,meal_id,count,state) values(?,?,?,0);";
				orderdetailid=base.insertSql(sql, new Object[]{addorderid,mealid,mealcount});
				if(checkhotmeal(mealid)){
					String sql2="update order_detail set rank=? where order_detail_id=?";
					base.updateSql(sql2, new Object[]{j,orderdetailid});
					StringBuffer cooksql=new StringBuffer();
					cooksql.append("insert into cook(order_id,meal_id,count,state,rank,order_detail_id)");
					//cooksql.append(" select a.order_id,a.meal_id,1,a.price,a.customer_id,a.state,a.rank from order_detail a");
					cooksql.append(" values(?,?,1,?,?,?)");
				for(int k=0;k<Integer.parseInt(mealcount);k++){	
						base.updateSql(cooksql.toString(), new Object[]{addorderid,mealid,0,j,orderdetailid});
				}
					j++;
				}
			}
			
			return 1;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return 0;
}
@Override
/**
 * 判断是否全部上桌，该订单为2
 */
public int changeOrTo2(String orderid) {
	BaseDAO base=new BaseDAO();
	int i=0;
	String count=getDetailcount(orderid);
	String sql="select * from( select count(order_id)as count2 from order_detail where order_id=? and state=3)a";
	String sql2="UPDATE orders SET state=2 WHERE order_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{orderid});
		if(list!=null&&list.size()>0){
			Map map=(Map) list.get(0);
			String count2=map.get("count2").toString();
			if(count2.equals(count)){
				i=base.updateSql(sql2, new Object[]{orderid});
			}
			return i;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 通知结账
 */
public int calltopay(String orderid) {
	BaseDAO base=new BaseDAO();
	String sql="UPDATE orders SET `call`=1 WHERE order_id=?";
	try {
		int i=base.updateSql(sql, new Object[]{orderid});
		return i;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}
@Override
/**
 * 提示要求结账
 */
public String selectordercall(String orderid) {
	// TODO Auto-generated method stub
	BaseDAO base=new BaseDAO();
	String sql="select * from orders where order_id=?";
	try {
		List list=base.selectInfo(sql, new Object[]{orderid});
		if(list!=null&& list.size()>0){
			Map map=(Map) list.get(0);
			if(StringUtil.checkNotNull(map.get("call"))){
				String callstate=map.get("call").toString();	
				return callstate;
			}else{
				return null;
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
}
