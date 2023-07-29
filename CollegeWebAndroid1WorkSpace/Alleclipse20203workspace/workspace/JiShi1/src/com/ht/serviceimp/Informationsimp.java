package com.ht.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ht.bean.Informations;
import com.ht.service.InformationsI;
import com.ht.util.MybatisUtil;

public class Informationsimp  implements InformationsI{
	public static void main(String[] args) {
		InformationsI ss = new Informationsimp();
		List<Informations> list = ss.selinforlist();
		for(Informations i:list){
			System.out.println(i.getInTitle()+i.getInContent()+i.getInInforid()+i.getInReplycount());
		}
	}

	@Override
	public List<Informations> selinforlist() {
		SqlSession session=MybatisUtil.opensession();
		List<Informations> list = session.selectList("com.ht.service.InformationsI.selinforlist");
		return list;
	}
	
	public Informations getinfor(Long id){
		return MybatisUtil.opensession().selectOne("com.ht.service.InformationsI.getinfor",id);
	}
	@Override
	public int alertinfor(Map<String,Object> map) {
		return MybatisUtil.opensession().update("com.ht.service.InformationsI.alertinfor",map);
	}
}
