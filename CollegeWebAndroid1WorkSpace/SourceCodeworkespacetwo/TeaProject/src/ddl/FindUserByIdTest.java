package ddl;

import com.bean.User;
import com.dao.UsersDao;

public class FindUserByIdTest {
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		User user = dao.find(1);
		System.out.println("idΪ1��User�����nameΪ��" + user.getUsername());
	}
}
