package chuang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import chuang.entity.DdCate;
import chuang.service.ICateService;

/*
 *	数据字典大类controller
 */
@Controller
@RequestMapping("/admin/")
public class CateController {

	@Autowired
	private ICateService cateService;
	
	/**
	 * 添加数据字典大类
	 * @param cate
	 * @param req
	 * @return
	 */
	@RequestMapping("addCate.action")
	public String addCate(DdCate cate,HttpServletRequest req){
		cateService.saveCate(cate);
		req.setAttribute("cates", cateService.getAllCates());
		return "forward:/admin/dd.jsp";
	}
	
	/**
	 * 删除数据字典大类，先删除了小类
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping(value="delCate.action")
	public String delCate(Integer id,HttpServletRequest req){
		cateService.delCate(id);
		req.setAttribute("cates", cateService.getAllCates());
		return "forward:/admin/dd.jsp";
	}
	
	/**
	 * 进入数据字典主界面
	 * @param req
	 * @return
	 */
	@RequestMapping("enterDdView.action")
	public String enterDdView(HttpServletRequest req){
		List<DdCate> cates = cateService.getAllCates();
		req.setAttribute("cates", cates);
		return "forward:/admin/dd.jsp";
	}
	
	/**
	 * 更新数据字典大类
	 * @param cate
	 * @param map
	 * @return
	 */
	@RequestMapping("updateCate.action")
	public String updateCate(DdCate cate,ModelMap map){
		cateService.updateCate(cate);
		map.put("cates", cateService.getAllCates());
		return "forward:/admin/dd.jsp";
	}
}
