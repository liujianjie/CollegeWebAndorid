package vo;

import java.util.HashSet;
import java.util.Set;

public class JingliVo {
	private Integer jl_jid;
	private Integer stu_id;
	private String jl_starttime;
	private String jl_endtime;
	private String jl_school;
	
	//在多的一端设置对象
	private StudentVo studentvo;

	public Integer getJl_jid() {
		return jl_jid;
	}

	public void setJl_jid(Integer jl_jid) {
		this.jl_jid = jl_jid;
	}

	public Integer getStuid() {
		return stu_id;
	}

	public void setStuid(Integer stu_id) {
		this.stu_id = stu_id;
	}

	public String getJl_starttime() {
		return jl_starttime;
	}

	public void setJl_starttime(String jl_starttime) {
		this.jl_starttime = jl_starttime;
	}

	public String getJl_endtime() {
		return jl_endtime;
	}

	public void setJl_endtime(String jl_endtime) {
		this.jl_endtime = jl_endtime;
	}

	public String getJl_school() {
		return jl_school;
	}

	public void setJl_school(String jl_school) {
		this.jl_school = jl_school;
	}

	public StudentVo getStudentvo() {
		return studentvo;
	}

	public void setStudentvo(StudentVo studentvo) {
		this.studentvo = studentvo;
	}
}
