package chuang.dao;

import java.util.List;

import chuang.entity.DdSub;

/*
 *	数据字典小类DAO接口
 */
public interface ISubDao {

	/**
	 * 添加数据字典小类
	 * @param sub
	 */
	public void saveSub(DdSub sub);
	
	/**
	 * 根据大类ID查询小类
	 * @param id
	 * @return
	 */
	public List<DdSub> getSubByCateId(Integer id);
	
	/**
	 * 根据大类ID删除小类
	 * @param id
	 */
	public void delSubByCateId(Integer id);
	
	/**
	 * 根据ID删除小类
	 * @param id
	 */
	public void delSubById(Integer id);
	
	/**
	 * 更新数据字典小类
	 * @param sub
	 */
	public void updateSub(DdSub sub);
	
	/**
	 * 根据大类code查询小类
	 * @param cateCode
	 * @return
	 */
	public List<DdSub> getSubsByCateCode(String cateCode);
}
