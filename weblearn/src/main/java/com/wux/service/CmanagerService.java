package com.wux.service;

import javax.servlet.http.HttpSession;

import com.wux.annotation.Comment;
import com.wux.entity.Cmanager;

public interface CmanagerService {
	// 登录管理员
	@Comment("登录")
	Cmanager showCmanagerByUsername(String username, String password, HttpSession session);

	// 注册管理员
	@Comment("注册")
	void registCmanager(Cmanager cmanager);

	
}
