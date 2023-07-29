package com.dc.dao.purchase;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class PurchaseDaoImpl implements PurchaseDao{
	/**
	 * 查询进货详情单
	 * */
	public  List findPruchare(Map map,PageEntity page){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.caterial_name,(demand-number) as sum,a.margin,");
		sql.append(" (demand-(demand-number))as quantity, ((demand-(demand-number))*univalent) as total,b.univalent");
		sql.append(" from caterial a join purchase b");
		sql.append(" on a.caterial_id=b.purchaseid");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("univalent"))){
			String univalent=map.get("univalent").toString();
			sql.append("  and univalent like '%"+univalent+"%'");
		}
		PageUtil pageUtil=new PageUtil();
		pageUtil.setpageinfo(sql, page);
		return page.getPagelist();
	}
	/**
	 * 新增进货详情单
	 * */
	/*public int insertPurchase(String quantity,String total,String univdent){
		BaseDAO base=new BaseDAO();
		
	}*/
}
