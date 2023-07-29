package org.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ht.dao.InformationsDao;
import org.ht.dao.impl.InformationsDaoImpl;
import org.ht.pojo.Informations;
import org.ht.service.InformationsService;

public class InformationsServiceImpl implements InformationsService{
private InformationsDao infoDao = new InformationsDaoImpl();
	public List<Informations> findInfos() {
		return infoDao.findAllInformations();
	}
	public Informations findById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("view", "1");//表示查看
		map.put("id", id);
		infoDao.updateInfo(map);
		return infoDao.findInfoById(id);
	}

}
