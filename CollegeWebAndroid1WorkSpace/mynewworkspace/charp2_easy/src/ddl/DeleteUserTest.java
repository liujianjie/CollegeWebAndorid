package ddl;

import dao.UsersDao;

public class DeleteUserTest {
	public static void main(String[] args) {
		UsersDao dao = new UsersDao();
		boolean b = dao.delete(11);
		System.out.println(b);
	}
}
