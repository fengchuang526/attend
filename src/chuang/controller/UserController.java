package chuang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import chuang.entity.User;
import chuang.service.IMenuService;
import chuang.service.impl.UserServiceImpl;
import chuang.util.Constants;

/*
 *	用户controller
 */
@Controller
public class UserController {
	
	@Autowired 
	private UserServiceImpl userBiz;
	@Autowired
	private IMenuService menuService;
	
	/**
	 * 用户登录
	 * @param req
	 * @param res
	 * @param userNo
	 * @param userPwd
	 * @return
	 */
	@RequestMapping("/userLogin.action")
	public String userLogin(HttpServletRequest req,HttpServletResponse res,String userNo,String userPwd){
		User user = userBiz.userLogin(userNo, userPwd);
		if(user == null){
			req.setAttribute("msg", "账号或者密码错误!");
			return "forward:/login.jsp";
		}
		//在此处把用户的权限全部查询出来
		req.getSession().setAttribute("currUser", user);
		req.getSession().setAttribute("menus", menuService.getMenusByStatus(Constants.YES));
		return "redirect:/index.jsp";
	}
	
	
}
