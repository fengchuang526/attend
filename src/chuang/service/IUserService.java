package chuang.service;

import chuang.entity.User;

/*
 *	用户Service接口
 */
public interface IUserService {
	/**
	 * 根据账号和密码查找用户
	 * @param userNo 账号 
	 * @param pwd  密码
	 * @return
	 */
	public User userLogin(String userNo,String pwd);
}
