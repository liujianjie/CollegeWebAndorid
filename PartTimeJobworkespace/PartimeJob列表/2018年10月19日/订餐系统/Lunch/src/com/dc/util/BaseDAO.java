package com.dc.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
/**
 * ���߰�����������ݿ⽻����
 * @author ��ʦ�ü����
 *����
 */
public class BaseDAO {
	//public static String url="jdbc:sqlserver://localhost:1433;databasename=dealline";
	//public static String user="sa";
	//public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";


	public static String password="123456";
	public static String url="jdbc:mysql://localhost:3306/dealonline?useUnicode=true&characterEncoding=utf-8";

	public static String user="root";
	public static String driver="com.mysql.jdbc.Driver";
	
	private Connection conn;
	private PreparedStatement pst;//
	private ResultSet rs;
	
	static{
		try {
			//������ṹ����
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	/**
	 * �������޸ġ�ɾ����ֻ����Ӱ������
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int updateSql(String sql,Object[] obj) throws Exception{
		try {
			//��ȡpreparedStatement Ԥ��sql��ִ�ж������sql�Ǻ��У�
			//update set age=?
			//���û�У�����Ҫ�����������������Ҫ��obj���ݽ��д�����
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			/*for(Object o:obj){
				System.out.println(o+"33");
			}*/
			int count = pst.executeUpdate();//ִ��sql������Ӱ������
			return count;
			
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
		
	}
	/**
	 * �������޸ġ�ɾ����ֻ����Ӱ������
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int updateSql2(String sql,Object... obj) throws Exception{
		try {
			//��ȡpreparedStatement Ԥ��sql��ִ�ж������sql�Ǻ��У�
			//update set age=?
			//���û�У�����Ҫ�����������������Ҫ��obj���ݽ��д�����
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			int count = pst.executeUpdate();//ִ��sql������Ӱ������
			return count;
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
	}
	/**
	 * �����ɹ��󷵻�����
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int insertSql(String sql,Object[] obj) throws Exception{
		try {
			//��ȡpreparedStatement Ԥ��sql��ִ�ж������sql�Ǻ��У�
			//update set age=?
			//���û�У�����Ҫ�����������������Ҫ��obj���ݽ��д�����
			pst = this.getConnection().prepareStatement(sql,pst.RETURN_GENERATED_KEYS);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			int count = pst.executeUpdate();//ִ��sql������Ӱ������
			rs=pst.getGeneratedKeys();//ֻ��һ��һ��
			if(rs.next()){
				return rs.getInt(1);//����ʱ����
			}
			return -1;
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
	}
	/**
	 * ��ѯ
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<HashMap> selectInfo(String sql,Object[] obj) throws Exception {
		try {
			//����sql���
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData biaojiegou = rs.getMetaData();
			int count = biaojiegou.getColumnCount();//��ȡ����
			List list = new ArrayList();//���ڽ������ݲ鵽�����ж���
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					Object liezhi = rs.getObject(i);
					String lieming = biaojiegou.getColumnName(i);
					map.put(lieming, liezhi);
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
	}
	/**
	 * ��ѯ,����һ����ṹ��������ʶ�Ҳ�ѯ��������װ��ʲô��ʽ
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<HashMap> selectInfo(String sql,Object[] obj,Class cla) throws Exception {
		try {
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData biaojiegou = rs.getMetaData();
			int count = biaojiegou.getColumnCount();//��ȡ����
			List list = new ArrayList();//���ڽ������ݲ鵽�����ж���
			while (rs.next()) {
				//newInstance����һ��������ʵ���൱�ڸ���ģ�忽������һ������
				//���ʱ�������û�ж������൱��ֱ��New  Object��
				Object objTemp=cla.newInstance();//ÿһ�ж���һ������
				//���ڲ�֪��Object����Щ��Ա������������Ҫͨ��cla�����ȡ��Ա������
				//��Ա�������ֺ����ݿ���ֶ�����Ӧ������Сд���ݿⲻ̫ȷ�����ҿ���ͳһת��Сд��_ȥ����
				//���ݳ�Ա��������ȡ��Ա�������󣬲�Ϊ�丳ֵ
				
				//��objTemp�����з���ֵ
				//�Ȼ�ȡ����(ѭ���л�ȡ����)
				for(int i=1;i<=count;i++){
					//����תСд����ȥ���»���
					String lieming=biaojiegou.getColumnName(i).toLowerCase().replace("_", "");
					Object liezhi=rs.getObject(i);
					//����������ȡFiled
					Field f=cla.getDeclaredField(lieming);//��Ա�������ֺ����ݿ��ֶ�����Ӧ������_ȥ��
				    f.setAccessible(true);
				    String lieType= f.getType().getName();
				    if(lieType.equals("int")){//����ҵ�ǰ��Ա������int����
				    	if(liezhi!=null){
				    		f.set(objTemp, Integer.parseInt(liezhi.toString()));
				    	}else{
				    		//��ֵΪ��
				    		f.set(objTemp, 0);
				    	}
				    }else if(lieType.equals("java.util.Timestamp")){
				    	Timestamp date=(Timestamp) liezhi;
				    	f.set(objTemp, date);
				    }else{
				    	f.set(objTemp, liezhi);
				    }
				    
				   // 
				}
				
				list.add(objTemp);
			}
			return list;
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
	}
	/*public class PreparedStatement{
		ResultSet generatedKeys;
		prepareStatement(?){
			
		}
		prepareStatement(?,?){
			generatedKeys=?
		}
		executeUpdate(){
		   update---
		   select * 
		   generatedKeys=resultset;
		}
		getGeneratedKeys{
			return generatedKeys;
		}
		
	}*/
	 
	public void close(){
		try {
			if (conn != null)
				conn.close();
			if (pst != null)
				pst.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
}
