package com.wux.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wux.entity.PageData;
import com.wux.entity.Special;
import com.wux.entity.TrollImage;
import com.wux.service.SpecialService;

@Controller
@RequestMapping("/special")
public class SpecialController {
	
	@Autowired
	private SpecialService ss;
	
	@RequestMapping("/queryByPage")
	@ResponseBody
	public <T> PageData<T> queryByPage(Integer page,Integer rows){
		PageData<T> pageData = new PageData<T>();
		List<T> list = (List<T>) ss.queryByPage(page, rows);
		Integer count = ss.count();
		pageData.setRows(list);
		pageData.setTotal(count);
		return pageData;
	}

	@RequestMapping("/add")
	@ResponseBody
	public void add(MultipartHttpServletRequest mreq, HttpSession session, HttpServletRequest req,Special s){
		List<MultipartFile> files = mreq.getFiles("file");
		for(MultipartFile file:files){
			ss.add(file, req, session, s);
		}
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public void del(HttpSession session,String id){
		System.out.println(id);
		ss.del(id, session);
	}
	
	@RequestMapping("/change")
	@ResponseBody
	public void change(Special s){
		ss.update(s);
	}
	
	
	@RequestMapping("/queryOne/{id}")
	@ResponseBody
	public Special queryOneSpecial(@PathVariable("id")String id){
		Special special = ss.selectById(id);
		return special;
	}
}
