package com.dc.dao.department;

import java.util.List;
import java.util.Map;

import com.dc.util.BaseDAO;

public class DepartTreeDAOImpl implements DepartTreeDAO{
	@Override
	/**
	 * ���в��ż�ְ��
	 */
	
	public List SelectAllDepart() {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		String sql="select * from depart where state=0";
		try {
			List list=base.selectInfo(sql, null);
			/*for(int i=0;i<list.size();i++){
				Map map=(Map) list.get(i);
				String departid=map.get("depart_id").toString();
				List sons=SelectDutyBydid(departid);
	    		map.put("sons", sons);	
			}*/
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
/**
 * ��ѯ����id�µ�����ְ��
 */
	@Override
	public List SelectDutyBydid(String departid) {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		String sql="select * from duty where depart_id=?";
		try {
			List list=base.selectInfo(sql, new Object[]{departid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
