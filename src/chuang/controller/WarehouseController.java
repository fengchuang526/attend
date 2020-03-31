package chuang.controller;

import java.util.Map;


import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chuang.dao.IRelaDao;
import chuang.dao.IWarehouseDao;
import chuang.enums.CateSubEnum;
import chuang.service.ISubService;
import chuang.service.IWarehouseService;
import chuang.util.AppUtil;

/*
 *	库存
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	private IWarehouseService iWarehouseService;
	@Autowired
	private ISubService subService;
	@Autowired
	private IWarehouseDao iWarehouseDao;
	@Autowired
	private IRelaDao iRelaDao;
	
	/**
	 * 进入商品管理界面
	 * @return
	 */
	@RequestMapping("enterWarehouse.action")
	public String enterWarehouse(Model model){
		model.addAttribute("goodsType", JSONArray.fromObject(subService.getSubsByCateCode("goodsType")));
		return "forward:/admin/warehousemanage.jsp";
	}
	
	/**
	 * 进入出库入库界面
	 * @return
	 */
	@RequestMapping("enterWarehouseOutIn.action")
	public String enterWarehouseOutIn(Model model){
		model.addAttribute("goods", JSONArray.fromObject(iWarehouseDao.findAllWareHouse()));
		model.addAttribute("relaPerson", JSONArray.fromObject(iRelaDao.findAllRela()));
		model.addAttribute("detailType", JSONArray.fromObject(subService.getSubsByCateCode(CateSubEnum.DETAIL_TYPE_CATE.getValue())));
		return "forward:/admin/warehouseoutin.jsp";
	}
	
	/**
	 * 查询仓库
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findWarehouse.action")
	public Map<String, Object> findWarehouse(Long page,Integer size){
		try{
			return iWarehouseService.findWarehouse(page,size);
		}catch(Exception e){
			e.printStackTrace();
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
	/**
	 * 保存商品
	 * @param data 商品信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveWarehouse.action")
	public Map<String, Object> saveWarehouse(String data){
		try{
			return iWarehouseService.saveWarehouse(data);
		}catch(Exception e){
			e.printStackTrace();
			return AppUtil.getMap(false, e.getMessage());
		}
	}
	
}
