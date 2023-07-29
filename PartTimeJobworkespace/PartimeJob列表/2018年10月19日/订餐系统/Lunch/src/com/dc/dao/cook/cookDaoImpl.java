package com.dc.dao.cook;

import java.util.*;

import net.sf.json.JSONObject;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class cookDaoImpl implements cookDao{
		/**
		 * 将所有下单成功的凉菜详情传送到后厨
		 * @return
		 */
		public List selectLianDish(){
			StringBuffer sql=new StringBuffer("");
			BaseDAO  base=new BaseDAO();
			sql.append("select a.*,b.meal_name,c.order_date from order_detail a ");
			sql.append(" join meal b on a.meal_id=b.meal_id ");
			sql.append(" join orders c on a.order_id=c.order_id ");
			sql.append(" where b.meal_type='凉菜' and c.state=1 and (a.state=0 or a.state=2) ");
			try {
				List list=base.selectInfo(sql.toString(),null);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 0代表未做    2代表正在做    1代表已完成
		 * 厨师做完一道菜点一次完成按钮，进行修改状态,为0时是改为2正在做，为2做修改改为1是已完成
		 * 完成做凉菜的界面
		 * @param orderdetailid
		 */
		public void finishDishLian(String orderdetailid,String state){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			if(StringUtil.checkNotNull(state)){
				if(state.equals("2")){
					sql.append(" update order_detail a set a.state=1 where a.order_detail_id=? ");
				}
			}
			if(StringUtil.checkNotNull(state)){
				if(state.equals("0")){
					sql.append(" update order_detail a set a.state=2 where a.order_detail_id=? ");
				}
			}
			try {
				base.updateSql(sql.toString(),new Object[]{orderdetailid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 查询已完成的菜品(已完成的热菜和凉菜)
		 * @return
		 */
		public List selectFinishDish(){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" SELECT e.*,f.room_number,f.room_type from ");
			sql.append(" (select a.cook_id,a.meal_id,a.count,a.state,b.meal_type,b.meal_compose,b.meal_name,");
			sql.append(" a.rank,c.room_id,c.order_date,c.state as state2,d.customer_name,d.customer_id");
			sql.append(" from cook a ");
			sql.append(" join meal b on a.meal_id=b.meal_id");
			sql.append(" RIGHT JOIN orders c on a.order_id=c.order_id");
			sql.append(" left join customer d on d.customer_id=c.customer_id");
			sql.append(" where c.state=1 and a.state=1");
			sql.append(" ORDER BY a.rank desc,a.rank desc ");
			sql.append(" ) e");
			sql.append(" left join room f on f.room_id=e.room_id");
			sql.append(" UNION");
			sql.append(" SELECT e.*,f.room_number,f.room_type from");
			sql.append(" (select 'cook_id',a.meal_id,a.count,a.state,b.meal_type,b.meal_compose,b.meal_name,");
			sql.append(" a.rank,c.room_id,c.order_date,c.state as state2,d.customer_name,d.customer_id ");
			sql.append(" from order_detail a ");
			sql.append(" join meal b on a.meal_id=b.meal_id ");
			sql.append(" RIGHT JOIN orders c on a.order_id=c.order_id ");
			sql.append(" left join customer d on d.customer_id=c.customer_id ");
			sql.append(" where c.state=1 and a.state=1 and b.meal_type='凉菜' ");
			sql.append(" ORDER BY a.rank desc,a.rank desc");
			sql.append(" ) e");
			sql.append(" left join room f on f.room_id=e.room_id");
			try {
				List list=base.selectInfo(sql.toString(),null);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 
		 * 展示的时候是把能合菜一起做的count显示在一起，不能合菜的菜一条一条展示出来
		 * 未做的热菜展示界面(将综合排序放入这里)再进行合菜(人多的时候做热菜顺序)
		 */
		public List usFood(){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			try {
				sql.append(" select a.* from ");
				sql.append(" (select b.cook_id,b.count as cook_count,b.state as state2,a.* from ");
				sql.append(" (select a.一桌一个菜的*3/10+订单顺序*4/10+催菜顺序*3/10 as countshun,a.*");
				sql.append(" from(");
				sql.append(" select b.meal_name,b.meal_compose,(订单中菜数量-(d.rank-1))/订单中菜数量*10 as 一桌一个菜的,");
				sql.append(" (o.总订单数-行号)/o.总订单数*10 as 订单顺序,催菜顺序,订单中菜数量,");
				sql.append(" d.* from order_detail d join");
				sql.append(" (select a.*,@rownum:=@rownum+1 as 行号  from ");
				sql.append(" (select a.rowcount as 总订单数,c.order_date,e.foodcount as 订单中菜数量,c.order_id,");
				sql.append(" case when c.pushfoodcount is null then 0");
				sql.append(" when c.pushfoodcount=0 then 0");
				sql.append(" when c.pushfoodcount=1 then 4");
				sql.append(" when c.pushfoodcount=2 then 7");
				sql.append(" when c.pushfoodcount>=3 then 10");
				sql.append(" end as 催菜顺序 from orders c,");
				sql.append(" (select count(a.order_id) as rowcount from orders a where a.state=1) a,");
								/*计算所有已接单的总订单数*/
				sql.append(" (select count(*) as foodcount,e.order_id from order_detail e");
				sql.append(" join meal b on e.meal_id=b.meal_id");
				sql.append(" where b.meal_type='热菜' group by  e.order_id) e");
										/*计算订单详情表中热菜的rank的最大数(不管做没做)*/
				sql.append(" where c.order_id=e.order_id");
				sql.append(" order by  c.order_date");
				sql.append(" ) a,(select @rownum:=-1) b");
				sql.append(" ) o on o.order_id=d.order_id");
				sql.append(" join meal b on d.meal_id=b.meal_id");
				sql.append(" where b.meal_type='热菜' ");
				sql.append(" )a");
				sql.append(" ORDER BY a.一桌一个菜的*3/10+订单顺序*4/10+催菜顺序*3/10 DESC");
				/* 这是综合排序*/
				/*ORDER BY a.一桌一个菜的 DESC*/
				/*这是一个桌一个菜的上*/
				sql.append(" ) a ");
				sql.append(" join cook b on a.order_detail_id=b.order_detail_id");
				sql.append(" where b.state=0 or b.state=2");
				sql.append(" ) a");
				sql.append(" ORDER BY a.countshun DESC");
				
				//( list2 ) 就是将详情表2---cook查出并且按照菜名排序
				List list2=base.selectInfo(sql.toString(),null);
				
				List<String> list3=new ArrayList();		//里面放所有的菜名。
				
				List list4=new ArrayList();		//里面放所有的合菜顺序。
				
				if(list2!=null&&list2.size()>0){
						for(int i=0;i<list2.size();i++){
							Map map=(Map) list2.get(i);
							String mealid=map.get("meal_id").toString();
							String cookid=map.get("cook_id").toString();
							boolean state=false;
							
							//   该if进行菜名是否相同的判断
							if(list3!=null&&list3.size()>0){		
									for(int j=0;j<list3.size();j++){
										String mealid2=list3.get(j);
										if(mealid2.equals(mealid)){
											state=true;
											break;
										}
									}
									if(state==false){
										list3.add(mealid);
									}
									state=false;
									for(int z=0;z<list4.size();z++){
										Map map2=(Map) list4.get(z);
										String mealid3=map2.get("meal_id").toString();
										int count=Integer.parseInt(map2.get("cook_count").toString());
										String compose=map2.get("meal_compose").toString();
										
										//判断是否能合菜并且给合菜加一个最高数值限制
										if(mealid3.equals(mealid) && count<3 && compose.equals("能")){
											String cookid2=map2.get("cook_id").toString();
											count+=1;
											cookid=cookid+"-"+cookid2;
											map2.put("cook_count",count);
											map2.put("cook_id",cookid);
											state=true;
											break;
										}
									}
									if(state==false){
										list4.add(map);
									}
								
							}else{
								list3.add(mealid);		//第一条数据的菜id直接放进来
								list4.add(map);			//list2集合中的第一条数据整条放入list4中，list4是将要返回到做热菜的界面
							}
							
						}
						return list4;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 0代表未做    2代表正在做    1代表已完成
		 * 厨师做完一道菜点一次完成按钮，进行修改状态,为0时是改为2正在做，为2做修改改为1是已完成
		 * 这是对热菜做的时候修改热菜的状态(人多的时候)
		 * @param state
		 * @param cookid
		 */
		public void finishRe(String state,String cookid){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			String[] str=cookid.split("-");
			if(StringUtil.checkNotNull(state)){
				if(state.equals("0")){
					sql.append(" update cook a set a.state=2 where a.cook_id=? ");
				}
			}
			if(StringUtil.checkNotNull(state)){
				if(state.equals("2")){
					sql.append(" update cook a set a.state=1 where a.cook_id=? ");
				}
			}
			try {
				for(int i=0;i<str.length;i++){
					base.updateSql(sql.toString(),new Object[]{str[i]});
				}
				
				//先将所有订单orders表中为1的(就是所有已接单的订单筛选出)，遍历到list中(只管热菜)
				StringBuffer sql2=new StringBuffer("");
				sql2.append(" select a.order_detail_id from order_detail a ");
				sql2.append(" join orders b on a.order_id=b.order_id ");
				sql2.append(" join meal c on a.meal_id=c.meal_id ");
				sql2.append(" where b.state=1 and c.meal_type='热菜' and a.state=0 ");
				List list=base.selectInfo(sql2.toString(),null);
				StringBuffer sql3=new StringBuffer("");
				sql3.append(" select * from cook a where a.order_detail_id=? and (a.state=0 or a.state=2) ");
				for(int i=0;i<list.size();i++){
					Map map=(Map) list.get(i);
					List list2=base.selectInfo(sql3.toString(),new Object[]{map.get("order_detail_id")});
					if(list2.isEmpty()){
						StringBuffer sql4=new StringBuffer("");
						sql4.append("UPDATE order_detail a set a.state=1 where a.order_detail_id=? ");
						base.updateSql(sql4.toString(),new Object[]{map.get("order_detail_id")});
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 未做的热菜展示界面(人少的时候做热菜顺序(里面也有合菜))一个订单全部做完再做下一个订单
		 * @return
		 */
		public List dishFewPeople(){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" select a.*,b.meal_compose,b.meal_name,c.order_date from cook a");
			sql.append(" join meal b on a.meal_id=b.meal_id ");
			sql.append(" join orders c on a.order_id=c.order_id");
			sql.append(" where b.meal_type='热菜' and (a.state=0 or a.state=2) and c.state=1");
			sql.append(" ORDER BY c.order_date ASC");
			try {
				//( list2 ) 就是将详情表2---cook查出并且按照菜名排序
				List list2=base.selectInfo(sql.toString(),null);
				
				List<String> list3=new ArrayList();		//里面放所有的菜名。
				
				List list4=new ArrayList();		//里面放所有的合菜顺序。
				
				if(list2!=null&&list2.size()>0){
						for(int i=0;i<list2.size();i++){
							Map map=(Map) list2.get(i);
							String mealid=map.get("meal_id").toString();
							String cookid=map.get("cook_id").toString();
							boolean state=false;
							
							//   该if进行菜名是否相同的判断
							if(list3!=null&&list3.size()>0){		
									for(int j=0;j<list3.size();j++){
										String mealid2=list3.get(j);
										if(mealid2.equals(mealid)){
											state=true;
											break;
										}
									}
									if(state==false){
										list3.add(mealid);
									}
									state=false;
									for(int z=0;z<list4.size();z++){
										Map map2=(Map) list4.get(z);
										String mealid3=map2.get("meal_id").toString();
										int count=Integer.parseInt(map2.get("count").toString());
										String compose=map2.get("meal_compose").toString();
										
										//判断是否能合菜并且给合菜加一个最高数值限制
										if(mealid3.equals(mealid) && count<3 && compose.equals("能")){
											String cookid2=map2.get("cook_id").toString();
											count+=1;
											cookid=cookid+"-"+cookid2;
											map2.put("count",count);
											map2.put("cook_id",cookid);
											state=true;
											break;
										}
									}
									if(state==false){
										list4.add(map);
									}
								
							}else{
								list3.add(mealid);		//第一条数据的菜id直接放进来
								list4.add(map);			//list2集合中的第一条数据整条放入list4中，list4是将要返回到做热菜的界面
							}
							
						}
						return list4;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
