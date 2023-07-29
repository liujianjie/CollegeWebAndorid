package com.dc.dao.LoginShowMenu;

import java.util.HashMap;
import java.util.List;

import com.dc.util.BaseDAO;
import com.dc.util.StringUtil;

public class ShowLoginMenuDAOImpl implements ShowLoginMenuDAO{

	public List<HashMap> selectallMenu(String mealid) {
		BaseDAO base=new BaseDAO();
		List list=null;
		StringBuffer sql=new StringBuffer();
		sql.append(" select a.meal_id,a.meal_type,a.meal_name,a.meal_price,a.meal_desc,a.meal_image, ");
		sql.append(" case when c.meal_id is not null then '没有了' when b.meal_id is not null then '不足'  else '盈余' end as state ");
		sql.append(" from meal a ");
		sql.append(" left join(  ");
		sql.append(" select b.meal_id  from  meal_caterial b ");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id ");
		sql.append(" where c.caterial_state=1 ");
		sql.append(" group by b.meal_id ");
		sql.append(" )b on a.meal_id=b.meal_id ");
		sql.append(" left join( ");
		sql.append(" select b.meal_id  from  meal_caterial b ");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id ");
		sql.append(" where c.caterial_state=2 ");
		sql.append(" group by b.meal_id ");
		sql.append(" )c on a.meal_id=c.meal_id ");
		try {
			if(StringUtil.checkNotNull(mealid)){
				sql.append("  where  a.meal_id=?");
				list=base.selectInfo(sql.toString(), new Object[]{mealid});
			}else{	
				list=base.selectInfo(sql.toString(), null);
			}
				return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List selectallRoom() {
		BaseDAO base=new BaseDAO();
		String sql="select * from room ORDER BY room_id desc";
		List list=null;
		try {
			list=base.selectInfo(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<HashMap> selectallMenu() {
		BaseDAO base=new BaseDAO();
		List list=null;
		StringBuffer sql=new StringBuffer();
		sql.append(" select a.meal_id,a.meal_type,a.meal_name,a.meal_price,a.meal_desc,a.meal_image, ");
		sql.append(" case when c.meal_id is not null then '没有了' when b.meal_id is not null then '不足'  else '盈余' end as state ");
		sql.append(" from meal a ");
		sql.append(" left join(  ");
		sql.append(" select b.meal_id  from  meal_caterial b ");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id ");
		sql.append(" where c.caterial_state=1 ");
		sql.append(" group by b.meal_id ");
		sql.append(" )b on a.meal_id=b.meal_id ");
		sql.append(" left join( ");
		sql.append(" select b.meal_id  from  meal_caterial b ");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id ");
		sql.append(" where c.caterial_state=2 ");
		sql.append(" group by b.meal_id ");
		sql.append(" )c on a.meal_id=c.meal_id ");
		try {
			list=base.selectInfo(sql.toString(), null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
