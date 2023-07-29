package com.dc.util;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;


public class PageUtil {
	public void setpageinfo(StringBuffer sql,PageEntity page){
		//sql.append("limit (当前页数-1)*每页多少条,每页多少条");
		StringBuffer Selsql=new StringBuffer(sql);
		//System.out.println(Selsql+"Selsql");
		Selsql.append(" limit "+((page.getNowpage()-1)*page.getPagecount())+","+page.getPagecount());
		//System.out.println(Selsql+"Selsql");
		BaseDAO base=new BaseDAO();
		try {
			List pagelist=base.selectInfo(Selsql.toString(), null);
			//System.out.println(pagelist+"pagelist");
			page.setPagelist(pagelist);
			StringBuffer Countsql=new StringBuffer();
			Countsql.append("select count(*) as sumcount FROM( ");
			Countsql.append(sql);
			Countsql.append(" )a");
			List list;
			list = base.selectInfo(Countsql.toString(), null);
			
			if(list!=null&&list.size()>0){
				Map map=(Map) list.get(0);
				//System.out.println(map+" map");
				int sumcount=StringUtil.changeObjectToInt(map.get("sumcount"));
				//System.out.println(sumcount+"sumcount");
				page.setSumcount(sumcount);
				int sumpage;
				if((sumcount%(page.getPagecount()))!=0){
					sumpage=(sumcount/(page.getPagecount()))+1;
					page.setSumpage(sumpage);
				//	System.out.println(page.getSumpage()+"sumpage1");
				}
				else{
					sumpage=sumcount/(page.getPagecount());
					page.setSumpage(sumpage);
				//	System.out.println(page.getSumpage()+"sumpage0");
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
