package chuang.entity;

import java.util.HashSet;
import java.util.Set;

/*
 *	数据字典大类
 */
public class DdCate extends IdEntity {
	/**
	 * 大类编码
	 */
	private String cateCode;
	/**
	 * 大类名称
	 */
	private String cateName;
	/**
	 * 大类描述
	 */
	private String cateDesc;
	/**
	 * 小类集合
	 */
	private Set subs = new HashSet();
	
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateDesc() {
		return cateDesc;
	}
	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}
	public Set getSubs() {
		return subs;
	}
	public void setSubs(Set subs) {
		this.subs = subs;
	}
}
