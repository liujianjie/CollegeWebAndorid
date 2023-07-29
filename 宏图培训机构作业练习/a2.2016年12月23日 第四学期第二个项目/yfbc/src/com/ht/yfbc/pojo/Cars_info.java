package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/** 车辆信息表对象 
 * <p>id:车辆型号信息表主键</p>
 * <p>carsname:车辆型号名称</p>
 * <p>carsweight:车辆载重(吨)</p>
 * <p>carscubage:车辆货仓容积</p>
 * <p>carsnum:车牌号码</p>
 * <p>carsenginenum:车辆发动机号</p>
 * <p>carsinsurancenum:车辆保险单号</p>
 * <p>carsbuydata:车辆购买时间</p>
 * <p>warehouseid:车辆隶属仓库</p>
 * <p>carsisvacancy:车辆状态(0-空闲,1-在途,2-维修)</p>*/
public class Cars_info implements Serializable {

	
	private String id;
	private String carsname;
	private String carsweight;
	private String carscubage;
	private String carsnum;
	private String carsenginenum;
	private String carsinsurancenum;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date carsbuydate;
	private String warehouseid;
	private Integer carsisvacancy;
	/** 车辆所属仓库 */
	public List<Warehouse> warehouses;

	public Cars_info() {

	}

	public Cars_info(String id, String carsname, String carsweight, String carscubage, String carsnum,
			String carsenginenum, String carsinsurancenum, Date carsbuydate, String warehouseid,
			Integer carsisvacancy, List<Warehouse> warehouses) {
		super();
		this.id = id;
		this.carsname = carsname;
		this.carsweight = carsweight;
		this.carscubage = carscubage;
		this.carsnum = carsnum;
		this.carsenginenum = carsenginenum;
		this.carsinsurancenum = carsinsurancenum;
		this.carsbuydate = carsbuydate;
		this.warehouseid = warehouseid;
		this.carsisvacancy = carsisvacancy;
		this.warehouses = warehouses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarsname() {
		return carsname;
	}

	public void setCarsname(String carsname) {
		this.carsname = carsname;
	}

	public String getCarsweight() {
		return carsweight;
	}

	public void setCarsweight(String carsweight) {
		this.carsweight = carsweight;
	}

	public String getCarscubage() {
		return carscubage;
	}

	public void setCarscubage(String carscubage) {
		this.carscubage = carscubage;
	}

	public String getCarsnum() {
		return carsnum;
	}

	public void setCarsnum(String carsnum) {
		this.carsnum = carsnum;
	}

	public String getCarsenginenum() {
		return carsenginenum;
	}

	public void setCarsenginenum(String carsenginenum) {
		this.carsenginenum = carsenginenum;
	}

	public String getCarsinsurancenum() {
		return carsinsurancenum;
	}

	public void setCarsinsurancenum(String carsinsurancenum) {
		this.carsinsurancenum = carsinsurancenum;
	}

	public Date getCarsbuydate() {
		return carsbuydate;
	}

	public void setCarsbuydate(Date carsbuydate) {
		this.carsbuydate = carsbuydate;
	}

	public String getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}

	public Integer getCarsisvacancy() {
		return carsisvacancy;
	}

	public void setCarsisvacancy(Integer carsisvacancy) {
		this.carsisvacancy = carsisvacancy;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

}
