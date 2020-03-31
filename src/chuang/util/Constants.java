package chuang.util;
/*
 *	常量类
 */
public class Constants {
	
	//员工状态
	public static final String EMPL_STATUS_CODE = "emplStatus";
	/**
	 * 在职
	 */
	public static final String EMPL_STATUS_NORMAL = "1";
	/**
	 * 离职
	 */
	public static final String EMPL_STATUS_DIS = "0";
	
	//计薪方式
	public static final String COUNT_PAY_WAY_CODE = "countPayWay";
	
	
	//是否
	public static final String YES_OR_NO = "yesOrNo";
	/**
	 * 是
	 */
	public static final String YES = "1";
	/**
	 * 否
	 */
	public static final String NO = "0";
	
	/**
	 * 导出的考勤表头
	 */
	public static final String[] EXPORT_WORKS_TITLE = {"姓名","日期","计薪方式","单价","工作总计","补助金额","总计","备注"};
	/**
	 * 导出考勤的总计表头
	 */
	public static final String[] EXPORT_SUMAMT_TITLE = {"总计："};
	
	/**
	 * 导出的考勤表格格式
	 */
	public static final String EXPORT_EXCEL_XLS = ".xls";
	/**
	 * 字体名称
	 */
	public static final String EXPORT_FONT_NAME = "微软雅黑";
	/**
	 * 时间格式
	 */
	public static final String EXPORT_DATE_FORMAT = "yyyy年MM月dd日";
	/**
	 * 数字格式
	 */
	public static final String EXPORT_NUMBER_FORMAT = "0.00";
}
