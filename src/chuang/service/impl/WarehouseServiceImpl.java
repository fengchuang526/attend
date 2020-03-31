package chuang.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IWarehouseDao;
import chuang.entity.Warehouse;
import chuang.service.IWarehouseService;
import chuang.util.AppUtil;
import chuang.util.ResponsePage;

/*
 *	仓库
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService {

	@Autowired
	private IWarehouseDao iWarehouseDao;
	
	@Override
	public Map<String, Object> findWarehouse(Long page,Integer size) {
		List<Warehouse> list = iWarehouseDao.findAllWareHouse();
		ResponsePage<Warehouse> response = new ResponsePage<Warehouse>();
		response.setAllData(list);
		response.setNumber(page);
		response.setSize(size);
		return AppUtil.getMap(response);
	}

	@Override
	public Map<String, Object> saveWarehouse(String data) {
		if(StringUtils.isBlank(data)){
			return AppUtil.getMap(false, "无法保存：传入的信息为空！");
		}
		JSONObject json = JSONObject.fromObject(data);
		Warehouse warehouse = (Warehouse)JSONObject.toBean(json, Warehouse.class);
		String id = json.getString("id");
		if(StringUtils.isBlank(id)){//新增
			iWarehouseDao.saveWarehouse(warehouse);
		}else{//编辑
			iWarehouseDao.updateWarehouse(warehouse);
		}
		return AppUtil.getMap(true, "保存成功！");
	}

}
