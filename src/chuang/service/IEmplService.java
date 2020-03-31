package chuang.service;

import java.util.List;

import chuang.entity.Employee;

/*
 *	员工的service
 */
public interface IEmplService {

	public void saveEmpl(Employee empl);
	
	public List<Employee> getAllEmpls();
	
	public Employee getEmplById(Integer id);
	
	public void updateEmpl(Employee empl);
	
	public void updateEmplStatus(Integer id,String status);
	
	public List<Employee> getEmplsByStatus(String status);
}
