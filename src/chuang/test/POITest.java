package chuang.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			File file = new File("F:/aaa.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = wb.getSheetAt(1);
			XSSFRow row = sheet.getRow(0);
			for(int j=0;j<410;j++){
				XSSFCell cell = row.getCell(j);
				if(cell == null){
					System.out.println(j+"列:null");
					continue;
				}
				System.out.println(j+"列："+cell.getStringCellValue());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
