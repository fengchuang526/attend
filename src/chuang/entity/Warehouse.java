package chuang.entity;

import java.sql.Timestamp;

/*
 *	仓库
 */
public class Warehouse extends IdEntity{
	
	/**
	 * 物品编码
	 */
	private String goodsCode;
	/**
	 * 物品名称
	 */
	private String goodsName;
	/**
	 * 物品数量
	 */
	private Integer goodsNum;
	/**
	 * 物品描述
	 */
	private String goodsDesc;
	/**
	 * 物品类型
	 */
	private String goodsType;
	/**
	 * 物品单价（元）
	 */
	private Double goodsPrice;
	/**
	 * 创建时间
	 */
	private Timestamp createDate;
	/**
	 * 更新时间
	 */
	private Timestamp updateDate;
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
}
