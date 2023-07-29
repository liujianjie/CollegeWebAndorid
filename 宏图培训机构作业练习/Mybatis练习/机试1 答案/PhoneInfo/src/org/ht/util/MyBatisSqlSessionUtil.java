package org.ht.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionUtil {
	private static Reader reader=null;
	private static String config="MyBatisConfig.xml";
	private static SqlSessionFactoryBuilder ssfb = null;
	private static SqlSessionFactory ssf = null;
	private static SqlSession session = null;
	public static SqlSession openSession() {
		try {
			reader  = Resources.getResourceAsReader(config);
			ssfb=new SqlSessionFactoryBuilder();
			ssf = ssfb.build(reader);
			if(session==null){
				//设置为自动提交
				session=ssf.openSession(true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
