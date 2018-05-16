package com.wux.dao;

import com.wux.entity.Menus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenusDao {

	Menus findMenus(@Param("id") Integer id);
	List<Menus> findAll();
	List<Menus> findPage(@Param("start")Integer start, @Param("pageSize") Integer pageSize);
	void addMenus(Menus menus);
	void removeMenus(@Param("id") Integer id);
	void modifyMenus(Menus menus);
	Integer count();
}
