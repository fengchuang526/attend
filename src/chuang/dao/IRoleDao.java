package chuang.dao;

import java.util.List;

import chuang.entity.Role;

/*
 *	角色DAO接口
 */
public interface IRoleDao {

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
	 * 查询出所有的角色
	 * @return
	 */
	public List<Role> getAllRoles();
	/**
	 * 查询出特定状态的菜单
	 * @param status
	 * @return
	 */
	public List<Role> getRolesByStatus(String status);
	
	
	
	
	
}
