package serviceI;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import vo.StudentVo;

public interface StuI {
	//这两个我不知道spring自带的类是那个，所以。。
	public int count();
	
	public Object seldan(int id);//查询单行
	
	//spring自带的类实现
	public List selstu(DetachedCriteria dc,int startcount,int pageCount);
	
	public void add(StudentVo stu);
	
	public void delete(StudentVo stu);
	
	public void alert(StudentVo stu);
	
	//spring自带的类因为我的servicebean配的有问题没用后的实现
	public List list(String hql,int startcount,int pageCount);
	
	public void add2(StudentVo stu);
	
	public void delete2(StudentVo stu);
	
	public void alert2(StudentVo stu);
}
