package chuang.dto;
/*
 *	仓库交易明细统计分析DTO
 */
public class WarehouseDetailAnalyDTO {
	
	/**
	 * 分析类型
	 */
	private String statisType;
	/**
	 * 开始日期
	 */
	private String startDate;
	/**
	 * 结束日期
	 */
	private String endDate;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 商品总数
	 */
	private Long goodsCount;
	/**
	 * 交易类型
	 */
	private String detailType;
	/**
	 * 商品总价
	 */
	private Double goodsAmt;
	
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getStatisType() {
		return statisType;
	}
	public void setStatisType(String statisType) {
		this.statisType = statisType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getDetailType() {
		return detailType;
	}
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}
	public Double getGoodsAmt() {
		return goodsAmt;
	}
	public void setGoodsAmt(Double goodsAmt) {
		this.goodsAmt = goodsAmt;
	}
	
}
