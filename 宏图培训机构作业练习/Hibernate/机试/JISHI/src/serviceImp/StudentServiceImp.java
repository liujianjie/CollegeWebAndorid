package serviceImp;

import java.util.List;

import common.Hibernate_Dao;
import serviceI.StudentServiceI;
import vo.StudentVo;

public class StudentServiceImp extends Hibernate_Dao implements StudentServiceI{

	@Override
	public boolean addstu(StudentVo stu) {
		return addObj(stu);
	}

	@Override
	public List stulist() {
		return list("from StudentVo");
	}

	@Override
	public StudentVo toalert(int id) {
		return (StudentVo) getObj(StudentVo.class,id);
	}

	@Override
	public boolean alert(StudentVo stu) {
		return updObj(stu);
	}

	@Override
	public boolean deletestu(StudentVo stu) {
		return delObj(stu);
	}

	@Override
	public int Row() {
		return totalRow("select count(*) from StudentVo");
	}

	@Override
	public List fenye(int startRow, int pagecount) {
		return pagelist("from StudentVo",startRow,pagecount);
	}
	
}
