package serviceI;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import vo.StudentVo;

public interface StuI {
	//�������Ҳ�֪��spring�Դ��������Ǹ������ԡ���
	public int count();
	
	public Object seldan(int id);//��ѯ����
	
	//spring�Դ�����ʵ��
	public List selstu(DetachedCriteria dc,int startcount,int pageCount);
	
	public void add(StudentVo stu);
	
	public void delete(StudentVo stu);
	
	public void alert(StudentVo stu);
	
	//spring�Դ�������Ϊ�ҵ�servicebean���������û�ú��ʵ��
	public List list(String hql,int startcount,int pageCount);
	
	public void add2(StudentVo stu);
	
	public void delete2(StudentVo stu);
	
	public void alert2(StudentVo stu);
}
