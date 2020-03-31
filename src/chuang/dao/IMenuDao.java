package chuang.dao;

import java.util.List;

import chuang.entity.Menu;

/*
 *	菜单的DAO接口
 */
public interface IMenuDao {
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	public List<Menu> getAllMenu();
	
	/**
	 * 根据ID获取菜单
	 * @param id
	 * @return
	 */
	public Menu getMenuById(Integer id);
	
	/**
	 * 新增菜单
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
	 * 查找状态下的菜单
	 * @param status
	 * @return
	 */
	public List<Menu> getMenusByStatus(String status);
}
