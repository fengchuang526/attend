package chuang.service;

import java.util.List;
import java.util.Map;

import chuang.entity.EmplWork;

/*
 *	员工考勤service
 */
public interface IEmplWorkService {
	
	/**
	 * 保存考勤
	 * @param work
	 */
	public void saveEmplWork(EmplWork work);
	
	/**
	 * 获取范围内的考勤记录
	 * @param map
	 * @return
	 */
	public List<EmplWork> getWorkByStartAndEndDate(Map map);
	
	public void deleteWorkById(Integer id);
	
	public void updateWork(EmplWork work);
	
	public EmplWork getEmplWorkById(Integer id);
	
	public List<EmplWork> getEmplWorksByEmplId(Integer id);
	
	public List<EmplWork> getAllEmplWorks();
	
	public List<EmplWork> getEmplWorkByDateAndEmplId(Map map);
	
}
