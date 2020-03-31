package chuang.entity;

import java.util.HashSet;
import java.util.Set;

/*
 *	角色实体类
 */
public class Role extends IdEntity {
	/**
	 * 角色编码
	 */
	private String roleCode;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 是否使用
	 */
	private String isUse;
	/**
	 * 用户集合
	 */
	private Set<User> users = new HashSet<User>(0);
	/**
	 * 菜单集合
	 */
	private Set<Menu> auths = new HashSet<Menu>(0);
	
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Menu> getAuths() {
		return auths;
	}
	public void setAuths(Set<Menu> auths) {
		this.auths = auths;
	}
}
