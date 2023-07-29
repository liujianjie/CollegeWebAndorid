package com.dc.dao.CustomerDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class customerDAOImpl implements customerDAO{
/**
 *查询所有顾客信息
 */
	public List<HashMap> selectAllCustomer() {
		BaseDAO base=new BaseDAO();
		String sql="select * from customer";
		try {
			List list =base.selectInfo(sql, null);
			if(list!=null&&list.size()>0){
				return list;
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
 * 分页显示所有顾客
 */
	public List<HashMap> selectCustomerBycheck(Map map, PageEntity page) {
		BaseDAO base= new BaseDAO();
		StringBuffer sql=new StringBuffer();
			sql.append("select * from customer where 1=1");
		if(StringUtil.checkNotNull(map.get("customername"))){
			String customername=map.get("customername").toString();
			sql.append(" and customer_name like '%"+customername+"%'");
		}
		if(StringUtil.checkNotNull(map.get("customeruser"))){
			String customeruser=map.get("customeruser").toString();
			sql.append(" and customer_account_name like '%"+customeruser+"%'");
		}
		//sql.append(" limit "+(page.getNowpage()-1)*page.getPagecount()+","+page.getPagecount());
		PageUtil pageutil=new PageUtil();
		pageutil.setpageinfo(sql, page);
		return page.getPagelist();
	}

}
