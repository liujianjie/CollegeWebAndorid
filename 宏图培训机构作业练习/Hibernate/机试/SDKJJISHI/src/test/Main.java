package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Query;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import serviceI.StuI;
import serviceImp.StuImp;
import vo.StudentVo;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
		DataSource data=(DataSource)context.getBean("dsource");
		try {
			Connection conn=data.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		SessionFactory sessionfactory=(SessionFactory)context.getBean("sessionfactory");
		Session session=sessionfactory.openSession();
		System.out.println(session);
		Query query=session.createQuery("from StudentVo");
		List list=query.list();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			StudentVo stu=(StudentVo)list.get(i);
			System.out.println(stu.getStu_name());
		}
		StuI ss=(StuImp)context.getBean("stuservice");
		
	}
}
