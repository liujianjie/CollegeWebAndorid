package ddl;
import java.util.List;

import com.bean.User;
import com.dao.UsersDao;

public class FindAllUserTest {
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		List<User> list = dao.findAllUser();
		System.out.println(list.size());
	}
}
