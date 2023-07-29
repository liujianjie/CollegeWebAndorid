package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate_Util {
	private static SessionFactory sessionf = null;

	public static SessionFactory getSessionFactory() {
		if (sessionf == null) {
			sessionf = new Configuration().configure(
					"config-resource/hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionf;
	}
	
	public static Session getSession(){
		return getSessionFactory().openSession();
	}
	public static void main(String[] args) {
		System.out.println(Hibernate_Util.getSession());
	}
}
