package com.wux.dao;

import java.util.List;

import com.wux.entity.Menu;
import org.apache.ibatis.annotations.Param;

import com.wux.entity.Menu;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao {

	// 增加菜单

	// 删除菜单

	// 修改菜单

	//根据菜单id，查询所有子菜单
	List<Menu> selectSubMenu(@Param("mid") String mid);

	//根据菜单id,查询
	Menu selectMenuById(@Param("mid") String mid);
}
