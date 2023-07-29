package ddl;

import goods.entity.User;
import dao.UsersDao;

public class UpdateUserTest {
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		User user = new User();
		user.setId(5);
		user.setUsername("pp");
		user.setSex("Ů");
		user.setPassword("12345");

		boolean flag = dao.update(user);
		System.out.println(flag);
	}
}
