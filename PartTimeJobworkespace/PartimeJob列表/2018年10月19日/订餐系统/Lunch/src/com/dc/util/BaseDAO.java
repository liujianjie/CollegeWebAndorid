package com.dc.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
/**
 * 工具包，具体和数据库交互的
 * @author 教师用计算机
 *不行
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
			//保存类结构的类
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
	 * 新增、修改、删除、只返回影响条数
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int updateSql(String sql,Object[] obj) throws Exception{
		try {
			//获取preparedStatement 预设sql的执行对象，这个sql是含有？
			//update set age=?
			//如果没有？不需要参数，如果有问题需要对obj数据进行传参数
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			/*for(Object o:obj){
				System.out.println(o+"33");
			}*/
			int count = pst.executeUpdate();//执行sql，返回影响条数
			return count;
			
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
		
	}
	/**
	 * 新增、修改、删除、只返回影响条数
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int updateSql2(String sql,Object... obj) throws Exception{
		try {
			//获取preparedStatement 预设sql的执行对象，这个sql是含有？
			//update set age=?
			//如果没有？不需要参数，如果有问题需要对obj数据进行传参数
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			int count = pst.executeUpdate();//执行sql，返回影响条数
			return count;
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
	}
	/**
	 * 新增成功后返回主键
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int insertSql(String sql,Object[] obj) throws Exception{
		try {
			//获取preparedStatement 预设sql的执行对象，这个sql是含有？
			//update set age=?
			//如果没有？不需要参数，如果有问题需要对obj数据进行传参数
			pst = this.getConnection().prepareStatement(sql,pst.RETURN_GENERATED_KEYS);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			int count = pst.executeUpdate();//执行sql，返回影响条数
			rs=pst.getGeneratedKeys();//只有一行一列
			if(rs.next()){
				return rs.getInt(1);//返回时主键
			}
			return -1;
		} catch (Exception e) {
			throw e;
		}finally{
			this.close();
		}
	}
	/**
	 * 查询
	 * @param sql
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<HashMap> selectInfo(String sql,Object[] obj) throws Exception {
		try {
			//？的sql语句
			pst = this.getConnection().prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			ResultSet rs = pst.executeQuery();
			ResultSetMetaData biaojiegou = rs.getMetaData();
			int count = biaojiegou.getColumnCount();//获取列数
			List list = new ArrayList();//用于接收数据查到的所有东西
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
	 * 查询,接收一个类结构。用来标识我查询到东西封装成什么格式
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
			int count = biaojiegou.getColumnCount();//获取列数
			List list = new ArrayList();//用于接收数据查到的所有东西
			while (rs.next()) {
				//newInstance创建一个对象。其实就相当于根据模板拷贝出来一个对象。
				//这个时候对象是没有东西，相当于直接New  Object。
				Object objTemp=cla.newInstance();//每一行都是一个对象
				//由于不知道Object有哪些成员变量，所以需要通过cla反射获取成员变量。
				//成员变量名字和数据库的字段名对应。（大小写数据库不太确定，我可以统一转成小写，_去除）
				//根据成员变量名获取成员变量对象，并为其赋值
				
				//往objTemp对象中放入值
				//先获取列名(循环列获取列名)
				for(int i=1;i<=count;i++){
					//列名转小写并且去除下划线
					String lieming=biaojiegou.getColumnName(i).toLowerCase().replace("_", "");
					Object liezhi=rs.getObject(i);
					//根据列名获取Filed
					Field f=cla.getDeclaredField(lieming);//成员变量名字和数据库字段名对应，并将_去除
				    f.setAccessible(true);
				    String lieType= f.getType().getName();
				    if(lieType.equals("int")){//如果我当前成员变量是int类型
				    	if(liezhi!=null){
				    		f.set(objTemp, Integer.parseInt(liezhi.toString()));
				    	}else{
				    		//列值为空
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
