package com.wux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wux.entity.Menu;
import com.wux.service.MenuService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	// 查询子菜单
	@RequestMapping("showMenu")
	@ResponseBody
	public List<Menu> showListMenu(String menuId){
		List<Menu> list = menuService.showSubMenu(menuId);
		for (Menu menu : list) {
			System.out.println(menu);
		}
		return list;
	}
}
