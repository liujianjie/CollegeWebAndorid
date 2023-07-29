package com.dc.dao.predetermine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class PredetermineDaoImpI implements PredetermineDao{
		/**
		 * ��̨������Ԥ���ķ������У����Խ��ж��ѡ�񣩲�ѯ
		 * @return
		 */
		public List findLineRoom(Map map,PageEntity page){
			StringBuffer sql=new StringBuffer("");
			sql.append("");
			sql.append(" select a.*,b.customer_name,b.customer_phone,c.room_number,c.room_state,c.room_type,c.peo_count from predetermine a ");
			sql.append(" LEFT JOIN customer b on  a.customer_id=b.customer_id ");
			sql.append(" join room c on a.room_id=c.room_id ");
			sql.append(" where 1=1 ");
			if(StringUtil.checkNotNull(map.get("customername"))){
				String customername=map.get("customername").toString();
				sql.append(" and (b.customer_name like '%"+customername+"%' or a.pre_customer like '%"+customername+"%') ");
			}
			if(StringUtil.checkNotNull(map.get("roomnumber"))){
				String roomnumber=map.get("roomnumber").toString();
				sql.append(" and c.room_number like '%"+roomnumber+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("preline"))){
				String preline=map.get("preline").toString();
				sql.append(" and a.pre_line like '%"+preline+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("customerphone"))){
				String customerphone=map.get("customerphone").toString();
				sql.append(" and (b.customer_phone like '%"+customerphone+"%' or a.pre_phone like '%"+customerphone+"%') ");
			}
			if(StringUtil.checkNotNull(map.get("predate"))){
				String predate=map.get("predate").toString();
				sql.append(" and a.pre_date like '%"+predate+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("roomtype"))){
				String roomtype=map.get("roomtype").toString();
				sql.append(" and c.room_type like '%"+roomtype+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("preframe"))){
				String preframe=map.get("preframe").toString();
				sql.append(" and a.pre_frame like '%"+preframe+"%' ");
			}
			sql.append(" ORDER BY a.pre_time DESC ");
			PageUtil pageutil=new PageUtil();
			pageutil.setpageinfo(sql, page);
			return page.getPagelist();
		}
		/**
		 * Ա������Ԥ�����ŶԹ˿�ȡ��Ԥ��
		 * @param preid
		 */
		public void empCancelCustomerRoom(String preid){
			StringBuffer sql=new StringBuffer("");
			sql.append(" update predetermine a set a.pre_state=? where a.pre_id=? ");
			BaseDAO base=new BaseDAO();
			try {
				base.updateSql(sql.toString(),new Object[]{"Ԥ����ȡ��",preid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 
		 * �ú�̨���Խ������������Ĳ�ѯ����״̬�����źͷ�����Ϣ
		 * @return
		 */
		public List findEmptyRoom(Map map,PageEntity page){
			StringBuffer sql=new StringBuffer("");
			sql.append(" select a.room_number,a.peo_count,a.room_state,a.room_type from room a");
			sql.append(" where 1=1 ");
			BaseDAO base=new BaseDAO();
			if(StringUtil.checkNotNull(map.get("state"))){
				String state=map.get("state").toString();
				sql.append(" and room_state like '%"+state+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("roomnumber"))){
				String roomnumber=map.get("roomnumber").toString();
				sql.append(" and a.room_number like '%"+roomnumber+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("peocount"))){
				String peocount=map.get("peocount").toString();
				sql.append(" and a.peo_count like '%"+peocount+"%' ");
			}
			if(StringUtil.checkNotNull(map.get("type"))){
				String type=map.get("type").toString();
				sql.append(" and room_type like '%"+type+"%' ");
			}
			PageUtil pageUtil=new PageUtil();
			pageUtil.setpageinfo(sql, page);
			return page.getPagelist();
		}
		/**
		 * ������������
		 * @return
		 * 
		 */
		public void insertRoom(String roomnumber,String peocount,String roomtype){
			String sql="insert into room(room_number,room_state,peo_count,room_type)values(?,'����',?,?)";
			BaseDAO base=new BaseDAO();
			try {
				base.updateSql(sql,new Object[]{roomnumber,peocount,roomtype});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ����������Ž���Ψһ��У��
		 * @return
		 * 
		 */
		public Map checkRoom(String roomnumber){
			String sql="select * from room where room_number=?";
			BaseDAO base=new BaseDAO();
			try {
				List list=base.selectInfo(sql,new Object[]{roomnumber});
				if(list!=null&&list.size()>0){
					Map map=(Map) list.get(0);
					return map;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * �˿�ѡ��Ԥ�����ڴ�ǰ̨���������в�ѯ�������п���Ԥ���ķ�����Ϣ
		 * @return
		 */
		public List selectRoom(String peocount,String roomtype,String predate,String preframe){
			StringBuffer sql=new StringBuffer("");
			sql.append("select b.room_number,b.room_type,b.peo_count,b.room_id from room b where  ");
			if(StringUtil.checkNotNull(peocount)){
				sql.append(" b.peo_count like '%"+peocount+"%' and ");
			}
			if(StringUtil.checkNotNull(roomtype)){
				sql.append(" b.room_type like '%"+roomtype+"%' and ");
			}
			sql.append(" b.room_id not in( ");
			sql.append(" select a.room_id from predetermine a ");
			sql.append(" where a.pre_date=? and a.pre_frame=? and a.pre_state='����Ԥ��') ");
			BaseDAO base=new BaseDAO();
			try {
				List list=base.selectInfo(sql.toString(),new Object[]{predate,preframe});
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * �˿���Ԥ�����ŵ�
		 * @return
		 */
		public void insertPreterMine(String customerid,String roomid,String predate,String preframe){
			String sql="insert into predetermine(customer_id,room_id,pre_time,pre_date,pre_frame,pre_state,pre_line)values(?,?,now(),?,?,'����Ԥ��','����')";
			BaseDAO base=new BaseDAO();
			try {
				base.updateSql(sql,new Object[]{customerid,roomid,predate,preframe});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ���ݹ˿�id��ѯ����Ԥ����Ϣ
		 * @return
		 */
		public List selectCustomer(String customerid){
			StringBuffer sql=new StringBuffer("");
			sql.append("select a.*,b.*,c.* ");
			sql.append(" from predetermine a ");
			sql.append(" join customer b on a.customer_id=b.customer_id ");
			sql.append(" join room c on a.room_id=c.room_id ");
			sql.append(" where b.customer_id=? ORDER BY pre_time DESC ");
			BaseDAO base=new BaseDAO();
			try {
				List list=base.selectInfo(sql.toString(),new Object[]{customerid});
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * �˿͸����Լ�Ԥ����id����ȡ��Ԥ�����ŵ�
		 * @return
		 */
		public void cansel(String preid){
			String sql="update predetermine a set a.pre_state=? where a.pre_id=?";
			BaseDAO base=new BaseDAO();
			try {
				base.updateSql(sql,new Object[]{"Ԥ����ȡ��",preid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ��̨Ա����Ԥ������������ʾ����
		 * @return
		 */
		public List empFindReserveRoom(String peocount,String roomtype,String predate,String preframe){
			StringBuffer sql=new StringBuffer("");
			sql.append("select b.room_number,b.room_type,b.peo_count,b.room_id from room b where  ");
			if(StringUtil.checkNotNull(peocount)){
				sql.append(" b.peo_count like '%"+peocount+"%' and ");
			}
			if(StringUtil.checkNotNull(roomtype)){
				sql.append(" b.room_type like '%"+roomtype+"%' and ");
			}
			sql.append(" b.room_id in( ");
			sql.append(" select a.room_id from predetermine a ");
			sql.append(" where a.pre_date=? and a.pre_frame=? and a.pre_state='����Ԥ��') ");
			BaseDAO base=new BaseDAO();
			try {
				List list=base.selectInfo(sql.toString(),new Object[]{predate,preframe});
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * Ա�����һ���˿͵�Ԥ��������Ϣ
		 *
		 */
		public void empInsertPreterMine(String roomid,String predate,String preframe,String precustomer,String prephone){
			StringBuffer sql=new StringBuffer("");
			sql.append("insert into predetermine ");
			sql.append(" (room_id,pre_time,pre_date,pre_frame,pre_state,pre_customer,pre_phone,pre_line) ");
			sql.append(" values(?,now(),?,?,'����Ԥ��',?,?,'��̨') ");
			BaseDAO base=new BaseDAO();
			try {
				base.updateSql(sql.toString(),new Object[]{roomid,predate,preframe,precustomer,prephone});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ����ʱ��ʾ��������״̬
		 * @return
		 */
		public List openFindRoom(String roomnumber){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" select a.room_id,a.room_number,a.peo_count,a.room_state,a.room_type from room a");
			sql.append(" where 1=1 ");
			if(StringUtil.checkNotNull(roomnumber)){
				sql.append(" and a.room_number like '%"+roomnumber+"%' ");
			}
			try {
				List list=base.selectInfo(sql.toString(),null);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * �������޸ĸ÷����״̬
		 * @param roomid
		 */
		public void updateOpenRoom(String roomid){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" update room set room_state=? where room_id=? ");//ִ���޸ķ����״̬
			try {
				base.updateSql(sql.toString(),new Object[]{"ʹ����",roomid});
				StringBuffer sql2=new StringBuffer("");
				//ִ���޸�Ԥ�����״̬���������������Ԥ������ô�����Ԥ�����˿����Ϳ��Խ�������Ԥ������Ϊ��Ԥ����ɡ�
				sql2.append(" update predetermine set pre_state=? where room_id=? and pre_state='����Ԥ��' ");
				base.updateSql(sql2.toString(),new Object[]{"Ԥ�����",roomid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ����ʹ�ú�ĳɴ�ɨ�е�״̬
		 * @param roomid
		 */
		public void recoverOpenRoom(String roomid){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" update room set room_state=? where room_id=? ");
			try {
				base.updateSql(sql.toString(),new Object[]{"��ɨ��",roomid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ��ɨ��ɺ�ָ��ɿ���״̬
		 * @param roomid
		 */
		public void huifuOpenRoom(String roomid){
			BaseDAO base=new BaseDAO();
			StringBuffer sql=new StringBuffer("");
			sql.append(" update room set room_state=? where room_id=? ");
			try {
				base.updateSql(sql.toString(),new Object[]{"����",roomid});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ����ʱ����ǰʱ��ε�Ԥ����id�����
		 * @return
		 */
		public List yudingOpenRoom(){
			BaseDAO base=new BaseDAO();
			Date date=new Date();
			SimpleDateFormat dateformat1=new SimpleDateFormat("HH");
			int hour=Integer.parseInt(dateformat1.format(date));
			if(hour<12){
				
				// Ԥ��ʱ��Ϊ11:00-14:00ʱ��(Ԥ��״̬��ʾ��Ԥ����ʼ��1Сʱ��Ͳ�����ʾ��)����12���Ժ�û�б�Ԥ�����κ���Ϣ
				
				StringBuffer sql=new StringBuffer("");
				sql.append(" select a.room_id,b.*,a.pre_customer from predetermine a ");
				sql.append(" left join customer b on b.customer_id=a.customer_id ");
				sql.append(" where a.pre_date=curdate() and a.pre_state='����Ԥ��' and a.pre_frame='11:00-14:00' ");
				try {
					List list = base.selectInfo(sql.toString(), null);
					return list;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}else if(hour>=14&&hour<18){
				
				// Ԥ��ʱ��Ϊ17:00-20:00ʱ��(Ԥ��״̬��ʾ��Ԥ����ʼ��1Сʱ��Ͳ�����ʾ��)����18���Ժ�û�б�Ԥ�����κ���Ϣ
				
				StringBuffer sql=new StringBuffer("");
				sql.append(" select a.room_id,b.customer_name,a.pre_customer from predetermine a ");
				sql.append(" left join customer b on b.customer_id=a.customer_id ");
				sql.append(" where a.pre_date=curdate() and a.pre_state='����Ԥ��' and a.pre_frame='17:00-20:00' ");
				try {
					List list = base.selectInfo(sql.toString(), null);
					return list;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}else{
				return null;
			}
		}
		/**
		 * ��ʱ���Զ�ִ�и��޸����Ӷ�����Щ����Ԥ������δ��ס��"����Ԥ��"�ĳ�"Ԥ����ʱû��"
		 */
		public void dingShiPredetermine(){
			BaseDAO base=new BaseDAO();
			Date date=new Date();
			SimpleDateFormat dateformat1=new SimpleDateFormat("HH");
			int hour=Integer.parseInt(dateformat1.format(date));
			if(hour<=14){
				
				//��ѯ���쵱ǰʱ��С��14��
				
				StringBuffer sql=new StringBuffer("");
				sql.append(" select * from predetermine where pre_date=curdate() ");
				sql.append(" and pre_frame='11:00-14:00' and pre_state='����Ԥ��' ");
				try {
					List list = base.selectInfo(sql.toString(),null);
					if(hour>=12){
						for(int i=0;i<list.size();i++){
							Map map=(Map) list.get(i);
							StringBuffer sql2=new StringBuffer("");
							sql2.append(" update predetermine set pre_state='Ԥ����ʱû��' where room_id=? and pre_date=curdate()");
							base.updateSql(sql2.toString(),new Object[]{map.get("room_id")});
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(hour>=14){
				StringBuffer sql=new StringBuffer("");
				sql.append(" select * from predetermine where pre_date=curdate() ");
				sql.append(" and pre_frame='17:00-20:00' and pre_state='����Ԥ��' ");
				try {
					List list = base.selectInfo(sql.toString(),null);
					if(hour>=18){
						for(int i=0;i<list.size();i++){
							Map map=(Map) list.get(i);
							StringBuffer sql2=new StringBuffer("");
							sql2.append(" update predetermine set pre_state='Ԥ����ʱû��' where room_id=? and pre_date=curdate() ");
							base.updateSql(sql2.toString(),new Object[]{map.get("room_id")});
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
}
