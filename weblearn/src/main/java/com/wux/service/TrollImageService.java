package com.wux.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wux.entity.TrollImage;
import org.springframework.web.multipart.MultipartFile;

import com.wux.annotation.Comment;
import com.wux.entity.TrollImage;


public interface TrollImageService {
	@Comment("增加轮播图")
	void addTrollImage(MultipartFile source, HttpServletRequest req, TrollImage trollImage);
	@Comment("分页查询轮播图")
	List<TrollImage> showTrollImage(Integer page, Integer rows);
	@Comment("展示轮播图")
	Integer  showTotalTrollImage();
	@Comment("编辑轮播图")
	void setTrollImage(TrollImage trollImage);
	@Comment("删除轮播图")
	void delTrollImage(String id);

}
