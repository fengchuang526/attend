package chuang.service;

import java.util.List;

import chuang.entity.Menu;

/*
 *	菜单的service接口
 */
public interface IMenuService {
	/**
	 * 保存菜单
	 * @param menu
	 */
	public void saveMenu(Menu menu);
	/**
	 * 更新菜单
	 * @param menu
	 */
	public void updateMenu(Menu menu);
	/**
	 * 删除菜单
	 * @param id
	 */
	public void deleteMenu(Integer id);
	/**
	 * 根据ID查询菜单
	 * @param id
	 * @return
	 */
	public Menu getMenuById(Integer id);
	/**
	 * 查询所有的菜单
	 * @return
	 */
	public List<Menu> getAllMenus();
	
	/**
	 * 通过状态查询菜单
	 * @param status
	 * @return
	 */
	public List<Menu> getMenusByStatus(String status);
}
