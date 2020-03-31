package chuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import chuang.service.IRoleService;
import chuang.service.ISubService;
import chuang.util.Constants;

/*
 *	权限的Controller
 */
@Controller
@RequestMapping("/admin/")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	@Autowired
	private ISubService subService;
	
	/**
	 * 进入角色管理主界面
	 * @param map
	 * @return
	 */
	@RequestMapping("enterRoleIndex.action")
	public String enterRoleIndex(ModelMap map){
		map.put("roles", roleService.getAllRoles());
		map.put("yesOrNo", subService.getSubsByCateCode(Constants.YES_OR_NO));
		return "forward:/admin/role.jsp";
	}
	
	
	
}
