package com.dc.dao.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;
/**
 * 仓库材料
 * 马方伟
 * */
public class CaterialDaoImpl implements CaterialDao{
	
	/**
	 * 唯一性校验代码
	 */
	public boolean checkUserName2(String caterialid,String caterialname) {
		BaseDAO base=new BaseDAO();
		String sql="select * from caterial where caterial_name=?";
		List list=null;
		try {
			list = base.selectInfo(sql, new Object[]{caterialname});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 查询所有材料的数量
	 * */
	
	public List findCaterial(Map map,PageEntity page){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		//sql.append("select caterial_id,caterial_name,unit,demand,caterial_state from caterial");
		sql.append("select* from(select caterial_id,caterial_name,unit,demand,caterial_state,case when caterial_state=2 then '没有了' when caterial_state=1 then '不足'  else '盈余' end as state from caterial order by warehouse_date desc)a");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("caterialname"))){
			String caterialname=map.get("caterialname").toString();
			sql.append(" and caterial_name like '%"+caterialname+"%'");
		}
		
		PageUtil pageUtil=new PageUtil();
		pageUtil.setpageinfo(sql, page);
		return page.getPagelist();
	}
	//修改材料状态
	public boolean updatecaterial(String caterialname){
		String sql="update caterial set  caterial_state=0 where  caterial_name=?";
		BaseDAO base=new BaseDAO();
		int a=-1;
		try {
			a=base.updateSql(sql, new Object[]{caterialname});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a>0){
       	 return true;
        } 
		 return false;
		
	} 
	/**
	 * 新增材料
	 * */
	public int insertCaterial(String empid,String caterialname,String unit,String demand){
		BaseDAO base=new BaseDAO();
		String sql="insert into caterial (emp_id,caterial_name,unit,demand,number,warehouse_date,caterial_state) values(?,?,?,?,0,NOW(),0)";
		try {
			int i=base.updateSql(sql, new Object[]{empid,caterialname,unit,demand});
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 查询材料
	 * */
	public Map fCaterial(String caterialid){
		BaseDAO base=new BaseDAO();
		String sql="select * from caterial where caterial_id=?";
		try {
			List<HashMap> list=base.selectInfo(sql, new Object[]{caterialid});
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
			return list.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改材料
	 * */
	public void updateCaterial(String caterialid,String demand){
		BaseDAO base=new BaseDAO();
		String sql="update caterial set demand=? where caterial_id=?";
		try {
			int i=base.updateSql(sql,new Object[]{demand,caterialid});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除材料
	 * */
	public int deleteCarterial(String caterialid){
		BaseDAO base=new BaseDAO();
		String sql="delete from caterial where caterial_id=?";
		try {
			int i=base.updateSql(sql, new Object[]{caterialid});
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * 查询材料单位下拉框
	 * */
	public List selectUnit(){
		BaseDAO base=new BaseDAO();
		String sql="select DISTINCT unit from caterial";
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
	


