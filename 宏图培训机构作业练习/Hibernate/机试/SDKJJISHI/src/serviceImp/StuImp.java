package serviceImp;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import serviceI.StuI;
import vo.StudentVo;

public class StuImp extends HibernateDaoSupport implements StuI{
	@Override
	public int count() {
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		Query query=session.createQuery("select count(*) from StudentVo");
		Long longs=(Long) query.uniqueResult();
		tran.commit();
		session.close();
		return Integer.parseInt(longs+"");
	}
	
	@Override
	public Object seldan(int id) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		Object obj=session.get(StudentVo.class, id);
		tran.commit();
		session.close();
		return obj;
	}
	
	@Override
	public List selstu(DetachedCriteria dc,int startcount, int pageCount) {
		return getHibernateTemplate().findByCriteria(dc,startcount,pageCount);

	}
	
	@Override
	public void add(StudentVo stu) {
		getHibernateTemplate().save(stu);
	}
	
	@Override
	public void delete(StudentVo stu) {
		getHibernateTemplate().delete(stu);
		
	}
	
	@Override
	public void alert(StudentVo stu) {
		getHibernateTemplate().update(stu);
		
	}
	
	//---------------------华丽的分割线--------------------------------------
	
	@Override
	public List list(String hql,int startcount, int pageCount) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setFirstResult(startcount);
		query.setMaxResults(pageCount);
		List list=query.list();
		tran.commit();
		session.close();
		return list;
	}
	
	@Override
	public void add2(StudentVo stu) {
		//getHibernateTemplate().save(stu);
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(stu);
		tran.commit();
		session.close();
	}

	@Override
	public void delete2(StudentVo stu) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		session.delete(stu);
		tran.commit();
		session.close();
	}

	@Override
	public void alert2(StudentVo stu) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		Transaction tran=session.beginTransaction();
		session.update(stu);
		tran.commit();
		session.close();
		
	}

	
}
