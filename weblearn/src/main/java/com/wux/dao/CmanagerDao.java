package com.wux.dao;

import com.wux.entity.Cmanager;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface CmanagerDao {

	// 登录管理员
	Cmanager showCmanagerByUsername(@Param("username") String username);

	// 注册管理员
	void insertCmanager(Cmanager cmanager);
}
