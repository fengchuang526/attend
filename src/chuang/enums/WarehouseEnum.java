package chuang.enums;
/*
 *	仓库枚举
 */
public enum WarehouseEnum {
	
	/**
	 * 明细类型-出库
	 */
	DETAIL_TYPE_OUT("out"),
	/**
	 * 明细类型-入库
	 */
	DETAIL_TYPE_IN("in"),
	/**
	 * 统计分析类型-商品
	 */
	STATIS_GOODS("goods"),
	/**
	 * 统计分析类型-相关方
	 */
	STATIS_RELA("rela");

	private String value;

	public String getValue() {
		return value;
	}

	private WarehouseEnum(String value) {
		this.value = value;
	}
	
}
