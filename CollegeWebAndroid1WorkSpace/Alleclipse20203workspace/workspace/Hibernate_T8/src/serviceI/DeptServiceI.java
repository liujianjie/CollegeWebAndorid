package serviceI;

import java.util.List;

public interface DeptServiceI {
	
	public void say();
	
	//��ѯ������
	public int totalRowdept();
	
	public int totalRowemp();
	
	//hql
	public List hibernatehql(int startrow,int pagecount);
	
	//sql �����ѽ������Ϊmap����ʱ
	public List hibernatesql(int startrow,int pagecount);
	
	//sql ���ѽ������Ϊmap����ʱ
	public List hibernatesql1(int startrow,int pagecount);
}
