package ddl;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.bean.User;
import com.dao.UsersDao;;

public class JdbcInsertTest {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UsersDao dao = new UsersDao();
		User user = new User();
		user.setUsername("mm");
		user.setSex("Ů");
		user.setPassword("1234");
		user.setEmail("17@qq.com");
//		user.setBirthday(sdf.format("2000-02-12"));
		boolean flag = dao.insert(user);
		System.out.println(flag);
	}
}
