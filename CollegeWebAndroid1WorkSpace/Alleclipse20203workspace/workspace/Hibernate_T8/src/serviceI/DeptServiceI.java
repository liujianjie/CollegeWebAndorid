package serviceI;

import java.util.List;

public interface DeptServiceI {
	
	public void say();
	
	//查询总行数
	public int totalRowdept();
	
	public int totalRowemp();
	
	//hql
	public List hibernatehql(int startrow,int pagecount);
	
	//sql 当不把结果集设为map集合时
	public List hibernatesql(int startrow,int pagecount);
	
	//sql 当把结果集设为map集合时
	public List hibernatesql1(int startrow,int pagecount);
}
