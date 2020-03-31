package chuang.controller;

import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chuang.dao.IRelaDao;
import chuang.dao.IWarehouseDao;
import chuang.dto.WarehouseDetailAnalyDTO;
import chuang.entity.WarehouseDetail;
import chuang.enums.CateSubEnum;
import chuang.service.ISubService;
import chuang.service.IWarehouseDetailService;
import chuang.util.AppUtil;

/*
 *	仓库明细
 */
@Controller
@RequestMapping("/warehouseDetail")
public class WarehouseDetailController {
	
	private static final Logger LOG = LogManager.getLogger(WarehouseDetailController.class);

	@Autowired
	private IWarehouseDetailService iWarehouseDetailService;
	@Autowired
	private ISubService subService;
	@Autowired
	private IWarehouseDao iWarehouseDao;
	@Autowired
	private IRelaDao iRelaDao;
	
	
	/**
	 * 保存明细
	 * @param data 明细数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveDetail.action")
	public Map<String, Object> saveDetail(String data){
		try{
			return iWarehouseDetailService.saveDetail(data);
		}catch(Exception e){
			e.printStackTrace();
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
	/**
	 * 查询明细
	 * @param page 第几页
	 * @param size 每页多少
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findWarehouseDetail.action")
	public Map<String, Object> findWarehouseDetail(Long page,Integer size){
		try{
			return iWarehouseDetailService.findWarehouseDetail(page,size);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage(),e);
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
	/**
	 * 删除明细
	 * @param id 明细ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteWarehouseDetail.action")
	public Map<String, Object> deleteWarehouseDetail(String id){
		try{
			return iWarehouseDetailService.deleteWarehouseDetail(id);
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
	/**
	 * 进入统计分析界面
	 * @return
	 */
	@RequestMapping("enterWarehouseStatisAnaly.action")
	public String enterWarehouseStatisAnaly(ModelMap modelMap){
		modelMap.put("detailType", JSONArray.fromObject(subService.getSubsByCateCode(CateSubEnum.DETAIL_TYPE_CATE.getValue())));
		modelMap.addAttribute("goods", JSONArray.fromObject(iWarehouseDao.findAllWareHouse()));
		modelMap.addAttribute("relaPerson", JSONArray.fromObject(iRelaDao.findAllRela()));
		return "forward:/warehousestatisanaly.jsp";
	} 
	
	/**
	 * 查询交易明细
	 * @param warehouseDetail
	 * @return
	 */
	@ResponseBody
	@RequestMapping("searchWarehouseDetail.action")
	public Map<String, Object> searchWarehouseDetail(WarehouseDetail warehouseDetail,Long page,Integer size){
		try{
			return iWarehouseDetailService.searchWarehouseDetail(warehouseDetail,page,size);
		}catch(Exception e){
			e.printStackTrace();
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
	/**
	 * 交易明细统计分析
	 * @param warehouseDetailAnalyDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("searchWarehouseDetailAnaly.action")
	public Map<String, Object> searchWarehouseDetailAnaly(WarehouseDetailAnalyDTO warehouseDetailAnalyDTO,Long page,Integer size){
		try{
			return iWarehouseDetailService.searchWarehouseDetailAnaly(warehouseDetailAnalyDTO,page,size);
		}catch(Exception e){
			e.printStackTrace();
			return AppUtil.getMap(false, e.getMessage());
		}
	}
}
