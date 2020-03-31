package chuang.entity;

import java.util.Date;

/*
 *	员工合同表
 */
public class EmplCont extends IdEntity {
	/**
	 * 员工
	 */
	private Employee empl;
	/**
	 * 员工ID
	 */
	private Integer emplId;
	/**
	 * 员工姓名
	 */
	private String emplName;
	/**
	 * 计薪方式
	 */
	private String counSalaWay;
	/**
	 * 单价（元）
	 */
	private Double unitPrice;
	/**
	 * 开始时间
	 */
	private Date startDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否启用
	 */
	private String isUse;

	public Employee getEmpl() {
		return empl;
	}
	public void setEmpl(Employee empl) {
		this.empl = empl;
	}
	public Integer getEmplId() {
		return emplId;
	}
	public void setEmplId(Integer emplId) {
		this.emplId = emplId;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public String getCounSalaWay() {
		return counSalaWay;
	}
	public void setCounSalaWay(String counSalaWay) {
		this.counSalaWay = counSalaWay;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	
}
