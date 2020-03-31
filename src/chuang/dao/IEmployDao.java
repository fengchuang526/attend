package chuang.dao;

import java.util.List;
import java.util.Map;

import chuang.entity.Employee;

/*
 *	员工的DAO接口
 */
public interface IEmployDao {
	
	/**
	 * 添加员工
	 * @param empl 员工
	 */
	public void saveEmploy(Employee empl);
	
	/**
	 * 查询所有的员工
	 * @return
	 */
	public List<Employee> getAllEmplo();
	
	/**
	 * 根据员工ID查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmplById(Integer id);
	
	/**
	 * 更新员工
	 * @param empl
	 */
	public void updateEmpl(Employee empl);
	
	/**
	 * 改变员工状态
	 * @param map
	 */
	public void changeEmplStatus(Map map);
	
	/**
	 * 查询特定状态下的员工
	 * @param status
	 * @return
	 */
	public List<Employee> getEmplsByStatus(String status);
}
