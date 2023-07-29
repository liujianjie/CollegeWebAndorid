package com.dc.dao.cook;

import java.util.*;

import net.sf.json.JSONObject;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class cookDaoImpl implements cookDao{
		/**
		 * �������µ��ɹ����������鴫�͵����
		 * @return
		 */
		public List selectLianDish(){
			StringBuffer sql=new StringBuffer("");
			BaseDAO  base=new BaseDAO();
			sql.append("select a.*,b.meal_name,c.order_date from order_detail a ");
			sql.append(" join meal b on a.meal_id=b.meal_id ");
			sql.append(" join orders c on a.order_id=c.order_id ");
			sql.append(" where b.meal_type='����' and c.state=1 and (a.state=0 or a.state=2) ");
			try {
				List list=base.selectInfo(sql.toString(),null);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 0����δ��    2����������    1���������
		 * ��ʦ����һ���˵�һ����ɰ�ť�������޸�״̬,Ϊ0ʱ�Ǹ�Ϊ2��������Ϊ2���޸ĸ�Ϊ1�������
		 * ��������˵Ľ���
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
		 * ��ѯ����ɵĲ�Ʒ(����ɵ��Ȳ˺�����)
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
			sql.append(" where c.state=1 and a.state=1 and b.meal_type='����' ");
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
		 * չʾ��ʱ���ǰ��ܺϲ�һ������count��ʾ��һ�𣬲��ܺϲ˵Ĳ�һ��һ��չʾ����
		 * δ�����Ȳ�չʾ����(���ۺ������������)�ٽ��кϲ�(�˶��ʱ�����Ȳ�˳��)
		 */
		public List usFood(){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			try {
				sql.append(" select a.* from ");
				sql.append(" (select b.cook_id,b.count as cook_count,b.state as state2,a.* from ");
				sql.append(" (select a.һ��һ���˵�*3/10+����˳��*4/10+�߲�˳��*3/10 as countshun,a.*");
				sql.append(" from(");
				sql.append(" select b.meal_name,b.meal_compose,(�����в�����-(d.rank-1))/�����в�����*10 as һ��һ���˵�,");
				sql.append(" (o.�ܶ�����-�к�)/o.�ܶ�����*10 as ����˳��,�߲�˳��,�����в�����,");
				sql.append(" d.* from order_detail d join");
				sql.append(" (select a.*,@rownum:=@rownum+1 as �к�  from ");
				sql.append(" (select a.rowcount as �ܶ�����,c.order_date,e.foodcount as �����в�����,c.order_id,");
				sql.append(" case when c.pushfoodcount is null then 0");
				sql.append(" when c.pushfoodcount=0 then 0");
				sql.append(" when c.pushfoodcount=1 then 4");
				sql.append(" when c.pushfoodcount=2 then 7");
				sql.append(" when c.pushfoodcount>=3 then 10");
				sql.append(" end as �߲�˳�� from orders c,");
				sql.append(" (select count(a.order_id) as rowcount from orders a where a.state=1) a,");
								/*���������ѽӵ����ܶ�����*/
				sql.append(" (select count(*) as foodcount,e.order_id from order_detail e");
				sql.append(" join meal b on e.meal_id=b.meal_id");
				sql.append(" where b.meal_type='�Ȳ�' group by  e.order_id) e");
										/*���㶩����������Ȳ˵�rank�������(������û��)*/
				sql.append(" where c.order_id=e.order_id");
				sql.append(" order by  c.order_date");
				sql.append(" ) a,(select @rownum:=-1) b");
				sql.append(" ) o on o.order_id=d.order_id");
				sql.append(" join meal b on d.meal_id=b.meal_id");
				sql.append(" where b.meal_type='�Ȳ�' ");
				sql.append(" )a");
				sql.append(" ORDER BY a.һ��һ���˵�*3/10+����˳��*4/10+�߲�˳��*3/10 DESC");
				/* �����ۺ�����*/
				/*ORDER BY a.һ��һ���˵� DESC*/
				/*����һ����һ���˵���*/
				sql.append(" ) a ");
				sql.append(" join cook b on a.order_detail_id=b.order_detail_id");
				sql.append(" where b.state=0 or b.state=2");
				sql.append(" ) a");
				sql.append(" ORDER BY a.countshun DESC");
				
				//( list2 ) ���ǽ������2---cook������Ұ��ղ�������
				List list2=base.selectInfo(sql.toString(),null);
				
				List<String> list3=new ArrayList();		//��������еĲ�����
				
				List list4=new ArrayList();		//��������еĺϲ�˳��
				
				if(list2!=null&&list2.size()>0){
						for(int i=0;i<list2.size();i++){
							Map map=(Map) list2.get(i);
							String mealid=map.get("meal_id").toString();
							String cookid=map.get("cook_id").toString();
							boolean state=false;
							
							//   ��if���в����Ƿ���ͬ���ж�
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
										
										//�ж��Ƿ��ܺϲ˲��Ҹ��ϲ˼�һ�������ֵ����
										if(mealid3.equals(mealid) && count<3 && compose.equals("��")){
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
								list3.add(mealid);		//��һ�����ݵĲ�idֱ�ӷŽ���
								list4.add(map);			//list2�����еĵ�һ��������������list4�У�list4�ǽ�Ҫ���ص����Ȳ˵Ľ���
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
		 * 0����δ��    2����������    1���������
		 * ��ʦ����һ���˵�һ����ɰ�ť�������޸�״̬,Ϊ0ʱ�Ǹ�Ϊ2��������Ϊ2���޸ĸ�Ϊ1�������
		 * ���Ƕ��Ȳ�����ʱ���޸��Ȳ˵�״̬(�˶��ʱ��)
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
				
				//�Ƚ����ж���orders����Ϊ1��(���������ѽӵ��Ķ���ɸѡ��)��������list��(ֻ���Ȳ�)
				StringBuffer sql2=new StringBuffer("");
				sql2.append(" select a.order_detail_id from order_detail a ");
				sql2.append(" join orders b on a.order_id=b.order_id ");
				sql2.append(" join meal c on a.meal_id=c.meal_id ");
				sql2.append(" where b.state=1 and c.meal_type='�Ȳ�' and a.state=0 ");
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
		 * δ�����Ȳ�չʾ����(���ٵ�ʱ�����Ȳ�˳��(����Ҳ�кϲ�))һ������ȫ������������һ������
		 * @return
		 */
		public List dishFewPeople(){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" select a.*,b.meal_compose,b.meal_name,c.order_date from cook a");
			sql.append(" join meal b on a.meal_id=b.meal_id ");
			sql.append(" join orders c on a.order_id=c.order_id");
			sql.append(" where b.meal_type='�Ȳ�' and (a.state=0 or a.state=2) and c.state=1");
			sql.append(" ORDER BY c.order_date ASC");
			try {
				//( list2 ) ���ǽ������2---cook������Ұ��ղ�������
				List list2=base.selectInfo(sql.toString(),null);
				
				List<String> list3=new ArrayList();		//��������еĲ�����
				
				List list4=new ArrayList();		//��������еĺϲ�˳��
				
				if(list2!=null&&list2.size()>0){
						for(int i=0;i<list2.size();i++){
							Map map=(Map) list2.get(i);
							String mealid=map.get("meal_id").toString();
							String cookid=map.get("cook_id").toString();
							boolean state=false;
							
							//   ��if���в����Ƿ���ͬ���ж�
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
										
										//�ж��Ƿ��ܺϲ˲��Ҹ��ϲ˼�һ�������ֵ����
										if(mealid3.equals(mealid) && count<3 && compose.equals("��")){
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
								list3.add(mealid);		//��һ�����ݵĲ�idֱ�ӷŽ���
								list4.add(map);			//list2�����еĵ�һ��������������list4�У�list4�ǽ�Ҫ���ص����Ȳ˵Ľ���
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
