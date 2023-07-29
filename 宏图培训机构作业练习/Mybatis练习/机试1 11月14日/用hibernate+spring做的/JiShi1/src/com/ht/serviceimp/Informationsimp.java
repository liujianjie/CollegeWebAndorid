package com.ht.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ht.bean.Dept;
import com.ht.bean.Informations;
import com.ht.common.Hibernate_Dao;
import com.ht.common.Hibernate_Util;
import com.ht.service.InformationsI;
import com.ht.util.MybatisUtil;

public class Informationsimp extends Hibernate_Dao implements InformationsI{
	public static void main(String[] args) {
		InformationsI ss = new Informationsimp();
		List<Informations> list = ss.selinforlist();
		for(Informations i:list){
			System.out.println(i.getInTitle()+i.getInContent()+i.getInInforid()+i.getInReplycount());
		}
		ss.seldept();
	}

	@Override
	public List<Informations> selinforlist() {
		List<Informations> list=null;
		try{
			SqlSession session=MybatisUtil.opensession();
			list= session.selectList("com.ht.service.InformationsI.selinforlist");
		System.out.println(list.size());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list;
		//return listbyhql("from Informations");
	}
	
	public List<Dept> seldept(){
		return MybatisUtil.opensession().selectList("com.ht.service.InformationsI.seldept");
	}
	public Informations getinfor(Long id){
		return MybatisUtil.opensession().selectOne("com.ht.service.InformationsI.getinfor",id);
	}
	@Override
	public boolean alertinfor(Informations infor) {
		return updObj(infor);
	}
}
