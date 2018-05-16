package com.wux.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.wux.annotation.Comment;
import com.wux.entity.Special;

public interface SpecialService {
	@Comment("分页查询专辑")
	public List<Special> queryByPage(Integer currentPage, Integer rows);
	@Comment("统计专辑")
	public Integer count();
	@Comment("查询专辑")
	public Special selectById(String id);
//	public Special selectByPrimaryKey(String id);
	@Comment("删除专辑")
	public void del(String id, HttpSession session);
	@Comment("增加专辑")
	public void add(MultipartFile file, HttpServletRequest req, HttpSession session, Special s);
	@Comment("编辑专辑")
	public void update(Special special);
}
