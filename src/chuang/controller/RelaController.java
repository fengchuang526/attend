package chuang.controller;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chuang.service.IRelaService;
import chuang.util.AppUtil;

/*
 *	相关方
 */
@Controller
@RequestMapping("/rela")
public class RelaController {
	
	private static final Logger LOG = LogManager.getLogger(RelaController.class);

	@Autowired
	private IRelaService iRelaService;
	
	/**
	 * 进入相关方管理
	 * @return
	 */
	@RequestMapping("enterRelaManage.action")
	public String enterRelaManage(){
		return "forward:/admin/relamanage.jsp";
	}

	/**
	 * 查询相关方
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findRela.action")
	public Map<String, Object> findRela(Long page,Integer size){
		try{
			return iRelaService.findAllRela(page,size);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
	/**
	 * 保存相关方
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveRela.action")
	public Map<String, Object> saveRela(String data){
		try{
			return iRelaService.saveRela(data);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
			return AppUtil.getMap(false, e.getMessage());
		}
	}

}
