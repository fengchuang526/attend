package chuang.service;

import java.util.Map;

import chuang.dto.WarehouseDetailAnalyDTO;
import chuang.entity.WarehouseDetail;

/*
 *	仓库明细
 */
public interface IWarehouseDetailService {

	/**
	 * 保存明细
	 * @param data 明细数据
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> saveDetail(String data) throws Exception;

	/**
	 * 查找全部明细
	 * @param page 第几页
	 * @param size 每页多少
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findWarehouseDetail(Long page, Integer size) throws Exception;

	/**
	 * 删除明细
	 * @param id 明细ID
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteWarehouseDetail(String id) throws Exception;

	/**
	 * 查询交易明细
	 * @param warehouseDetail
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchWarehouseDetail(WarehouseDetail warehouseDetail,Long page,Integer size) throws Exception;

	/**
	 * 统计分析查询
	 * @param warehouseDetailAnalyDTO 统计分析DTO
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> searchWarehouseDetailAnaly(
			WarehouseDetailAnalyDTO warehouseDetailAnalyDTO, Long page,
			Integer size) throws Exception;

}
