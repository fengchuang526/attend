package chuang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IMenuDao;
import chuang.entity.Menu;
import chuang.service.IMenuService;

/*
 *	菜单Service的实现类
 */
@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuDao menuDao;
	
	@Override
	public void saveMenu(Menu menu) {
		menuDao.saveMenu(menu);
	}

	@Override
	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}

	@Override
	public void deleteMenu(Integer id) {
		menuDao.deleteMenu(id);
	}

	@Override
	public Menu getMenuById(Integer id) {
		return menuDao.getMenuById(id);
	}

	@Override
	public List<Menu> getAllMenus() {
		return menuDao.getAllMenu();
	}

	@Override
	public List<Menu> getMenusByStatus(String status) {
		return menuDao.getMenusByStatus(status);
	}

}
