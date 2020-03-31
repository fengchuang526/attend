package chuang.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*
 *	POI读取数据时工具
 */
public class PoiReadExcelByModelUtil {

    /**
     * 把数字型的cell转化成String
     * @param cell
     * @return
     */
    public static String getStrForCellNum(Cell cell){
    	Double temp = cell.getNumericCellValue();
    	return temp.toString().substring(0, temp.toString().indexOf("."));
    }
	
    /**
     * 取cell的值,只是String和Number
     * @param cell
     * @return
     */
    public static Object getCellValue(Cell cell){
    	if(cell != null){
    		if(cell.getCellType() == Cell.CELL_TYPE_STRING){
    			return cell.getStringCellValue();
    		}
    		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
    			return cell.getNumericCellValue();
    		}
    	}
    	return null;
    }
    
    /**
     * 用于将excel表格中列索引转成列号字母，从A对应1开始
     * 
     * @param index
     *            列索引
     * @return 列号
     */
    public static String indexToColumn(int index) {
        if (index <= 0) {
        	try {
        		throw new Exception("Invalid parameter");
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
        index--;
        String column = "";
        do{
        	if (column.length() > 0) {
        		index--;
        	}
        	column = ((char) (index % 26 + (int) 'A')) + column;
        	index = (int) ((index - index % 26) / 26);
        }while(index > 0);
        return column;
    }
    
    /**
     * tanjing
     * 住哪换日期
     * @param cell
     * @return
     */
    public static Object getDateCellValue(Cell cell){
    	if(cell != null){
    		//if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || HSSFDateUtil.isCellDateFormatted(cell)){
    		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC ){
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	        Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
    	        return sdf.format(date).toString();
    		}
    	}
    	return null;
    }
    
    /**
     * tanjing
     * @throws ParseException 
     */
    public static Object getBFBCellValue(Cell cell) throws ParseException{
    	if(cell != null){
    		Object obj=getCellValue(cell);
    		String value = obj.toString();
    		boolean status = value.contains("%");  
    		if(status){
    			NumberFormat nf=NumberFormat.getPercentInstance();
    			nf.setMaximumFractionDigits(4);
				Number m=nf.parse(value);
				return m;
    		}else{
    			return value;
    		}
    	}
    	return null;
    }
    
    /**
     * 把文本格式的数字为科学技术法转化成正常的汉字
     * @param cell
     * @return
     */
    public static String formTextNum(Cell cell){
    	if(cell == null){
    		return null;
    	}
    	if(cell.getCellType() == Cell.CELL_TYPE_STRING){
    		return cell.getStringCellValue();
    	}else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
    		DecimalFormat df = new DecimalFormat("0");  
    		return df.format(cell.getNumericCellValue()); 
    	}
    	return null;
    }
    
    
}
