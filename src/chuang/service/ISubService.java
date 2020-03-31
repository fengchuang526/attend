package chuang.service;

import java.util.List;

import chuang.entity.DdSub;

/*
 *	数据字典小类Service接口
 */
public interface ISubService {
	/**
	 * 添加小类
	 * @param sub
	 */
	public void saveSub(DdSub sub);
	
	/**
	 * 查询大类下面的全部小类
	 * @param cateId
	 * @return
	 */
	public List<DdSub> getSubByCateId(Integer cateId);
	
	/**
	 * 根据大类ID删除小类
	 * @param cateId
	 */
	public void delSubByCateId(Integer cateId);
	
	/**
	 * 根据小类ID删除小类
	 * @param id
	 */
	public void delSubById(Integer id);
	
	/**
	 * 更新数据字典小类
	 * @param sub
	 */
	public void updateSub(DdSub sub);
	
	/**
	 * 根据大类CODE查询小类
	 * @param cateCode
	 * @return
	 */
	public List<DdSub> getSubsByCateCode(String cateCode);
	
}
