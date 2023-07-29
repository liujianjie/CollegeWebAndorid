package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_Util {
	private static SessionFactory sessionFactory=null;
	public static SessionFactory getsessionfactory(){
		if(sessionFactory==null){
			sessionFactory=new Configuration().configure("config-source/hibernate-cfg.xml").
					buildSessionFactory();
		}
		return sessionFactory;
	}
	public static Session getsession(){
		return getsessionfactory().openSession();
	}
	public static void main(String[] args) {
		System.out.println(Hibernate_Util.getsession());
	}
}
