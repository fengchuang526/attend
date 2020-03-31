package chuang.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import chuang.entity.Employee;
import chuang.service.IEmplService;
import chuang.service.ISubService;
import chuang.util.Constants;

/*
 *	员工controller
 */
@Controller
@RequestMapping("/admin/")
public class EmploController {
	
	@Autowired
	private IEmplService emplService;
	@Autowired
	private ISubService subService;
	
	@InitBinder    
	public void initBinder(WebDataBinder binder) {    
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    
	        dateFormat.setLenient(false);    
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	}

	/**
	 * 添加员工
	 * @param empl
	 * @param map
	 * @return
	 */
	@RequestMapping("addEmployee.action")
	public String addEmplopyee(Employee empl,ModelMap map){
		System.out.println(empl.toString());
		emplService.saveEmpl(empl);
		List<Employee> empls = emplService.getAllEmpls();
		map.put("empls", empls);
		map.put("emplStatus", subService.getSubsByCateCode(Constants.EMPL_STATUS_CODE));
		return "forward:/admin/employee.jsp";
	}
	
	/**
	 * 跳转到添加员工界面
	 * @return
	 */
	@RequestMapping("addEmpl.action")
	public String enterAddEmpl(ModelMap map){
		return "redirect:/admin/addemployee.jsp";
	}
	
	/**
	 * 进入员工管理主界面
	 * @param map
	 * @return
	 */
	@RequestMapping("enterEmplIndex.action")
	public String enterEmplIndex(ModelMap map){
		map.put("empls", emplService.getAllEmpls());
		map.put("emplStatus", subService.getSubsByCateCode(Constants.EMPL_STATUS_CODE));
		return "forward:/admin/employee.jsp";
	}
	
	/**
	 * 进入员工更新界面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("updateEmpl.action")
	public String updateEmplIndex(Integer id,ModelMap map){
		map.put("empl", emplService.getEmplById(id));
		return "forward:/admin/addemployee.jsp";
	}
	
	/**
	 * 更新员工信息
	 * @param empl
	 * @param map
	 * @return
	 */
	@RequestMapping("updateEmployee.action")
	public String updateEmplData(Employee empl,ModelMap map){
		emplService.updateEmpl(empl);
		map.put("empls", emplService.getAllEmpls());
		map.put("emplStatus", subService.getSubsByCateCode(Constants.EMPL_STATUS_CODE));
		return "forward:/admin/employee.jsp";
	}
	
	/**
	 * 员工离职
	 * @param id
	 * @return
	 */
	@RequestMapping("fireEmpl.action")
	public String fireEmpl(Integer id,ModelMap map){
		emplService.updateEmplStatus(id, Constants.EMPL_STATUS_DIS);
		map.put("empls", emplService.getAllEmpls());
		map.put("emplStatus", subService.getSubsByCateCode(Constants.EMPL_STATUS_CODE));
		return "forward:/admin/employee.jsp";
	}
	
}
