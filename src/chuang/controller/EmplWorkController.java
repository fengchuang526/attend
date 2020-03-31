package chuang.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.RegionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import chuang.entity.DdSub;
import chuang.entity.EmplWork;
import chuang.entity.Employee;
import chuang.service.IEmplService;
import chuang.service.IEmplWorkService;
import chuang.service.ISubService;
import chuang.util.Constants;
import chuang.util.DateUtil;

/*
 *	员工考勤Controller
 */
@Controller
public class EmplWorkController {

	@Autowired
	private IEmplService emplService;
	@Autowired
	private ISubService subService;
	@Autowired
	private IEmplWorkService workService;
	
	@InitBinder    
	public void initBinder(WebDataBinder binder) {    
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    
	        dateFormat.setLenient(false);    
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	}
	
	/**
	 * 进入考勤主页面
	 * @param map
	 * @return
	 */
	@RequestMapping("enterWorkIndex.action")
	public String enterWorkIndex(ModelMap map){
		Date nowDate = new Date();
		Map<String,String> inMap = new HashMap<String,String>();
		String startDate = DateUtil.getFirstDayOfMonth(nowDate);
		String endDate = DateUtil.getLastDayOfMonth(nowDate);
		inMap.put("startDate", startDate);
		inMap.put("endDate", endDate);
		map.put("works", workService.getWorkByStartAndEndDate(inMap));
		map.put("empls", emplService.getAllEmpls());
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/emplwork.jsp";
	}
	
	/**
	 * 进入添加考勤界面
	 * @return
	 */
	@RequestMapping("enterAddWork.action")
	public String enterAddWork(ModelMap map){
		map.put("empls", emplService.getEmplsByStatus(Constants.EMPL_STATUS_NORMAL));
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/addemplwork.jsp";
	}
	
	/**
	 * 增加考勤
	 * @param work
	 * @param map
	 * @return
	 */
	@RequestMapping("addEmplWork.action")
	public String addEmplWork(EmplWork work,ModelMap map){
		Integer emplId = work.getEmplId();
		if(emplId != null && !"".equals(emplId)){
			workService.saveEmplWork(work);
		}
		Date nowDate = new Date();
		Map<String,String> inMap = new HashMap<String,String>();
		String startDate = DateUtil.getFirstDayOfMonth(nowDate);
		String endDate = DateUtil.getLastDayOfMonth(nowDate);
		inMap.put("startDate", startDate);
		inMap.put("endDate", endDate);
		map.put("works", workService.getWorkByStartAndEndDate(inMap));
		map.put("empls", emplService.getAllEmpls());
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/emplwork.jsp";
	}
	
	/**
	 * 进入更新考勤页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("enterUpdateWork.action")
	public String enterUpdateWork(Integer id,ModelMap map){
		map.put("work", workService.getEmplWorkById(id));
		map.put("empls", emplService.getEmplsByStatus(Constants.EMPL_STATUS_NORMAL));
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/addemplwork.jsp";
	}
	
	/**
	 * 更新考勤
	 * @param work
	 * @param map
	 * @return
	 */
	@RequestMapping("updateEmplWork.action")
	public String updateEmplWork(EmplWork work,ModelMap map){
		workService.updateWork(work);
		Date nowDate = new Date();
		Map<String,String> inMap = new HashMap<String,String>();
		String startDate = DateUtil.getFirstDayOfMonth(nowDate);
		String endDate = DateUtil.getLastDayOfMonth(nowDate);
		inMap.put("startDate", startDate);
		inMap.put("endDate", endDate);
		map.put("works", workService.getWorkByStartAndEndDate(inMap));
		map.put("empls", emplService.getAllEmpls());
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/emplwork.jsp";
	}

