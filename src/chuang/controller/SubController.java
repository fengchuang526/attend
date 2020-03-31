package chuang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import chuang.entity.DdSub;
import chuang.service.ICateService;
import chuang.service.ISubService;

/*
 *	数据字典小类Controller
 */
@Controller
@RequestMapping("/admin/")
public class SubController {

	@Autowired
	private ISubService subService;
	@Autowired
	private ICateService cateService;
	
	/**
	 * 异步查询大类下的小类
	 * @param id
	 * @param res
	 */
	@RequestMapping("findSubsByCateId.action")
	public void findSubByCateId(Integer id,HttpServletResponse res){
		List<DdSub> subs = subService.getSubByCateId(id);
		PrintWriter writer = null;
		try {
			writer = res.getWriter();
			writer.print(JSONArray.fromObject(subs).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
		
	}
	
	/**
	 * 添加小类
	 * @param sub
	 * @param map
	 * @return
	 */
	@RequestMapping("addSub.action")
	public String addSub(DdSub sub,ModelMap map){
		subService.saveSub(sub);
		map.put("cates", cateService.getAllCates());
		map.put("cateId", sub.getpId());
		return "forward:/admin/dd.jsp";
	}
	
	/**
	 * 更新小类
	 * @param sub
	 * @param map
	 * @return
	 */
	@RequestMapping("updateSub.action")
	public String updateSub(DdSub sub,ModelMap map){
		subService.updateSub(sub);
		map.put("cates", cateService.getAllCates());
		map.put("cateId", sub.getpId());
		return "forward:/admin/dd.jsp";
	}
	
	/**
	 * 删除小类
	 * @param id
	 */
	@RequestMapping("delSub.action")
	public void delSubById(Integer id,HttpServletResponse res){
		subService.delSubById(id);
		JSONObject jo = new JSONObject();
		jo.put("success", true);
		PrintWriter writer = null;
		try {
			writer = res.getWriter();
			writer.print(jo);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
	}
}
