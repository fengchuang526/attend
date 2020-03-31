package chuang.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.util.LocaleServiceProviderPool.LocalizedObjectGetter;

import chuang.dao.IWarehouseDao;
import chuang.dao.IWarehouseDetailDao;
import chuang.dto.WarehouseDetailAnalyDTO;
import chuang.entity.Warehouse;
import chuang.entity.WarehouseDetail;
import chuang.enums.WarehouseEnum;
import chuang.service.IWarehouseDetailService;
import chuang.util.AppUtil;
import chuang.util.ResponsePage;

/*
 *	仓库明细
 */
@Service
public class WarehouseDetailServiceImpl implements IWarehouseDetailService {
	
	@Autowired
	private IWarehouseDetailDao warehouseDetailDao;
	@Autowired
	private IWarehouseDao warehouseDao;

	@Override
	public Map<String, Object> saveDetail(String data) throws Exception {
		if(StringUtils.isBlank(data)){
			return AppUtil.getMap(false, "无法保存：传入的参数为空！");
		}
		JSONObject json = JSONObject.fromObject(data);
		WarehouseDetail warehouseDetail = (WarehouseDetail)JSONObject.toBean(json, WarehouseDetail.class);
		String detailType = json.getString("detailType");
		//查询商品
		Warehouse warehouse = warehouseDao.findByGoodsCode(json.getString("goodsCode"));
		if(warehouse == null){
			return AppUtil.getMap(false, "无法保存：不存在此商品！");
		}
		Integer goodsNum = warehouse.getGoodsNum();
		Integer detailNum = warehouseDetail.getDetailNum();
		if(WarehouseEnum.DETAIL_TYPE_IN.getValue().equals(detailType)){
			//入库
			warehouse.setGoodsNum(goodsNum + detailNum);
		}else if(WarehouseEnum.DETAIL_TYPE_OUT.getValue().equals(detailType)){
			//出库
			if(goodsNum < detailNum){
				throw new RuntimeException("商品库存少于交易数量！");
			}
			warehouse.setGoodsNum(goodsNum - detailNum);
		}
		warehouseDao.updateGoodsNum(warehouse);
		//计算明细总价
		warehouseDetail.setDetailAmt(warehouseDetail.getDetailNum() * warehouse.getGoodsPrice());
		warehouseDetailDao.saveWarehouseDetail(warehouseDetail);
		return AppUtil.getMap(true, "保存成功！");
	}

	@Override
	public Map<String, Object> findWarehouseDetail(Long page, Integer size)
			throws Exception {
		List<WarehouseDetail> list = warehouseDetailDao.findAllWarehouseDetail();
		ResponsePage<WarehouseDetail> response = new ResponsePage<WarehouseDetail>();
		response.setAllData(list);
		response.setNumber(page);
		response.setSize(size);
		return AppUtil.getMap(response);
	}

	@Override
	public Map<String, Object> deleteWarehouseDetail(String id)
			throws Exception {
		if(StringUtils.isBlank(id)){
			return AppUtil.getMap(false, "无法删除：传入的ID为空！");
		}
		WarehouseDetail warehouseDetail = warehouseDetailDao.findById(id);
		if(warehouseDetail == null){
			return AppUtil.getMap(false, "无法删除：明细不存在！");
		}
		Integer detailNum = warehouseDetail.getDetailNum();
		if(detailNum != null && detailNum > 0){
			String detailType = warehouseDetail.getDetailType();
			Warehouse warehouse = warehouseDao.findByGoodsCode(warehouseDetail.getGoodsCode());
			if(WarehouseEnum.DETAIL_TYPE_IN.getValue().equals(detailType)){
				//入库明细:要减回去
				warehouse.setGoodsNum(warehouse.getGoodsNum() - detailNum);
			}else if(WarehouseEnum.DETAIL_TYPE_OUT.getValue().equals(detailType)){
				//出库明细：要加回来
				warehouse.setGoodsNum(warehouse.getGoodsNum() + detailNum);
			}
			warehouseDao.updateGoodsNum(warehouse);
		}
		warehouseDetailDao.deleteWarehouseDetail(id);
		return AppUtil.getMap(true, "删除成功！");
	}

	@Override
	public Map<String, Object> searchWarehouseDetail(
			WarehouseDetail warehouseDetail,Long page,Integer size) throws Exception {
		List<WarehouseDetail> list = warehouseDetailDao.findWarehouseDetailByCondition(warehouseDetail);
		ResponsePage<WarehouseDetail> response = new ResponsePage<WarehouseDetail>();
		response.setAllData(list);
		response.setNumber(page);
		response.setSize(size);
		return AppUtil.getMap(response);
	}

	@Override
	public Map<String, Object> searchWarehouseDetailAnaly(
			WarehouseDetailAnalyDTO warehouseDetailAnalyDTO, Long page,
			Integer size) throws Exception {
		String statisType = warehouseDetailAnalyDTO.getStatisType();
		List<WarehouseDetailAnalyDTO> list = null;
		if(WarehouseEnum.STATIS_RELA.getValue().equals(statisType)){
			//相关方
			list = warehouseDetailDao.findWarehouseDetailRelaAnaly(warehouseDetailAnalyDTO);
		}else{
			//商品（默认也为商品）
			list = warehouseDetailDao.findWarehouseDetailGoodsAnaly(warehouseDetailAnalyDTO);
		}
		ResponsePage<WarehouseDetailAnalyDTO> response = new ResponsePage<WarehouseDetailAnalyDTO>();
		response.setAllData(list);
		response.setNumber(page);
		response.setSize(size);
		return AppUtil.getMap(response);
	}

}
