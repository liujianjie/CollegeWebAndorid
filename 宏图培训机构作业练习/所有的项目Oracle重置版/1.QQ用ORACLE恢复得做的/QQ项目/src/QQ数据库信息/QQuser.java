package QQ���ݿ���Ϣ;

import java.io.Serializable;

public class QQuser implements Serializable{
	private int id;//id
	private String qqnum;//qq��
	private String qqname;//�ǳ�
	private String pwd;//����
	private String face;//ͷ��
	private String names;//��ʵ����
	private int age;//����
	private String sex;//--�Ա�
	private String dateremix;//--ũ������
	private String years;//--���
	private String months;//--�·�
	private String dprivate;//--�շ�
	private String country;//--����
	private String province;//--ʡ��
	private String city;//--����
	private String mark;//����ǩ��
	private String nation;//����
	private int levels;//�ȼ�
	private String star;//����
	private int status;//����״̬ 0 ���ߣ�1 ���ߣ�2 ����3 æµ
	private String ipadd;//ip
	private int port;//�˿�
	
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
