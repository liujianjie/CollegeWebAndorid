package serviceI;

import java.util.List;

import vo.StudentVo;

public interface StudentServiceI {
	public boolean addstu(StudentVo stu);
	public List stulist();
	
	public StudentVo toalert(int id);
	public boolean alert(StudentVo stu);
	public boolean deletestu(StudentVo stu);
	
	//·ÖÒ³
	public int Row();
	
	public List fenye(int startRow,int pagecount);
}
