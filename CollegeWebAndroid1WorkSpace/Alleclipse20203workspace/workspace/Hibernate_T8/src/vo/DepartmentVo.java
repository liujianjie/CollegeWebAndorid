package vo;

import java.util.HashSet;
import java.util.Set;

public class DepartmentVo {
	private Integer deptid;
	private String deptname;
	private	Integer parentid;
	
	//¼¯ºÏ
	private Set employee=new HashSet();

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Set getEmployee() {
		return employee;
	}

	public void setEmployee(Set employee) {
		this.employee = employee;
	}
}
