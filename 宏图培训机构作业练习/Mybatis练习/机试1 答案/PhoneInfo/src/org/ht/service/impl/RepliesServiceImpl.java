package org.ht.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.ht.dao.InformationsDao;
import org.ht.dao.RepliesDao;
import org.ht.dao.impl.InformationsDaoImpl;
import org.ht.dao.impl.RepliesDaoImpl;
import org.ht.pojo.Replies;
import org.ht.service.RepliesService;

public class RepliesServiceImpl implements RepliesService {
	private RepliesDao dao = new RepliesDaoImpl();
	private InformationsDao infoDao = new InformationsDaoImpl();
	public int addRep(Replies re) {
		int cnt=dao.addReplies(re);
		if(cnt>0){
			Map<String, Object> pramMap = new HashMap<String, Object>();
			pramMap.put("id", re.getInfoId());
			pramMap.put("reply", "1");
			cnt=infoDao.updateInfo(pramMap);
		}
		return cnt;
	}
}
