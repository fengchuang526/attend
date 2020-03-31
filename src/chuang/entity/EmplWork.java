package chuang.entity;

import java.util.Date;

/*
 *	员工工作日志表
 */
public class EmplWork extends IdEntity {
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
	 * 工作日期
	 */
	private Date workDate;
	/**
	 * 工作方式
	 */
	private String workWay;
	/**
	 * 工作单价（元）
	 */
	private Double workPrice;
	/**
	 * 工作总计
	 */
	private Double workCount;
	/**
	 * 工作补助（元）
	 */
	private Double workAllow;
	/**
	 * 总计金额（元）
	 */
	private Double workAmount;
	/**
	 * 备注
	 */
	private String remark;
	
	
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
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public String getWorkWay() {
		return workWay;
	}
	public void setWorkWay(String workWay) {
		this.workWay = workWay;
	}
	public Double getWorkPrice() {
		return workPrice;
	}
	public void setWorkPrice(Double workPrice) {
		this.workPrice = workPrice;
	}
	public Double getWorkCount() {
		return workCount;
	}
	public void setWorkCount(Double workCount) {
		this.workCount = workCount;
	}
	public Double getWorkAllow() {
		return workAllow;
	}
	public void setWorkAllow(Double workAllow) {
		this.workAllow = workAllow;
	}
	public Double getWorkAmount() {
		return workAmount;
	}
	public void setWorkAmount(Double workAmount) {
		this.workAmount = workAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
