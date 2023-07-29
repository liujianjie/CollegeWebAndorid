package com.ht.serviceimp;

import java.util.List;

import com.ht.bean.Replies;
import com.ht.common.Hibernate_Dao;
import com.ht.service.RepliesI;

public class Repliesimp extends Hibernate_Dao implements RepliesI{
	public List selrep(Long id){
		return listbysql("select * from replies where in_inforid ="+id);
	}
	public boolean add(Replies re){
		return addObj(re);
	}
}
