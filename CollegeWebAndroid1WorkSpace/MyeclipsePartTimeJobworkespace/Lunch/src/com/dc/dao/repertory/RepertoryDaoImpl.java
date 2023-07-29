package com.dc.dao.repertory;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class RepertoryDaoImpl implements RepertoryDao{
	/**
	 * ‘≠≤ƒ≈Ãµ„≤È—Ø
	 * */
	public List findcaterial(Map map,PageEntity page){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select caterial_name,demand+margin as sum,");
		sql.append(" demand+margin-demand as remainder from caterial");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("caterialname"))){
			String caterialname=map.get("caterialname").toString();
			sql.append("  and caterial_name like '%"+caterialname+"%'");
		}
		PageUtil pageUtil=new PageUtil();
		pageUtil.setpageinfo(sql, page);
		return page.getPagelist();
	}
}
