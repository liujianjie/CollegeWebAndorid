package com.ht.daoimp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ht.bean.Informations;
import com.ht.daoi.InforDaoI;

public class InforDaoImp implements InforDaoI{
	
	@Resource
	SqlSessionFactory sqlSessionFactory;//随意 不一定要和id一样 sqlSessionFactory
	
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		this.sqlSessionFactory = sqlSessionFactory;
//	}

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//		SqlSessionFactory sqlsessions = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		InforDaoI ss = new InforDaoImp();
		List<Informations> list = ss.selinforlist();
		for(Informations i:list){
			System.out.println(i.getInTitle()+i.getInContent()+i.getInInforid()+i.getInReplycount());
		}
	}
	
	@Override
	public List<Informations> selinforlist() {
		SqlSession session=sqlSessionFactory.openSession();
		List<Informations> list = session.selectList("com.ht.daoi.InforDaoI.selinforlist");
		return list;
	}
	
	public Informations getinfor(Long id){
		SqlSession session=sqlSessionFactory.openSession();
		return session.selectOne("com.ht.daoi.InforDaoI.getinfor",id);
	}
	@Override
	public int alertinfor(Map<String,Object> map) {
		SqlSession session=sqlSessionFactory.openSession();
		return session.update("com.ht.daoi.InforDaoI.alertinfor",map);
	}
}
