package com.ht.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.bean.Replies;
import com.ht.daoi.InforDaoI;
import com.ht.daoi.RepliesDaoI;
import com.ht.service.RepliesI;
import com.ht.util.MybatisUtil;
@Service
public class Repliesimp  implements RepliesI{
	
	@Resource
	RepliesDaoI redao;
	@Resource
	InforDaoI indao;
	
//	public void setRedao(RepliesDaoI redao) {
//		this.redao = redao;
//	}
//
//	public void setIndao(InforDaoI indao) {
//		this.indao = indao;
//	}

	public int add(Replies re){
		//添加成功后才修改
		int ct = redao.add(re);
		if(ct>0){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("view", 2);
			map.put("id", re.getInInforid());
			indao.alertinfor(map);
		}
		return ct;
	}
}
