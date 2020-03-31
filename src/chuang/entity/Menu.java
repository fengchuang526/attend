package chuang.entity;

import java.util.HashSet;
import java.util.Set;

/*
 *	菜单表
 */
public class Menu extends IdEntity{
	/**
	 * 菜单编码
	 */
	private String menuCode;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单链接地址
	 */
	private String menuUrl;
	/**
	 * 是否使用
	 */
	private String isUse;
	/**
	 * 是否为叶子  0：N   1：Y
	 */
	private String isLeaf; 
	/**
	 * 父几点ID
	 */
	private Integer parentId;
	/**
	 * 根节点ID
	 */
	private Integer rootId;
	/**
	 * 子菜单
	 */
	private Set<Menu> children = new HashSet<Menu>(0);

	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getRootId() {
		return rootId;
	}
	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}
	public Set<Menu> getChildren() {
		return children;
	}
	public void setChildren(Set<Menu> children) {
		this.children = children;
	}
	
}
