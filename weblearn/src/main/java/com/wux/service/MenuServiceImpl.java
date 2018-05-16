package com.wux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wux.dao.MenuDao;
import com.wux.entity.Menu;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> showSubMenu(String mid) {
		return menuDao.selectSubMenu(mid);
	}

	@Override
	public Menu showMenuById(String mid) {
		return menuDao.selectMenuById(mid);
	}
}
