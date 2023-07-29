package ddl;
import java.util.List;

import goods.entity.User;
import dao.UsersDao;

public class FindAllUserTest {
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		List<User> list = dao.findAllUser();
		System.out.println(list.size());
	}
}
