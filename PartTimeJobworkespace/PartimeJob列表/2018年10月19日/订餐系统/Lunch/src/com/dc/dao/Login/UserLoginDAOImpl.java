package com.dc.dao.Login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.util.BaseDAO;
import com.dc.util.StringUtil;

public class UserLoginDAOImpl implements UserLoginDAO{
	/**
	 * 用户登录，先判断用户是否存在通过username
	 * @return 该用户信息
	 */

	public Map Login(String username,String customerid) {
		BaseDAO base=new BaseDAO();
		String sql="select * from customer where customer_account_name=? ";
		if(StringUtil.checkNotNull(customerid)){
			sql+=" and customer_id!="+customerid;
		}
		List list=null;
		try {
		 list=base.selectInfo(sql, new Object[]{username});
		 if(list!=null&&list.size()>0){
			 return (Map) list.get(0);
		 }
		 else
			 return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用户进行注册
	 */
	public int register(String customername, String customeruser,
			String pwd, String birthday, String sex, String customerphone,
			String province, String city, String district,
			String customeradd) {
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("insert into customer(customer_name,sex,");
		sql.append("customer_phone,customer_birthday,");
		sql.append("customer_account_name,");
		sql.append("customer_pwd,customer_province,customer_city,");
		sql.append("customer_district,customer_add) VALUES(?,?,?,?,?,?,?,?,?,?)");
		if(birthday==null){
			birthday=null;
		}else if(birthday.equals("")){
			birthday=null;
		}
		Object[] obj=new Object[]{customername, sex, customerphone,birthday, customeruser,
				pwd, province,city,district,customeradd};
		try {
			int i=base.updateSql(sql.toString(), obj);
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	/**
	 * 通过id查询顾客
	 */
	public Map selectBycustid(String customerid) {
		BaseDAO base=new BaseDAO();
		String sql="select * from customer where customer_id=?";
		try {
			List<HashMap> list=base.selectInfo(sql, new Object[]{customerid});
			if(list!=null&&list.size()>0){
				Map map=list.get(0);
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 有id修改用户
	 */
	@Override
	public int updatecustomer(String customerid, String customername,
			String customeruser, String pwd, String birthday, String sex,
			String customerphone, String province, String city,
			String district, String customeradd) {
		// TODO Auto-generated method stub
		//UPDATE `customer` SET `customer_add`='sadfaf1' WHERE (`customer_id`='10')
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("UPDATE  customer set customer_name=?,sex=?,");
		sql.append("customer_phone=?,customer_birthday=?,");
		sql.append("customer_account_name=?,");
		sql.append("customer_pwd=?,customer_province=?,customer_city=?,");
		sql.append("customer_district=?,customer_add=? where(customer_id=?)");
		if(birthday.equals("")||birthday==null){
			birthday=null;
		}
		Object[] obj=new Object[]{customername, sex, customerphone,birthday, customeruser,
				pwd, province,city,district,customeradd,customerid};
		try {
			int i=base.updateSql(sql.toString(), obj);
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
