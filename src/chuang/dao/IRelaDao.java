package chuang.dao;

import java.util.List;

import chuang.entity.Rela;

/*
 *	相关方
 */
public interface IRelaDao {

	/**
	 * 保存相关方
	 * @param rela
	 */
	public void saveRela(Rela rela);
	
	/**
	 * 查询全部相关方
	 * @return
	 */
	public List<Rela> findAllRela();
	
	/**
	 * 更新相关方
	 * @param rela
	 */
	public void updateRela(Rela rela);
}
