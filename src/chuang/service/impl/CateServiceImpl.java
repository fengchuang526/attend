package chuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chuang.dao.ICateDao;
import chuang.dao.ISubDao;
import chuang.entity.DdCate;
import chuang.service.ICateService;

/*
 *	数据字典大类service实现类
 */
@Service
public class CateServiceImpl implements ICateService {

	@Autowired
	private ICateDao cateDao;
	@Autowired
	private ISubDao subDao;
	
	@Override
	public void saveCate(DdCate cate) {
		cateDao.saveCate(cate);
	}

	@Override
	public List<DdCate> getAllCates() {
		return cateDao.getAllCate();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delCate(Integer cateId) {
		subDao.delSubByCateId(cateId);
		cateDao.delCate(cateId);
	}

	@Override
	public void updateCate(DdCate cate) {
		cateDao.updateCateById(cate);
	}

}
