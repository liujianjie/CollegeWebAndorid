package vo;

public class EmployeeVo {
	private Integer eid;
	private Integer deptid;
	private String empname;
	private String sex;
	
	//…Ë÷√∂‘œÛ
	private DepartmentVo departmentvo;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public DepartmentVo getDepartmentvo() {
		return departmentvo;
	}

	public void setDepartmentvo(DepartmentVo departmentvo) {
		this.departmentvo = departmentvo;
	}
}
