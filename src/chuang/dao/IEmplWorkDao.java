package chuang.dao;

import java.util.List;
import java.util.Map;

import chuang.entity.EmplWork;

/*
 *	员工考勤DAO
 */
public interface IEmplWorkDao {

	/**
	 * 保存考勤
	 * @param work
	 */
	public void saveEmplWork(EmplWork work);
	
	/**
	 * 更新考勤记录
	 * @param work
	 */
	public void updateEmplWork(EmplWork work);
	
	/**
	 * 删除考勤记录
	 * @param id
	 */
	public void delEmplWork(Integer id);
	
	/**
	 * 得到全部的考勤记录
	 * @return
	 */
	public List<EmplWork> getAllEmplWorks();
	
	/**
	 * 查询出某一段时间的考勤记录
	 * @param map
	 * @return
	 */
	public List<EmplWork> getEmplWorksByDate(Map map);
	
	/**
	 * 查询出特定员工的考勤记录
	 * @param id
	 * @return
	 */
	public List<EmplWork> getEmplWorksByEmplId(Integer id);
	
	/**
	 * 根据id查询考勤记录
	 * @param id
	 * @return
	 */
	public EmplWork getEmplWorkById(Integer id);
	
	/**
	 * 查询特定时间的特定员工的考勤记录
	 * @param map
	 * @return
	 */
	public List<EmplWork> getEmplWorksByDateAndEmplId(Map map);
}
