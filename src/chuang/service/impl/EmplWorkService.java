package chuang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IEmplWorkDao;
import chuang.entity.EmplWork;
import chuang.service.IEmplWorkService;

/*
 *	员工考勤serivce
 */
@Service
public class EmplWorkService implements IEmplWorkService {

	@Autowired
	private IEmplWorkDao workDao;
	
	@Override
	public void saveEmplWork(EmplWork work) {
		workDao.saveEmplWork(work);
	}

	@Override
	public List<EmplWork> getWorkByStartAndEndDate(Map map) {
		return workDao.getEmplWorksByDate(map);
	}

	@Override
	public void deleteWorkById(Integer id) {
		workDao.delEmplWork(id);
	}

	@Override
	public void updateWork(EmplWork work) {
		workDao.updateEmplWork(work);
	}

	@Override
	public EmplWork getEmplWorkById(Integer id) {
		return workDao.getEmplWorkById(id);
	}

	@Override
	public List<EmplWork> getEmplWorksByEmplId(Integer id) {
		return workDao.getEmplWorksByEmplId(id);
	}

	@Override
	public List<EmplWork> getAllEmplWorks() {
		return workDao.getAllEmplWorks();
	}

	@Override
	public List<EmplWork> getEmplWorkByDateAndEmplId(Map map) {
		return workDao.getEmplWorksByDateAndEmplId(map);
	}

}
