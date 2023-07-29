package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static String config = "MyBatis.xml";
	public static Reader reader = null;
	public static SqlSessionFactoryBuilder ssfb = null;
	public static SqlSessionFactory ssf = null;
	public static SqlSession session = null;
	
	public static SqlSession opensession(){
		try {
			reader = Resources.getResourceAsReader(config);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ssfb = new SqlSessionFactoryBuilder();
		ssf = ssfb.build(reader);
		if(session==null){
			session = ssf.openSession();
		}
		return session;
	}
}
