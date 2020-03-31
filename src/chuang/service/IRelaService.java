package chuang.service;

import java.util.Map;

/*
 *	相关方
 */
public interface IRelaService {

	/**
	 * 查询全部相关方
	 * @return
	 */
	public Map<String, Object> findAllRela(Long page,Integer size) throws Exception;

	/**
	 * 保存相关方
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> saveRela(String data) throws Exception;

}
