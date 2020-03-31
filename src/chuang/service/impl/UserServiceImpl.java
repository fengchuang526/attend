package chuang.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IUserDao;
import chuang.entity.User;
import chuang.service.IUserService;

/*
 *	用户Service实现类
 */
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	/**
	 * 0:账号不存在	 1：密码错误  2：成功登陆
	 */
	public User userLogin(String userNo, String pwd) {
		List<User> users = new ArrayList<User>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("no", userNo);
		map.put("pwd", pwd);
		users = userDao.getUserByNoAndPwd(map);
		if(users != null && users.size() > 0){
			return users.get(0);
		}
		return null;
	}
	
}
