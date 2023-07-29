package com.ht.serviceimp;

import java.util.List;

import com.ht.bean.Replies;
import com.ht.service.RepliesI;
import com.ht.util.MybatisUtil;

public class Repliesimp  implements RepliesI{
	
	public static void main(String[] args) {
		Repliesimp ss = new Repliesimp();
		List<Replies> list = ss.selrep((long)1);
		System.out.println(list.size());
		System.out.println(list.get(0).getReId());
	}
	
	public List<Replies> selrep(Long id){
		return MybatisUtil.opensession().selectList("com.ht.service.RepliesI.selrepofinforid",id);
	}
	public int add(Replies re){
		return MybatisUtil.opensession().insert("com.ht.service.RepliesI.add",re);
	}
}
