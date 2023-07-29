package serviceImp;

import java.util.List;

import common.Hibernate_imp;
import serviceI.DeptServiceI;

public class DeptServiceImp extends Hibernate_imp implements DeptServiceI{

	@Override
	public void say() {
		System.out.println("我只想和你说说话");
		
	}

	@Override
	public List hibernatehql(int startrow, int pagecount) {
		return hibernatehql("from DepartmentVo", startrow, pagecount);
	}

	@Override
	public int totalRowdept() {
		return totalRow("select count(*) from DepartmentVo");
	}

	@Override
	public int totalRowemp() {
		return totalRow("select count(*) from EmployeeVo");
	}	
	
	@Override
	public List hibernatesql(int startrow, int pagecount) {
		//查询的是表 不是对象了
		return hibernatebysql("select e.empname,e.sex,d.deptname from employee e left join department d on e.deptid=d.deptid",startrow,pagecount);
	}

	@Override
	public List hibernatesql1(int startrow, int pagecount) {
		//查询的是表 不是对象了
				return hibernatebysql1("select e.empname,e.sex,d.deptname from employee e left join department d on e.deptid=d.deptid",startrow,pagecount);
	}							  

}
