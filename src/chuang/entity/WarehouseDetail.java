package chuang.entity;

import java.util.Date;

/*
 *	仓库明细
 */
public class WarehouseDetail extends IdEntity {
	
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 明细描述
	 */
	private String detailDesc;
	/**
	 * 明细数量
	 */
	private Integer detailNum;
	/**
	 * 交易总价
	 */
	private Double detailAmt;
	/**
	 * 明细类型
	 */
	private String detailType;
	/**
	 * 相关方
	 */
	private Integer relaPerson;
	/**
	 * 明细日期
	 */
	private Date detailDate;
	/**
	 * 查询开始时间
	 */
	private String startDate;
	/**
	 * 查询结束时间
	 */
	private String endDate;
	
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public Integer getDetailNum() {
		return detailNum;
	}
	public void setDetailNum(Integer detailNum) {
		this.detailNum = detailNum;
	}
	public String getDetailType() {
		return detailType;
	}
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}
	public String getDetailDesc() {
		return detailDesc;
	}
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}
	public Integer getRelaPerson() {
		return relaPerson;
	}
	public void setRelaPerson(Integer relaPerson) {
		this.relaPerson = relaPerson;
	}
	public Double getDetailAmt() {
		return detailAmt;
	}
	public void setDetailAmt(Double detailAmt) {
		this.detailAmt = detailAmt;
	}
	public Date getDetailDate() {
		return detailDate;
	}
	public void setDetailDate(Date detailDate) {
		this.detailDate = detailDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

}
