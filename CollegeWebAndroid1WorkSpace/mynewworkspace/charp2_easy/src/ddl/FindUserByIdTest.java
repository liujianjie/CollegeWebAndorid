package ddl;

import goods.entity.User;
import dao.UsersDao;

public class FindUserByIdTest {
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		User user = dao.find(1);
		System.out.println("id为1的User对象的name为：" + user.getUsername());
	}
}
