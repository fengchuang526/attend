package chuang.entity;
/*
 *	相关方
 */
public class Rela extends IdEntity{
	
	/**
	 * 相关方姓名
	 */
	private String relaName;
	/**
	 * 相关方联系方式
	 */
	private String relaPhone;
	/**
	 * 相关方住址
	 */
	private String relaAddress;
	/**
	 * 备注
	 */
	private String remark;
	public String getRelaName() {
		return relaName;
	}
	public void setRelaName(String relaName) {
		this.relaName = relaName;
	}
	public String getRelaPhone() {
		return relaPhone;
	}
	public void setRelaPhone(String relaPhone) {
		this.relaPhone = relaPhone;
	}
	public String getRelaAddress() {
		return relaAddress;
	}
	public void setRelaAddress(String relaAddress) {
		this.relaAddress = relaAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
