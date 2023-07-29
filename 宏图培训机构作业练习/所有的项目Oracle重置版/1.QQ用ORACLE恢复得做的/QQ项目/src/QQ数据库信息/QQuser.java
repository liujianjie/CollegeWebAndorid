package QQ数据库信息;

import java.io.Serializable;

public class QQuser implements Serializable{
	private int id;//id
	private String qqnum;//qq号
	private String qqname;//昵称
	private String pwd;//密码
	private String face;//头像
	private String names;//真实姓名
	private int age;//年龄
	private String sex;//--性别
	private String dateremix;//--农历日历
	private String years;//--年份
	private String months;//--月份
	private String dprivate;//--日份
	private String country;//--国家
	private String province;//--省份
	private String city;//--城市
	private String mark;//个性签名
	private String nation;//名族
	private int levels;//等级
	private String star;//星座
	private int status;//在线状态 0 离线，1 在线，2 隐身，3 忙碌
	private String ipadd;//ip
	private int port;//端口
	
	public String getIpadd() {
		return ipadd;
	}
	public void setIpadd(String ipadd) {
		this.ipadd = ipadd;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQqnum() {
		return qqnum;
	}
	public void setQqnum(String qqnum) {
		this.qqnum = qqnum;
	}
	public String getQqname() {
		return qqname;
	}
	public void setQqname(String qqname) {
		this.qqname = qqname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDate() {
		return dateremix;
	}
	public void setDate(String dateremix) {
		this.dateremix = dateremix;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public String getDprivate() {
		return dprivate;
	}
	public void setDprivate(String dprivate) {
		this.dprivate = dprivate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
