package chuang.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *	
 */
public class DateTest {

	public static void main(String[] args) {
//		System.out.println(new SimpleDateFormat("yyyy-MM").format(new Date()));
		String dateStr = "2017-11";
		String[] date = dateStr.split("-");
		for(String str : date){
			System.out.println(str);
		}
	}

}
