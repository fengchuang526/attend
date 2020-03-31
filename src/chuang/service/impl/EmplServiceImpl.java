package chuang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IEmployDao;
import chuang.entity.Employee;
import chuang.service.IEmplService;
import chuang.util.Constants;

/*
 *	员工service实现类
 */
@Service
public class EmplServiceImpl implements IEmplService {
	
	@Autowired
	private IEmployDao emplDao;
	
	@Override
	public void saveEmpl(Employee empl) {
		empl.setEmplStatus(Constants.EMPL_STATUS_NORMAL);
		emplDao.saveEmploy(empl);
	}

	@Override
	public List<Employee> getAllEmpls() {
		return emplDao.getAllEmplo();
	}

	@Override
	public Employee getEmplById(Integer id) {
		return emplDao.getEmplById(id);
	}

	@Override
	public void updateEmpl(Employee empl) {
		emplDao.updateEmpl(empl);
	}

	@Override
	public void updateEmplStatus(Integer id, String status) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("status", status);
		emplDao.changeEmplStatus(map);
	}

	@Override
	public List<Employee> getEmplsByStatus(String status) {
		return emplDao.getEmplsByStatus(status);
	}

}
