package chuang.dao;

import java.util.List;

import chuang.entity.DdCate;

/*
 *	数据字典大类DAO接口
 */
public interface ICateDao {
	/**
	 * 添加数据字典大类
	 * @param cate
	 */
	public void saveCate(DdCate cate);
	
	/**
	 * 得到所有的数据字典大类
	 * @return
	 */
	public List<DdCate> getAllCate();
	
	/**
	 * 删除数据字典大类
	 * @param id
	 */
	public void delCate(Integer id);
	
	/**
	 * 更新数据字典大类
	 * @param cate
	 */
	public void updateCateById(DdCate cate);
}
