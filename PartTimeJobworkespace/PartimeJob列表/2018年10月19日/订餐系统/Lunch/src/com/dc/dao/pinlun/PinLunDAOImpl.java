package com.dc.dao.pinlun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class PinLunDAOImpl implements PinLunDAO{
    /**
     * 后台查询所有评论
     */
	@Override
	public List SelAllpinlun(Map map,PageEntity page) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,c.customer_name,m.meal_name");
		sql.append(" from comments a,customer c ,meal m");
		sql.append(" where a.customer_id=c.customer_id");
		sql.append(" and a.customer_id=c.customer_id");
		sql.append(" and a.meal_id=m.meal_id");
		sql.append(" and 1=1");
		if(StringUtil.checkNotNull(map.get("commentcontent"))){
			String commentcontent=(String) map.get("commentcontent");
			sql.append(" and a.comment_content like '%"+commentcontent+"%' ");
		}
		if(StringUtil.checkNotNull(map.get("commentreplay"))){
			String commentreplay=(String) map.get("commentreplay");
			sql.append(" and a.comment_replay like '%"+commentreplay+"%' ");
		}
		sql.append(" ORDER BY a.replay_time DESC");
		PageUtil pageutil=new PageUtil();
	    pageutil.setpageinfo(sql, page);
		return page.getPagelist();
	}
    /**
     * 后台员工删除评论
     */
	@Override
	public boolean deletePinlun(String commentid) {
		// TODO Auto-generated method stub
		String sql="delete from comments where comment_id=?";
		BaseDAO base=new BaseDAO();
		try {
			int a=base.updateSql(sql, new Object[]{commentid});
		    if(a>0){
		    	return true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	/**
	 * 根据评论id查询该条评论信息
	 */
	public Map SelPinlun(String commentid) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,c.customer_name,m.meal_name");
		sql.append(" from comments a,customer c,meal m");
		sql.append(" where a.customer_id=c.customer_id ");
		sql.append(" and a.meal_id=m.meal_id");
		sql.append(" and a.comment_id="+commentid+"");
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql.toString(),null);
			if(list!=null&&!list.isEmpty()){
				Map map=(Map) list.get(0);
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	/***
	 * 根据回复进行修改
	 */
	public boolean updatePinlun(String commentreplay,String commentid, String empid ) {
		// TODO Auto-generated method stub
		String sql="update  comments set comment_replay=?,replay_time=now(),emp_id=? where comment_id=?";
		BaseDAO base=new BaseDAO();
		//获取当前时间
		/*Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String orderdate=sdf.format(date);*/
		try {
			int a=base.updateSql(sql, new Object[]{commentreplay,empid,commentid});
		    if(a>0){
		    	return true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
