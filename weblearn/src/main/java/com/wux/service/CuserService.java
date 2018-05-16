package com.wux.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.wux.annotation.Comment;
import com.wux.entity.Cuser;


public interface CuserService {
	@Comment("分页查询用户")
	List<Cuser> showCuser(Integer page, Integer rows);
	@Comment("查询用户总数")
	Integer showTotalCuser();
	@Comment("删除用户")
	void removeCuser(String id);
	@Comment("更新用户")
	void updateCuser(Cuser cuser);
	@Comment("用户登录")
	Cuser login(String username, String password, HttpSession session);


	

}
