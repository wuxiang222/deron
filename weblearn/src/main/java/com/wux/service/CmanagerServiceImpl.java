package com.wux.service;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wux.dao.CmanagerDao;
import com.wux.entity.Cmanager;
import com.wux.util.MD5Util;

@Service
public class CmanagerServiceImpl implements CmanagerService {
	@Autowired
	private CmanagerDao cmanagerDao;

	@Override
	public Cmanager showCmanagerByUsername(String username, String password, HttpSession session) {
		// 根据username 获得user对象
		Cmanager cmanager = cmanagerDao.showCmanagerByUsername(username);
		if (cmanager != null) {
			// 获得盐 和数据库中加密密码dbPass
			String salt = cmanager.getSalt();
			String dbpassword = cmanager.getPassword();
			// 根据用户输入的密码 和盐生成 newPass
			String jdkMD = MD5Util.getMD5(password, salt);
			// 对比 newPass 和 dbPass
			if (jdkMD.equals(dbpassword)) {
				session.setAttribute("username", username);
				return cmanager;
			}
		}
		return null;
	}

	@Override
	public void registCmanager(Cmanager cmanager) {
		String id = UUID.randomUUID().toString().replace("-", "");
		cmanager.setCmanager_id(id);
	
		// 生成盐
		String salt = MD5Util.getSalt(4);
		String target =salt + cmanager.getPassword();
		// 拼接，调用MD5工具加密
		String jdkMD = MD5Util.getMD5(target);
		// 盐赋值个管理员
		cmanager.setSalt(salt);
		// MD5密码赋值个管理员
		cmanager.setPassword(jdkMD);
		// 调用Dao		
		cmanagerDao.insertCmanager(cmanager);
	}

}
