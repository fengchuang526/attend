package chuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.ISubDao;
import chuang.entity.DdSub;
import chuang.service.ISubService;

/*
 *	数据字典小类Service实现类
 */
@Service
public class SubServiceImpl implements ISubService {

	@Autowired
	private ISubDao subDao;
	
	@Override
	public void saveSub(DdSub sub) {
		subDao.saveSub(sub);
	}

	@Override
	public List<DdSub> getSubByCateId(Integer cateId) {
		return subDao.getSubByCateId(cateId);
	}

	@Override
	public void delSubByCateId(Integer cateId) {
		subDao.delSubByCateId(cateId);
	}

	@Override
	public void delSubById(Integer id) {
		subDao.delSubById(id);
	}

	@Override
	public void updateSub(DdSub sub) {
		subDao.updateSub(sub);
	}

	@Override
	public List<DdSub> getSubsByCateCode(String cateCode) {
		return subDao.getSubsByCateCode(cateCode);
	}

}
