package com.wux.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wux.annotation.Comment;
import com.wux.entity.Menu;
@Service
public interface MenuService {
	// 增加菜单

		// 删除菜单

		// 修改菜单

		//根据菜单id，查询所有子菜单
	@Comment("展示菜单")
		List<Menu> showSubMenu(String mid);

		//根据菜单id,查询
	@Comment("查询一个菜单")
		Menu showMenuById(String mid);
}
