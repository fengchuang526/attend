package chuang.service;

import java.util.List;

import chuang.entity.DdCate;

/*
 *	数据字典大类service接口
 */
public interface ICateService {
	
	public void saveCate(DdCate cate);
	
	public List<DdCate> getAllCates();
	
	public void delCate(Integer cateId);
	
	public void updateCate(DdCate cate);
}
