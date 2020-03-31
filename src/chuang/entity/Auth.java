package chuang.entity;
/*
 *	权限实体类
 */
public class Auth{
	/**
	 * 角色
	 */
	private Role role;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 菜单
	 */
	private Menu menu;
	/**
	 * 菜单ID
	 */
	private Integer menuId;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
}
