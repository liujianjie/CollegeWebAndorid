package org.ht.dao;

import java.util.List;
import java.util.Map;

import org.ht.pojo.Informations;

public interface InformationsDao {
	List<Informations> findAllInformations();
	Informations findInfoById(Integer id);
	int updateInfo(Map<String, Object> pramMap);
}