	/**
	 * 删除考勤记录
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteWork.action")
	public String deleteEmplWork(Integer id,ModelMap map){
		workService.deleteWorkById(id);
		Date nowDate = new Date();
		Map<String,String> inMap = new HashMap<String,String>();
		String startDate = DateUtil.getFirstDayOfMonth(nowDate);
		String endDate = DateUtil.getLastDayOfMonth(nowDate);
		inMap.put("startDate", startDate);
		inMap.put("endDate", endDate);
		map.put("works", workService.getWorkByStartAndEndDate(inMap));
		map.put("empls", emplService.getAllEmpls());
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/emplwork.jsp";
	}
	
	/**
	 * 搜索员工的考勤记录
	 * @param emplId 员工ID
	 * @param map
	 * @return
	 */
	@RequestMapping("searchEmplWorks.action")
	public String searchEmplWorks(Integer emplId,ModelMap map){
		map.put("works", workService.getEmplWorksByEmplId(emplId));
		map.put("empls", emplService.getAllEmpls());
		map.put("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
		return "forward:/emplwork.jsp";
	}
	
	/**
	 * 导出考勤
	 * @param exportDate
	 * @param map
	 * @return
	 */
	@RequestMapping("exportWorks.action")
	public void exportWorks(String exportDate,HttpServletResponse res,HttpServletRequest req){
		String[] date = exportDate.split("-");
		String startDate = DateUtil.getFirstDayOfMonth(Integer.valueOf(date[0]), Integer.valueOf(date[1]));
		String endDate = DateUtil.getLastDayOfMonth(Integer.valueOf(date[0]), Integer.valueOf(date[1]));
		List<Employee> empls = emplService.getEmplsByStatus(Constants.EMPL_STATUS_NORMAL);
		if(empls == null || empls.size() <= 0){
			this.packReturnData(req);
			try {
				req.getRequestDispatcher("/emplwork.jsp").forward(req, res);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ;
		}
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//设置表头样式
		HSSFCellStyle titleStyle = wb.createCellStyle();
		//字体
		HSSFFont titleFont = wb.createFont();
		titleFont.setFontName(Constants.EXPORT_FONT_NAME);
		titleFont.setFontHeightInPoints((short)12);
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		titleStyle.setFont(titleFont);
		//设置单元格边框
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		
		//设置通用单元格样式
		HSSFCellStyle cellStyle = wb.createCellStyle();
		//设置字体
		HSSFFont cellFont = wb.createFont();
		titleFont.setFontName(Constants.EXPORT_FONT_NAME);
		cellStyle.setFont(cellFont);
		//设置表格边框
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//设置内容位置
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		
		//设置表格格式类
		HSSFDataFormat hssfDF = wb.createDataFormat();
		
		//设置时间单元格格式
		HSSFCellStyle dateStyle = wb.createCellStyle();
		//设置字体
		dateStyle.setFont(cellFont);
		//设置时间格式
		dateStyle.setDataFormat(hssfDF.getFormat(Constants.EXPORT_DATE_FORMAT));
		//设置变格边框
		dateStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dateStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dateStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dateStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		
		//设置数据单元格格式
		HSSFCellStyle numStyle = wb.createCellStyle();
		//设置字体
		numStyle.setFont(cellFont);
		//设置数字格式
		numStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(Constants.EXPORT_NUMBER_FORMAT));
		//设置表格边框
		numStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		numStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		numStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		numStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		
		List<DdSub> ways = subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE);
		for(Employee empl : empls){
			Map<String,Object> temp = new HashMap<String,Object>();
			temp.put("startDate", startDate);
			temp.put("endDate", endDate);
			temp.put("emplId", empl.getId());
			HSSFSheet sheet = wb.createSheet(empl.getEmplName());
			List<EmplWork> works = workService.getEmplWorkByDateAndEmplId(temp);
			if(works == null || works.size() <= 0){
				Row nullRow = sheet.createRow(0);
				Cell nullCell = nullRow.createCell(0);
				nullCell.setCellValue("该员工本月没有考勤！");
				continue;
			}
			double sumAmt = 0;//考勤当月总额
			HSSFRow title = sheet.createRow(0);
			String[] head = Constants.EXPORT_WORKS_TITLE;
			int colLen = head.length;
			for(int j=0;j<colLen;j++){
				HSSFCell cell = title.createCell(j);
				cell.setCellValue(head[j]);
				cell.setCellStyle(titleStyle);
			}
			for(int i=0;i<works.size();i++){
				int index = 0;
				HSSFRow row = sheet.createRow(i+1);
				EmplWork work = works.get(i);
				
				HSSFCell nameCell = row.createCell(index++);
				nameCell.setCellValue(work.getEmplName());
				nameCell.setCellStyle(cellStyle);
				
				HSSFCell dateCell = row.createCell(index++);
				dateCell.setCellValue(work.getWorkDate());
				dateCell.setCellStyle(dateStyle);
				
				HSSFCell wayCell = row.createCell(index++);
				String wayStr = null;
				for(DdSub sub : ways){
					if(sub.getSubCode().equals(work.getWorkWay())){
						wayStr = sub.getSubName();
					}
				}
				wayCell.setCellValue(wayStr);
				wayCell.setCellStyle(cellStyle);
				
				HSSFCell priCell = row.createCell(index++);
				priCell.setCellValue(work.getWorkPrice() == null ? "" : work.getWorkPrice().toString());
				priCell.setCellStyle(numStyle);
				
				HSSFCell countCell = row.createCell(index++);
				countCell.setCellValue(work.getWorkCount() == null ? "" : work.getWorkCount().toString());
				countCell.setCellStyle(numStyle);
				
				HSSFCell allCell = row.createCell(index++);
				allCell.setCellValue(work.getWorkAllow() == null ? "" : work.getWorkAllow().toString());
				allCell.setCellStyle(numStyle);
				
				HSSFCell amtCell = row.createCell(index++);
				amtCell.setCellValue(work.getWorkAmount() == null ? "" : work.getWorkAmount().toString());
				amtCell.setCellStyle(numStyle);
				
				sumAmt += (work.getWorkAmount() == null ? 0d : work.getWorkAmount());
				
				HSSFCell reCell = row.createCell(index);
				reCell.setCellValue(work.getRemark());
				reCell.setCellStyle(cellStyle);
			}
			
			//合计工资
			HSSFRow sumAmtRow = sheet.createRow(works.size()+1);
			//合并单元格
			CellRangeAddress rangeCell = new CellRangeAddress(works.size()+1, works.size()+1, 0, 5);
			sheet.addMergedRegion(rangeCell);
			HSSFCell sumTitleCell = sumAmtRow.createCell(0);
			sumTitleCell.setCellValue(Constants.EXPORT_SUMAMT_TITLE[0]);
			sumTitleCell.setCellStyle(cellStyle);
			//设置合并单元格边框
			RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN, rangeCell, sheet, wb);
			RegionUtil.setBorderTop(HSSFCellStyle.BORDER_THIN, rangeCell, sheet, wb);
			RegionUtil.setBorderLeft(HSSFCellStyle.BORDER_THIN, rangeCell, sheet, wb);
			RegionUtil.setBorderRight(HSSFCellStyle.BORDER_THIN, rangeCell, sheet, wb);
			
			HSSFCell sumValueCell = sumAmtRow.createCell(6);
			sumValueCell.setCellValue(sumAmt);
			sumValueCell.setCellStyle(numStyle);
		}
		OutputStream os = null;
		String fileName = exportDate + Constants.EXPORT_EXCEL_XLS;
		try {
			res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			res.setContentType("application/vnd.ms-excel");
			os = res.getOutputStream();
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 封装返回到主界面的数据信息
	 * @param map
	 */
	public void packReturnData(HttpServletRequest req){
		Date nowDate = new Date();
		Map<String,String> inMap = new HashMap<String,String>();
		String startDate = DateUtil.getFirstDayOfMonth(nowDate);
		String endDate = DateUtil.getLastDayOfMonth(nowDate);
		inMap.put("startDate", startDate);
		inMap.put("endDate", endDate);
		req.setAttribute("works", workService.getWorkByStartAndEndDate(inMap));
		req.setAttribute("empls", emplService.getAllEmpls());
		req.setAttribute("countPayWay", subService.getSubsByCateCode(Constants.COUNT_PAY_WAY_CODE));
	}
	
}
