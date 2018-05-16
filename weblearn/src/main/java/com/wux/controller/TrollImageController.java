package com.wux.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wux.entity.PageData;
import com.wux.entity.TrollImage;
import com.wux.service.TrollImageService;

@Controller
@RequestMapping("/trollimage")
public class TrollImageController {
	@Autowired
	private TrollImageService trollImageService;
	// 上传图片
	@RequestMapping("/upload")
	public void upload(MultipartFile source, HttpServletRequest req, TrollImage trollImage){    // 上传轮播图
		trollImageService.addTrollImage(source, req, trollImage);
	}
	
	@RequestMapping("showTrollImage")
	@ResponseBody
	public <T> PageData<T> showTrollImage(Integer page, Integer rows){    // 展示轮播图
		PageData<T> pageData = new PageData<T>();
		List<TrollImage> list = trollImageService.showTrollImage(page, rows);
		pageData.setRows((List<T>) list);
		pageData.setTotal(trollImageService.showTotalTrollImage());
		return pageData;
	}
	
	@RequestMapping("setTrollImage")
	@ResponseBody
	public String setTrollImage(TrollImage trollImage){    // 删除轮播图
		trollImageService.setTrollImage(trollImage);
		return "ok";
	}
	
	@RequestMapping("delTrollImage")
	@ResponseBody
	public String delTrollImage(String id){    // 删除轮播图
		trollImageService.delTrollImage(id);
		return "ok";
	}
}
