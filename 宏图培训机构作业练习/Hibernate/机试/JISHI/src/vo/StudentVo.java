package vo;

import java.util.HashSet;
import java.util.Set;

public class StudentVo {
	private Integer stu_id;
	private String stu_name;
	private Integer stu_age;
	private String stu_sex;
	private String stu_desc;
	
	//在一的一段设置集合
	private Set jinglivo=new HashSet();

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

	public Set getJinglivo() {
		return jinglivo;
	}

	public void setJinglivo(Set jinglivo) {
		this.jinglivo = jinglivo;
	}
	
}
