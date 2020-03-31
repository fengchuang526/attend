package chuang.entity;
/*
 *	数据字典小类
 */
public class DdSub extends IdEntity {
	/**
	 * 小类名称
	 */
	private String subName;
	/**
	 * 小类编码
	 */
	private String subCode;
	/**
	 * 小类描述
	 */
	private String subDesc;
	/**
	 * 小类值
	 */
	private String subValue;
	/**
	 * 对用大类
	 */
	private DdCate cateId;
	/**
	 * 大类ID
	 */
	private Integer pId;
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}
	public String getSubValue() {
		return subValue;
	}
	public void setSubValue(String subValue) {
		this.subValue = subValue;
	}
	public DdCate getCateId() {
		return cateId;
	}
	public void setCateId(DdCate cateId) {
		this.cateId = cateId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	
}
