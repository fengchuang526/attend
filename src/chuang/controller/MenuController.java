package chuang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import chuang.entity.Menu;
import chuang.service.IMenuService;
import chuang.service.ISubService;
import chuang.util.Constants;

import net.sf.json.JSONArray;
/*
 *	菜单的控制层
 */
@Controller
@RequestMapping("/admin/")
public class MenuController {
	
	@Autowired
	private IMenuService menuService;
	@Autowired
	private ISubService subService;
	
	/**
	 * 进入菜单管理主页面
	 * @param map
	 * @return
	 */
	@RequestMapping("enterMenuIndex.action")
	public String enterMenuIndex(ModelMap map){
		map.put("menus", menuService.getAllMenus());
		map.put(Constants.YES_OR_NO, subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/menu.jsp";
	}
	
	/**
	 * 进入添加菜单页面
	 * @return
	 */
	@RequestMapping("enterAddMenu.action")
	public String enterAddMenu(ModelMap map){
		map.put(Constants.YES_OR_NO, subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/addmenu.jsp";
	}
	
	/**
	 * 添加菜单
	 * @return
	 */
	@RequestMapping("addMenu.action")
	public String addMenu(Menu menu,ModelMap map){
		String isUse = menu.getIsUse();
		if(isUse==null||"".equals(isUse)){
			menu.setIsUse(Constants.YES);
		}
		menuService.saveMenu(menu);
		map.put("menus", menuService.getAllMenus());
		map.put(Constants.YES_OR_NO, subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/menu.jsp";
	}
	
	/**
	 * 进入更新菜单页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("enterUpdateMenu.action")
	public String enterUpdateMenu(Integer id,ModelMap map){
		map.put("menu", menuService.getMenuById(id));
		map.put(Constants.YES_OR_NO, subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/addmenu.jsp";
	}
	
	/**
	 * 更新菜单
	 * @param menu
	 * @param map
	 * @return
	 */
	@RequestMapping("updataMenu.action")
	public String updateMenu(Menu menu,ModelMap map){
		menuService.updateMenu(menu);
		map.put("menus", menuService.getAllMenus());
		map.put(Constants.YES_OR_NO, subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/menu.jsp";
	}
	
	/**
	 * 删除菜单
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteMenu.action")
	public String deleteMenu(Integer id,ModelMap map){
		menuService.deleteMenu(id);
		map.put("menus", menuService.getAllMenus());
		map.put(Constants.YES_OR_NO, subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/menu.jsp";
	}
	
	/**
	 * 获取启用的菜单
	 */
	@RequestMapping("getUseMenus.action")
	public void getUseMenus(HttpServletResponse res){
		List<Menu> menus = menuService.getMenusByStatus(Constants.YES);
		PrintWriter writer = null;
		try {
			writer = res.getWriter();
			writer.print(JSONArray.fromObject(menus).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
	}
	
}
