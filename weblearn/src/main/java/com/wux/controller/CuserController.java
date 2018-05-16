package com.wux.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wux.entity.Cuser;
import com.wux.entity.PageData;
import com.wux.service.CuserService;

@Controller
@RequestMapping("/cuser")
public class CuserController {

	@Autowired
	private CuserService cuserService;

	// 查询
	@RequestMapping("show")
	@ResponseBody
	public <T> PageData<T> showProducts(Integer page, Integer rows) {
		PageData<T> pageData = new PageData<T>();
		List<T> list = (List<T>) cuserService.showCuser(page, rows);
		pageData.setRows((List<T>) list);
		pageData.setTotal(cuserService.showTotalCuser());
		return pageData;
	}

	// 删除
	@RequestMapping("remove")
	@ResponseBody
	public void removeProduct(String id) {
		cuserService.removeCuser(id);
	}

	// 更新
	@RequestMapping("update")
	@ResponseBody
	public void updateProduct(Cuser cuser) {
		cuserService.updateCuser(cuser);
	}
	
	@RequestMapping("login")
	@ResponseBody
	public Cuser login(String username, String password, HttpSession session){
		Cuser cuser = cuserService.login(username, password, session);
		if(cuser != null){
			return cuser;
		}
		return null;
	}
}
