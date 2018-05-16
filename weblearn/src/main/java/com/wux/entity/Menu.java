package com.wux.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
	private String menu_id;
	private String menu_name;
	private String menu_icon;
	private List<Menu> children;
	private String href;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String menu_id, String menu_name, String menu_icon,
			List<Menu> children, String href) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_icon = menu_icon;
		this.children = children;
		this.href = href;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_icon() {
		return menu_icon;
	}
	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_name=" + menu_name
				+ ", menu_icon=" + menu_icon + ", children=" + children
				+ ", href=" + href + "]";
	}
}
