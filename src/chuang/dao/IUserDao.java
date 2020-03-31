package chuang.dao;

import java.util.List;
import java.util.Map;

import chuang.entity.User;

/*
 *	用户DAO接口
 */
public interface IUserDao{
	public List<User> getUserByUserNo(String userNo);
	public List<User> getUserByNoAndPwd(Map map);
}
