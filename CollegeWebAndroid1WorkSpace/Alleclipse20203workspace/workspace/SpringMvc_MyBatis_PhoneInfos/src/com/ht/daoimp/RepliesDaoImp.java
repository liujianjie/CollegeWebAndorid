package com.ht.daoimp;

import java.util.List;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ht.bean.Replies;
import com.ht.daoi.RepliesDaoI;

public class RepliesDaoImp implements RepliesDaoI{
	public static void main(String[] args) {
		RepliesDaoImp ss = new RepliesDaoImp();
		List<Replies> list = ss.selrep((long)1);
		System.out.println(list.size());
		System.out.println(list.get(0).getReId());
	}
	@Resource
	SqlSessionFactory sqlSessionFactory;//随意 不一定要和id一样 sqlSessionFactory
	
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		this.sqlSessionFactory = sqlSessionFactory;
//	}
	
	public List<Replies> selrep(Long id){
		SqlSession session=sqlSessionFactory.openSession();
		return session.selectList("com.ht.daoi.RepliesDaoI.selrep",id);
	}
	public int add(Replies re){
		SqlSession session=sqlSessionFactory.openSession();
		return session.insert("com.ht.daoi.RepliesDaoI.add",re);
	}
}
