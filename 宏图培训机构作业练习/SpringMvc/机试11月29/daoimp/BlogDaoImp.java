package com.ht.daoimp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ht.bean.Blog;
import com.ht.bean.Users;
import com.ht.daoi.BlogDaoI;

@Repository
public class BlogDaoImp implements BlogDaoI{

	@Resource
	SqlSessionFactory sqlsession;

	@Override
	public List<Blog> selbloglist(Map<String, Object> map) {
		SqlSession session = sqlsession.openSession();
		return session.selectList("com.ht.daoi.BlogDaoI.selbloglist",map);
	}

	@Override
	public List<Blog> seluserblog(Map<String, Object> map) {
		SqlSession session = sqlsession.openSession();
		return session.selectList("com.ht.daoi.BlogDaoI.seluserblog",map);
	}
	public int addblog(Map<String, Object> map){
		SqlSession session = sqlsession.openSession();
		return session.insert("com.ht.daoi.BlogDaoI.addblog",map);
	}
	public int delblog(Integer id){
		SqlSession session = sqlsession.openSession();
		return session.delete("com.ht.daoi.BlogDaoI.delblog",id);
	}
	public int selbloglistcount(){
		SqlSession session = sqlsession.openSession();
		return session.selectOne("com.ht.daoi.BlogDaoI.selbloglistcount");
	}
	public int seluserblogcount(Integer id){
		SqlSession session = sqlsession.openSession();
		return session.selectOne("com.ht.daoi.BlogDaoI.seluserblogcount",id);
	}
}
