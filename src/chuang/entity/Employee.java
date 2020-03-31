package chuang.entity;

import java.util.Date;

/*
 *	员工实体类
 */
public class Employee extends IdEntity{
	/**
	 * 员工编号
	 */
	private String emplNo;
	/**
	 * 员工名
	 */
	private String emplName;
	/**
	 * 员工电话1
	 */
	private String emplPhoneOne;
	/**
	 * 员工电话2
	 */
	private String emplPhoneTwo;
	/**
	 * 员工电话3
	 */
	private String emplPhoneThre;
	/**
	 * 员工家庭地址
	 */
	private String emplAddress;
	/**
	 * 员工生日
	 */
	private Date emplBirthday;
	/**
	 * 员工邮箱
	 */
	private String emplEmail;
	/**
	 * 员工入职时间
	 */
	private Date emplEntryDate;
	/**
	 * 员工微信号
	 */
	private String emplWechat;
	/**
	 * 员工支付宝号
	 */
	private String emplAlipay;
	/**
	 * 员工银行卡号
	 */
	private String emplBankNo;
	/**
	 * 员工状态
	 */
	private String emplStatus;
	/**
	 * 离职时间
	 */
	private Date dimiDate;
	public String getEmplNo() {
		return emplNo;
	}
	public void setEmplNo(String emplNo) {
		this.emplNo = emplNo;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public String getEmplPhoneOne() {
		return emplPhoneOne;
	}
	public void setEmplPhoneOne(String emplPhoneOne) {
		this.emplPhoneOne = emplPhoneOne;
	}
	public String getEmplPhoneTwo() {
		return emplPhoneTwo;
	}
	public void setEmplPhoneTwo(String emplPhoneTwo) {
		this.emplPhoneTwo = emplPhoneTwo;
	}
	public String getEmplPhoneThre() {
		return emplPhoneThre;
	}
	public void setEmplPhoneThre(String emplPhoneThre) {
		this.emplPhoneThre = emplPhoneThre;
	}
	public String getEmplAddress() {
		return emplAddress;
	}
	public void setEmplAddress(String emplAddress) {
		this.emplAddress = emplAddress;
	}
	public Date getEmplBirthday() {
		return emplBirthday;
	}
	public void setEmplBirthday(Date emplBirthday) {
		this.emplBirthday = emplBirthday;
	}
	public String getEmplEmail() {
		return emplEmail;
	}
	public void setEmplEmail(String emplEmail) {
		this.emplEmail = emplEmail;
	}
	public Date getEmplEntryDate() {
		return emplEntryDate;
	}
	public void setEmplEntryDate(Date emplEntryDate) {
		this.emplEntryDate = emplEntryDate;
	}
	public String getEmplWechat() {
		return emplWechat;
	}
	public void setEmplWechat(String emplWechat) {
		this.emplWechat = emplWechat;
	}
	public String getEmplAlipay() {
		return emplAlipay;
	}
	public void setEmplAlipay(String emplAlipay) {
		this.emplAlipay = emplAlipay;
	}
	public String getEmplBankNo() {
		return emplBankNo;
	}
	public void setEmplBankNo(String emplBankNo) {
		this.emplBankNo = emplBankNo;
	}
	public String getEmplStatus() {
		return emplStatus;
	}
	public void setEmplStatus(String emplStatus) {
		this.emplStatus = emplStatus;
	}
	public Date getDimiDate() {
		return dimiDate;
	}
	public void setDimiDate(Date dimiDate) {
		this.dimiDate = dimiDate;
	}
	
	@Override
	public String toString() {
		return "Employee [emplNo=" + emplNo + ", emplName=" + emplName
				+ ", emplPhoneOne=" + emplPhoneOne + ", emplPhoneTwo="
				+ emplPhoneTwo + ", emplPhoneThre=" + emplPhoneThre
				+ ", emplAddress=" + emplAddress + ", emplBirthday="
				+ emplBirthday + ", emplEmail=" + emplEmail
				+ ", emplEntryDate=" + emplEntryDate + ", emplWechat="
				+ emplWechat + ", emplAlipay=" + emplAlipay + ", emplBankNo="
				+ emplBankNo + ", emplStatus=" + emplStatus + ", dimiDate="
				+ dimiDate + "]";
	}
	
}
