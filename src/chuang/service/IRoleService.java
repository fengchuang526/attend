package chuang.service;

import java.util.List;

import chuang.entity.Role;

/*
 *	角色的service接口
 */
public interface IRoleService {
	/**
	 * 保存角色
	 * @param role
	 */
	public void saveRole(Role role);
	/**
	 * 更新角色
	 * @param role
	 */
	public void updateRole(Role role);
	/**
	 * 删除角色
	 * @param id
	 */
	public void deleteRole(Integer id);
	/**
	 * 获取全部的角色
	 * @return
	 */
	public List<Role> getAllRoles();
	/**
	 * 获取特定状态的角色
	 * @return
	 */
	public List<Role> getRolesByStatus(String status);
}
