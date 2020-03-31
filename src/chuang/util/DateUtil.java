package chuang.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 *	时间工具类
 */
public class DateUtil {
	
	/** 
	* 获得该月第一天 
	* @param year 
	* @param month 
	* @return 
	*/  
	public static String getFirstDayOfMonth(int year,int month){  
	        Calendar cal = Calendar.getInstance();  
	        //设置年份  
	        cal.set(Calendar.YEAR,year);  
	        //设置月份  
	        cal.set(Calendar.MONTH, month-1);  
	        //获取某月最小天数  
	        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);  
	        //设置日历中月份的最小天数  
	        cal.set(Calendar.DAY_OF_MONTH, firstDay);  
	        //格式化日期  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        String firstDayOfMonth = sdf.format(cal.getTime());  
	        return firstDayOfMonth;  
	} 
	
	/**
	 * 获取当月第一天
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(Date date){
		Calendar calen = Calendar.getInstance();
		calen.setTime(date);
		int firstDay = calen.getActualMinimum(calen.DAY_OF_MONTH);
		//设置日历中月份的最小天数  
		calen.set(Calendar.DAY_OF_MONTH, firstDay);  
        //格式化日期  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String firstDayOfMonth = sdf.format(calen.getTime());  
        return firstDayOfMonth;
	}
	  
	/** 
	* 获得该月最后一天 
	* @param year 
	* @param month 
	* @return 
	*/  
	public static String getLastDayOfMonth(int year,int month){  
	        Calendar cal = Calendar.getInstance();  
	        //设置年份  
	        cal.set(Calendar.YEAR,year);  
	        //设置月份  
	        cal.set(Calendar.MONTH, month-1);  
	        //获取某月最大天数  
	        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
	        //设置日历中月份的最大天数  
	        cal.set(Calendar.DAY_OF_MONTH, lastDay);  
	        //格式化日期  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        String lastDayOfMonth = sdf.format(cal.getTime());  
	        return lastDayOfMonth;  
	}
	
	/**
	 * 获取当月最后一天
	 * @param date
	 * @return
	 */
	public static String getLastDayOfMonth(Date date){
		Calendar calen = Calendar.getInstance();
		calen.setTime(date);
		int lastDay = calen.getActualMaximum(calen.DAY_OF_MONTH);
		//设置日历中月份的最小天数  
		calen.set(Calendar.DAY_OF_MONTH, lastDay);  
        //格式化日期  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String lastDayOfMonth = sdf.format(calen.getTime());  
        return lastDayOfMonth; 
	}
	
	/**
	 * 得到格式化的日期字符串
	 * @param date 日期
	 * @param pattern 格式
	 * @return
	 */
	public static String getDayStr(Date date,String pattern){
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(getLastDayOfMonth(new Date()));
	}
}
