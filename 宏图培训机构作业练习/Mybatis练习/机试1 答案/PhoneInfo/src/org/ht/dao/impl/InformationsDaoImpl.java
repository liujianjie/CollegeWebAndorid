package org.ht.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.ht.dao.InformationsDao;
import org.ht.pojo.Informations;
import org.ht.pojo.Replies;
import org.ht.util.MyBatisSqlSessionUtil;

public class InformationsDaoImpl implements InformationsDao{

	public List<Informations> findAllInformations() {
		SqlSession session = MyBatisSqlSessionUtil.openSession();
		List<Informations> list = session.selectList("informationsDao.findAllInformations");
		return list;
	}
	public static void main(String[] args) {
		InformationsDao dao = new InformationsDaoImpl();
		Map<String, Object> pramMap = new HashMap<String, Object>();
		pramMap.put("view", "1");
		pramMap.put("id", 3);
		dao.updateInfo(pramMap);
}
public Informations findInfoById(Integer id) {
	SqlSession session = MyBatisSqlSessionUtil.openSession();
	Informations info = session.selectOne("informationsDao.findInfoById",id);
	return info;
}
public int updateInfo(Map<String, Object> pramMap) {
	SqlSession session = MyBatisSqlSessionUtil.openSession();
	int count = session.update("informationsDao.updateInfo",pramMap);
	return count;
}
}
