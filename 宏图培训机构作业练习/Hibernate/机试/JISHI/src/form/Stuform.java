package form;

import org.apache.struts.action.ActionForm;

public class Stuform extends ActionForm{
	//学生
	private Integer stu_id;
	private String stu_name;
	private Integer stu_age;
	private String stu_sex;
	private String stu_desc;

	//经历
	private Integer[] jl_jid;
	private String[] jl_starttime;
	private String[] jl_endtime;
	private String[] jl_school;
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Integer getStu_age() {
		return stu_age;
	}
	public void setStu_age(Integer stu_age) {
		this.stu_age = stu_age;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_desc() {
		return stu_desc;
	}
	public void setStu_desc(String stu_desc) {
		this.stu_desc = stu_desc;
	}
	public Integer[] getJl_jid() {
		return jl_jid;
	}
	public void setJl_jid(Integer[] jl_jid) {
		this.jl_jid = jl_jid;
	}
	public String[] getJl_starttime() {
		return jl_starttime;
	}
	public void setJl_starttime(String[] jl_starttime) {
		this.jl_starttime = jl_starttime;
	}
	public String[] getJl_endtime() {
		return jl_endtime;
	}
	public void setJl_endtime(String[] jl_endtime) {
		this.jl_endtime = jl_endtime;
	}
	public String[] getJl_school() {
		return jl_school;
	}
	public void setJl_school(String[] jl_school) {
		this.jl_school = jl_school;
	}

}
