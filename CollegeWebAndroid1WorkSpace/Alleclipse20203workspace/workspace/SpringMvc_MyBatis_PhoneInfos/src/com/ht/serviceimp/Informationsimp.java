package com.ht.serviceimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ht.bean.Informations;
import com.ht.daoi.InforDaoI;
import com.ht.service.InformationsI;
@Service
public class Informationsimp  implements InformationsI{
	
	@Resource
	InforDaoI infordao;//InforDaoI infordao = new InforDaoImp();
	
//	public void setInfordao(InforDaoI infordao) {
//		this.infordao = infordao;
//	}
	public static void main(String[] args) {
		InformationsI ss = new Informationsimp();
		List<Informations> list = ss.selinforlist();
		for(Informations i:list){
			System.out.println(i.getInTitle()+i.getInContent()+i.getInInforid()+i.getInReplycount());
		}
	}
	@Override
	public List<Informations> selinforlist() {
		return infordao.selinforlist();
	}
	
	public Informations getinfor(Long id){
		//这里修改查看人数 业务逻辑
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("view", "1");
		map.put("id", id);
		infordao.alertinfor(map);
		return infordao.getinfor(id);
	}
	
}
