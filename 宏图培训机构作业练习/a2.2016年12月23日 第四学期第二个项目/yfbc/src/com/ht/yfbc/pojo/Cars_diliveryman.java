package com.ht.yfbc.pojo;
/**
 * id:主键id<br>
 * userid:用户id<br>
 * warehouseid:仓库id<br>
 * isHave:是否已经配车<br>
 * @author hjx
 *
 */
public class Cars_diliveryman {
	private String id;
	private String userid;
	private String warehouseid;
	private String isHave;
	public Cars_diliveryman() {
	}
	public Cars_diliveryman(String id, String userid, String warehouseid, String isHave) {
		this.id = id;
		this.userid = userid;
		this.warehouseid = warehouseid;
		this.isHave = isHave;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getIsHave() {
		return isHave;
	}
	public void setIsHave(String isHave) {
		this.isHave = isHave;
	}
	@Override
	public String toString() {
		return "Cars_diliveryman [id=" + id + ", userid=" + userid + ", warehouseid=" + warehouseid + ", isHave="
				+ isHave + "]";
	}
	
	
}
