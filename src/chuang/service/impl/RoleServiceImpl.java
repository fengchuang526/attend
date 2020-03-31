package chuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IRoleDao;
import chuang.entity.Role;
import chuang.service.IRoleService;

/*
 *	角色service实现类
 */
@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public void saveRole(Role role) {
		roleDao.saveRole(role);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	@Override
	public void deleteRole(Integer id) {
		roleDao.deleteRole(id);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public List<Role> getRolesByStatus(String status) {
		return roleDao.getRolesByStatus(status);
	}

}
