package com.wux.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wux.annotation.Comment;
import com.wux.dao.CuserDao;
import com.wux.entity.Cuser;

@Service
@Transactional
public class CuserServiceImpl implements CuserService {

	@Autowired
	CuserDao cuserDao;
	@Override
	public List<Cuser> showCuser(Integer page, Integer rows) {
		Integer start = (page-1)*rows;
		Integer end = page*rows;
		List<Cuser> list = cuserDao.showCuser(start, end);
		System.out.println(list+"###########################");
		return list;
	}

	@Override
	public Integer showTotalCuser() {
		return cuserDao.showTotalCuser();
	}

	@Override
	public void removeCuser(String id) {
		cuserDao.removeCuser(id);
		
	}

	@Override
	public void updateCuser(Cuser cuser) {
		cuserDao.updateCuser(cuser);
		
	}

	@Override
	@Comment("用户登录")
	public Cuser login(String username, String password, HttpSession session) {
		Cuser cuser = cuserDao.login(username, password);
		session.setAttribute("username", username);
		return cuser;
		
	}

}
