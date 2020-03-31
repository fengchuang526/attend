package chuang.dao;

import java.util.List;

import chuang.entity.Warehouse;

/*
 *	仓库接口
 */
public interface IWarehouseDao {

	/**
	 * 查询仓库
	 * @return
	 */
	public List<Warehouse> findAllWareHouse();
	
	/**
	 * 保存
	 * @param warehouse
	 */
	public void saveWarehouse(Warehouse warehouse);
	
	/**
	 * 更新库存
	 * @param warehouse
	 */
	public void updateWarehouse(Warehouse warehouse);
	
	/**
	 * 根据商品编码查询商品
	 * @param goodsCode 商品编码
	 * @return
	 */
	public Warehouse findByGoodsCode(String goodsCode);
	
	/**
	 * 更新商品数量
	 * @param warehouse 商品信息
	 */
	public void updateGoodsNum(Warehouse warehouse);
}
