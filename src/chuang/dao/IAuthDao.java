package chuang.dao;

import chuang.entity.Auth;

/*
 *	权限的DAO接口
 */
public interface IAuthDao {

	/**
	 * 保存权限
	 * @param auth
	 */
	public void saveAuth(Auth auth);
	
	/**
	 * 删除权限
	 * @param auth
	 */
	public void deleAuth(Auth auth);
	
	
}
