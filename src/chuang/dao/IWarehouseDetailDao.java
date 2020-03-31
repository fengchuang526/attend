package chuang.dao;

import java.util.List;

import chuang.dto.WarehouseDetailAnalyDTO;
import chuang.entity.WarehouseDetail;

/*
 *	仓库明细
 */
public interface IWarehouseDetailDao {

	/**
	 * 保存仓库明细
	 * @param warehouseDetail
	 */
	public void saveWarehouseDetail(WarehouseDetail warehouseDetail);
	
	/**
	 * 查找全部明细
	 * @return
	 */
	public List<WarehouseDetail> findAllWarehouseDetail();
	
	/**
	 * 根据ID查询明细
	 * @param id 明细ID
	 * @return
	 */
	public WarehouseDetail findById(String id);
	
	/**
	 * 删除明细
	 * @param id 明细ID
	 */
	public void deleteWarehouseDetail(String id);
	
	/**
	 * 根据条件查询
	 * @param warehouseDetail
	 * @return
	 */
	public List<WarehouseDetail> findWarehouseDetailByCondition(WarehouseDetail warehouseDetail);

	/**
	 * 统计分析-商品维度
	 * @param warehouseDetailAnalyDTO
	 * @return
	 */
	public List<WarehouseDetailAnalyDTO> findWarehouseDetailGoodsAnaly(WarehouseDetailAnalyDTO warehouseDetailAnalyDTO);

	/**
	 * 统计分析-相关方维度
	 * @param warehouseDetailAnalyDTO
	 * @return
	 */
	public List<WarehouseDetailAnalyDTO> findWarehouseDetailRelaAnaly(WarehouseDetailAnalyDTO warehouseDetailAnalyDTO);
}
	