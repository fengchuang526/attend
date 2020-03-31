package chuang.service;

import java.util.Map;


/*
 *	仓库
 */
public interface IWarehouseService {

	/**
	 * 查询仓库
	 * @return
	 */
	public Map<String, Object> findWarehouse(Long page,Integer size);

	/**
	 * 保存商品
	 * @param data
	 * @return
	 */
	public Map<String, Object> saveWarehouse(String data);

}
