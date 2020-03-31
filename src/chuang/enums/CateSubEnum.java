package chuang.enums;
/*
 *	大类小类
 */
public enum CateSubEnum {
	
	/**
	 * 明细类型大类编码
	 */
	DETAIL_TYPE_CATE("outIn");

	private String value;

	public String getValue() {
		return value;
	}

	private CateSubEnum(String value) {
		this.value = value;
	}
	
}
