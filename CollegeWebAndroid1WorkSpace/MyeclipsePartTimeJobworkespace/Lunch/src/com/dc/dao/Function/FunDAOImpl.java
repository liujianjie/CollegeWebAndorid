package com.dc.dao.Function;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class FunDAOImpl implements FunDAO{
    /**
     * 根据ID查询功能
     */
	public Map findFunctionsByid(String functionid) {
		// TODO Auto-generated method stub
		String sql="select * from functions where function_id=?";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql, new Object[]{functionid});
			if(list!=null&&!list.isEmpty()){
				Map map=(Map)list.get(0);
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/***
	 * 根据父级名称查询子功能
	 * @param functionparentid
	 * @return
	 */
	public List Selfunction(String functionid,PageEntity page){
		        StringBuffer sql=new StringBuffer();
		        sql.append("select c.* FROM (select a.*,b.function_name as parent_name from functions a");
		        sql.append(" left join functions b on a.function_parent_id=b.function_id");
				sql.append(" where 1=1 ");
				if(StringUtil.checkNotNull(functionid)){
					sql.append(" and a.function_parent_id="+functionid+" ");
				}else{
					sql.append(" and a.function_parent_id is null ");
				}	
				sql.append(" ORDER BY a.date DESC) c");
				PageUtil pageutil=new PageUtil();
			    pageutil.setpageinfo(sql, page);
				return page.getPagelist();
	}
    /**
     * 添加功能
     */
	public boolean insertFunction(String functionname, String functiondec,
			String functionurl, String state,String functionparentid, String userid,String username) {
		// TODO Auto-generated method stub
		String sql="insert into functions (function_name,function_dec,function_url,state,function_parent_id,user_id,user_name,date) values(?,?,?,?,?,?,?,now())";
		BaseDAO base=new BaseDAO();
		if(!com.dc.util.StringUtil.checkNotNull(functionparentid)){
			functionparentid=null;
		}
		try {
			int a=base.updateSql(sql, new Object[]{functionname,functiondec,functionurl,state,functionparentid,userid,username});
			if(a>0){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
    /**
     * 修改功能
     */
	public boolean updateFunction(String functionname, String functiondec,
			String functionurl, String state,String functionparentid, String userid,String username, String functionid) {
		// TODO Auto-generated method stub
		String sql="update functions set function_name=?,function_dec=?,function_url=?,state=?,function_parent_id=? ,user_id=?,date=now(),user_name=? where function_id=?";
		BaseDAO base=new BaseDAO();
		if(!com.dc.util.StringUtil.checkNotNull(functionparentid)){
			functionparentid=null;
		}
		try {
			int b=base.updateSql(sql.toString(), new Object[]{functionname,functiondec,functionurl,state,functionparentid,userid,username,functionid});
		    if(b>0){
		    	return true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	/**
	 * 查询所有功能名称和ID
	 */
	public List findFunctions(String functionid){
		if(com.dc.util.StringUtil.checkNotNull(functionid)){
				String sql="select function_id,function_name from functions where function_parent_id is null and function_id!=? and state=0";
				BaseDAO base=new BaseDAO();
				try {
					List list=base.selectInfo(sql,new Object[]{functionid});
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		}else{
				String sql="select function_id,function_name from functions where function_parent_id is null and state=0";
				BaseDAO base=new BaseDAO();
				try {
					List list=base.selectInfo(sql,null);
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
		 }
	} 
	/***
	 * 查询所有父功能
	 * 
	 */
	public List FindParentFunction(PageEntity page){
		StringBuffer sql=new StringBuffer();
		sql.append("select * from functions where function_parent_id  is null ORDER BY date DESC ");
		PageUtil pageutil=new PageUtil();
	    pageutil.setpageinfo(sql, page);
		return page.getPagelist();
		
	}
	/**
	 * 查询所有父功能用来动态生成功能树
	 */
	public List FindALLFunctions(){
		String sql="select * from functions where function_parent_id is null and state=0";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql, null);
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String parentid=map.get("function_id").toString();
				List sons=this.SelALLFunctions(parentid);
				map.put("sons", sons);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询父id子功能
	 */
	public List SelALLFunctions(String parentid){
		String sql="select * from functions where function_parent_id=? and state=0";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql, new Object[]{parentid});
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String parentid1=map.get("function_id").toString();
				List sons=this.SelALLFunctions(parentid1);
				map.put("sons", sons);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改功能状态	
	 */
	public boolean upOrDown(String state,String functionid){
		BaseDAO base=new BaseDAO();
		String sql="UPDATE functions  SET state=? WHERE function_id=?";
		int A=-1;
			try {
				A=base.updateSql(sql, new Object[]{state,functionid});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(A>0){
				return true;
			}else{
				return false;
			}
	}
	/**
	 * 校验功能名是否重复
	 */
	public boolean checkFunctions(String functionname,String functionid) {
		String sql="select * from functions where function_name=?";
		//判断是新增还是修改
		if(functionid!=null&&!functionid.equals("")){
			sql=sql+" and function_id!="+functionid;
		}
		BaseDAO base=new BaseDAO();
		// TODO Auto-generated method stub
		List list=null;
		try {
			list = base.selectInfo(sql, new Object[]{functionname});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	//查询所有功能状态
	public List FindState(){
		String sql="SELECT distinct state from functions";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
